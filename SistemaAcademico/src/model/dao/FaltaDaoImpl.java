package model.dao;

import javax.persistence.EntityManager;
import model.pojo.Falta;

public class FaltaDaoImpl implements Dao<Falta>{
    private static FaltaDaoImpl instancia = null;
    
    public static FaltaDaoImpl getInstancia(){
        if(FaltaDaoImpl.instancia == null)
            instancia = new FaltaDaoImpl();
        return instancia;
    }
    
    @Override
    public void salvar (EntityManager em, Falta falta){
        em.getTransaction().begin();
        try{
            em.persist(falta);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
    
    @Override
    public Falta buscar (EntityManager em, Object id){
        Falta falta = new Falta(null, null);
        em.getTransaction().begin();
        try{
            falta = em.find(Falta.class, id);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return falta;
    }
            
            
    @Override
    public void alterar (EntityManager em, Falta falta){
        em.getTransaction().begin();
        try{
            em.merge(falta);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}

