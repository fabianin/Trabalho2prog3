/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import DaoJPA.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import model.pojo.Teste;

/**
 *
 * @author Fabiano
 */
public interface TesteDao {

    void create(Teste teste);

    void destroy(Long id) throws NonexistentEntityException;

    void edit(Teste teste) throws NonexistentEntityException, Exception;

    Teste findTeste(Long id);

    List<Teste> findTesteEntities();

    List<Teste> findTesteEntities(int maxResults, int firstResult);

    EntityManager getEntityManager();

    int getTesteCount();
    
}
