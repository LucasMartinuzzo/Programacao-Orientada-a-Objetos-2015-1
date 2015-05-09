/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.util.List;

/**
 *
 * @author Lucas
 */
public class Disciplina {
    private String nome;
    private String ementa;
    private Integer cargaHoraria;
    private List<Professor> professor;
    private List<Turma> turma;
    
    public Disciplina(String nome, String ementa, Integer cargaHoraria){
        this.nome = nome;
        this.ementa = ementa;
        this.cargaHoraria = cargaHoraria;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getEmenta(){
        return nome;
    }
    
    public void setEmenta(String ementa){
        this.ementa = ementa;
    }
    
    public Integer getCargaHoraria(){
        return cargaHoraria;
    }
    
    public void setCargaHoraria(Integer cargaHoraria){
        this.cargaHoraria = cargaHoraria;
    }
    
    public List<Professor> getProfessor(){
        return professor;
    }
    public List<Turma> getTurma(){
        return turma;
    }
}