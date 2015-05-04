/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.util.List;

/**
 *
 * @author Pedro
 */
public class Professor {
    private String nome;
    private String cpf;
    private String departamento;
    private List<Disciplina> disciplina;
    
    public Professor (String nome, String cpf, String departamento){
        this.nome = nome;
        this.cpf = cpf;
        this.departamento = departamento;
    }
    
    public String getNome (){
        return nome;
    }
    
    public void setNome (String nome){
        this.nome = nome;
    }
    
    public String getCpf (){
        return cpf;
    }
    
    public void setCpf (String cpf){
        this.cpf = cpf;
    }
    
    public String getDepartamento (){
        return departamento;
    }
    
    public void setDepartamento (String departamento){
        this.departamento = departamento;
    }
    
    //**********************DISCIPLINAS*********************
    
    public List<Disciplina> getDisciplina (){
        return disciplina;
    }
    
    public boolean contemDisciplina (Disciplina disciplina){
        return this.disciplina.contains(disciplina);
    }
     
    public void adicionarDisciplina (Disciplina disciplina){
        this.disciplina.add(disciplina);
        disciplina.getProfessor().add(this);
    }
    
    public void removerDisciplina (Disciplina disciplina){
        this.disciplina.remove(disciplina);
        disciplina.getProfessor().remove(this);
    }
}