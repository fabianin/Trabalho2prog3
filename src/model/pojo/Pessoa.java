package model.pojo;

import java.util.Objects;

public abstract class Pessoa extends PojoBase {

    private final String nome;
    private final long cpf;

    public Pessoa() {
        this.cpf=0;
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
    

}
