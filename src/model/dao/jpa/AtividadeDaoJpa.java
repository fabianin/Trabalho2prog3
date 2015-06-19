/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao.jpa;

import model.dao.AtividadeDao;
import DaoJPA.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.pojo.Atividade;
import model.pojo.Turma;

/**
 *
 * @author Fabiano
 */
public class AtividadeDaoJpa implements Serializable, AtividadeDao {

    public AtividadeDaoJpa(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    @Override
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void create(Atividade atividade) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turma turma = atividade.getTurma();
            if (turma != null) {
                turma = em.getReference(turma.getClass(), turma.getId());
                atividade.setTurma(turma);
            }
            em.persist(atividade);
            if (turma != null) {
                turma.getAtividades().add(atividade);
                turma = em.merge(turma);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void edit(Atividade atividade) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Atividade persistentAtividade = em.find(Atividade.class, atividade.getId());
            Turma turmaOld = persistentAtividade.getTurma();
            Turma turmaNew = atividade.getTurma();
            if (turmaNew != null) {
                turmaNew = em.getReference(turmaNew.getClass(), turmaNew.getId());
                atividade.setTurma(turmaNew);
            }
            atividade = em.merge(atividade);
            if (turmaOld != null && !turmaOld.equals(turmaNew)) {
                turmaOld.getAtividades().remove(atividade);
                turmaOld = em.merge(turmaOld);
            }
            if (turmaNew != null && !turmaNew.equals(turmaOld)) {
                turmaNew.getAtividades().add(atividade);
                turmaNew = em.merge(turmaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = atividade.getId();
                if (findAtividade(id) == null) {
                    throw new NonexistentEntityException("The atividade with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Atividade atividade;
            try {
                atividade = em.getReference(Atividade.class, id);
                atividade.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The atividade with id " + id + " no longer exists.", enfe);
            }
            Turma turma = atividade.getTurma();
            if (turma != null) {
                turma.getAtividades().remove(atividade);
                turma = em.merge(turma);
            }
            em.remove(atividade);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public List<Atividade> findAtividadeEntities() {
        return findAtividadeEntities(true, -1, -1);
    }

    @Override
    public List<Atividade> findAtividadeEntities(int maxResults, int firstResult) {
        return findAtividadeEntities(false, maxResults, firstResult);
    }

    private List<Atividade> findAtividadeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Atividade.class));
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

    @Override
    public Atividade findAtividade(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Atividade.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public int getAtividadeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Atividade> rt = cq.from(Atividade.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
