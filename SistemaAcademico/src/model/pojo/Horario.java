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
public class Horario {
    private String diaDaSemana;
    private String hora;
    private String local;

    public Horario (String diaDaSemana, String hora, String local) {
        this.diaDaSemana = diaDaSemana;
        this.hora = hora;
        this.local = local;
    }
    
    public String getDiaDaSemana() {
        return diaDaSemana;
    }

    public void setDiaDaSemana(String diaDaSemana) {
        this.diaDaSemana = diaDaSemana;
    }

    public String getHorario() {
        return hora;
    }

    public void setHorario(String hora) {
        this.hora = hora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}