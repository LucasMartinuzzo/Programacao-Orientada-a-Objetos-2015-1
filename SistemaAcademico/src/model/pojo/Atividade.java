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
    
    public Turma getTurma(){
        return turma;
    }
    
    public List<Nota> getNota(){
        return nota;
    }
    
    public Boolean notasLancadas(){
        return notasLancadas;
    }
    
    /*Pois o professor pode lançar duas notas de valores diferentes para uma
    atividade para o mesmo aluno ou tentar lançar uma nota já lançada.*/
    public Boolean adicaoValida(Nota nota) {
        if (this.notasLancadas)
            return false;
        for (Nota notaConsultada: this.nota) {
            if (notaConsultada.getAluno().equals(nota.getAluno()))
                return false;
        }
        return true;
    }
    
    public Boolean adicionaNota(Nota nota){
        if (this.adicaoValida(nota))
            return this.nota.add(nota);
        return false;
    }
    
    public Nota retornaNota (Nota nota) {
        return this.nota.get(this.nota.indexOf(nota));
    }
}