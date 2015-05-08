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
    private List<Aula> aula;
    private List<Aluno> aluno;
    private List<Atividade> atividade;
    
    public Turma (Integer ano, Integer periodo, Integer numeroDeVagas,
            Disciplina disciplina, Professor professor, List<Aula> aula) {
        this.ano = ano;
        this.periodo = periodo;
        this.numeroDeVagas = numeroDeVagas;
        this.disciplina = disciplina;
        this.professor = professor;
        this.aula = aula;
    }
    
    public Turma (Integer ano, Integer periodo, Integer numeroDeVagas,
            Disciplina disciplina, Professor professor, List<Aula> aula,
            List<Aluno> aluno) {
        this(ano, periodo, numeroDeVagas, disciplina, professor, aula);
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
    
    //***************** AULAS ************************
    public List<Aula> getAula () {
        return aula;
    }
    
    public Boolean adicionarAula (Aula aula) {
        if (this.aula.contains(aula) == false)
            return this.aula.add(aula);
        return false;
    }
    
    public Boolean removerAula (Aula aula) {
        return this.aula.remove(aula);
    }
    
    public Aula retornaAula (Aula aula) {
        return this.aula.get(this.aula.indexOf(aula));
    }
    
    //***************** ALUNOS *************************
    public List<Aluno> getAluno () {
        return aluno;
    }
    
    public Boolean adicaoDeAlunoValida (Aluno aluno) {
        return (this.aluno.contains(aluno) == false || 
                this.aluno.size() < this.numeroDeVagas);
    }
    
    public Boolean adicionarAluno (Aluno aluno) {
        if (this.adicaoDeAlunoValida(aluno)) {
            aluno.getTurma().add(this);
            return this.aluno.add(aluno);
        }
        return false;
    }
    
    public Boolean removerAluno (Aluno aluno) {
        if (this.aluno.remove(aluno))
            return aluno.getTurma().remove(this);
        return false;
    }
    
    //**************** ATIVIDADES *********************
    public List<Atividade> getAtividade () {
        return atividade;
    }
    
    public Boolean adicionarAtividade (Atividade atividade) {
        if (this.atividade.contains(atividade) == false)
            return this.atividade.add(atividade);
        return false;
    }
    
    public Boolean removerAtividade (Atividade atividade) {
        return this.atividade.remove(atividade);
    }
    
    public Atividade retornaAtividade (Atividade atividade) {
        return this.atividade.get(this.atividade.indexOf(atividade));
    }
}