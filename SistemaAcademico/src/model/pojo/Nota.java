package model.pojo;

/**
 *
 * @author Filipe
 */
public class Nota implements Comparable<Nota>{
    private String id;
    private Double nota;
    private Aluno aluno;
    private Atividade atividade;

    public Nota (String id, Double nota, Aluno aluno, Atividade atividade){
        this.id = id;
        this.nota = nota;
        this.aluno = aluno;
        this.atividade = atividade;
    }

    public Nota(String id, Nota nota) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getId (){
        return id;
    }
    
    public Double getNota(){
        return nota;
    }
    
    public void setNota(Double nota){
        this.nota = nota;
    }
    
    public Aluno getAluno(){
        return aluno;
    }
    
    public void setAluno(Aluno aluno){
        this.aluno = aluno;
    }
    
    public Atividade getAtividade(){
        return atividade;
    }
    
    public void setAtividade(Atividade atividade){
        this.atividade = atividade;
    }
    
    @Override
    public int compareTo (Nota nota){
        return this.id.compareTo(nota.id);
    }
    @Override
    public String toString () {
        return ("ID: " + this.id + "\nNotas: " + this.nota + "\nAluno: " 
                + this.aluno.getNome() + "\nAtividade: " + atividade.getNome() 
                + "("+atividade.getTipo()+")");
    }    
}
