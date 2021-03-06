/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.dao.jpa.expections.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import model.pojo.Nota;

/**
 *
 * @author Fabiano
 */
public interface NotaDao {

    void create(Nota nota);

    void destroy(Long id) throws NonexistentEntityException;

    void edit(Nota nota) throws NonexistentEntityException, Exception;

    Nota findNota(Long id);

    List<Nota> findNotaEntities();

    List<Nota> findNotaEntities(int maxResults, int firstResult);

    EntityManager getEntityManager();

    int getNotaCount();
    
}
