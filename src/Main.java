
//import DaoJPA.AlunoJpaDao;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.dao.AlunoDao;
import model.pojo.Aluno;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fabiano
 */
public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrabalhoPU");
        
        Aluno a = new Aluno(23, "aaaa", 23);
//        AlunoDao alunoDaoJpa = new AlunoJpaDao(emf);
//        alunoDaoJpa.create(a);
    }
}
