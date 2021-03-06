/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.desktop;

import view.desktop.disciplina.TelaListarDisciplinas;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.swing.JOptionPane;
import model.dao.AlunoDao;
import model.dao.AtividadeDao;
import model.dao.DisciplinaDao;
import model.dao.FaltaDao;
import model.dao.NotaDao;
import model.dao.ProfessorDao;
import model.dao.TurmaDao;
import model.dao.jpa.AlunoDaoJpa;
import model.dao.jpa.AtividadeDaoJpa;
import model.dao.jpa.DisciplinaDaoJpa;
import model.dao.jpa.FaltaDaoJpa;
import model.dao.jpa.NotaDaoJpa;
import model.dao.jpa.ProfessorDaoJpa;
import model.dao.jpa.TurmaDaoJpa;
import model.dao.jpa.expections.NonexistentEntityException;
import model.pojo.Turma;
import view.desktop.aluno.TelaCadastrarAluno;
import view.desktop.aluno.TelaDeletarAluno;
import view.desktop.aluno.TelaEditarAluno;
import view.desktop.aluno.TelaInformacoesAluno;
import view.desktop.aluno.TelaListarAlunos;
import view.desktop.aluno.nota.TelaLancarNota;
import view.desktop.atividade.TelaCadastrarAtividade;
import view.desktop.consultas.TelaConsultarTurma;
import view.desktop.consultas.TelaConsultarTurmasOferecidas;
import view.desktop.disciplina.TelaCadastrarDisciplina;
import view.desktop.disciplina.TelaDeletarDisciplina;
import view.desktop.disciplina.TelaEditarDisciplina;
import view.desktop.disciplina.TelaInformacoesDisciplina;
import view.desktop.falta.TelaLancarFalta;
import view.desktop.professor.TelaCadastrarProfessor;
import view.desktop.professor.TelaDeletarProfessor;
import view.desktop.professor.TelaEditarProfessor;
import view.desktop.professor.TelaListarProfessores;
import view.desktop.turma.TelaCadastrarTurma;
import view.desktop.turma.TelaDeletarTurma;
import view.desktop.turma.TelaEditarTurma;
import view.desktop.turma.TelaListarTurmas;

/**
 *
 * @author Elias Júnior
 */
public class TelaPrincipal extends javax.swing.JFrame {
    
