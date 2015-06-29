/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.desktop.aluno.nota;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.pojo.Aluno;
import model.pojo.Atividade;
import model.pojo.Nota;
import model.pojo.Turma;
import view.desktop.TelaPrincipal;

/**
 *
 * @author Elias Júnior
 */
public class TelaLancarNota extends javax.swing.JFrame {

    private TelaPrincipal telaPrincipal;
    private Turma turma;
    private Atividade atividade;
    private Aluno aluno;

    /**
     * Creates new form TelaLancarNota
     */
    public TelaLancarNota(TelaPrincipal telaPrincipal) {
        initComponents();
        this.telaPrincipal = telaPrincipal;
        this.carregarListaTurmas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        ListaTurmas = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        ListaAtividades = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        ListaAlunos = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        ValorObtido = new javax.swing.JTextField();
        LancarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lançar nota", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel1.setText("Turma:");

        ListaTurmas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ListaTurmasItemStateChanged(evt);
            }
        });

        jLabel2.setText("Atividade:");

        ListaAtividades.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ListaAtividadesItemStateChanged(evt);
            }
        });

        jLabel3.setText("Aluno:");

        ListaAlunos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ListaAlunosItemStateChanged(evt);
            }
        });

        jLabel4.setText("Valor obtido:");

        LancarButton.setText("Lançar");
        LancarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LancarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ListaTurmas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ListaAtividades, 0, 289, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ListaAlunos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ValorObtido))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(LancarButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ListaTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ListaAtividades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ListaAlunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ValorObtido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LancarButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (this.telaPrincipal != null) {
            this.telaPrincipal.setInitData();
            this.telaPrincipal.setVisible(true);
        }
    }//GEN-LAST:event_formWindowClosing

    private void ListaTurmasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ListaTurmasItemStateChanged
        this.getSelectedTurma();
        this.carregarListaAtividades();
        this.carregarListaAlunos();
        this.getSelectedAtividade();
        this.getSelectedAluno();
    }//GEN-LAST:event_ListaTurmasItemStateChanged

    private void ListaAtividadesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ListaAtividadesItemStateChanged
        this.getSelectedAtividade();
    }//GEN-LAST:event_ListaAtividadesItemStateChanged

    private void ListaAlunosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ListaAlunosItemStateChanged
        this.getSelectedAluno();
    }//GEN-LAST:event_ListaAlunosItemStateChanged

    private void LancarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LancarButtonActionPerformed
        try {
            double valorObtido = Double.parseDouble(this.ValorObtido.getText());
            if (this.aluno == null) {
                JOptionPane.showMessageDialog(this, "Você precisa selecionar um aluno.");
            } else if (this.atividade == null) {
                JOptionPane.showMessageDialog(this, "Você precisa selecionar uma atividade.");
            } else if (this.turma == null) {
                JOptionPane.showMessageDialog(this, "Você precisa selecionar uma turma.");
            } else {
                int index = this.turma.getAtividades().indexOf(this.atividade);
                if (index == -1) {
                    JOptionPane.showMessageDialog(this, "Atividade não encontrada na disciplina.");
                } else {
                    Atividade atividade = this.turma.getAtividades().get(index);
                    Nota nota = atividade.getNotaByAluno(this.aluno);
                    if (nota != null) {
                        JOptionPane.showMessageDialog(this, "A nota já foi lançada.");
                    } else {
                        nota = new Nota(valorObtido, this.aluno, atividade);
                        TelaPrincipal.notaDao.create(nota);
                        atividade.addNota(nota);
                        TelaPrincipal.atividadeDao.edit(atividade);
                        JOptionPane.showMessageDialog(this, "Nota lançada com sucesso.");
                    }
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Formato numérico inválido.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            Logger.getLogger(TelaLancarNota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_LancarButtonActionPerformed

    private void carregarListaTurmas() {
        List<Turma> turmas = TelaPrincipal.turmaDao.findTurmaEntities();
        this.ListaTurmas.removeAllItems();
        turmas.forEach((Turma t) -> {
            String nome = t.getId() + ": " + t.getProfessor().getNome() + " - " + t.getDisciplina().getNome();
            this.ListaTurmas.addItem(nome);
        });
        this.getSelectedTurma();
        this.carregarListaAtividades();
        this.carregarListaAlunos();
        this.getSelectedAtividade();
        this.getSelectedAluno();
    }

    private void getSelectedTurma() {
        String idStr = (String) this.ListaTurmas.getSelectedItem();
        if (idStr == null) {
            this.turma = null;
        } else {
            long id = Long.parseLong(idStr.split(":")[0]);
            Turma turma = TelaPrincipal.turmaDao.findTurma(id);
            this.turma = turma;
        }
    }

    private void carregarListaAtividades() {
        this.ListaAtividades.removeAllItems();
        if (turma != null) {
            turma.getAtividades().forEach((Atividade a) -> {
                String nome = a.getId() + ": " + a.getNome();
                this.ListaAtividades.addItem(nome);
            });
        }
    }

    private void getSelectedAtividade() {
        String idStr = (String) this.ListaTurmas.getSelectedItem();
        if (idStr == null) {
            this.atividade = null;
        } else {
            long id = Long.parseLong(idStr.split(":")[0]);
            Atividade atividade = TelaPrincipal.atividadeDao.findAtividade(id);
            this.atividade = atividade;
        }
    }

    private void carregarListaAlunos() {
        this.ListaAlunos.removeAllItems();
        if (this.turma != null) {
            this.turma.getAlunos().forEach((Aluno a) -> {
                String nome = a.getId() + ": " + a.getNome();
                this.ListaAlunos.addItem(nome);
            });
        }
    }

    private void getSelectedAluno() {
        String idStr = (String) this.ListaTurmas.getSelectedItem();
        if (idStr == null) {
            this.aluno = null;
        } else {
            long id = Long.parseLong(idStr.split(":")[0]);
            Aluno aluno = TelaPrincipal.alunoDao.findAluno(id);
            this.aluno = aluno;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LancarButton;
    private javax.swing.JComboBox ListaAlunos;
    private javax.swing.JComboBox ListaAtividades;
    private javax.swing.JComboBox ListaTurmas;
    private javax.swing.JTextField ValorObtido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
