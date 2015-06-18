/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.dao.AlunoDaoImpl;
import model.dao.DisciplinaDaoImpl;
import model.dao.ProfessorDaoImpl;
import model.dao.TurmaDaoImpl;
import model.pojo.Aluno;
import model.pojo.Disciplina;
import model.pojo.Professor;
import model.pojo.Turma;

/**
 *
 * @author Lucas
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("SistemaAcademicoPU");
        EntityManager em = emf.createEntityManager();
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        Professor professor = new Professor("123","Helcio","Computacao");
        Disciplina disciplina = new Disciplina("Arquitetura","Coisas",12);
        Aluno aluno = new Aluno("12","Calouro");
        Turma turma = new Turma(2022,1,"Sala","13:00",10,disciplina,professor);
        professor.adicionarDisciplina(disciplina);
        ProfessorDaoImpl.getInstancia().alterar(em, professor);
        DisciplinaDaoImpl.getInstancia().alterar(em, disciplina);
        //System.out.println("Professor-Disciplina: " + professor.getDisciplina().get(0) + 
        //        "\n Disciplina-Professor: " + disciplina.getProfessor().get(0));
        //turma.adicionarAluno(aluno);
        //ProfessorDaoImpl.getInstancia().salvar(em, professor);
        //DisciplinaDaoImpl.getInstancia().salvar(em, disciplina);
        //AlunoDaoImpl.getInstancia().salvar(em, aluno);
        //TurmaDaoImpl.getInstancia().salvar(em, turma);
        em.close();
        emf.close();
    }
}
