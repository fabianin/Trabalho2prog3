/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.desktop.aluno;

import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import model.pojo.Aluno;
import view.desktop.TelaPrincipal;

/**
 *
 * @author Elias Júnior
 */
public class TelaCadastrarAluno extends javax.swing.JFrame {

    TelaPrincipal telaPrincipal;

    public TelaCadastrarAluno(TelaPrincipal telaPrincipal) {
        initComponents();
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

        PainelCadastrarAluno = new javax.swing.JPanel();
        NomeLabel = new javax.swing.JLabel();
        MatriculaLabel = new javax.swing.JLabel();
        CpfLabel = new javax.swing.JLabel();
        NomeValue = new javax.swing.JTextField();
        MatriculaValue = new javax.swing.JTextField();
        CpfValue = new javax.swing.JTextField();
        ConfirmButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        PainelCadastrarAluno.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastrar aluno", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        NomeLabel.setText("Nome:");

        MatriculaLabel.setText("Matrícula:");

        CpfLabel.setText("CPF:");

        NomeValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeValueActionPerformed(evt);
            }
        });

        ConfirmButton.setText("Cadastrar");
        ConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelCadastrarAlunoLayout = new javax.swing.GroupLayout(PainelCadastrarAluno);
        PainelCadastrarAluno.setLayout(PainelCadastrarAlunoLayout);
        PainelCadastrarAlunoLayout.setHorizontalGroup(
            PainelCadastrarAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelCadastrarAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelCadastrarAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelCadastrarAlunoLayout.createSequentialGroup()
                        .addComponent(NomeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NomeValue))
                    .addGroup(PainelCadastrarAlunoLayout.createSequentialGroup()
                        .addComponent(CpfLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CpfValue))
                    .addGroup(PainelCadastrarAlunoLayout.createSequentialGroup()
                        .addComponent(MatriculaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MatriculaValue))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelCadastrarAlunoLayout.createSequentialGroup()
                        .addGap(0, 270, Short.MAX_VALUE)
                        .addComponent(ConfirmButton)))
                .addContainerGap())
        );
        PainelCadastrarAlunoLayout.setVerticalGroup(
            PainelCadastrarAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelCadastrarAlunoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelCadastrarAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeLabel)
                    .addComponent(NomeValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelCadastrarAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MatriculaLabel)
                    .addComponent(MatriculaValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelCadastrarAlunoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CpfLabel)
                    .addComponent(CpfValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ConfirmButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PainelCadastrarAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PainelCadastrarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void NomeValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeValueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeValueActionPerformed

    private void ConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmButtonActionPerformed
        try {
            String nome;
            long matricula, cpf;
            nome = this.NomeValue.getText();
            matricula = Long.parseLong(this.MatriculaValue.getText());
            cpf = Long.parseLong(this.CpfValue.getText());
            Aluno aluno = new Aluno(matricula, nome, cpf);
            TelaPrincipal.alunoDao.create(aluno);
            int resposta = JOptionPane.showConfirmDialog(this, "O aluno foi cadastrado. Deseja cadastrar outro?");
            switch (resposta) {
                case 0:
                    this.NomeValue.setText("");
                    this.CpfValue.setText("");
                    this.MatriculaValue.setText("");
                    break;
                default:
                    this.closeFrame();
                    break;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Há um erro no formato da matrícula ou CPF.");
        }
    }//GEN-LAST:event_ConfirmButtonActionPerformed

    private void closeFrame() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        this.dispose();
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSED));
    }

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusLost

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (this.telaPrincipal != null) {
            this.telaPrincipal.setInitData();
            this.telaPrincipal.setVisible(true);
        }
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConfirmButton;
    private javax.swing.JLabel CpfLabel;
    private javax.swing.JTextField CpfValue;
    private javax.swing.JLabel MatriculaLabel;
    private javax.swing.JTextField MatriculaValue;
    private javax.swing.JLabel NomeLabel;
    private javax.swing.JTextField NomeValue;
    private javax.swing.JPanel PainelCadastrarAluno;
    // End of variables declaration//GEN-END:variables
}
