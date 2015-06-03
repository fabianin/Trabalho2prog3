package model.pojo;

import DaoJPA.JPAUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Fabiano
 */
@Entity
public class Aluno extends Pessoa implements Serializable {
    @OneToOne
    private final long matricula;
    @ManyToMany
    private ArrayList<Turma> turmas;

    public Aluno() {
        this.matricula=0;
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
        if (this.matricula != other.matricula) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Aluno{" + "matricula=" + matricula + ", turmas=" + turmas + '}';
    }

}
