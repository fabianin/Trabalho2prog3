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
import model.pojo.Disciplina;
import model.pojo.Professor;

/**
 *
 * @author Fabiano
 */
public class ProfessorJpaDao implements Serializable {

    public ProfessorJpaDao(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Professor professor) {
        if (professor.getTurmas() == null) {
            professor.setTurmas(new ArrayList<>());
        }
        if (professor.getDisciplinasApto() == null) {
            professor.setDisciplinasApto(new ArrayList<>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Turma> attachedTurmas = new ArrayList<>();
            for (Turma turmasTurmaToAttach : professor.getTurmas()) {
                turmasTurmaToAttach = em.getReference(turmasTurmaToAttach.getClass(), turmasTurmaToAttach.getId());
                attachedTurmas.add(turmasTurmaToAttach);
            }
            professor.setTurmas((ArrayList<Turma>) attachedTurmas);
            List<Disciplina> attachedDisciplinasApto = new ArrayList<>();
            for (Disciplina disciplinasAptoDisciplinaToAttach : professor.getDisciplinasApto()) {
                disciplinasAptoDisciplinaToAttach = em.getReference(disciplinasAptoDisciplinaToAttach.getClass(), disciplinasAptoDisciplinaToAttach.getId());
                attachedDisciplinasApto.add(disciplinasAptoDisciplinaToAttach);
            }
            professor.setDisciplinasApto((ArrayList<Disciplina>) attachedDisciplinasApto);
            em.persist(professor);
            for (Turma turmasTurma : professor.getTurmas()) {
                Professor oldProfessorOfTurmasTurma = turmasTurma.getProfessor();
                turmasTurma.setProfessor(professor);
                turmasTurma = em.merge(turmasTurma);
                if (oldProfessorOfTurmasTurma != null) {
                    oldProfessorOfTurmasTurma.getTurmas().remove(turmasTurma);
                    oldProfessorOfTurmasTurma = em.merge(oldProfessorOfTurmasTurma);
                }
            }
            for (Disciplina disciplinasAptoDisciplina : professor.getDisciplinasApto()) {
                disciplinasAptoDisciplina.getProfessoresAptos().add(professor);
                disciplinasAptoDisciplina = em.merge(disciplinasAptoDisciplina);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Professor professor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Professor persistentProfessor = em.find(Professor.class, professor.getId());
            List<Turma> turmasOld = persistentProfessor.getTurmas();
            List<Turma> turmasNew = professor.getTurmas();
            List<Disciplina> disciplinasAptoOld = persistentProfessor.getDisciplinasApto();
            List<Disciplina> disciplinasAptoNew = professor.getDisciplinasApto();
            List<Turma> attachedTurmasNew = new ArrayList<>();
            for (Turma turmasNewTurmaToAttach : turmasNew) {
                turmasNewTurmaToAttach = em.getReference(turmasNewTurmaToAttach.getClass(), turmasNewTurmaToAttach.getId());
                attachedTurmasNew.add(turmasNewTurmaToAttach);
            }
            turmasNew = attachedTurmasNew;
            professor.setTurmas((ArrayList<Turma>) turmasNew);
            List<Disciplina> attachedDisciplinasAptoNew = new ArrayList<>();
            for (Disciplina disciplinasAptoNewDisciplinaToAttach : disciplinasAptoNew) {
                disciplinasAptoNewDisciplinaToAttach = em.getReference(disciplinasAptoNewDisciplinaToAttach.getClass(), disciplinasAptoNewDisciplinaToAttach.getId());
                attachedDisciplinasAptoNew.add(disciplinasAptoNewDisciplinaToAttach);
            }
            disciplinasAptoNew = attachedDisciplinasAptoNew;
            professor.setDisciplinasApto((ArrayList<Disciplina>) disciplinasAptoNew);
            professor = em.merge(professor);
            for (Turma turmasOldTurma : turmasOld) {
                if (!turmasNew.contains(turmasOldTurma)) {
                    turmasOldTurma.setProfessor(null);
                    turmasOldTurma = em.merge(turmasOldTurma);
                }
            }
            for (Turma turmasNewTurma : turmasNew) {
                if (!turmasOld.contains(turmasNewTurma)) {
                    Professor oldProfessorOfTurmasNewTurma = turmasNewTurma.getProfessor();
                    turmasNewTurma.setProfessor(professor);
                    turmasNewTurma = em.merge(turmasNewTurma);
                    if (oldProfessorOfTurmasNewTurma != null && !oldProfessorOfTurmasNewTurma.equals(professor)) {
                        oldProfessorOfTurmasNewTurma.getTurmas().remove(turmasNewTurma);
                        oldProfessorOfTurmasNewTurma = em.merge(oldProfessorOfTurmasNewTurma);
                    }
                }
            }
            for (Disciplina disciplinasAptoOldDisciplina : disciplinasAptoOld) {
                if (!disciplinasAptoNew.contains(disciplinasAptoOldDisciplina)) {
                    disciplinasAptoOldDisciplina.getProfessoresAptos().remove(professor);
                    disciplinasAptoOldDisciplina = em.merge(disciplinasAptoOldDisciplina);
                }
            }
            for (Disciplina disciplinasAptoNewDisciplina : disciplinasAptoNew) {
                if (!disciplinasAptoOld.contains(disciplinasAptoNewDisciplina)) {
                    disciplinasAptoNewDisciplina.getProfessoresAptos().add(professor);
                    disciplinasAptoNewDisciplina = em.merge(disciplinasAptoNewDisciplina);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = professor.getId();
                if (findProfessor(id) == null) {
                    throw new NonexistentEntityException("The professor with id " + id + " no longer exists.");
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
            Professor professor;
            try {
                professor = em.getReference(Professor.class, id);
                professor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The professor with id " + id + " no longer exists.", enfe);
            }
            List<Turma> turmas = professor.getTurmas();
            for (Turma turmasTurma : turmas) {
                turmasTurma.setProfessor(null);
                turmasTurma = em.merge(turmasTurma);
            }
            List<Disciplina> disciplinasApto = professor.getDisciplinasApto();
            for (Disciplina disciplinasAptoDisciplina : disciplinasApto) {
                disciplinasAptoDisciplina.getProfessoresAptos().remove(professor);
                disciplinasAptoDisciplina = em.merge(disciplinasAptoDisciplina);
            }
            em.remove(professor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Professor> findProfessorEntities() {
        return findProfessorEntities(true, -1, -1);
    }

    public List<Professor> findProfessorEntities(int maxResults, int firstResult) {
        return findProfessorEntities(false, maxResults, firstResult);
    }

    private List<Professor> findProfessorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Professor.class));
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

    public Professor findProfessor(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Professor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProfessorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Professor> rt = cq.from(Professor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
