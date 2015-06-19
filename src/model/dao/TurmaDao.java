/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.dao.jpa.expections.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import model.pojo.Turma;

/**
 *
 * @author Fabiano
 */
public interface TurmaDao {

    void create(Turma turma);

    void destroy(Long id) throws NonexistentEntityException;

    void edit(Turma turma) throws NonexistentEntityException, Exception;

    Turma findTurma(Long id);

    List<Turma> findTurmaEntities();

    List<Turma> findTurmaEntities(int maxResults, int firstResult);

    EntityManager getEntityManager();

    int getTurmaCount();
    
}
