/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.util.List;
/**
 *
 * @author JeanPablo
 */
public class Aluno {
    private String nome;
    private String cpf;
    private List<Turma> turma; 
    private List<Falta> falta;
    private List<Nota> nota;

    public Aluno (String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Turma> getTurma() {
        return turma;
    }

    public List<Falta> getFalta() {
        return falta;
    }

    public List<Nota> getNota() {
        return nota;
    }
}