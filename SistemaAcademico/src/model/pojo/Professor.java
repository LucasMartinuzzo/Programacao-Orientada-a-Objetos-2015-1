package model.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class Professor implements Comparable<Professor>{
    private String nome;
    private String cpf;
    private String departamento;
    private List<Disciplina> disciplina = new ArrayList<>();
    
    public Professor (String nome, String cpf, String departamento){
        this.nome = nome;
        this.cpf = cpf;
        this.departamento = departamento;
    }
    
    public String getNome (){
        return nome;
    }
    
    public void setNome (String nome){
        this.nome = nome;
    }
    
    public String getCpf (){
        return cpf;
    }
    
    public void setCpf (String cpf){
        this.cpf = cpf;
    }
    
    public String getDepartamento (){
        return departamento;
    }
    
    public void setDepartamento (String departamento){
        this.departamento = departamento;
    }
    
    public List<Disciplina> getDisciplina (){
        return disciplina;
    }
    
    public Boolean adicionarDisciplina (Object objeto){
        Disciplina disciplina = (Disciplina) objeto;
        if (!(this.getDisciplina().contains(disciplina))) {
            disciplina.getProfessor().add(this);
            return this.getDisciplina().add(disciplina);
        }
        return false;
    }
    
    public Boolean removerDisciplina (Disciplina disciplina){
        if (this.getDisciplina().remove(disciplina))
            return disciplina.getProfessor().remove(this);
        return false;
    }
    
    @Override
    public int compareTo (Professor professor){
        return this.cpf.compareTo(professor.cpf);
    }
    
    @Override
    public String toString () {
        return ("Nome: " + this.nome + "\nCPF: " + this.cpf + "\nDepartamento: " + this.departamento);
    }
}