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
    private Integer numeroDeVagas;
    private Disciplina disciplina;
    private Professor professor;
    private List<Horario> horario;
    private List<Aluno> aluno;
    private List<Atividade> atividade;
    
    public Turma (Integer ano, Integer periodo, String local,
            Integer numeroDeVagas, Disciplina disciplina, Professor professor,
            List<Horario> horario) {
        this.ano = ano;
        this.periodo = periodo;
        this.numeroDeVagas = numeroDeVagas;
        this.disciplina = disciplina;
        this.professor = professor;
        this.horario = horario;
    }
    
    public Integer getAno () {
        return this.ano;
    }
    
    public void setAno (Integer ano) {
        this.ano = ano;
    }
    
    public Integer getPeriodo () {
        return this.periodo;
    }
    
    public void setPeriodo (Integer periodo) {
        this.periodo = periodo;
    }
    
    public Integer getNumeroDeVagas () {
        return this.numeroDeVagas;
    }
    
    public void setNumeroDeVagas (Integer numeroDeVagas) {
        this.numeroDeVagas = numeroDeVagas;
    }
    
    public Disciplina getDisciplina () {
        return this.disciplina;
    }
    
    public void setDisciplina (Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    public Professor getProfessor () {
        return this.professor;
    }
    
    public void setProfessor (Professor professor) {
        this.professor = professor;
    }
    
    //****FAZER OS MÉTODOS RELATIVOS AOS HORÁRIOS DE AULA**********
    
    //***************** ALUNOS *************************
    public List<Aluno> getListaDeAlunos () {
        return this.aluno;
    }
    
    public boolean contemAluno (Aluno aluno) {
        return this.aluno.contains(aluno);
    }
    
    public boolean adicaoDeAlunoValida (Aluno aluno) {
        return (this.contemAluno(aluno) || this.aluno.size() == this.numeroDeVagas);
    }
    
    public void adicionarAluno (Aluno aluno) {
        this.aluno.add(aluno);
    }
    
    public void removerAluno (Aluno aluno) {
        this.aluno.remove(aluno);
    }
    
    //**************** ATIVIDADES *********************
    public List<Atividade> getListaDeAtividades () {
        return this.atividade;
    }
    
    public boolean contemAtividade (Atividade atividade) {
        return this.atividade.contains(atividade);
    }
    
    public void adicionarAtividade (Atividade atividade) {
        this.atividade.add(atividade);
    }
    
    public void removerAtividade (Atividade atividade) {
        this.atividade.remove(atividade);
    }
}
