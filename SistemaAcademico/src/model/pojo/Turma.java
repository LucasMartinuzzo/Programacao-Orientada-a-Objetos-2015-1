package model.pojo;

import java.util.ArrayList;
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
    private List<Aluno> aluno = new ArrayList<>();
    private List<Atividade> atividade = new ArrayList<>();
    
    public Turma (String id, Integer ano, Integer periodo, Integer numeroDeVagas,
            Disciplina disciplina, Professor professor, List<Aula> aula, List<Aluno> aluno) {
        this.id = id;
        this.ano = ano;
        this.periodo = periodo;
        this.numeroDeVagas = numeroDeVagas;
        this.disciplina = disciplina;
        this.professor = professor;
        this.aula = aula;
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
    
    public void setDisciplina (Object obj) {
        Disciplina disciplina = (Disciplina) obj;
        this.disciplina = disciplina;
    }
    
    public Professor getProfessor () {
        return professor;
    }
    
    public void setProfessor (Object obj) {
        Professor professor = (Professor) obj;
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
    
    public Boolean adicionarAula (Object obj) {
        Aula aula = (Aula) obj;
        if (!this.getAula().contains(aula))
            return this.getAula().add(aula);
        return false;
    }
    
    public Boolean removerAula (Aula aula) {
        return this.getAula().remove(aula);
    }
    
    /*public Aula retornaAula (Turma this, Aula aula) {
        if (this.getAula().contains(aula))
            //return this.getAula().get(this.getAula().indexOf(aula));
        else
            return null;
    }*/
    
    public Boolean adicionarAluno (Aluno aluno) {
        if (!this.getAluno().contains(aluno) || 
                this.getAluno().size() < this.getNumeroDeVagas()) {
            aluno.getTurma().add(this);
            return this.getAluno().add(aluno);
        }
        return false;
    }
    
    public Boolean removerAluno (Aluno aluno) {
        if (this.getAluno().remove(aluno))
            return aluno.getTurma().remove(this);
        return false;
    }
    
    public Boolean adicionarAtividade (Atividade atividade) {
        if (!this.getAtividade().contains(atividade))
            return this.getAtividade().add(atividade);
        return false;
    }
    
    public Boolean removerAtividade (Atividade atividade) {
        return this.getAtividade().remove(atividade);
    }
    
    /*public Atividade retornaAtividade (Turma this, Atividade atividade) {
        if (this.getAtividade().contains(atividade))
            return this.getAtividade().get(this.getAtividade().indexOf(atividade));
        else
            return null;
    }*/
    
    @Override
    public int compareTo (Turma turma) {
        return this.id.compareTo(turma.id);
    }
    
    @Override
    public String toString () {
        return ("ID: " + this.id + "\nAno: " + this.ano +
                "\nPeríodo: " + this.periodo + "\nNúmero de vagas: " + this.numeroDeVagas +
                "\nDisciplina: " + this.disciplina.getNome() +
                "\nProfessor: " + this.professor.getNome() + "\n");
    }
    
    //LEMBRAR DE APAGAR
    public void imprimirListaAulas () {
        for (Aula aula: this.aula)
            System.out.println(aula.toString() + "\n");
    }
    
    //LEMBRAR DE APAGAR
    public void imprimirListaAlunos () {
        for (Aluno aluno: this.aluno)
            System.out.println(aluno.toString() + "\n");
    }
    
    //LEMBRAR DE APAGAR
    public void imprimirListaAtividades () {
        for (Atividade atividade: this.atividade)
            System.out.println(atividade.toString() + "\n");
    }
}
