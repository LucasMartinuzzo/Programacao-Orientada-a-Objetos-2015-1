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
    private Turma turma;

    public Falta (Integer falta, Turma turma){
        this.falta = falta;
        this.turma = turma;
    }
    
    public Integer getFalta(){
        return falta;
    }
    
    public void setFalta(Integer falta){
        this.falta = falta;
    }
    
    public Turma getTurma(){
        return turma;
    }
    
    public void setTurma(Turma turma){
        this.turma = turma;
    }
}