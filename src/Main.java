
import JDBCDao.JDBCAlunoDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.text.html.parser.Entity;
import model.dao.AlunoDao;
import model.pojo.Aluno;
import model.pojo.Turma;

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
        Aluno a = new Aluno(25, "Fabiano", 23);
        AlunoDao JDBCalunos = new JDBCAlunoDAO();
        JDBCalunos.addAluno(a);
        JDBCalunos.salvar();
    }
}
