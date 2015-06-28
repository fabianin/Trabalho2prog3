/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.desktop.disciplina;

import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import model.pojo.Disciplina;
import view.desktop.TelaPrincipal;

/**
 *
 * @author Elias Júnior
 */
public class TelaCadastrarDisciplina extends javax.swing.JFrame {

    TelaPrincipal telaPrincipal;

    public TelaCadastrarDisciplina(TelaPrincipal telaPrincipal) {
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

        PainelCadastrarDisciplina = new javax.swing.JPanel();
        NomeLabel = new javax.swing.JLabel();
        EmentaLabel = new javax.swing.JLabel();
        CargaHorariaLabel = new javax.swing.JLabel();
        NomeValue = new javax.swing.JTextField();
        EmentaValue = new javax.swing.JTextField();
        CargaHorariaValue = new javax.swing.JTextField();
        CadastrarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        PainelCadastrarDisciplina.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastrar disciplina", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        NomeLabel.setText("Nome:");

        EmentaLabel.setText("Ementa:");

        CargaHorariaLabel.setText("Carga horária:");

        CadastrarButton.setText("Cadastrar");
        CadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelCadastrarDisciplinaLayout = new javax.swing.GroupLayout(PainelCadastrarDisciplina);
        PainelCadastrarDisciplina.setLayout(PainelCadastrarDisciplinaLayout);
        PainelCadastrarDisciplinaLayout.setHorizontalGroup(
            PainelCadastrarDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelCadastrarDisciplinaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelCadastrarDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelCadastrarDisciplinaLayout.createSequentialGroup()
                        .addComponent(NomeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NomeValue))
                    .addGroup(PainelCadastrarDisciplinaLayout.createSequentialGroup()
                        .addComponent(CargaHorariaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CargaHorariaValue, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
                    .addGroup(PainelCadastrarDisciplinaLayout.createSequentialGroup()
                        .addComponent(EmentaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EmentaValue))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelCadastrarDisciplinaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CadastrarButton)))
                .addContainerGap())
        );
        PainelCadastrarDisciplinaLayout.setVerticalGroup(
            PainelCadastrarDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelCadastrarDisciplinaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelCadastrarDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeLabel)
                    .addComponent(NomeValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelCadastrarDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmentaLabel)
                    .addComponent(EmentaValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelCadastrarDisciplinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CargaHorariaLabel)
                    .addComponent(CargaHorariaValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CadastrarButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PainelCadastrarDisciplina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PainelCadastrarDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void CadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarButtonActionPerformed
        String nome, ementa;
        long cargaHoraria;
        try {
            nome = this.NomeValue.getText();
            ementa = this.EmentaValue.getText();
            cargaHoraria = Long.parseLong(this.CargaHorariaValue.getText());
            Disciplina disciplina = new Disciplina(nome, ementa, cargaHoraria);
            TelaPrincipal.disciplinaDao.create(disciplina);
            int resposta = JOptionPane.showConfirmDialog(this, "A disciplina foi cadastrada. Deseja cadastrar outra?");
            switch (resposta) {
                case 0:
                    this.NomeValue.setText("");
                    this.EmentaValue.setText("");
                    this.CargaHorariaValue.setText("");
                    break;
                default:
                    this.closeFrame();
                    break;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Há um erro no formato da carga horária.");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, "Argumento ilegal informado.");
        }
    }//GEN-LAST:event_CadastrarButtonActionPerformed

    private void closeFrame() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        this.dispose();
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSED));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CadastrarButton;
    private javax.swing.JLabel CargaHorariaLabel;
    private javax.swing.JTextField CargaHorariaValue;
    private javax.swing.JLabel EmentaLabel;
    private javax.swing.JTextField EmentaValue;
    private javax.swing.JLabel NomeLabel;
    private javax.swing.JTextField NomeValue;
    private javax.swing.JPanel PainelCadastrarDisciplina;
    // End of variables declaration//GEN-END:variables
}
