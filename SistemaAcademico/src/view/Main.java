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
        Main main = new Main();
        //AtividadeView atividadeView = new AtividadeView();
        
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("SistemaAcademicoPU");
        EntityManager em = emf.createEntityManager();
        
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        
        Professor professor = new Professor("123","Helcio","Computacao");
//        Disciplina disciplina = new Disciplina("Arquitetura","Coisas",12);
//        Disciplina disciplina2 = new Disciplina("Ed1","Mais coisas", 12);
//        Aluno aluno = new Aluno("12","Calouro");
//        Turma turma = new Turma(2022,1,"Sala","13:00",10,disciplina,professor);
//        ProfessorDaoImpl.getInstancia().salvar(em, professor);
        Professor prof = ProfessorDaoImpl.getInstancia().buscar(em, "123");
        prof.setCpf("456");
        ProfessorDaoImpl.getInstancia().alterar(em, prof);
//        DisciplinaDaoImpl.getInstancia().salvar(em,disciplina);
//        DisciplinaDaoImpl.getInstancia().salvar(em, disciplina2);
//        AlunoDaoImpl.getInstancia().salvar(em, aluno);
//        TurmaDaoImpl.getInstancia().salvar(em, turma);
//        professor.adicionarDisciplina(disciplina2);
//        professor.adicionarDisciplina(disciplina);
//        ProfessorDaoImpl.getInstancia().alterar(em, professor);
//        turma.adicionarAluno(aluno);
//        main.imprimir(em, atividadeView);
//        TurmaDaoImpl.getInstancia().alterar(em, turma);
//        AlunoDaoImpl.getInstancia().alterar(em, aluno);
        em.close();
        emf.close();
    }
    
    public static List<Disciplina> lista (EntityManager em){
        Query query = em.createQuery("SELECT e FROM Disciplina e");
        return (List<Disciplina>) query.getResultList();
    }
    
    public void imprimir (EntityManager em, AtividadeView atividadeView){
        atividadeView.cadastrar(em);
    }
    
    
}
