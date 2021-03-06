/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.desktop.professor;

import java.awt.Component;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.pojo.Disciplina;
import model.pojo.Professor;
import view.desktop.TelaPrincipal;

/**
 *
 * @author Elias Júnior
 */
public class TelaEditarProfessor extends javax.swing.JFrame {

    private TelaPrincipal telaPrincipal;
    private Professor professorEditing;

    /**
     * Creates new form TelaEditarProfessor
     */
    public TelaEditarProfessor(TelaPrincipal tp) {
        initComponents();
        this.carregarDisciplinas();
        this.toggleEditarFields(false);
        this.telaPrincipal = tp;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        PainelEditarProfessor = new javax.swing.JPanel();
        CpfLabel = new javax.swing.JLabel();
        EditarButton = new javax.swing.JToggleButton();
        CpfValue = new javax.swing.JTextField();
        PainelInformacoes = new javax.swing.JPanel();
        EditNomeLabel = new javax.swing.JLabel();
        EditNomeValue = new javax.swing.JTextField();
        EditCpfLabel = new javax.swing.JLabel();
        EditCpfValue = new javax.swing.JTextField();
        EditDepartamentoLabel = new javax.swing.JLabel();
        EditDepartamentoValue = new javax.swing.JTextField();
        EditDisciplinasAptoLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        EditListaDisciplinasApto = new javax.swing.JTable();
        EditListaDisciplinas = new javax.swing.JComboBox();
        EditAdicionarButton = new javax.swing.JToggleButton();
        EditSalvarButton = new javax.swing.JButton();
        EditIdLabel = new javax.swing.JLabel();
        EditIdValue = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        PainelEditarProfessor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar professor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        CpfLabel.setText("CPF:");

        EditarButton.setText("Editar");
        EditarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarButtonActionPerformed(evt);
            }
        });

        PainelInformacoes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        EditNomeLabel.setText("Nome:");

        EditCpfLabel.setText("CPF:");

        EditDepartamentoLabel.setText("Departamento:");

        EditDisciplinasAptoLabel.setText("Disciplinas apto:");

        EditListaDisciplinasApto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(EditListaDisciplinasApto);

        /*
        */

        EditAdicionarButton.setText("Adicionar");
        EditAdicionarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditAdicionarButtonActionPerformed(evt);
            }
        });

        EditSalvarButton.setText("Salvar");
        EditSalvarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditSalvarButtonActionPerformed(evt);
            }
        });

        EditIdLabel.setText("ID:");

        javax.swing.GroupLayout PainelInformacoesLayout = new javax.swing.GroupLayout(PainelInformacoes);
        PainelInformacoes.setLayout(PainelInformacoesLayout);
        PainelInformacoesLayout.setHorizontalGroup(
            PainelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(PainelInformacoesLayout.createSequentialGroup()
                        .addComponent(EditNomeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EditNomeValue))
                    .addGroup(PainelInformacoesLayout.createSequentialGroup()
                        .addComponent(EditCpfLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EditCpfValue))
                    .addGroup(PainelInformacoesLayout.createSequentialGroup()
                        .addComponent(EditDepartamentoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EditDepartamentoValue))
                    .addGroup(PainelInformacoesLayout.createSequentialGroup()
                        .addComponent(EditDisciplinasAptoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EditListaDisciplinas, 0, 201, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EditAdicionarButton))
                    .addGroup(PainelInformacoesLayout.createSequentialGroup()
                        .addComponent(EditIdLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EditIdValue))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelInformacoesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(EditSalvarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PainelInformacoesLayout.setVerticalGroup(
            PainelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditIdLabel)
                    .addComponent(EditIdValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditNomeLabel)
                    .addComponent(EditNomeValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditCpfLabel)
                    .addComponent(EditCpfValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditDepartamentoLabel)
                    .addComponent(EditDepartamentoValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EditDisciplinasAptoLabel)
                    .addComponent(EditListaDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditAdicionarButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EditSalvarButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PainelEditarProfessorLayout = new javax.swing.GroupLayout(PainelEditarProfessor);
        PainelEditarProfessor.setLayout(PainelEditarProfessorLayout);
        PainelEditarProfessorLayout.setHorizontalGroup(
            PainelEditarProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelEditarProfessorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelEditarProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PainelInformacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PainelEditarProfessorLayout.createSequentialGroup()
                        .addComponent(CpfLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CpfValue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EditarButton)))
                .addContainerGap())
        );
        PainelEditarProfessorLayout.setVerticalGroup(
            PainelEditarProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelEditarProfessorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelEditarProfessorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CpfLabel)
                    .addComponent(EditarButton)
                    .addComponent(CpfValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PainelInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PainelEditarProfessor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PainelEditarProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            long cpf = Long.parseLong(this.CpfValue.getText());
            List<Professor> professores = TelaPrincipal.professorDao.findProfessorEntities().stream().filter((p) -> p.getCpf() == cpf).collect(Collectors.toList());
            if (professores.size() == 0) {
                this.toggleEditarFields(false);
                JOptionPane.showMessageDialog(this, "Não foi encontrado nenhum professor com esse CPF.");
            } else {
                Professor professor = professores.get(0);
                this.toggleEditarFields(true);
                this.carregarProfessor(professor);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Formato numérico inválido.");
        }
    }//GEN-LAST:event_EditarButtonActionPerformed

    private void EditAdicionarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditAdicionarButtonActionPerformed
        String disciplinaIdStr = (String) this.EditListaDisciplinas.getSelectedItem();
        if (disciplinaIdStr == null) {
            JOptionPane.showMessageDialog(this, "Você deve selecionar uma disciplina para adicionar.");
        } else {
            long id = Long.parseLong(disciplinaIdStr.split(":")[0]);
            Disciplina disciplina = TelaPrincipal.disciplinaDao.findDisciplina(id);
            if (disciplina == null) {
                JOptionPane.showMessageDialog(this, "Disciplina não encontrada.");
            } else if (this.professorEditing.getDisciplinasApto().contains(disciplina)) {
                JOptionPane.showMessageDialog(this, "Esse professor já está apto a lecionar essa disciplina.");
            } else {
                this.professorEditing.addDisciplinaApto(disciplina);
                DefaultTableModel dtm = (DefaultTableModel) this.EditListaDisciplinasApto.getModel();
                dtm.addRow(new Object[]{disciplina.getId(), disciplina.getNome()});
                JOptionPane.showMessageDialog(this, "O professor agora pode lecionar essa disciplina.");
            }
        }
    }//GEN-LAST:event_EditAdicionarButtonActionPerformed

    private void EditSalvarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditSalvarButtonActionPerformed
        if (this.professorEditing != null) {
            try {
                this.professorEditing.setCpf(Long.parseLong(this.EditCpfValue.getText()));
                this.professorEditing.setNome(this.EditNomeValue.getText());
                this.professorEditing.setDepartamento(this.EditDepartamentoValue.getText());
                TelaPrincipal.professorDao.edit(this.professorEditing);
                this.toggleEditarFields(false);
                JOptionPane.showMessageDialog(this, "Professor editado.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_EditSalvarButtonActionPerformed

    private void toggleEditarFields(boolean status) {
        this.limparEditarFields();
        Component[] fields = this.PainelInformacoes.getComponents();
        for (Component field : fields) {
            field.setEnabled(status);
        }
        this.EditIdValue.setEnabled(false);
    }

    private void limparEditarFields() {
        this.professorEditing = null;
        this.EditCpfValue.setText("");
        this.EditDepartamentoValue.setText("");
        this.EditIdValue.setText("");
        this.EditNomeValue.setText("");
        this.limparTable();
    }

    private void limparTable() {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtm.setColumnIdentifiers(new Object[]{"ID", "Nome"});
        this.EditListaDisciplinasApto.setModel(dtm);
    }

    private void carregarTable() {
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtm.setColumnIdentifiers(new Object[]{"ID", "Nome"});
        this.professorEditing.getDisciplinasApto().forEach((d) -> {
            dtm.addRow(new Object[]{d.getId(), d.getNome()});
        });
        this.EditListaDisciplinasApto.setModel(dtm);
    }

    private void carregarProfessor(Professor professor) {
        this.professorEditing = professor;
        this.carregarTable();
        this.EditCpfValue.setText(String.valueOf(professor.getCpf()));
        this.EditDepartamentoValue.setText(professor.getDepartamento());
        this.EditIdValue.setText(String.valueOf(professor.getId()));
        this.EditNomeValue.setText(professor.getNome());
    }

    private void carregarDisciplinas() {
        List<Disciplina> disciplinas = TelaPrincipal.disciplinaDao.findDisciplinaEntities();
        disciplinas.forEach((d) -> {
            String nome = d.getId() + ": " + d.getNome();
            this.EditListaDisciplinas.addItem(nome);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CpfLabel;
    private javax.swing.JTextField CpfValue;
    private javax.swing.JToggleButton EditAdicionarButton;
    private javax.swing.JLabel EditCpfLabel;
    private javax.swing.JTextField EditCpfValue;
    private javax.swing.JLabel EditDepartamentoLabel;
    private javax.swing.JTextField EditDepartamentoValue;
    private javax.swing.JLabel EditDisciplinasAptoLabel;
    private javax.swing.JLabel EditIdLabel;
    private javax.swing.JTextField EditIdValue;
    private javax.swing.JComboBox EditListaDisciplinas;
    private javax.swing.JTable EditListaDisciplinasApto;
    private javax.swing.JLabel EditNomeLabel;
    private javax.swing.JTextField EditNomeValue;
    private javax.swing.JButton EditSalvarButton;
    private javax.swing.JToggleButton EditarButton;
    private javax.swing.JPanel PainelEditarProfessor;
    private javax.swing.JPanel PainelInformacoes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
