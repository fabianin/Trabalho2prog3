/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCDao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import model.dao.AlunoDao;
import model.pojo.Aluno;

/**
 *
 * @author Fabiano
 */
public class JDBCAlunoDAO implements AlunoDao{
    List<Aluno> listaAlunos ;
    
    public void addAluno(Aluno a){
        if(this.listaAlunos == null){
            this.listaAlunos = new ArrayList<>();
        }
        this.listaAlunos.add(a);
    }

    @Override
    public void salvar() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Trabalho2prog3PU");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        for(Aluno x : this.listaAlunos){
            manager.persist(x);
            transaction.commit();
        }
        manager.close();
        factory.close();
    }

    @Override
    public List<Aluno> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Aluno getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
