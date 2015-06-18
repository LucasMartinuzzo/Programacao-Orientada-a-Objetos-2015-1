package model.dao;

import javax.persistence.EntityManager;
import model.pojo.Disciplina;

public class DisciplinaDaoImpl implements Dao<Disciplina>{
    private static DisciplinaDaoImpl instancia = null;
    
    public static DisciplinaDaoImpl getInstancia(){
        if(DisciplinaDaoImpl.instancia == null)
            instancia = new DisciplinaDaoImpl();
        return instancia;
    }
    
    @Override
    public void salvar (EntityManager em, Disciplina disciplina){
        em.getTransaction().begin();
        try{
            em.persist(disciplina);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
    
    @Override
    public Disciplina buscar (EntityManager em, Object nome){
        Disciplina disciplina = new Disciplina(null, null, null);
        em.getTransaction().begin();
        try{
            disciplina = em.find(Disciplina.class, nome);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return disciplina;
    }
            
            
    @Override
    public void alterar (EntityManager em, Disciplina disciplina){
        em.getTransaction().begin();
        try{
            em.merge(disciplina);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}
