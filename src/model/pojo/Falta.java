package model.pojo;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Falta extends GenericEntity {

    private long numFaltas;

    @OneToOne(fetch = FetchType.EAGER)
    private Aluno aluno;
    @ManyToOne(fetch = FetchType.EAGER)
    private Turma turma;

    public Falta() {
    }

    public Falta(long numFaltas, Aluno aluno, Turma turma) {
        Objects.requireNonNull(aluno);
        if (numFaltas < 0) {
            throw new IllegalArgumentException("O numero de faltas não pode ser negativo");
        }
        this.numFaltas = numFaltas;
        this.aluno = aluno;
        this.turma = turma;
        turma.addFalta(this);
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public long getNumFaltas() {
        return numFaltas;
    }

    public Aluno getAluno() {
        return aluno;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (int) (this.numFaltas ^ (this.numFaltas >>> 32));
        hash = 59 * hash + Objects.hashCode(this.aluno);
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
        final Falta other = (Falta) obj;
        if (this.numFaltas != other.numFaltas) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Falta{" + "numFaltas=" + numFaltas + ", aluno=" + aluno + '}';
    }

    public void setNumFaltas(long numFaltas) {
        this.numFaltas = numFaltas;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

}
