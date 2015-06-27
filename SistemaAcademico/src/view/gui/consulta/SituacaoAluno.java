package view.gui.consulta;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import model.dao.AlunoDaoImpl;
import model.dao.DisciplinaDaoImpl;
import model.pojo.Aluno;
import model.pojo.Disciplina;
import model.pojo.Turma;
import model.pojo.Falta;
import model.pojo.Nota;
import model.pojo.Atividade;
import view.gui.MenuPrincipal;

public class SituacaoAluno extends javax.swing.JFrame {

    private MenuPrincipal menuPrincipal;
    private EntityManager em;
    private AlunoDaoImpl daoAluno = AlunoDaoImpl.getInstancia();
    private DisciplinaDaoImpl daoDisciplina = DisciplinaDaoImpl.getInstancia();
    
    public SituacaoAluno() {
        initComponents();
    }

    public SituacaoAluno(MenuPrincipal menuPrincipal, EntityManager em){
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
        fieldCpf = new javax.swing.JTextField();
        botaoVerificar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaSituacao = new javax.swing.JTextArea();
        fieldDisciplina = new javax.swing.JTextField();
        labelDisciplina8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel7.setMaximumSize(new java.awt.Dimension(800, 600));

        labelDisciplina6.setText("CPF:");

        fieldCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCpfActionPerformed(evt);
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
        titulo.setText("Consulta da Situação de Alunos");

        textAreaSituacao.setColumns(20);
        textAreaSituacao.setRows(5);
        jScrollPane1.setViewportView(textAreaSituacao);
        textAreaSituacao.setEditable(false);

        fieldDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldDisciplinaActionPerformed(evt);
            }
        });

        labelDisciplina8.setText("Disciplina:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoVerificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoVoltar))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(labelDisciplina6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(labelDisciplina8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fieldDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDisciplina6)
                    .addComponent(fieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDisciplina8)
                    .addComponent(fieldDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoVerificar)
                    .addComponent(botaoVoltar))
                .addGap(42, 42, 42))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCpfActionPerformed

    private void botaoVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVerificarActionPerformed
        textAreaSituacao.setText(null);
        String cpf = fieldCpf.getText();
        if(!cpf.trim().isEmpty()){
            Aluno aluno = daoAluno.buscar(em, cpf);
            if (aluno != null){
                String nome = fieldDisciplina.getText();
                if (!nome.trim().isEmpty()){
                    Disciplina disciplina = daoDisciplina.buscar(em, nome);
                    if (disciplina != null){
                        Boolean aux = false;
                        Boolean aprovado = true;
                        if (!disciplina.getTurma().isEmpty()){
                            for (Turma turma: disciplina.getTurma()){
                                if (turma.getAluno().contains(aluno)){
                                    imprimir(aluno,turma);
                                    for (Falta falta: aluno.getFalta())
                                        if (falta.getTurma().equals(turma)){
                                            Double result = (Double.parseDouble(falta.getFalta().toString()))/disciplina.getCargaHoraria();
                                            if(result > 0.25){
                                                aprovado = false;
                                                break;
                                            }
                                        }
                                    if (aluno.notaFinal(turma) < 6.0)
                                        aprovado = false;
                                    if (aprovado)
                                        textAreaSituacao.append("\nAprovado.\n");
                                    else
                                        textAreaSituacao.append("\nReprovado.\n");
                                    aux = true;     
                                    fieldDisciplina.setText(null);
                                    fieldCpf.setText(null);
                                    break;
                                }
                            }
                            if (!aux)
                                JOptionPane.showMessageDialog(this,"O aluno não está matriculado em nenhuma "
                                        + "turma dessa disciplina.","Erro",JOptionPane.ERROR_MESSAGE);
                        }else
                            JOptionPane.showMessageDialog(this,"Não há turmas dessa disciplina.","Erro",JOptionPane.ERROR_MESSAGE);              
                    }else
                        JOptionPane.showMessageDialog(this,"Disciplina não cadastrada (nome inválido).","Erro",JOptionPane.ERROR_MESSAGE);
                }else
                    JOptionPane.showMessageDialog(this,"O campo Disciplina deve ser preenchido.","Erro",JOptionPane.ERROR_MESSAGE);
            }else
                JOptionPane.showMessageDialog(this,"Aluno não cadastrado (CPF inválido).","Erro",JOptionPane.ERROR_MESSAGE);
        }else
            JOptionPane.showMessageDialog(this,"O campo CPF deve ser preenchido.","Erro",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_botaoVerificarActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void fieldDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldDisciplinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldDisciplinaActionPerformed

    public void imprimir (Aluno aluno, Turma turma){
        textAreaSituacao.append("Aluno: " + aluno.getNome() +" (" + aluno.getCpf() + ")");
        textAreaSituacao.append("\nNotas: ");
        for (Atividade atividade : turma.getAtividade()){
            for (Nota nota: atividade.getNota())
                if (nota.getAluno().equals(aluno)){
                    textAreaSituacao.append("\n\tAtividade " + atividade.getNome() + ":" + nota.getNota().toString());
                    break;
                }
        }
        textAreaSituacao.append("\nNota Final: " + aluno.notaFinal(turma).toString());
        for (Falta falta : aluno.getFalta())
            if (falta.getTurma().equals(turma)){
                textAreaSituacao.append("\nFaltas: " + falta.getFalta().toString());
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
            java.util.logging.Logger.getLogger(SituacaoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SituacaoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SituacaoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SituacaoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SituacaoAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoVerificar;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JTextField fieldCpf;
    private javax.swing.JTextField fieldDisciplina;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelDisciplina6;
    private javax.swing.JLabel labelDisciplina8;
    private javax.swing.JTextArea textAreaSituacao;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
