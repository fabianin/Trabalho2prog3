/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.dao.jpa.expections.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import model.pojo.Aluno;

/**
 *
 * @author Fabiano
 */
public interface AlunoDao  {

    void create(Aluno aluno);

    void destroy(Long id) throws NonexistentEntityException;

    void edit(Aluno aluno) throws NonexistentEntityException, Exception;

    Aluno findAluno(Long id);

    List<Aluno> findAlunoEntities();

    List<Aluno> findAlunoEntities(int maxResults, int firstResult);

    int getAlunoCount();

    EntityManager getEntityManager();
    
}
