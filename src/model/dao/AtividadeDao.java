/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import DaoJPA.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import model.pojo.Atividade;

/**
 *
 * @author Fabiano
 */
public interface AtividadeDao {

    void create(Atividade atividade);

    void destroy(Long id) throws NonexistentEntityException;

    void edit(Atividade atividade) throws NonexistentEntityException, Exception;

    Atividade findAtividade(Long id);

    List<Atividade> findAtividadeEntities();

    List<Atividade> findAtividadeEntities(int maxResults, int firstResult);

    int getAtividadeCount();

    EntityManager getEntityManager();
    
}
