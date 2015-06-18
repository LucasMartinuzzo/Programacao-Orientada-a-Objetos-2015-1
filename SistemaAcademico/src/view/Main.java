/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        Professor professor = new Professor("123","Helcio","Computacao");
        Disciplina disciplina = new Disciplina("Arquitetura","Coisas",12);
        Aluno aluno = new Aluno("12","Calouro");
        Turma turma = new Turma(2022,1,"Sala","13:00",10,disciplina,professor);
        Main main = new Main();
        main.persist(disciplina);
        main.persist(professor);
        main.persist(aluno);
        main.persist(turma);
    }
    public void persist (Object object){
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("SistemaAcademicoPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(object);
            em.getTransaction().commit();
        }
        catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
