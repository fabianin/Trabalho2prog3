package model.pojo;

import java.util.Objects;
import javax.persistence.Entity;

@Entity
public class Nota extends GenericEntity {

	private final double valorObtido;
	private final Aluno aluno;

    public Nota(double valorObtido, Aluno aluno) {
        Objects.requireNonNull(aluno);
        this.valorObtido = valorObtido;
        this.aluno = aluno;
    }

    public double getValorObtido() {
        return valorObtido;
    }

    public Aluno getAluno() {
        return aluno;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.valorObtido) ^ (Double.doubleToLongBits(this.valorObtido) >>> 32));
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
        final Nota other = (Nota) obj;
        if (Double.doubleToLongBits(this.valorObtido) != Double.doubleToLongBits(other.valorObtido)) {
            return false;
        }
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nota{" + "valorObtido=" + valorObtido + ", aluno=" + aluno + '}';
    }
    

}
