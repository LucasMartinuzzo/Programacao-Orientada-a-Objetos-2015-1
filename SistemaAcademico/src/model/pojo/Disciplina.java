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
    
    //disciplina.getTurma().add(this)
    //AINDA FALTA INSERIR A TURMA CRIADA(No turma.java) NA LISTA DE TURMAS DA DISCIPLINA
    
    public Disciplina(String nome, String ementa, Integer cargaHoraria){
        this.nome = nome;
        this.ementa = ementa;
        this.cargaHoraria = cargaHoraria;
    }
    
    public void consultarTurmas (String nome, Integer ano, Integer periodo){
        
    }
    
    public List<Professor> getProfessor(){
        return professor;
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
    //***************** Turma *************************
    public List<Turma> getTurma () {
        return turma;
    }
    
    public boolean contemTurma (Turma turma) {
        return this.turma.contains(turma);
    }
    
    public boolean adicaoDeTurmaValida (Turma turma) {
        return (this.contemTurma(turma));
    }
    
    public void adicionarTurma (Turma turma) {
        turma.getDisciplina().add(this);
        this.turma.add(turma);
    }
    
    public void removerTurma (Turma turma) {
        turma.getDisciplina().remove(this);
        this.turma.remove(turma);
    }
    
}
