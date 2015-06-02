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
public class JPAAlunoDAO implements AlunoDao {  
    List<Aluno> listaAlunos;

    @Override
    public void addAluno(Aluno a) {
        if (this.listaAlunos == null) {
            this.listaAlunos = new ArrayList<>();
        }
        this.listaAlunos.add(a);
    }

    @Override
    public void salvar() {
        JPAUtil.getEntityManager().getTransaction().begin();
        for (Aluno x : this.listaAlunos) {
            JPAUtil.getEntityManager().persist(x);
            JPAUtil.getEntityManager().getTransaction().commit();
        }
        JPAUtil.getEntityManager().close();
    }

    @Override
    public List<Aluno> listar() {
        List<Aluno> alunos;
        JPAUtil.getEntityManager().close();
        return null;
    }

    @Override
    public Aluno getByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
