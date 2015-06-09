package model.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Turma extends GenericEntity {

    private final long ano;
    private final long periodo;
    @Column(name = "local", nullable = false)
    private final String local;
    private final long numVagas;
    private final String horario;
    @ManyToOne
    private final Disciplina disciplinas;
    @ManyToOne
    private Professor professor;
    @ManyToMany
    private List<Aluno> alunos;
    @OneToMany
    private List<Falta> faltas;
    @OneToMany(mappedBy = "turma")
    private List<Atividade> atividades;

    public Turma() {
        this.ano = 0;
        this.periodo = 0;
        this.local = null;
        this.numVagas = 0;
        this.horario = null;
        this.disciplinas = null;
        this.professor = null;
    }

    public Turma(long ano, long periodo, String local, long numVagas, String horario, Disciplina disciplina, Professor professor) {
        Objects.requireNonNull(horario);
        Objects.requireNonNull(disciplina);
        Objects.requireNonNull(professor);
        if(numVagas<0){
            throw new IllegalArgumentException("Numero de vagas não pode ser negativo.");
        }
        this.ano = ano;
        this.periodo = periodo;
        this.local = local;
        this.numVagas = numVagas;
        this.horario = horario;
        this.disciplinas = disciplina;
        this.professor = professor;
    }

    public long getAno() {
        return ano;
    }

    public long getPeriodo() {
        return periodo;
    }

    public String getLocal() {
        return local;
    }

    public long getNumVagas() {
        return numVagas;
    }

    public String getHorario() {
        return horario;
    }

    public Disciplina getDisciplina() {
        return disciplinas;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Aluno> getAlunos() {
        return Collections.unmodifiableList(alunos);
    }

    public List<Atividade> getAtividades() {
        return Collections.unmodifiableList(atividades);
    }

    public List<Falta> getFaltas() {
        return Collections.unmodifiableList(faltas);
    }
    public void addAluno(Aluno a){
        Objects.requireNonNull(a);
        if(this.alunos == null){
            alunos = new ArrayList<>();
        }
        if(alunos.contains(a)){
            throw new IllegalArgumentException("Aluno já está matriculado nessa turma");
        } else{
            alunos.add(a);
        }
    }
    public void addAtividade(Atividade a){
        Objects.requireNonNull(a);
        if(atividades == null){
            atividades = new ArrayList<>();
        }
        if(atividades.contains(a)){
            throw new IllegalArgumentException("atividade já está cadastrada nessa turma");
        } else{
            atividades.add(a);
        }
    }
    public void addFalta(Falta f){
        Objects.requireNonNull(f);
        if(faltas == null){
            faltas = new ArrayList<>();
        }
        if(faltas.contains(f)){
            throw new IllegalArgumentException("Falta já está cadastrada nessa turma");
        } else{
            faltas.add(f);
        }
    }
    public long getFaltaByAluno(Aluno a){
        List<Falta> falta = faltas.stream().filter(x ->x.getAluno() == a).collect(Collectors.toList());
        if(falta == null){
            throw new IllegalArgumentException("Aluno não matriculado nessa turma ou com faltas ainda não lançadas.");
        } else{
            return falta.get(0).getNumFaltas();
        }
    }
    public double getMediaTurma(Aluno a){
        double media = 0;
        double valorMaximoAtividade = 0;
        for(Atividade x: this.getAtividades()){
            media+=x.getNotaByAluno(a);
            valorMaximoAtividade+=x.getValor();
        }
        media = media/valorMaximoAtividade;
        return media;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setAlunos(List<Aluno> arrayList) {
        this.alunos = arrayList;
    }

    public void setAtividades(List<Atividade> arrayList) {
        this.atividades = arrayList;
    }

}
