package model.dao;

import javax.persistence.EntityManager;
import model.pojo.Nota;

public class NotaDaoImpl implements Dao<Nota> {    
    private static NotaDaoImpl instancia = null;
    
    public static NotaDaoImpl getInstancia(){
        if(NotaDaoImpl.instancia == null)
            instancia = new NotaDaoImpl();
        return instancia;
    }
    
    @Override
    public void salvar (EntityManager em, Nota nota){
        em.getTransaction().begin();
        try{
            em.persist(nota);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
    
    @Override
    public Nota buscar (EntityManager em, Object id){
        Nota nota = new Nota(null, null, null);
        em.getTransaction().begin();
        try{
            nota = em.find(Nota.class, id);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return nota;
    }
            
            
    @Override
    public void alterar (EntityManager em, Nota nota){
        em.getTransaction().begin();
        try{
            em.merge(nota);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
    
}
