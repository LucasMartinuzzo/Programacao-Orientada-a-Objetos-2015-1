/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.pojo.Turma;

/**
 *
 * @author Lucas
 */
public class TurmaDaoImpl implements Dao<Turma> {    
    private static TurmaDaoImpl instancia = null;
    
    public static TurmaDaoImpl getInstancia(){
        if(TurmaDaoImpl.instancia == null)
            instancia = new TurmaDaoImpl();
        return instancia;
    }
    
    @Override
    public void salvar (EntityManager em, Turma turma){
        em.getTransaction().begin();
        try{
            em.persist(turma);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
    
    @Override
    public Turma buscar (EntityManager em, Object id){
        Turma turma = new Turma(null, null, null, null, null, null, null);
        em.getTransaction().begin();
        try{
            turma = em.find(Turma.class, id);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return turma;
    }
            
            
    @Override
    public void alterar (EntityManager em, Turma turma){
        em.getTransaction().begin();
        try{
            em.merge(turma);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
    
    @Override
    public List<Turma> obterTodos (EntityManager em){
        Query query = em.createQuery("SELECT e FROM Turma e");
        return (List<Turma>) query.getResultList();
    }
}
