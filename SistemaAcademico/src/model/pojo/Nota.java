/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

/**
 *
 * @author Filipe
 */
public class Nota {
    private Double nota;
    private Aluno aluno;
    private Atividade atividade;

    public Double getNota(){
        return nota;
    }
    public void setNota(Double nota){
        this.nota = nota;
    }
    public Aluno getAluno(){
        return aluno;
    }    
    public Atividade getAtividade(){
        return atividade;
    }
    public Nota (Double nota, Aluno aluno, Atividade atividade){
        this.nota = nota;
        this.aluno = aluno;
        this.atividade = atividade;
    // precisa vericar se o aluno esta matriculado na turma;
    } 
}