    public static EntityManagerFactory emf;
    public static AlunoDao alunoDao;
    public static DisciplinaDao disciplinaDao;
    public static FaltaDao faltaDao;
    public static NotaDao notaDao;
    public static ProfessorDao professorDao;
    public static TurmaDao turmaDao;
    public static AtividadeDao atividadeDao;

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        try {
            emf = Persistence.createEntityManagerFactory("Trabalho2prog3PU");
            alunoDao = new AlunoDaoJpa(emf);
            disciplinaDao = new DisciplinaDaoJpa(emf);
            faltaDao = new FaltaDaoJpa(emf);
            notaDao = new NotaDaoJpa(emf);
            professorDao = new ProfessorDaoJpa(emf);
            turmaDao = new TurmaDaoJpa(emf);
            atividadeDao = new AtividadeDaoJpa(emf);
            setInitData();
        } catch (Exception ex) {
            this.disableEverything(ex.getMessage());
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void disableEverything() {
        this.disableEverything("Erro desconhecido.");
    }
    
    public void disableEverything(String msg) {
        this.setVisible(false);
        JOptionPane.showMessageDialog(this, msg);
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        this.dispose();
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSED));
    }

    /**
     * Define o conteúdo inicial da tela
     */
    public void setInitData() {
        this.AlunosCadastradosValue.setText(String.valueOf(TelaPrincipal.alunoDao.getAlunoCount()));
        this.DisciplinasCadastradasValue.setText(String.valueOf(TelaPrincipal.disciplinaDao.getDisciplinaCount()));
        this.ProfessoresCadastradosValue.setText(String.valueOf(TelaPrincipal.professorDao.getProfessorCount()));
        this.TurmasCadastradasValue.setText(String.valueOf(TelaPrincipal.turmaDao.getTurmaCount()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelEstatisticas = new javax.swing.JPanel();
        AlunosCadastradosLabel = new javax.swing.JLabel();
        AlunosCadastradosValue = new javax.swing.JLabel();
        ProfessoresCadastradosLabel = new javax.swing.JLabel();
        ProfessoresCadastradosValue = new javax.swing.JLabel();
        DisciplinasCadastradasLabel = new javax.swing.JLabel();
        DisciplinasCadastradasValue = new javax.swing.JLabel();
        TurmasCadastradasLabel = new javax.swing.JLabel();
        TurmasCadastradasValue = new javax.swing.JLabel();
        PainelInstrucoes = new javax.swing.JPanel();
        instrucoesLinha1 = new javax.swing.JLabel();
        instrucoesLinha2 = new javax.swing.JLabel();
        instrucoesLinha3 = new javax.swing.JLabel();
        MenuPrincipal = new javax.swing.JMenuBar();
        MenuAluno = new javax.swing.JMenu();
        MenuCadastrarAluno = new javax.swing.JMenuItem();
        MenuDeletarAluno = new javax.swing.JMenuItem();
        MenuEditarAluno = new javax.swing.JMenuItem();
        MenuListarAlunos = new javax.swing.JMenuItem();
        MenuInformacoesAluno = new javax.swing.JMenuItem();
        MenuProfessor = new javax.swing.JMenu();
        MenuCadastrarProfessor = new javax.swing.JMenuItem();
        MenuDeletarProfessor = new javax.swing.JMenuItem();
        MenuEditarProfessor = new javax.swing.JMenuItem();
        MenuListarProfessores = new javax.swing.JMenuItem();
        MenuDisciplina = new javax.swing.JMenu();
        MenuCadastrarDisciplina = new javax.swing.JMenuItem();
        MenuDeletarDisciplina = new javax.swing.JMenuItem();
        MenuEditarDisciplina = new javax.swing.JMenuItem();
        MenuListarDisciplinas = new javax.swing.JMenuItem();
        MenuVisualizarDisciplina = new javax.swing.JMenuItem();
        MenuTurma = new javax.swing.JMenu();
        MenuCadastrarTurma = new javax.swing.JMenuItem();
        MenuDeletarTurma = new javax.swing.JMenuItem();
        MenuEditarTurma = new javax.swing.JMenuItem();
        MenuListarTurmas = new javax.swing.JMenuItem();
        MenuNota = new javax.swing.JMenu();
        MenuLancarNota = new javax.swing.JMenuItem();
        MenuAtividade = new javax.swing.JMenu();
        MenuCadastrarAtividade = new javax.swing.JMenuItem();
        MenuConsultas = new javax.swing.JMenu();
        MenuConsultarTurmas = new javax.swing.JMenuItem();
        MenuConsultarTurmasOferecidas = new javax.swing.JMenuItem();
        MenuFalta = new javax.swing.JMenu();
        MenuLancarFalta = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        PanelEstatisticas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estatísticas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        AlunosCadastradosLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        AlunosCadastradosLabel.setText("Alunos cadastrados:");

        AlunosCadastradosValue.setText("0");

        ProfessoresCadastradosLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ProfessoresCadastradosLabel.setText("Professores cadastrados:");

        ProfessoresCadastradosValue.setText("0");

        DisciplinasCadastradasLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DisciplinasCadastradasLabel.setText("Disciplinas cadastradas:");

        DisciplinasCadastradasValue.setText("0");

        TurmasCadastradasLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TurmasCadastradasLabel.setText("Turmas cadastradas:");

        TurmasCadastradasValue.setText("0");

        javax.swing.GroupLayout PanelEstatisticasLayout = new javax.swing.GroupLayout(PanelEstatisticas);
        PanelEstatisticas.setLayout(PanelEstatisticasLayout);
        PanelEstatisticasLayout.setHorizontalGroup(
            PanelEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEstatisticasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelEstatisticasLayout.createSequentialGroup()
                        .addComponent(AlunosCadastradosLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(AlunosCadastradosValue))
                    .addGroup(PanelEstatisticasLayout.createSequentialGroup()
                        .addComponent(ProfessoresCadastradosLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ProfessoresCadastradosValue))
                    .addGroup(PanelEstatisticasLayout.createSequentialGroup()
                        .addComponent(DisciplinasCadastradasLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DisciplinasCadastradasValue))
                    .addGroup(PanelEstatisticasLayout.createSequentialGroup()
                        .addComponent(TurmasCadastradasLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TurmasCadastradasValue)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelEstatisticasLayout.setVerticalGroup(
            PanelEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEstatisticasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AlunosCadastradosLabel)
                    .addComponent(AlunosCadastradosValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProfessoresCadastradosLabel)
                    .addComponent(ProfessoresCadastradosValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DisciplinasCadastradasLabel)
                    .addComponent(DisciplinasCadastradasValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelEstatisticasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TurmasCadastradasLabel)
                    .addComponent(TurmasCadastradasValue))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PainelInstrucoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Instruções", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        instrucoesLinha1.setText("Seja bem vindo ao sistema de gerenciamento escolar. No menu superior você deve abrir a sessão que deseja, por exemplo:");
        instrucoesLinha1.setMaximumSize(new java.awt.Dimension(1024, 14));

        instrucoesLinha2.setText("Caso você queira gerenciar os alunos, como cadastrar, clique na aba \"Aluno\" e selecione \"Cadastrar aluno\". ");

        instrucoesLinha3.setText("Sempre que você realizar uma ação no programa, automaticamente ele será salvo e não será possível restaurar os dados anteriores.");

        javax.swing.GroupLayout PainelInstrucoesLayout = new javax.swing.GroupLayout(PainelInstrucoes);
        PainelInstrucoes.setLayout(PainelInstrucoesLayout);
        PainelInstrucoesLayout.setHorizontalGroup(
            PainelInstrucoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelInstrucoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelInstrucoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(instrucoesLinha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PainelInstrucoesLayout.createSequentialGroup()
                        .addGroup(PainelInstrucoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PainelInstrucoesLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(instrucoesLinha2))
                            .addComponent(instrucoesLinha3))
                        .addGap(0, 334, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PainelInstrucoesLayout.setVerticalGroup(
            PainelInstrucoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelInstrucoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(instrucoesLinha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instrucoesLinha2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instrucoesLinha3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MenuAluno.setText("Aluno");
        MenuAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAlunoActionPerformed(evt);
            }
        });

        MenuCadastrarAluno.setText("Cadastrar aluno");
        MenuCadastrarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastrarAlunoActionPerformed(evt);
            }
        });
        MenuAluno.add(MenuCadastrarAluno);

        MenuDeletarAluno.setText("Deletar aluno");
        MenuDeletarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuDeletarAlunoActionPerformed(evt);
            }
        });
        MenuAluno.add(MenuDeletarAluno);

        MenuEditarAluno.setText("Editar aluno");
        MenuEditarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEditarAlunoActionPerformed(evt);
            }
        });
        MenuAluno.add(MenuEditarAluno);

        MenuListarAlunos.setText("Listar alunos");
        MenuListarAlunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuListarAlunosActionPerformed(evt);
            }
        });
        MenuAluno.add(MenuListarAlunos);

        MenuInformacoesAluno.setText("Informações de aluno");
        MenuInformacoesAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuInformacoesAlunoActionPerformed(evt);
            }
        });
        MenuAluno.add(MenuInformacoesAluno);

        MenuPrincipal.add(MenuAluno);

        MenuProfessor.setText("Professor");

        MenuCadastrarProfessor.setText("Cadastrar professor");
        MenuCadastrarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastrarProfessorActionPerformed(evt);
            }
        });
        MenuProfessor.add(MenuCadastrarProfessor);

        MenuDeletarProfessor.setText("Deletar professor");
        MenuDeletarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuDeletarProfessorActionPerformed(evt);
            }
        });
        MenuProfessor.add(MenuDeletarProfessor);

        MenuEditarProfessor.setText("Editar professor");
        MenuEditarProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEditarProfessorActionPerformed(evt);
            }
        });
        MenuProfessor.add(MenuEditarProfessor);

        MenuListarProfessores.setText("Listar professores");
        MenuListarProfessores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuListarProfessoresActionPerformed(evt);
            }
        });
        MenuProfessor.add(MenuListarProfessores);

        MenuPrincipal.add(MenuProfessor);

        MenuDisciplina.setText("Disciplina");

        MenuCadastrarDisciplina.setText("Cadastrar disciplina");
        MenuCadastrarDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastrarDisciplinaActionPerformed(evt);
            }
        });
        MenuDisciplina.add(MenuCadastrarDisciplina);

        MenuDeletarDisciplina.setText("Deletar disciplina");
        MenuDeletarDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuDeletarDisciplinaActionPerformed(evt);
            }
        });
        MenuDisciplina.add(MenuDeletarDisciplina);

        MenuEditarDisciplina.setText("Editar disciplina");
        MenuEditarDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEditarDisciplinaActionPerformed(evt);
            }
        });
        MenuDisciplina.add(MenuEditarDisciplina);

        MenuListarDisciplinas.setText("Listar disciplinas");
        MenuListarDisciplinas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuListarDisciplinasActionPerformed(evt);
            }
        });
        MenuDisciplina.add(MenuListarDisciplinas);

        MenuVisualizarDisciplina.setText("Informações da disciplina");
        MenuVisualizarDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuVisualizarDisciplinaActionPerformed(evt);
            }
        });
        MenuDisciplina.add(MenuVisualizarDisciplina);

        MenuPrincipal.add(MenuDisciplina);

        MenuTurma.setText("Turma");

        MenuCadastrarTurma.setText("Cadastrar turma");
        MenuCadastrarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastrarTurmaActionPerformed(evt);
            }
        });
        MenuTurma.add(MenuCadastrarTurma);

        MenuDeletarTurma.setText("Deletar turma");
        MenuDeletarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuDeletarTurmaActionPerformed(evt);
            }
        });
        MenuTurma.add(MenuDeletarTurma);

        MenuEditarTurma.setText("Editar turma");
        MenuEditarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuEditarTurmaActionPerformed(evt);
            }
        });
        MenuTurma.add(MenuEditarTurma);

        MenuListarTurmas.setText("Listar turmas");
        MenuListarTurmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuListarTurmasActionPerformed(evt);
            }
        });
        MenuTurma.add(MenuListarTurmas);

        MenuPrincipal.add(MenuTurma);

        MenuNota.setText("Nota");

        MenuLancarNota.setText("Lançar nota");
        MenuLancarNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuLancarNotaActionPerformed(evt);
            }
        });
        MenuNota.add(MenuLancarNota);

        MenuPrincipal.add(MenuNota);

        MenuAtividade.setText("Atividade");

        MenuCadastrarAtividade.setText("Cadastrar atividade");
        MenuCadastrarAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCadastrarAtividadeActionPerformed(evt);
            }
        });
        MenuAtividade.add(MenuCadastrarAtividade);

        MenuPrincipal.add(MenuAtividade);

        MenuConsultas.setText("Consultas");

        MenuConsultarTurmas.setText("Consultar turmas");
        MenuConsultarTurmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuConsultarTurmasActionPerformed(evt);
            }
        });
        MenuConsultas.add(MenuConsultarTurmas);

        MenuConsultarTurmasOferecidas.setText("Consultar turmas oferecidas");
        MenuConsultarTurmasOferecidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuConsultarTurmasOferecidasActionPerformed(evt);
            }
        });
        MenuConsultas.add(MenuConsultarTurmasOferecidas);

        MenuPrincipal.add(MenuConsultas);

        MenuFalta.setText("Falta");

        MenuLancarFalta.setText("Lançar falta");
        MenuLancarFalta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuLancarFaltaActionPerformed(evt);
            }
        });
        MenuFalta.add(MenuLancarFalta);

        MenuPrincipal.add(MenuFalta);

        setJMenuBar(MenuPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelEstatisticas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PainelInstrucoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelEstatisticas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PainelInstrucoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(493, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MenuCadastrarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastrarAlunoActionPerformed
        TelaCadastrarAluno cadastrarAluno = new TelaCadastrarAluno(this);
        cadastrarAluno.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuCadastrarAlunoActionPerformed

    private void MenuDeletarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuDeletarAlunoActionPerformed
        TelaDeletarAluno deletarAluno = new TelaDeletarAluno(this);
        deletarAluno.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuDeletarAlunoActionPerformed

    private void MenuCadastrarProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastrarProfessorActionPerformed
        TelaCadastrarProfessor cadastrarProfessor = new TelaCadastrarProfessor(this);
        cadastrarProfessor.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuCadastrarProfessorActionPerformed

    private void MenuDeletarProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuDeletarProfessorActionPerformed
        TelaDeletarProfessor deletarProfessor = new TelaDeletarProfessor(this);
        deletarProfessor.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuDeletarProfessorActionPerformed

    private void MenuCadastrarDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastrarDisciplinaActionPerformed
        TelaCadastrarDisciplina cadastrarDisciplina = new TelaCadastrarDisciplina(this);
        cadastrarDisciplina.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuCadastrarDisciplinaActionPerformed

    private void MenuDeletarDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuDeletarDisciplinaActionPerformed
        TelaDeletarDisciplina deletarDisciplina = new TelaDeletarDisciplina(this);
        deletarDisciplina.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuDeletarDisciplinaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (emf != null) {
            emf.close();
        }
    }//GEN-LAST:event_formWindowClosing

    private void MenuCadastrarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastrarTurmaActionPerformed
        TelaCadastrarTurma cadastrarTurma = new TelaCadastrarTurma(this);
        cadastrarTurma.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuCadastrarTurmaActionPerformed

    private void MenuDeletarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuDeletarTurmaActionPerformed
        TelaDeletarTurma deletarTurma = new TelaDeletarTurma(this);
        deletarTurma.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuDeletarTurmaActionPerformed

    private void MenuEditarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEditarAlunoActionPerformed
        TelaEditarAluno editarAluno = new TelaEditarAluno(this);
        editarAluno.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuEditarAlunoActionPerformed

    private void MenuAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAlunoActionPerformed

    }//GEN-LAST:event_MenuAlunoActionPerformed

    private void MenuListarAlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuListarAlunosActionPerformed
        TelaListarAlunos listarAlunos = new TelaListarAlunos(this);
        listarAlunos.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuListarAlunosActionPerformed

    private void MenuInformacoesAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuInformacoesAlunoActionPerformed
        TelaInformacoesAluno informacoesAluno = new TelaInformacoesAluno(this);
        informacoesAluno.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuInformacoesAlunoActionPerformed

    private void MenuEditarDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEditarDisciplinaActionPerformed
        TelaEditarDisciplina editarDisciplina = new TelaEditarDisciplina(this);
        editarDisciplina.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuEditarDisciplinaActionPerformed

    private void MenuVisualizarDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuVisualizarDisciplinaActionPerformed
        TelaInformacoesDisciplina informacoesDisciplina = new TelaInformacoesDisciplina(this);
        informacoesDisciplina.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuVisualizarDisciplinaActionPerformed

    private void MenuListarDisciplinasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuListarDisciplinasActionPerformed
        TelaListarDisciplinas listarDisciplinas = new TelaListarDisciplinas(this);
        listarDisciplinas.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuListarDisciplinasActionPerformed

    private void MenuEditarProfessorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEditarProfessorActionPerformed
        TelaEditarProfessor editarProfessor = new TelaEditarProfessor(this);
        editarProfessor.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuEditarProfessorActionPerformed

    private void MenuListarProfessoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuListarProfessoresActionPerformed
        TelaListarProfessores listarProfessores = new TelaListarProfessores(this);
        listarProfessores.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuListarProfessoresActionPerformed

    private void MenuEditarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuEditarTurmaActionPerformed
        TelaEditarTurma editarTurma = new TelaEditarTurma(this);
        editarTurma.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuEditarTurmaActionPerformed

    private void MenuListarTurmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuListarTurmasActionPerformed
        TelaListarTurmas listarTurmas = new TelaListarTurmas(this);
        listarTurmas.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuListarTurmasActionPerformed

    private void MenuLancarNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuLancarNotaActionPerformed
        TelaLancarNota lancarNota = new TelaLancarNota(this);
        lancarNota.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuLancarNotaActionPerformed

    private void MenuCadastrarAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCadastrarAtividadeActionPerformed
        TelaCadastrarAtividade cadastrarAtividade = new TelaCadastrarAtividade(this);
        cadastrarAtividade.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuCadastrarAtividadeActionPerformed

    private void MenuConsultarTurmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuConsultarTurmasActionPerformed
        TelaConsultarTurma consultarTurma = new TelaConsultarTurma(this);
        consultarTurma.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuConsultarTurmasActionPerformed

    private void MenuConsultarTurmasOferecidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuConsultarTurmasOferecidasActionPerformed
        TelaConsultarTurmasOferecidas turmasOferecidas = new TelaConsultarTurmasOferecidas(this);
        turmasOferecidas.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuConsultarTurmasOferecidasActionPerformed

    private void MenuLancarFaltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuLancarFaltaActionPerformed
        TelaLancarFalta lancarFalta = new TelaLancarFalta(this);
        lancarFalta.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MenuLancarFaltaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AlunosCadastradosLabel;
    private javax.swing.JLabel AlunosCadastradosValue;
    private javax.swing.JLabel DisciplinasCadastradasLabel;
    private javax.swing.JLabel DisciplinasCadastradasValue;
    private javax.swing.JMenu MenuAluno;
    private javax.swing.JMenu MenuAtividade;
    private javax.swing.JMenuItem MenuCadastrarAluno;
    private javax.swing.JMenuItem MenuCadastrarAtividade;
    private javax.swing.JMenuItem MenuCadastrarDisciplina;
    private javax.swing.JMenuItem MenuCadastrarProfessor;
    private javax.swing.JMenuItem MenuCadastrarTurma;
    private javax.swing.JMenuItem MenuConsultarTurmas;
    private javax.swing.JMenuItem MenuConsultarTurmasOferecidas;
    private javax.swing.JMenu MenuConsultas;
    private javax.swing.JMenuItem MenuDeletarAluno;
    private javax.swing.JMenuItem MenuDeletarDisciplina;
    private javax.swing.JMenuItem MenuDeletarProfessor;
    private javax.swing.JMenuItem MenuDeletarTurma;
    private javax.swing.JMenu MenuDisciplina;
    private javax.swing.JMenuItem MenuEditarAluno;
    private javax.swing.JMenuItem MenuEditarDisciplina;
    private javax.swing.JMenuItem MenuEditarProfessor;
    private javax.swing.JMenuItem MenuEditarTurma;
    private javax.swing.JMenu MenuFalta;
    private javax.swing.JMenuItem MenuInformacoesAluno;
    private javax.swing.JMenuItem MenuLancarFalta;
    private javax.swing.JMenuItem MenuLancarNota;
    private javax.swing.JMenuItem MenuListarAlunos;
    private javax.swing.JMenuItem MenuListarDisciplinas;
    private javax.swing.JMenuItem MenuListarProfessores;
    private javax.swing.JMenuItem MenuListarTurmas;
    private javax.swing.JMenu MenuNota;
    private javax.swing.JMenuBar MenuPrincipal;
    private javax.swing.JMenu MenuProfessor;
    private javax.swing.JMenu MenuTurma;
    private javax.swing.JMenuItem MenuVisualizarDisciplina;
    private javax.swing.JPanel PainelInstrucoes;
    private javax.swing.JPanel PanelEstatisticas;
    private javax.swing.JLabel ProfessoresCadastradosLabel;
    private javax.swing.JLabel ProfessoresCadastradosValue;
    private javax.swing.JLabel TurmasCadastradasLabel;
    private javax.swing.JLabel TurmasCadastradasValue;
    private javax.swing.JLabel instrucoesLinha1;
    private javax.swing.JLabel instrucoesLinha2;
    private javax.swing.JLabel instrucoesLinha3;
    // End of variables declaration//GEN-END:variables
}
