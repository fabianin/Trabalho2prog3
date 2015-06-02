package model.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


public class Professor extends Pessoa {

    private final String departamento;
    private ArrayList<Turma> turmas;
    private ArrayList<Disciplina> disciplinasApto;

    public Professor(String departamento, String nome, long cpf) {
        super(nome, cpf);
        Objects.requireNonNull(departamento);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public List<Turma> getTurmas() {
        return Collections.unmodifiableList(turmas);
    }

    public List<Disciplina> getDisciplinasApto() {
        return Collections.unmodifiableList(disciplinasApto);
    }
    public void addTurma(Turma t){
        Objects.requireNonNull(t);
        if(this.turmas == null){
            this.turmas = new ArrayList<>();
        }
        if(this.turmas.contains(t)){
            throw new IllegalArgumentException("Essa turmna já está na lista de turmas desse professor");
        } else{
            this.turmas.add(t);
        }
    }
    public void addDisciplinaApto(Disciplina d){
        Objects.requireNonNull(d);
        if(disciplinasApto == null){
            disciplinasApto = new ArrayList<>();
        }
        if(disciplinasApto.contains(d)){
            throw new IllegalArgumentException("Essa turmna já está na lista de turmas desse professor");
        } else {
            this.disciplinasApto.add(d);
        }
    }

    

}
