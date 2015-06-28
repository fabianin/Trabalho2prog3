package model.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author Fabiano
 */
@Entity
public class Aluno extends Pessoa {

    @Column(updatable = false)
    private long matricula;
    @ManyToMany
    private List<Turma> turmas;

    public Aluno() {
        this.matricula = 0;
    }

    public Aluno(long matricula, String nome, long cpf) {
        super(nome, cpf);
        this.matricula = matricula;
    }

    public void addTurma(Turma t) {
        Objects.requireNonNull(t);
        if (turmas == null) {
            turmas = new ArrayList<>();
        }
        this.turmas.add(t);
    }

    public long getMatricula() {
        return matricula;
    }

    public List<Turma> getTurmas() {
        if (this.turmas == null) {
            this.turmas = new ArrayList<>();
        }
        return Collections.unmodifiableList(turmas);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.matricula ^ (this.matricula >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        return this.matricula == other.matricula;
    }

    @Override
    public String toString() {
        return "Aluno{" + "matricula=" + matricula + ", turmas=" + turmas + '}';
    }

    public void setTurmas(List<Turma> turmasNew) {
        this.turmas = turmasNew;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

}
