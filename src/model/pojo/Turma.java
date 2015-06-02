package model.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Turma extends PojoBase {

    private final long ano;
    private final long periodo;
    private final String local;
    private final long numVagas;
    private final String horario;
    private final Disciplina disciplina;
    private final Professor professor;
    private ArrayList<Aluno> alunos;
    private ArrayList<Atividade> atividades;
    private ArrayList<Falta> faltas;

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
        this.disciplina = disciplina;
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
        return disciplina;
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

}
