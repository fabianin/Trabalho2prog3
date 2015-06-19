/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import DaoJPA.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import model.pojo.Falta;

/**
 *
 * @author Fabiano
 */
public interface FaltaDao {

    void create(Falta falta);

    void destroy(Long id) throws NonexistentEntityException;

    void edit(Falta falta) throws NonexistentEntityException, Exception;

    Falta findFalta(Long id);

    List<Falta> findFaltaEntities();

    List<Falta> findFaltaEntities(int maxResults, int firstResult);

    EntityManager getEntityManager();

    int getFaltaCount();
    
}
