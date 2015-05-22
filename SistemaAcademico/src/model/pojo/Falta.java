package model.pojo;

/**
 *
 * @author Filipe
 */
public class Falta implements Comparable<Falta>{
    private String id;
    private Integer falta;
    private Turma turma;

    public Falta (String id, Integer falta, Turma turma){
        this.id = id;
        this.falta = falta;
        this.turma = turma;
    }
    
    public String getId(){
        return id;
    }
    
    public Integer getFalta(){
        return falta;
    }
    
    public void setFalta(Integer falta){
        this.falta = falta;
    }
    
    public Turma getTurma(){
        return turma;
    }
    
    public void setTurma(Object objeto){
        Turma turma = (Turma) objeto;
        this.turma = turma;
    }
    @Override
    public int compareTo (Falta falta) {
        return this.id.compareTo(falta.id);
    }
    @Override
    public String toString () {
        return ("ID: " + this.id + "\nFaltas: " + this.falta + "\nDisciplina: " 
                + this.turma.getDisciplina().getNome() + "\n");
    }    
}