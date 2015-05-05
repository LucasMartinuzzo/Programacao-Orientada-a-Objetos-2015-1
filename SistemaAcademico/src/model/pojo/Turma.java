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
    
    public Turma (Integer ano, Integer periodo, Integer numeroDeVagas,
            Disciplina disciplina, Professor professor, List<Horario> horario) {
        this.ano = ano;
        this.periodo = periodo;
        this.numeroDeVagas = numeroDeVagas;
        this.disciplina = disciplina;
        this.professor = professor;
        this.horario = horario;
    }
    
    public Turma (Integer ano, Integer periodo, Integer numeroDeVagas,
            Disciplina disciplina, Professor professor, List<Horario> horario,
            List<Aluno> aluno) {
        this(ano, periodo, numeroDeVagas, disciplina, professor, horario);
        this.aluno = aluno;
    }
    
    public Integer getAno () {
        return ano;
    }
    
    public void setAno (Integer ano) {
        this.ano = ano;
    }
    
    public Integer getPeriodo () {
        return periodo;
    }
    
    public void setPeriodo (Integer periodo) {
        this.periodo = periodo;
    }
    
    public Integer getNumeroDeVagas () {
        return numeroDeVagas;
    }
    
    public void setNumeroDeVagas (Integer numeroDeVagas) {
        this.numeroDeVagas = numeroDeVagas;
    }
    
    public Disciplina getDisciplina () {
        return disciplina;
    }
    
    public void setDisciplina (Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    public Professor getProfessor () {
        return professor;
    }
    
    public void setProfessor (Professor professor) {
        this.professor = professor;
    }
    
    //***************** HORÁRIO ************************
    public List<Horario> getHorario () {
        return horario;
    }
    
    public boolean contemHorario (Horario horario) {
        return this.horario.contains(horario);
    }
    
    public void adicionarHorario (Horario horario) {
        this.horario.add(horario);
    }
    
    public void removerHorario (Horario horario) {
        this.horario.remove(horario);
    }
    
    public Horario retornaHorario (Horario horario) {
        return this.horario.get(this.horario.indexOf(horario));
    }
    
    /*public void setHorario (Horario horarioAntigo, Horario horarioNovo) {
        Horario horarioNaLista = this.retornaHorario(horarioAntigo);
        horarioNaLista = horarioNovo;
    }*/
    
    //***************** ALUNOS *************************
    public List<Aluno> getAluno () {
        return aluno;
    }
    
    public boolean contemAluno (Aluno aluno) {
        return this.aluno.contains(aluno);
    }
    
    public boolean adicaoDeAlunoValida (Aluno aluno) {
        return (this.contemAluno(aluno) || this.aluno.size() == this.numeroDeVagas);
    }
    
    public void adicionarAluno (Aluno aluno) {
        aluno.getTurma().add(this);
        this.aluno.add(aluno);
    }
    
    public void removerAluno (Aluno aluno) {
        aluno.getTurma().remove(this);
        this.aluno.remove(aluno);
    }
    
    //**************** ATIVIDADES *********************
    public List<Atividade> getAtividade () {
        return atividade;
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
    
    public Atividade retornaAtividade (Atividade atividade) {
        return this.atividade.get(this.atividade.indexOf(atividade));
    }
    
    /*public void setAtividade (Atividade atividadeAntiga, Atividade atividadeNova) {
        Atividade atividadeNaLista = this.retornaAtividade(atividadeAntiga);
        atividadeNaLista = atividadeNova;
    }*/

    public boolean ehIgual (Turma turma){
        return (this == turma);
    }
}