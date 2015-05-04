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
public class Falta {
    private Integer falta;
    private Aluno aluno;
    private Turma turma;

    public Integer getFalta(){
        return falta;
    }
    public void setFalta(Integer falta){
        this.falta = falta;
    }
    public Aluno getAluno(){
        return aluno;
    }
    public Turma getTurma(){
        return turma;
    }
    public Falta (Integer falta, Aluno aluno, Turma turma){
        this.falta = falta;
        this.aluno = aluno;
        this.turma = turma;
    }
}