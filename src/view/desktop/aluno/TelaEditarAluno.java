/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.desktop.aluno;

import java.awt.Component;
import java.awt.event.WindowEvent;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import model.pojo.Aluno;
import view.desktop.TelaPrincipal;

/**
 *
 * @author Elias Júnior
 */
public class TelaEditarAluno extends javax.swing.JFrame {

    TelaPrincipal telaPrincipal;

    /**
     * Creates new form TelaEditarAluno
     */
    public TelaEditarAluno(TelaPrincipal telaPrincipal) {
        initComponents();
        this.togglePainelEditarAlunoFields(false);
        this.telaPrincipal = telaPrincipal;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelEditarAluno = new javax.swing.JPanel();
        MatriculaLabel = new javax.swing.JLabel();
        MatriculaValue = new javax.swing.JTextField();
        EditarButton = new javax.swing.JButton();
        PainelEditarAlunoFields = new javax.swing.JPanel();
        EditNomeLabel = new javax.swing.JLabel();
        EditNomeValue = new javax.swing.JTextField();
        EditMatriculaLabel = new javax.swing.JLabel();
        EditMatriculaValue = new javax.swing.JTextField();
        EditCpfLabel = new javax.swing.JLabel();
        EditCpfValue = new javax.swing.JTextField();
        SalvarButton = new javax.swing.JButton();
        EditIdLabel = new javax.swing.JLabel();
        EditIdValue = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        PainelEditarAluno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar aluno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        MatriculaLabel.setText("Matrícula:");

        EditarButton.setText("Editar");
        EditarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarButtonActionPerformed(evt);
            }
        });

        PainelEditarAlunoFields.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do aluno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        PainelEditarAlunoFields.setDoubleBuffered(false);

        EditNomeLabel.setText("Nome:");

        EditMatriculaLabel.setText("Matrícula:");

        EditCpfLabel.setText("CPF:");

        SalvarButton.setText("Salvar");
        SalvarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalvarButtonActionPerformed(evt);
            }
        });

        EditIdLabel.setText("ID:");

        javax.swing.GroupLayout PainelEditarAlunoFieldsLayout = new javax.swing.GroupLayout(PainelEditarAlunoFields);
        PainelEditarAlunoFields.setLayout(PainelEditarAlunoFieldsLayout);
        PainelEditarAlunoFieldsLayout.setHorizontalGroup(
            PainelEditarAlunoFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelEditarAlunoFieldsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelEditarAlunoFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelEditarAlunoFieldsLayout.createSequentialGroup()
                        .addComponent(EditNomeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EditNomeValue))
                    .addGroup(PainelEditarAlunoFieldsLayout.createSequentialGroup()
                        .addComponent(EditMatriculaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EditMatriculaValue))
                    .addGroup(PainelEditarAlunoFieldsLayout.createSequentialGroup()
                        .addComponent(EditCpfLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EditCpfValue))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelEditarAlunoFieldsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(SalvarButton))
                    .addGroup(PainelEditarAlunoFieldsLayout.createSequentialGroup()
                        .addComponent(EditIdLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EditIdValue)))
                .addContainerGap())
        );
        PainelEditarAlunoFieldsLayout.setVerticalGroup(
            PainelEditarAlunoFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelEditarAlunoFieldsLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(PainelEditarAlunoFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditIdLabel)
                    .addComponent(EditIdValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelEditarAlunoFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditNomeLabel)
                    .addComponent(EditNomeValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelEditarAlunoFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditMatriculaLabel)
                    .addComponent(EditMatriculaValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelEditarAlunoFieldsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditCpfLabel)
                    .addComponent(EditCpfValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SalvarButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PainelEditarAlunoLayout = new javax.swing.GroupLayout(PainelEditarAluno);
        PainelEditarAluno.setLayout(PainelEditarAlunoLayout);
        PainelEditarAlunoLayout.setHorizontalGroup(
            PainelEditarAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelEditarAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelEditarAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PainelEditarAlunoFields, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PainelEditarAlunoLayout.createSequentialGroup()
                        .addComponent(MatriculaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MatriculaValue, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EditarButton)))
                .addContainerGap())
        );
        PainelEditarAlunoLayout.setVerticalGroup(
            PainelEditarAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelEditarAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelEditarAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MatriculaLabel)
                    .addComponent(EditarButton)
                    .addComponent(MatriculaValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PainelEditarAlunoFields, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PainelEditarAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PainelEditarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void EditarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarButtonActionPerformed
        try {
            long matricula = Long.parseLong(this.MatriculaValue.getText());
            List<Aluno> alunos = TelaPrincipal.alunoDao.findAlunoEntities().stream().filter((a) -> a.getMatricula() == matricula).collect(Collectors.toList());
            if (alunos.size() == 0) {
                JOptionPane.showMessageDialog(this, "Nenhum aluno foi encontrado com essa matrícula.");
            } else {
                this.carregarPainelAluno(alunos.get(0));
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Formato da matrícula inválido.");
        }
    }//GEN-LAST:event_EditarButtonActionPerformed

    private void SalvarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarButtonActionPerformed
        try {
            long id = Long.parseLong(this.EditIdValue.getText());
            String nome = this.EditNomeValue.getText();
            long cpf = Long.parseLong(this.EditCpfValue.getText());
            long matricula = Long.parseLong(this.EditMatriculaValue.getText());
            Aluno aluno = TelaPrincipal.alunoDao.findAluno(id);
            if (aluno == null) {
                JOptionPane.showMessageDialog(this, "Não foi encontrado o aluno.");
            } else {
                aluno.setNome(nome);
                aluno.setMatricula(matricula);
                aluno.setCpf(cpf);
                TelaPrincipal.alunoDao.edit(aluno);
                JOptionPane.showMessageDialog(this, "Aluno salvo com sucesso.");
                this.limparPainelAluno();
                this.togglePainelEditarAlunoFields(false);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Erro com os formatos numéricos.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_SalvarButtonActionPerformed

    private void carregarPainelAluno(Aluno aluno) {
        this.togglePainelEditarAlunoFields(true);
        this.EditIdValue.setText(String.valueOf(aluno.getId()));
        this.EditCpfValue.setText(String.valueOf(aluno.getCpf()));
        this.EditNomeValue.setText(aluno.getNome());
        this.EditMatriculaValue.setText(String.valueOf(aluno.getMatricula()));
    }

    private void limparPainelAluno() {
        this.EditIdValue.setText("");
        this.EditCpfValue.setText("");
        this.EditNomeValue.setText("");
        this.EditMatriculaValue.setText("");
    }

    private void togglePainelEditarAlunoFields(boolean status) {
        Component[] fields = this.PainelEditarAlunoFields.getComponents();
        for (Component field : fields) {
            field.setEnabled(status);
        }
        this.EditIdValue.setEnabled(false);
    }

    private void closeFrame() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        this.dispose();
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSED));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EditCpfLabel;
    private javax.swing.JTextField EditCpfValue;
    private javax.swing.JLabel EditIdLabel;
    private javax.swing.JTextField EditIdValue;
    private javax.swing.JLabel EditMatriculaLabel;
    private javax.swing.JTextField EditMatriculaValue;
    private javax.swing.JLabel EditNomeLabel;
    private javax.swing.JTextField EditNomeValue;
    private javax.swing.JButton EditarButton;
    private javax.swing.JLabel MatriculaLabel;
    private javax.swing.JTextField MatriculaValue;
    private javax.swing.JPanel PainelEditarAluno;
    private javax.swing.JPanel PainelEditarAlunoFields;
    private javax.swing.JButton SalvarButton;
    // End of variables declaration//GEN-END:variables
}
