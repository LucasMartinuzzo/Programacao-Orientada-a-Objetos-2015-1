/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
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
        Disciplina disciplina2 = new Disciplina("Ed1","Mais coisas", 12);
        Aluno aluno = new Aluno("12","Calouro");
        Turma turma = new Turma(2022,1,"Sala","13:00",10,disciplina,professor);
        //ProfessorDaoImpl.getInstancia().salvar(em, professor);
        //DisciplinaDaoImpl.getInstancia().salvar(em,disciplina);
        //DisciplinaDaoImpl.getInstancia().salvar(em, disciplina2);
        //professor.adicionarDisciplina(disciplina2);
        //professor.adicionarDisciplina(disciplina);
        //ProfessorDaoImpl.getInstancia().alterar(em, professor);
        //AlunoDaoImpl.getInstancia().salvar(em, aluno);
        //TurmaDaoImpl.getInstancia().salvar(em, turma);
        //turma.adicionarAluno(aluno);
        imprimir(lista(em));
        em.close();
        emf.close();
    }
    
    public static List<Disciplina> lista (EntityManager em){
        Query query = em.createQuery("SELECT e FROM Disciplina e");
        return (List<Disciplina>) query.getResultList();
    }
    public static void imprimir (List<Disciplina> list){
        for(Disciplina disc: list)
            System.out.println(disc);
    } 
    
}
