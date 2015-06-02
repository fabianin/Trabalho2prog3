
import JDBCDao.JPAAlunoDAO;
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
        AlunoDao JPAalunos = new JPAAlunoDAO();
       Aluno a = new Aluno(23, "fabiano", 23);
       JPAalunos.addAluno(a);
       JPAalunos.salvar();
    }
}
