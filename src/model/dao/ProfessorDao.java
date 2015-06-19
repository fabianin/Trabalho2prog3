/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import DaoJPA.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import model.pojo.Professor;

/**
 *
 * @author Fabiano
 */
public interface ProfessorDao {

    void create(Professor professor);

    void destroy(Long id) throws NonexistentEntityException;

    void edit(Professor professor) throws NonexistentEntityException, Exception;

    Professor findProfessor(Long id);

    List<Professor> findProfessorEntities();

    List<Professor> findProfessorEntities(int maxResults, int firstResult);

    EntityManager getEntityManager();

    int getProfessorCount();
    
}
