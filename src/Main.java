
//import DaoJPA.AlunoJpaDao;
import model.dao.*;
import model.dao.jpa.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.pojo.*;

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
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Trabalho2prog3PU");
        ProfessorDao daoProf = new ProfessorDaoJpa(emf);
        DisciplinaDao daoDisc = new DisciplinaDaoJpa(emf);
        Professor p = new Professor("DCEL", "Leonardo", 11223344);
        daoProf.create(p);
        Disciplina d = new Disciplina("Programação 3", "Tudo e mais um pouco. Você não vai ter tempo para outras matérias", 1000);
        daoDisc.create(d);
        Turma t = new Turma(10, 10, "sala", 20, "10", d, p);
        TurmaDao turmadao = new TurmaDaoJpa(emf);
        turmadao.create(t);
        emf.close();
    }
}
