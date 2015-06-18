package model.dao;

import javax.persistence.EntityManager;
import model.pojo.Atividade;

public class AtividadeDaoImpl implements Dao<Atividade>{
    private static AtividadeDaoImpl instancia = null;
    
    public static AtividadeDaoImpl getInstancia(){
        if(AtividadeDaoImpl.instancia == null)
            instancia = new AtividadeDaoImpl();
        return instancia;
    }
    
    @Override
    public void salvar (EntityManager em, Atividade atividade){
        em.getTransaction().begin();
        try{
            em.persist(atividade);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
    
    @Override
    public Atividade buscar (EntityManager em, Object id){
        Atividade atividade = new Atividade(null, null, null, null, null);
        em.getTransaction().begin();
        try{
            atividade = em.find(Atividade.class, id);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return atividade;
    }
            
            
    @Override
    public void alterar (EntityManager em, Atividade atividade){
        em.getTransaction().begin();
        try{
            em.merge(atividade);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}

