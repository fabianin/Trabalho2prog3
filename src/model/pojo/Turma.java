package model.pojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Turma extends GenericEntity {

    private long ano;
    private long periodo;
    @Column(name = "localAula", nullable = false)
    private String local;
    private long numVagas;
    private String horario;
    @ManyToOne(fetch = FetchType.EAGER)
    private Disciplina disciplinas;
    @ManyToOne(fetch = FetchType.EAGER)
    private Professor professor;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "turmas")
    private List<Aluno> alunos;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Falta> faltas;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "turma")
    private List<Atividade> atividades;

    public Turma() {

    }

    public Turma(long ano, long periodo, String local, long numVagas, String horario, Disciplina disciplina, Professor professor) {
        Objects.requireNonNull(horario);
        Objects.requireNonNull(disciplina);
        Objects.requireNonNull(professor);
        if (numVagas < 0) {
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
        if (this.alunos == null) {
            this.alunos = new ArrayList<>();
        }
        return alunos;
    }

    public List<Atividade> getAtividades() {
        if (this.atividades == null) {
            this.atividades = new ArrayList<>();
        }
        return atividades;
    }

    public List<Falta> getFaltas() {
        if (this.faltas == null) {
            this.faltas = new ArrayList<>();
        }
        return faltas;
    }

    public void addAluno(Aluno a) {
        Objects.requireNonNull(a);
        if (this.alunos == null) {
            alunos = new ArrayList<>();
        }
        if (alunos.contains(a)) {
            throw new IllegalArgumentException("Aluno já está matriculado nessa turma");
        } else {
            alunos.add(a);
        }
    }

    public void addAtividade(Atividade a) {
        Objects.requireNonNull(a);
        if (atividades == null) {
            atividades = new ArrayList<>();
        }
        if (atividades.contains(a)) {
            throw new IllegalArgumentException("atividade já está cadastrada nessa turma");
        } else {
            atividades.add(a);
        }
    }

    public void addFalta(Falta f) {
        Objects.requireNonNull(f);
        if (faltas == null) {
            faltas = new ArrayList<>();
        }
        if (faltas.contains(f)) {
            throw new IllegalArgumentException("Falta já está cadastrada nessa turma");
        } else {
            faltas.add(f);
        }
    }

    public long getFaltaByAluno(Aluno a) {
        List<Falta> falta = faltas.stream().filter(x -> x.getAluno() == a).collect(Collectors.toList());
        if (falta.size() == 0) {
            return -1;
        } else {
            return falta.get(0).getNumFaltas();
        }
    }

    public double getMediaTurma(Aluno a) {
        double media = 0;
        double valorMaximoAtividade = 0;
        for (Atividade x : this.getAtividades()) {
            Nota nota = x.getNotaByAluno(a);
            media += nota.getValorObtido();
            valorMaximoAtividade += x.getValor();
        }
        media = media / valorMaximoAtividade;
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

    public void setAno(long ano) {
        this.ano = ano;
    }

    public void setPeriodo(long periodo) {
        this.periodo = periodo;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setNumVagas(long numVagas) {
        this.numVagas = numVagas;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setDisciplinas(Disciplina disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void setFaltas(List<Falta> faltas) {
        this.faltas = faltas;
    }

}
