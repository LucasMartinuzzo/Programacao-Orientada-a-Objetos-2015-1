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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Turma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer ano;
    private Integer periodo;
    private String local;
    private String horario;
    private Integer numeroDeVagas;
    @ManyToOne
    @JoinColumn(name="nomeDisciplina")
    private Disciplina disciplina;
    @OneToOne
    @JoinColumn(name="cpfProfessor")
    private Professor professor;
    @ManyToMany
    @JoinTable(name="AlunoTurma", inverseJoinColumns={@JoinColumn(name="cpfAluno")},
            joinColumns={@JoinColumn(name="idTurma")})
    private List<Aluno> aluno = new ArrayList<>();
    @OneToMany(mappedBy="turma")
    private List<Atividade> atividade = new ArrayList<>();
    
    public Turma(){}

    public Turma(Integer ano, Integer periodo, String local, String horario, Integer numeroDeVagas, Disciplina disciplina, Professor professor) {
        this.ano = ano;
        this.periodo = periodo;
        this.local = local;
        this.horario = horario;
        this.numeroDeVagas = numeroDeVagas;
        this.disciplina = disciplina;
        this.professor = professor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Integer getNumeroDeVagas() {
        return numeroDeVagas;
    }

    public void setNumeroDeVagas(Integer numeroDeVagas) {
        this.numeroDeVagas = numeroDeVagas;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getAluno() {
        return aluno;
    }

    public List<Atividade> getAtividade() {
        return atividade;
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
        if (!(object instanceof Turma)) {
            return false;
        }
        Turma other = (Turma) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString () {
        return ("ID: " + this.id + "\nAno: " + this.ano +
                "\nPeríodo: " + this.periodo + "\nLocal: " + this.local + 
                "\n Horário: " + this.horario + "\nNúmero de Vagas: " + 
                this.numeroDeVagas + "\nDisciplina: " + this.disciplina.getNome() +
                "\nProfessor: " + this.professor.getNome() + "\n");
    }
    
    public Boolean adicionarAluno (Aluno aluno){
        if (this.getAluno().size() < this.getNumeroDeVagas() && !(this.getAluno().contains(aluno))){
            return this.getAluno().add(aluno);
        }
        return false;
    }

    public Boolean adicionarAtividade (Atividade atividade) {
        if (!this.getAtividade().contains(atividade))
            return this.getAtividade().add(atividade);
        return false;
    }
}
