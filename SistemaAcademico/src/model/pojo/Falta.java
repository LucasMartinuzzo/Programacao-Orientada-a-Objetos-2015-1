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
public class Falta implements Comparable<Falta>{
    private String id;
    private Integer falta;
    private Turma turma;

    public Falta (String id, Integer falta, Turma turma){
        this.id = id;
        this.falta = falta;
        this.turma = turma;
    }
    
    public String getId(){
        return id;
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
    @Override
    public int compareTo (Falta falta) {
        return this.id.compareTo(falta.id);
    }
}