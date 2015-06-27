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
public class Disciplina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String nome;
    private String ementa;
    private Integer cargaHoraria;
    @ManyToMany
    @JoinTable(name="DisciplinaProfessor", inverseJoinColumns={@JoinColumn(name="cpfProfessor")},
            joinColumns={@JoinColumn(name="nomeDisciplina")})
    private List<Professor> professor = new ArrayList<>();
    @OneToMany(mappedBy="disciplina")
    private List<Turma> turma = new ArrayList<>();
    
    public Disciplina(){}
    
    public Disciplina(String nome, String ementa, Integer cargaHoraria) {
        this.nome = nome;
        this.ementa = ementa;
        this.cargaHoraria = cargaHoraria;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public List<Professor> getProfessor() {
        return professor;
    }

    public List<Turma> getTurma() {
        return turma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nome != null ? nome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.nome == null && other.nome != null) || (this.nome != null && !this.nome.equals(other.nome))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ("Nome:\t" + this.nome + "\nEmenta:\t" + this.ementa + 
                "\nCarga Horária:\t" + this.cargaHoraria + "\n");
    }
    
    public Boolean adicionarTurma (Turma turma) {
        if (!this.getTurma().contains(turma))
            return this.getTurma().add(turma);
        return false;
    }
}
