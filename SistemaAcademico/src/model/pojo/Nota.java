package model.pojo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Nota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Double nota;
    @ManyToOne
    @JoinColumn(name="cpfAluno")
    private Aluno aluno;
    @ManyToOne
    @JoinColumn(name="idAtividade")
    private Atividade atividade;
    
    public Nota(){}

    public Nota(Double nota, Aluno aluno, Atividade atividade) {
        this.nota = nota;
        this.aluno = aluno;
        this.atividade = atividade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Nota)) {
            return false;
        }
        Nota other = (Nota) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString () {
        return ("ID:\t" + this.id + "\nNotas:\t" + this.nota + "\nAluno:\t" 
                + this.aluno.getNome() + "\nAtividade:\t" + atividade.getNome() 
                + "("+atividade.getTipo()+")" + "\nDisciplina:\t" + this.atividade.getTurma().getDisciplina().getNome()
                + "\nTurma(ID):\t" + this.atividade.getTurma().getId() + "\n");
    }   
}
