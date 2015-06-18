/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import javax.persistence.EntityManager;
import model.pojo.Professor;

/**
 *
 * @author Lucas
 */
public class ProfessorDaoImpl implements Dao<Professor> {    
    private static ProfessorDaoImpl instancia = null;
    
    public static ProfessorDaoImpl getInstancia(){
        if(ProfessorDaoImpl.instancia == null)
            instancia = new ProfessorDaoImpl();
        return instancia;
    }
    
    @Override
    public void salvar (EntityManager em, Professor professor){
        em.getTransaction().begin();
        try{
            em.persist(professor);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
    
    @Override
    public Professor buscar (EntityManager em, Object cpf){
        Professor professor = new Professor(null, null, null);
        em.getTransaction().begin();
        try{
            professor = em.find(Professor.class, cpf);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return professor;
    }
            
            
    @Override
    public void alterar (EntityManager em, Professor professor){
        em.getTransaction().begin();
        try{
            em.merge(professor);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}
