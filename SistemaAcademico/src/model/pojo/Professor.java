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

@Entity
public class Professor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String cpf;
    private String nome;
    private String departamento;
    @ManyToMany
    @JoinTable(name="DisciplinaProfessor", inverseJoinColumns={@JoinColumn(name="nomeDisciplina")},
            joinColumns={@JoinColumn(name="cpfProfessor")})
    private List<Disciplina> disciplina = new ArrayList();

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

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public List<Disciplina> getDisciplina() {
        return disciplina;
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
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.cpf == null && other.cpf != null) || (this.cpf != null && !this.cpf.equals(other.cpf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString () {
        return ("Nome: " + this.nome + "\nCPF: " + this.cpf + "\nDepartamento: " + this.departamento + "\n");
    }
}
