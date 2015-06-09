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
import model.pojo.Professor;
import model.pojo.Aluno;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.pojo.Atividade;
import model.pojo.Turma;

/**
 *
 * @author Fabiano
 */
public class TurmaJpaDao implements Serializable {

    public TurmaJpaDao(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Turma turma) {
        if (turma.getAlunos() == null) {
            turma.setAlunos(new ArrayList<>());
        }
        if (turma.getAtividades() == null) {
            turma.setAtividades(new ArrayList<>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Professor professor = turma.getProfessor();
            if (professor != null) {
                professor = em.getReference(professor.getClass(), professor.getId());
                turma.setProfessor(professor);
            }
            List<Aluno> attachedAlunos = new ArrayList<>();
            for (Aluno alunosAlunoToAttach : turma.getAlunos()) {
                alunosAlunoToAttach = em.getReference(alunosAlunoToAttach.getClass(), alunosAlunoToAttach.getId());
                attachedAlunos.add(alunosAlunoToAttach);
            }
            turma.setAlunos((ArrayList<Aluno>) attachedAlunos);
            List<Atividade> attachedAtividades;
            attachedAtividades = new ArrayList<>();
            for (Atividade atividadesAtividadeToAttach : turma.getAtividades()) {
                atividadesAtividadeToAttach = em.getReference(atividadesAtividadeToAttach.getClass(), atividadesAtividadeToAttach.getId());
                attachedAtividades.add(atividadesAtividadeToAttach);
            }
            turma.setAtividades((ArrayList<Atividade>) attachedAtividades);
            em.persist(turma);
            if (professor != null) {
                professor.getTurmas().add(turma);
                professor = em.merge(professor);
            }
            for (Aluno alunosAluno : turma.getAlunos()) {
                alunosAluno.getTurmas().add(turma);
                alunosAluno = em.merge(alunosAluno);
            }
            for (Atividade atividadesAtividade : turma.getAtividades()) {
                Turma oldTurmaOfAtividadesAtividade = atividadesAtividade.getTurma();
                atividadesAtividade.setTurma(turma);
                atividadesAtividade = em.merge(atividadesAtividade);
                if (oldTurmaOfAtividadesAtividade != null) {
                    oldTurmaOfAtividadesAtividade.getAtividades().remove(atividadesAtividade);
                    oldTurmaOfAtividadesAtividade = em.merge(oldTurmaOfAtividadesAtividade);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Turma turma) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turma persistentTurma = em.find(Turma.class, turma.getId());
            Professor professorOld = persistentTurma.getProfessor();
            Professor professorNew = turma.getProfessor();
            List<Aluno> alunosOld = persistentTurma.getAlunos();
            List<Aluno> alunosNew = turma.getAlunos();
            List<Atividade> atividadesOld = persistentTurma.getAtividades();
            List<Atividade> atividadesNew = turma.getAtividades();
            if (professorNew != null) {
                professorNew = em.getReference(professorNew.getClass(), professorNew.getId());
                turma.setProfessor(professorNew);
            }
            List<Aluno> attachedAlunosNew = new ArrayList<>();
            for (Aluno alunosNewAlunoToAttach : alunosNew) {
                alunosNewAlunoToAttach = em.getReference(alunosNewAlunoToAttach.getClass(), alunosNewAlunoToAttach.getId());
                attachedAlunosNew.add(alunosNewAlunoToAttach);
            }
            alunosNew = attachedAlunosNew;
            turma.setAlunos((ArrayList<Aluno>) alunosNew);
            List<Atividade> attachedAtividadesNew = new ArrayList<>();
            for (Atividade atividadesNewAtividadeToAttach : atividadesNew) {
                atividadesNewAtividadeToAttach = em.getReference(atividadesNewAtividadeToAttach.getClass(), atividadesNewAtividadeToAttach.getId());
                attachedAtividadesNew.add(atividadesNewAtividadeToAttach);
            }
            atividadesNew = attachedAtividadesNew;
            turma.setAtividades((ArrayList<Atividade>) atividadesNew);
            turma = em.merge(turma);
            if (professorOld != null && !professorOld.equals(professorNew)) {
                professorOld.getTurmas().remove(turma);
                professorOld = em.merge(professorOld);
            }
            if (professorNew != null && !professorNew.equals(professorOld)) {
                professorNew.getTurmas().add(turma);
                professorNew = em.merge(professorNew);
            }
            for (Aluno alunosOldAluno : alunosOld) {
                if (!alunosNew.contains(alunosOldAluno)) {
                    alunosOldAluno.getTurmas().remove(turma);
                    alunosOldAluno = em.merge(alunosOldAluno);
                }
            }
            for (Aluno alunosNewAluno : alunosNew) {
                if (!alunosOld.contains(alunosNewAluno)) {
                    alunosNewAluno.getTurmas().add(turma);
                    alunosNewAluno = em.merge(alunosNewAluno);
                }
            }
            for (Atividade atividadesOldAtividade : atividadesOld) {
                if (!atividadesNew.contains(atividadesOldAtividade)) {
                    atividadesOldAtividade.setTurma(null);
                    atividadesOldAtividade = em.merge(atividadesOldAtividade);
                }
            }
            for (Atividade atividadesNewAtividade : atividadesNew) {
                if (!atividadesOld.contains(atividadesNewAtividade)) {
                    Turma oldTurmaOfAtividadesNewAtividade = atividadesNewAtividade.getTurma();
                    atividadesNewAtividade.setTurma(turma);
                    atividadesNewAtividade = em.merge(atividadesNewAtividade);
                    if (oldTurmaOfAtividadesNewAtividade != null && !oldTurmaOfAtividadesNewAtividade.equals(turma)) {
                        oldTurmaOfAtividadesNewAtividade.getAtividades().remove(atividadesNewAtividade);
                        oldTurmaOfAtividadesNewAtividade = em.merge(oldTurmaOfAtividadesNewAtividade);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = turma.getId();
                if (findTurma(id) == null) {
                    throw new NonexistentEntityException("The turma with id " + id + " no longer exists.");
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
            Turma turma;
            try {
                turma = em.getReference(Turma.class, id);
                turma.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The turma with id " + id + " no longer exists.", enfe);
            }
            Professor professor = turma.getProfessor();
            if (professor != null) {
                professor.getTurmas().remove(turma);
                professor = em.merge(professor);
            }
            List<Aluno> alunos = turma.getAlunos();
            for (Aluno alunosAluno : alunos) {
                alunosAluno.getTurmas().remove(turma);
                alunosAluno = em.merge(alunosAluno);
            }
            List<Atividade> atividades = turma.getAtividades();
            for (Atividade atividadesAtividade : atividades) {
                atividadesAtividade.setTurma(null);
                atividadesAtividade = em.merge(atividadesAtividade);
            }
            em.remove(turma);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Turma> findTurmaEntities() {
        return findTurmaEntities(true, -1, -1);
    }

    public List<Turma> findTurmaEntities(int maxResults, int firstResult) {
        return findTurmaEntities(false, maxResults, firstResult);
    }

    private List<Turma> findTurmaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Turma.class));
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

    public Turma findTurma(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Turma.class, id);
        } finally {
            em.close();
        }
    }

    public int getTurmaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Turma> rt = cq.from(Turma.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
