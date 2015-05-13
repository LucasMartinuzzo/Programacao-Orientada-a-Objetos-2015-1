package model.pojo;

import java.util.List;
/**
 *
 * @author Lucas
 */
public class Disciplina implements Comparable<Disciplina>{
    private String nome;
    private String ementa;
    private Integer cargaHoraria;
    private List<Professor> professor;
    private List<Turma> turma;
    
    public Disciplina(String nome, String ementa, Integer cargaHoraria){
        this.nome = nome;
        this.ementa = ementa;
        this.cargaHoraria = cargaHoraria;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getEmenta(){
        return nome;
    }
    
    public void setEmenta(String ementa){
        this.ementa = ementa;
    }
    
    public Integer getCargaHoraria(){
        return cargaHoraria;
    }
    
    public void setCargaHoraria(Integer cargaHoraria){
        this.cargaHoraria = cargaHoraria;
    }
    
    public List<Professor> getProfessor(){
        return professor;
    }
    
    public List<Turma> getTurma(){
        return turma;
    }

    public Boolean adicionarTurma (Turma turma) {
        Disciplina disciplina = turma.getDisciplina();
        if (!disciplina.getTurma().contains(turma))
            return disciplina.getTurma().add(turma);
        return false;
    }

    public Boolean removerTurma (Turma turma) {
        Disciplina disciplina = turma.getDisciplina();
        return disciplina.getTurma().remove(turma);
    }
    @Override
    public int compareTo(Disciplina disciplina) {
        return this.nome.compareTo(disciplina.getNome());
    }
    
    @Override
    public String toString () {
        return ("Nome: " + this.nome + "\nEmenta: " + this.ementa + "\nCarga Horária: " + this.ementa);
    }
}