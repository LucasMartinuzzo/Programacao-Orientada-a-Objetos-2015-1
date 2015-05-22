package model.pojo;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Lucas
 */
public class Disciplina implements Comparable<Disciplina>{
    private String nome;
    private String ementa;
    private Integer cargaHoraria;
    private List<Professor> professor = new ArrayList<>();
    private List<Turma> turma = new ArrayList<>();
    
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
        return ementa;
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
        if (!this.getTurma().contains(turma))
            return this.getTurma().add(turma);
        return false;
    }

    public Boolean removerTurma (Turma turma) {
        return this.getTurma().remove(turma);
    }
    
    @Override
    public int compareTo(Disciplina disciplina) {
        return this.nome.compareTo(disciplina.getNome());
    }
    
    @Override
    public String toString () {
        return ("Nome: " + this.nome + "\nEmenta: " + this.ementa + 
                "\nCarga Horária: " + this.cargaHoraria + "\n");
    }
    
    //LEMBRAR DE APAGAR
    public void imprimirListaProfessores () {
        for (Professor professor: this.professor)
            System.out.println(professor.toString() + "\n");
    }
    
    //LEMBRAR DE APAGAR
    public void imprimirListaTurmas () {
        for (Turma turma: this.turma)
            System.out.println(turma.toString());
    }
}
