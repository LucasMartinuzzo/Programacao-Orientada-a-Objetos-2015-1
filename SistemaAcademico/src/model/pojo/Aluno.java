package model.pojo;
//CONSULTAR A SITUAÇÃO DO ALUNO EM DETERMINADA DISCIPLINA 
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
    public Boolean adicionarFalta(Object objeto){
        Falta falta = (Falta) objeto;
        if(!this.getFalta().contains(falta))
            return this.getFalta().add(falta);
        return false;
    }

    public List<Falta> getFalta() {
        return falta;
    }
    
    public List<Nota> getNota(){
        return nota;
    }
    
    public Boolean adicionarTurma (Object objeto) {
        Turma turma = (Turma) objeto;
        if (!this.getTurma().contains(turma) || 
                turma.getAluno().size() < turma.getNumeroDeVagas()) {
            turma.getAluno().add(this);
            return this.getTurma().add(turma);
        }
        return false;
    }
    public Boolean adicionaNota(Nota nota){
        if(!this.getNota().contains(nota))
            return this.getNota().add(nota);
        return false;
    }
    
//    public Nota retornaNota (Nota nota) {
//       if(this.getNota().contains(nota))
//            return this.getNota().get(this.getNota().indexOf(nota)); 
//       else
//            return null; 
//    }

    public Double NotaFinal(Turma turma){
        Double somaNotas = 0.0;
        for(Nota notaConsultada: this.getNota())
            if(notaConsultada.getAtividade().getTurma().equals(turma))
                somaNotas += notaConsultada.getNota();
        return somaNotas;
    }
    
    @Override
    public int compareTo (Aluno aluno) {
        return this.cpf.compareTo(aluno.cpf);
    }
    
    @Override
    public String toString () {
        return ("Nome: " + this.nome + "\nCPF: " + this.cpf);
    }
}