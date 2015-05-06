/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Mônicka
 */
public class Atividade {
    private String nome;
    private String tipo;
    private Calendar data;
    private Double valor;
    private Boolean notasLancadas;
    private Turma turma;
    private List<Nota> nota;
  
    public Atividade(String nome, String tipo, Calendar data, Double valor, Turma turma){
        this.data = data;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.notasLancadas = false;
        this.turma = turma;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public void setData(Calendar data){
        this.data = data;
    }
    
    public void setValor(Double valor){
        this.valor = valor;
    }
    
    public void constarLancamentoDeNotas(){
        this.notasLancadas = true;
    }
    
    public String getNome(){
        return nome;
    }
    
    public Double getValor(){
        return valor;
    }
    
    public Calendar getData(){
        return data;
    }
    
    public String getTipo(){
        return tipo;
    }

    public Boolean getNotasLancadas(){
        return notasLancadas;
    }
    
    public Turma getTurma(){
        return turma;
    }
    
    public List<Nota> getNota(){
        return nota;
    }
    
    /*Pois o professor pode lançar duas notas de valores diferentes para uma
    atividade para o mesmo aluno*/
    public boolean adicaoValida(Nota nota) {
        for (Nota notaConsultada: this.nota) {
            if (notaConsultada.getAluno().ehIgual(nota.getAluno()))
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
    
    public boolean ehIgual(Atividade atividade) {
        return (this == atividade);
    }
}