package model.pojo;

import java.util.List;

/**
 *
 * @author JeanPablo
 */
public class Turma implements Comparable<Turma> {
    private String id;
    private Integer ano;
    private Integer periodo;
    private Integer numeroDeVagas;
    private Disciplina disciplina;
    private Professor professor;
    private List<Aula> aula;
    private List<Aluno> aluno;
    private List<Atividade> atividade;
    
    public Turma (String id, Integer ano, Integer periodo, Integer numeroDeVagas,
            Disciplina disciplina, Professor professor, List<Aula> aula) {
        this.id = id;
        this.ano = ano;
        this.periodo = periodo;
        this.numeroDeVagas = numeroDeVagas;
        this.disciplina = disciplina;
        this.professor = professor;
        this.aula = aula;
    }
    
    public Turma (String id, Integer ano, Integer periodo, Integer numeroDeVagas,
            Disciplina disciplina, Professor professor, List<Aula> aula,
            List<Aluno> aluno) {
        this(id, ano, periodo, numeroDeVagas, disciplina, professor, aula);
        this.aluno = aluno;
    }
    
    public String getId () {
        return id;
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
    
    public List<Aula> getAula () {
        return aula;
    }
    
    public List<Aluno> getAluno () {
        return aluno;
    }
    
    public List<Atividade> getAtividade () {
        return atividade;
    }
    
    @Override
    public int compareTo (Turma turma) {
        return this.id.compareTo(turma.id);
    }
}