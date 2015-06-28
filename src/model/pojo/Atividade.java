package model.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Atividade extends GenericEntity {

    @Column(nullable = false)
    private String nome;
    @Column(name = "diaDaAtividade", nullable = false)
    private String data;
    private double valor;
    @Column(nullable = false)
    private String tipo;
    @ManyToOne
    private Turma turma;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Nota> notas;

    public Atividade() {
    }

    public Atividade(String nome, String data, long valor, String tipo, Turma turma) {
        Objects.requireNonNull(nome);
        Objects.requireNonNull(data);
        Objects.requireNonNull(tipo);
        Objects.requireNonNull(turma);
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor da atividade não pode ser igual ou menor que 0.");
        }
        this.nome = nome;
        this.data = data;
        this.valor = valor;
        this.tipo = tipo;
        this.turma = turma;
    }

    public String getNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public String getTipo() {
        return tipo;
    }

    public Turma getTurma() {
        return turma;
    }

    public List<Nota> getNotas() {
        if (this.notas == null) {
            this.notas = new ArrayList<>();
        }
        return Collections.unmodifiableList(notas);
    }

    public void addNota(Nota n) {
        if (this.notas == null) {
            notas = new ArrayList<>();
        }
        this.notas.add(n);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.nome);
        hash = 13 * hash + Objects.hashCode(this.data);
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.valor) ^ (Double.doubleToLongBits(this.valor) >>> 32));
        hash = 13 * hash + Objects.hashCode(this.tipo);
        hash = 13 * hash + Objects.hashCode(this.turma);
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
        final Atividade other = (Atividade) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (this.valor != other.valor) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return Objects.equals(this.turma, other.turma);
    }

    public double getNotaByAluno(Aluno a) {
        List<Nota> nota = this.getNotas().stream().filter(x -> x.getAluno() == a).collect(Collectors.toList());
        if (nota == null) {
            throw new IllegalArgumentException("Aluno não matriculado nessa turma ou com nota ainda não lançada.");
        } else {
            return nota.get(0).getValorObtido();
        }
    }

    @Override
    public String toString() {
        return "Atividade{" + "nome=" + nome + ", data=" + data + ", valor=" + valor + ", tipo=" + tipo + ", turma=" + turma + ", notas=" + notas + '}';
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

}
