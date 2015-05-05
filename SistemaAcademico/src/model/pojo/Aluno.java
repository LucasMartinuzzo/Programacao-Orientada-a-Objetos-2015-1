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
    
    /*Pois o professor pode lançar duas faltas de valores diferentes para um
    aluno na mesma turma*/
    public boolean adicaoValida(Falta falta) {
        for (Falta faltaConsultada: this.falta) {
            if (faltaConsultada.getTurma().ehIgual(falta.getTurma()))
                return false;
        }
        return true;
    }
    
    public void adicionaFalta(Falta falta){
        this.falta.add(falta);
    }

    public List<Nota> getNota() {
        return nota;
    }
    
    /*Pois o professor pode lançar duas notas de valores diferentes para um
    aluno para a mesma atividade*/
    public boolean adicaoValida(Nota nota) {
        for (Nota notaConsultada: this.nota) {
            if (notaConsultada.getAtividade().ehIgual(nota.getAtividade()))
                return false;
        }
        return true;
    }
    
    public void adicionaNota(Nota nota){
        this.nota.add(nota);
    }
    
    public Nota retornaNota (Nota nota) {
        return this.nota.get(this.nota.indexOf(nota));
    }
    
    /*public void setNota (Nota notaAntiga, Nota notaNova) {
        Nota notaNaLista = this.retornaNota(notaAntiga);
        notaNaLista = notaNova;
    }*/
}