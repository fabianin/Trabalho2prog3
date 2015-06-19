/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import DaoJPA.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import model.pojo.Disciplina;

/**
 *
 * @author Fabiano
 */
public interface DisciplinaDao {

    void create(Disciplina disciplina);

    void destroy(Long id) throws NonexistentEntityException;

    void edit(Disciplina disciplina) throws NonexistentEntityException, Exception;

    Disciplina findDisciplina(Long id);

    List<Disciplina> findDisciplinaEntities();

    List<Disciplina> findDisciplinaEntities(int maxResults, int firstResult);

    int getDisciplinaCount();

    EntityManager getEntityManager();
    
}
