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
    private List<Nota> nota;
  
    public Atividade(String nome, String tipo, Calendar data, Double valor){
        this.data = data;
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
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
}
