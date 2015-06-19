package model.pojo;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
@Entity
public class Falta extends GenericEntity {

    private long numFaltas;
    
    @OneToOne
    private Aluno aluno;

    public Falta() {
    }

    public Falta(long numFaltas, Aluno aluno) {
        Objects.requireNonNull(aluno);
        if(numFaltas<0){
            throw new IllegalArgumentException("O numero de faltas não pode ser negativo");
        }
        this.numFaltas = numFaltas;
        this.aluno = aluno;
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
    
    

}
