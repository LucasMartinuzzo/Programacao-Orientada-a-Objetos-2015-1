/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

/**
 *
 * @author JeanPablo
 */
public class Aula implements Comparable<Aula> {
    private String id;
    private String diaDaSemana;
    private String hora;
    private String local;

    public Aula (String id, String diaDaSemana, String hora, String local) {
        this.id = id;
        this.diaDaSemana = diaDaSemana;
        this.hora = hora;
        this.local = local;
    }
    
    public String getId() {
        return id;
    }
    
    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    
    @Override
    public int compareTo (Aula aula) {
        return this.id.compareTo(aula.id);
    }
}