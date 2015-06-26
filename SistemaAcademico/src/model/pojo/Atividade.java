package model.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Atividade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    private String tipo;
    private String data;
    private Double valor;
    @ManyToOne
    @JoinColumn(name="idTurma")
    private Turma turma;
    @OneToMany(mappedBy="atividade")
    private List<Nota> nota = new ArrayList<>();

    public Atividade() {}
    
    public Atividade(String nome, String tipo, String data, Double valor, Turma turma) {
        this.nome = nome;
        this.tipo = tipo;
        this.data = data;
        this.valor = valor;
        this.turma = turma;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public List<Nota> getNota() {
        return nota;
    }

    public void setNota(List<Nota> nota) {
        this.nota = nota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Atividade)) {
            return false;
        }
        Atividade other = (Atividade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ("ID:\t" + this.id + "\nNome:\t" + this.nome +
                "\nTipo:\t" + this.tipo + "\nData:\t" + this.data + "\nValor:\t" + this.valor +
                "\nDisciplina:\t" + this.turma.getDisciplina().getNome() + "\nTurma(ID):\t" + this.turma.getId() + "\n");
    }
    
    public Boolean adicionarNota(Nota nota){
        for (Nota notaConsultada: this.getNota()) {
            if (notaConsultada.getAluno().equals(nota.getAluno()))
                return false;
        }
        return this.getNota().add(nota);
    }
}
