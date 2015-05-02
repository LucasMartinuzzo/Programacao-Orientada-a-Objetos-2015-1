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
    private List<Falta> falta;
    
    public Turma (Integer ano, Integer periodo, String local, String horario, Integer numeroDeVagas,
            Disciplina disciplina, Professor professor, List<Aluno> aluno, List <Atividade> atividade) {
        this.ano = ano;
        this.periodo = periodo;
        this.local = local;
        this.horario = horario;
        this.numeroDeVagas = numeroDeVagas;
        this.disciplina = disciplina;
        this.professor = professor;
        this.atividade = atividade;
    }
    
    public Integer getAno () {
        return this.ano;
    }
    
    //public void setAno (Integer ano) {
    //    this.ano = ano;
    //}
    
    public Integer getPeriodo () {
        return this.periodo;
    }
    
    public String getLocal () {
        return this.local;
    }
    
    public String getHorario () {
        return this.horario;
    }
    
    public Integer getNumeroDeVagas () {
        return this.numeroDeVagas;
    }
    
    public Disciplina getDisciplina () {
        return this.disciplina;
    }
    
    public Professor getProfessor () {
        return this.professor;
    }
    
    public List<Aluno> getListaDeAlunos () {
        return this.aluno;
    }
    
    public List<Atividade> getListaDeAtividades () {
        return this.atividade;
    }
    
    public List<Falta> getListaDeFaltas () {
        return this.falta;
    }
}
