package model.pojo;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Nota extends GenericEntity {
    
    private double valorObtido;
    @OneToOne(fetch = FetchType.EAGER)
    private Aluno aluno;
    @ManyToOne(fetch = FetchType.EAGER)
    private Atividade atividade;
    
    public Nota() {
    }
    
    public Nota(double valorObtido, Aluno aluno, Atividade atividade) {
        Objects.requireNonNull(aluno);
        this.valorObtido = valorObtido;
        this.aluno = aluno;
        this.atividade = atividade;
        atividade.addNota(this);
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
        return Objects.equals(this.aluno, other.aluno);
    }
    
    @Override
    public String toString() {
        return "Nota{" + "valorObtido=" + valorObtido + ", aluno=" + aluno + '}';
    }
    
    public void setValorObtido(double valorObtido) {
        this.valorObtido = valorObtido;
    }
    
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }
    
    public Atividade getAtividade() {
        return atividade;
    }
    
}
