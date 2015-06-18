package model.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String cpf;
    private String nome;
    @ManyToMany
    @JoinTable(name="AlunoTurma", inverseJoinColumns={@JoinColumn(name="idTurma")},
            joinColumns={@JoinColumn(name="cpfAluno")})
    private List<Turma> turma = new ArrayList<>();
    @OneToMany
    @JoinColumn(name = "cpfAluno")
    private List<Falta> falta = new ArrayList<>();
    @OneToMany (mappedBy="aluno")
    private List<Nota> nota = new ArrayList<>();
    
    public Aluno () {}
    
    public Aluno (String cpf, String nome) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Turma> getTurma() {
        return turma;
    }

    public List<Falta> getFalta() {
        return falta;
    }

    public List<Nota> getNota() {
        return nota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpf != null ? cpf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.cpf == null && other.cpf != null) || (this.cpf != null && !this.cpf.equals(other.cpf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ("Nome: " + this.nome + "\nCPF: " + this.cpf + "\n");
    }
    
    public Boolean adicionarFalta(Falta falta){
        if(!this.getFalta().contains(falta))
            return this.getFalta().add(falta);
        return false;
    }
    
    public Boolean adicionarNota(Nota nota){
        if(!this.getNota().contains(nota))
            return this.getNota().add(nota);
        return false;
    }
    
    public Double notaFinal (Turma turma){
        Double somaNotas = 0.0;
        for(Nota notaConsultada: this.getNota())
            if(notaConsultada.getAtividade().getTurma().equals(turma))
                somaNotas += notaConsultada.getNota();
        return somaNotas;
    }
}
