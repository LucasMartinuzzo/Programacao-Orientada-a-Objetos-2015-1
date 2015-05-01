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
public class Turma {
    private Integer ano;
    private Integer periodo;
    private String local;
    private String horario;
    private Integer numeroDeVagas;
    private Disciplina disciplina;
    private Professor professor;
    private List<Aluno> aluno;
    private List<Atividade> atividade;
    private List<Falta> faltas;
}
