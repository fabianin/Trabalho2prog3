/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import DaoJPA.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import model.pojo.Aluno;

/**
 *
 * @author Fabiano
 */
public interface AtividadeDao {
    public EntityManager getEntityManager();
    public void create(Aluno aluno);
    public void edit(Aluno aluno) throws NonexistentEntityException, Exception;
    public void destroy(Long id) throws NonexistentEntityException;
    public List<Aluno> findAtividadeEntities();
    public List<Aluno> findAtividadeEntities(int maxResults, int firstResult);
    public Aluno findAtividade(Long id);
    public int getAtividadeCount();
    
}
