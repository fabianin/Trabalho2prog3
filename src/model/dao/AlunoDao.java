/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Aluno;

/**
 *
 * @author Fabiano
 */
public interface AlunoDao {
    public void salvar();
    public List<Aluno> listar();
    public Aluno getByName(String name);
    public void addAluno(Aluno a);
    
}
