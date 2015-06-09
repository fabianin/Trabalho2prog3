/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoJPA;

import DaoJPA.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.pojo.Turma;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.dao.AlunoDao;
import model.pojo.Aluno;

/**
 *
 * @author Fabiano
 */
public class AlunoJpaController implements Serializable, AlunoDao {

    public AlunoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Aluno aluno) {
        if (aluno.getTurmas() == null) {
            aluno.setTurmas(new ArrayList<Turma>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Turma> attachedTurmas = new ArrayList<Turma>();
            for (Turma turmasTurmaToAttach : aluno.getTurmas()) {
                turmasTurmaToAttach = em.getReference(turmasTurmaToAttach.getClass(), turmasTurmaToAttach.getId());
                attachedTurmas.add(turmasTurmaToAttach);
            }
            aluno.setTurmas(attachedTurmas);
            em.persist(aluno);
            for (Turma turmasTurma : aluno.getTurmas()) {
                turmasTurma.getAlunos().add(aluno);
                turmasTurma = em.merge(turmasTurma);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Aluno aluno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Aluno persistentAluno = em.find(Aluno.class, aluno.getId());
            List<Turma> turmasOld = persistentAluno.getTurmas();
            List<Turma> turmasNew = aluno.getTurmas();
            List<Turma> attachedTurmasNew = new ArrayList<Turma>();
            for (Turma turmasNewTurmaToAttach : turmasNew) {
                turmasNewTurmaToAttach = em.getReference(turmasNewTurmaToAttach.getClass(), turmasNewTurmaToAttach.getId());
                attachedTurmasNew.add(turmasNewTurmaToAttach);
            }
            turmasNew = attachedTurmasNew;
            aluno.setTurmas(turmasNew);
            aluno = em.merge(aluno);
            for (Turma turmasOldTurma : turmasOld) {
                if (!turmasNew.contains(turmasOldTurma)) {
                    turmasOldTurma.getAlunos().remove(aluno);
                    turmasOldTurma = em.merge(turmasOldTurma);
                }
            }
            for (Turma turmasNewTurma : turmasNew) {
                if (!turmasOld.contains(turmasNewTurma)) {
                    turmasNewTurma.getAlunos().add(aluno);
                    turmasNewTurma = em.merge(turmasNewTurma);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = aluno.getId();
                if (findAluno(id) == null) {
                    throw new NonexistentEntityException("The aluno with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Aluno aluno;
            try {
                aluno = em.getReference(Aluno.class, id);
                aluno.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The aluno with id " + id + " no longer exists.", enfe);
            }
            List<Turma> turmas = aluno.getTurmas();
            for (Turma turmasTurma : turmas) {
                turmasTurma.getAlunos().remove(aluno);
                turmasTurma = em.merge(turmasTurma);
            }
            em.remove(aluno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Aluno> findAlunoEntities() {
        return findAlunoEntities(true, -1, -1);
    }

    public List<Aluno> findAlunoEntities(int maxResults, int firstResult) {
        return findAlunoEntities(false, maxResults, firstResult);
    }

    private List<Aluno> findAlunoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Aluno.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Aluno findAluno(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Aluno.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlunoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Aluno> rt = cq.from(Aluno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
