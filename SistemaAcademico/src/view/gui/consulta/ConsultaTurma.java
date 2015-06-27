package view.gui.consulta;

import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import model.dao.DisciplinaDaoImpl;
import model.dao.TurmaDaoImpl;
import model.pojo.Turma;
import model.pojo.Atividade;
import model.pojo.Aluno;
import model.pojo.Disciplina;
import model.pojo.Falta;
import model.pojo.Nota;
import view.gui.MenuPrincipal;

public class ConsultaTurma extends javax.swing.JFrame {

    private MenuPrincipal menuPrincipal;
    private EntityManager em;
    private TurmaDaoImpl daoTurma = TurmaDaoImpl.getInstancia();
    private DisciplinaDaoImpl daoDisciplina = DisciplinaDaoImpl.getInstancia();
    
    public ConsultaTurma() {
        initComponents();
    }

    public ConsultaTurma(MenuPrincipal menuPrincipal, EntityManager em){
        this();
        this.menuPrincipal = menuPrincipal;
        this.em = em;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        this.setTitle("Sistema Acadêmico");
        jPanel7 = new javax.swing.JPanel();
        labelDisciplina6 = new javax.swing.JLabel();
        fieldDisciplina = new javax.swing.JTextField();
        botaoVerificar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaTurmas = new javax.swing.JTextArea();
        fieldAno = new javax.swing.JTextField();
        labelDisciplina8 = new javax.swing.JLabel();
        labelDisciplina9 = new javax.swing.JLabel();
        fieldPeriodo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel7.setMaximumSize(new java.awt.Dimension(800, 600));

        labelDisciplina6.setText("Disciplina:");

        fieldDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldDisciplinaActionPerformed(evt);
            }
        });

        botaoVerificar.setText("Verificar");
        botaoVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVerificarActionPerformed(evt);
            }
        });

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Consulta de Turmas");

        textAreaTurmas.setColumns(20);
        textAreaTurmas.setRows(5);
        jScrollPane1.setViewportView(textAreaTurmas);
        textAreaTurmas.setEditable(false);

        fieldAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldAnoActionPerformed(evt);
            }
        });

        labelDisciplina8.setText("Ano:");

        labelDisciplina9.setText("Período:");

        fieldPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldPeriodoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoVerificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoVoltar))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(labelDisciplina6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addComponent(fieldDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(labelDisciplina8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(labelDisciplina9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fieldPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDisciplina6)
                    .addComponent(fieldDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDisciplina8)
                    .addComponent(fieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDisciplina9)
                    .addComponent(fieldPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoVerificar)
                    .addComponent(botaoVoltar)))
        );

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldDisciplinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldDisciplinaActionPerformed

    private void botaoVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVerificarActionPerformed
        List<Turma> listaTurma = daoTurma.obterTodos(em);
        String nome = fieldDisciplina.getText();
        if(!nome.trim().isEmpty()){
            Disciplina disciplina = daoDisciplina.buscar(em, nome);
            if (disciplina != null){
                Integer ano = Integer.parseInt(fieldAno.getText());
                Integer periodo = Integer.parseInt(fieldPeriodo.getText());
                Boolean aux = false;
                textAreaTurmas.setText(null);
                for (Turma turma : listaTurma)
                    if (turma.getDisciplina().getNome().equals(nome) && turma.getAno().equals(ano) &&
                            turma.getPeriodo().equals(periodo)){
                        aux = true;
                        textAreaTurmas.append("Turma " + turma.getId().toString() + ":");
                        for (Aluno aluno: turma.getAluno())
                            imprimir(aluno, turma);
                        break;
                    }
                if(!aux)
                    textAreaTurmas.append("Não há turma com essas especificações.");
            }else
                JOptionPane.showMessageDialog(this,"Disciplina não cadastrada (nome inválido).","Erro",JOptionPane.ERROR_MESSAGE);
        }else
            JOptionPane.showMessageDialog(this,"O campo Disciplina deve ser preenchido.","Erro",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_botaoVerificarActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void fieldAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldAnoActionPerformed

    private void fieldPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldPeriodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldPeriodoActionPerformed

    public void imprimir (Aluno aluno, Turma turma){
        textAreaTurmas.append("\n\nAluno: " + aluno.getNome() +" (" + aluno.getCpf() + ")");
        textAreaTurmas.append("\nNotas: ");
        for (Atividade atividade : turma.getAtividade()){
            for (Nota nota: atividade.getNota())
                if (nota.getAluno().equals(aluno)){
                    textAreaTurmas.append("\n\tAtividade " + atividade.getNome() + ":" + nota.getNota().toString());
                    break;
                }
        }
        textAreaTurmas.append("\nNota Final: " + aluno.notaFinal(turma).toString());
        for (Falta falta : aluno.getFalta())
            if (falta.getTurma().equals(turma)){
                textAreaTurmas.append("\nFaltas: " + falta.getFalta().toString());
                break;
            }
    }

    private void formWindowClosed(java.awt.event.WindowEvent evt) {                                  
        menuPrincipal.setEnabled(true);
        menuPrincipal.toFront();
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultaTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaTurma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoVerificar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JTextField fieldAno;
    private javax.swing.JTextField fieldDisciplina;
    private javax.swing.JTextField fieldPeriodo;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelDisciplina6;
    private javax.swing.JLabel labelDisciplina8;
    private javax.swing.JLabel labelDisciplina9;
    private javax.swing.JTextArea textAreaTurmas;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
