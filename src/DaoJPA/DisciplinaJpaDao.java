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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.pojo.Disciplina;

/**
 *
 * @author Fabiano
 */
public class DisciplinaJpaDao implements Serializable {

    public DisciplinaJpaDao(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Disciplina disciplina) {
        if (disciplina.getProfessoresAptos() == null) {
            disciplina.setProfessoresAptos(new ArrayList<Professor>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Professor> attachedProfessoresAptos = new ArrayList<>();
            for (Professor professoresAptosProfessorToAttach : disciplina.getProfessoresAptos()) {
                professoresAptosProfessorToAttach = em.getReference(professoresAptosProfessorToAttach.getClass(), professoresAptosProfessorToAttach.getId());
                attachedProfessoresAptos.add(professoresAptosProfessorToAttach);
            }
            disciplina.setProfessoresAptos((ArrayList<Professor>) attachedProfessoresAptos);
            em.persist(disciplina);
            for (Professor professoresAptosProfessor : disciplina.getProfessoresAptos()) {
                professoresAptosProfessor.getDisciplinasApto().add(disciplina);
                professoresAptosProfessor = em.merge(professoresAptosProfessor);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Disciplina disciplina) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Disciplina persistentDisciplina = em.find(Disciplina.class, disciplina.getId());
            List<Professor> professoresAptosOld = persistentDisciplina.getProfessoresAptos();
            List<Professor> professoresAptosNew = disciplina.getProfessoresAptos();
            List<Professor> attachedProfessoresAptosNew = new ArrayList<>();
            for (Professor professoresAptosNewProfessorToAttach : professoresAptosNew) {
                professoresAptosNewProfessorToAttach = em.getReference(professoresAptosNewProfessorToAttach.getClass(), professoresAptosNewProfessorToAttach.getId());
                attachedProfessoresAptosNew.add(professoresAptosNewProfessorToAttach);
            }
            professoresAptosNew = attachedProfessoresAptosNew;
            disciplina.setProfessoresAptos((ArrayList<Professor>) professoresAptosNew);
            disciplina = em.merge(disciplina);
            for (Professor professoresAptosOldProfessor : professoresAptosOld) {
                if (!professoresAptosNew.contains(professoresAptosOldProfessor)) {
                    professoresAptosOldProfessor.getDisciplinasApto().remove(disciplina);
                    professoresAptosOldProfessor = em.merge(professoresAptosOldProfessor);
                }
            }
            for (Professor professoresAptosNewProfessor : professoresAptosNew) {
                if (!professoresAptosOld.contains(professoresAptosNewProfessor)) {
                    professoresAptosNewProfessor.getDisciplinasApto().add(disciplina);
                    professoresAptosNewProfessor = em.merge(professoresAptosNewProfessor);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = disciplina.getId();
                if (findDisciplina(id) == null) {
                    throw new NonexistentEntityException("The disciplina with id " + id + " no longer exists.");
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
            Disciplina disciplina;
            try {
                disciplina = em.getReference(Disciplina.class, id);
                disciplina.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The disciplina with id " + id + " no longer exists.", enfe);
            }
            List<Professor> professoresAptos = disciplina.getProfessoresAptos();
            for (Professor professoresAptosProfessor : professoresAptos) {
                professoresAptosProfessor.getDisciplinasApto().remove(disciplina);
                professoresAptosProfessor = em.merge(professoresAptosProfessor);
            }
            em.remove(disciplina);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Disciplina> findDisciplinaEntities() {
        return findDisciplinaEntities(true, -1, -1);
    }

    public List<Disciplina> findDisciplinaEntities(int maxResults, int firstResult) {
        return findDisciplinaEntities(false, maxResults, firstResult);
    }

    private List<Disciplina> findDisciplinaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Disciplina.class));
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

    public Disciplina findDisciplina(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Disciplina.class, id);
        } finally {
            em.close();
        }
    }

    public int getDisciplinaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Disciplina> rt = cq.from(Disciplina.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
