package model.pojo;

import java.util.List;

/**
 *
 * @author Pedro
 */
public class Professor implements Comparable<Professor>{
    private String nome;
    private String cpf;
    private String departamento;
    private List<Disciplina> disciplina;
    
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
    
    @Override
    public int compareTo (Professor professor){
        return this.cpf.compareTo(professor.cpf);
    }
}