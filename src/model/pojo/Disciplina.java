package model.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Disciplina extends GenericEntity {

    private String nome;
    private String ementa;
    private long cargaHoraria;
    @OneToMany(mappedBy = "disciplinas")
    private List<Turma> turmas;
    @ManyToMany
    private List<Professor> professoresAptos;

    public Disciplina() {
    }

    public Disciplina(String nome, String ementa, long cargaHoraria) throws IllegalArgumentException {
        Objects.requireNonNull(nome);
        Objects.requireNonNull(ementa);
        if(cargaHoraria<1){
            throw new IllegalArgumentException("Valor da carga horaria não pode ser negativo");
        }
        this.nome = nome;
        this.ementa = ementa;
        this.cargaHoraria = cargaHoraria;
    }

    public void addProfessorApto(Professor p) {
        Objects.requireNonNull(p);
        if (professoresAptos == null) {
            professoresAptos = new ArrayList<>();
        }
        this.professoresAptos.add(p);
    }

    public void addTurmaDisciplina(Turma t) {
        Objects.requireNonNull(t);
        if (this.turmas == null) {
            this.turmas = new ArrayList<>();
        }
        this.turmas.add(t);
    }

    public String getNome() {
        return nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public long getCargaHoraria() {
        return cargaHoraria;
    }

    public List<Turma> getTurmas() {
        if(this.turmas == null){
            this.turmas = new ArrayList<>();
        }
        return Collections.unmodifiableList(turmas);
    }

    public List<Professor> getProfessoresAptos() {
        if(this.professoresAptos == null){
            this.professoresAptos = new ArrayList<>();
        }
        return Collections.unmodifiableList(professoresAptos);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.ementa);
        hash = 59 * hash + (int) (this.cargaHoraria ^ (this.cargaHoraria >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != getClass()) {
            return false;
        } else {
        }
        final Disciplina other = (Disciplina) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.ementa, other.ementa)) {
            return false;
        }
        return this.cargaHoraria == other.cargaHoraria;
    }

    @Override
    public String toString() {
        return "Disciplina{" + "nome=" + nome + ", ementa=" + ementa + ", cargaHoraria=" + cargaHoraria + ", turmas=" + turmas + ", professoresAptos=" + professoresAptos + '}';
    }

    public void setProfessoresAptos(List<Professor> arrayList) {
        this.professoresAptos = arrayList;
    }

}
