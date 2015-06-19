package model.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Professor extends Pessoa {

    private String departamento;
    @OneToMany(mappedBy = "professor")
    private List<Turma> turmas;
    @ManyToMany(mappedBy = "professoresAptos")
    private List<Disciplina> disciplinasApto;

    public Professor() {
    }

    public Professor(String departamento, String nome, long cpf) {
        super(nome, cpf);
        Objects.requireNonNull(departamento);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public List<Turma> getTurmas() {
        if (this.turmas == null) {
            this.turmas = new ArrayList<>();
        }
        return turmas;
    }

    public List<Disciplina> getDisciplinasApto() {
        if (this.disciplinasApto == null) {
            this.disciplinasApto = new ArrayList<>();
        }
        return disciplinasApto;
    }

    public void addTurma(Turma t) {
        Objects.requireNonNull(t);
        if (this.turmas == null) {
            this.turmas = new ArrayList<>();
        }
        if (this.turmas.contains(t)) {
            throw new IllegalArgumentException("Essa turmna já está na lista de turmas desse professor");
        } else {
            this.turmas.add(t);
        }
    }

    public void addDisciplinaApto(Disciplina d) {
        Objects.requireNonNull(d);
        if (disciplinasApto == null) {
            disciplinasApto = new ArrayList<>();
        }
        if (disciplinasApto.contains(d)) {
            throw new IllegalArgumentException("Essa turmna já está na lista de turmas desse professor");
        } else {
            this.disciplinasApto.add(d);
        }
    }

    public void setTurmas(List<Turma> arrayList) {
        this.turmas = arrayList;
    }

    public void setDisciplinasApto(List<Disciplina> arrayList) {
        this.disciplinasApto = arrayList;
    }

}
