package model.pojo;

import java.util.Objects;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Pessoa extends GenericEntity {

    private String nome;
    private long cpf;

    public Pessoa() {
        this.cpf = 0;
        this.nome = null;
    }

    public String getNome() {
        return nome;
    }

    public long getCpf() {
        return cpf;
    }

    public Pessoa(String nome, long cpf) {
        Objects.requireNonNull(nome);
        this.nome = nome;
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

}
