package model.pojo;

import java.util.List;     

/**
 *
 * @author Filipe
 */
public class Aluno implements Comparable<Aluno>{
    private String nome;
    private String cpf;
    private List<Turma> turma;  
    private List<Falta> falta;
    private List<Nota> nota;

    public Aluno (String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Turma> getTurma() {
        return turma;
    }

    public List<Falta> getFalta() {
        return falta;
    }
    
    public List<Nota> getNota(){
        return nota;
    }
    
    @Override
    public int compareTo (Aluno aluno) {
        return this.cpf.compareTo(aluno.cpf);
    }
    
    @Override
    public String toString () {
        return ("Nome: " + this.nome + "\nCPF: " + this.cpf);
    }

    public Boolean adicaoValida(Nota nota) {
        return (!this.getNota().contains(nota));
    }
    
    public void adicionaNota(Nota nota){
        this.getNota().add(nota);
    }
    
    public Nota retornaNota (Nota nota) {
       if(this.getNota().contains(nota))
            return this.getNota().get(this.getNota().indexOf(nota)); 
       else
            return null; 
    }

    public Double NotaFinal(Turma turma){
        Double somaNotas = 0.0;
        for(Nota notaConsultada: this.getNota())
            if(notaConsultada.getAtividade().getTurma().equals(turma))
                somaNotas += notaConsultada.getNota();
    return somaNotas;
    }
}