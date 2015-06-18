package model.dao;

import javax.persistence.EntityManager;
import model.pojo.Aluno;

public class AlunoDaoImpl implements Dao<Aluno>{
    private static AlunoDaoImpl instancia = null;
    
    public static AlunoDaoImpl getInstancia(){
        if(AlunoDaoImpl.instancia == null)
            instancia = new AlunoDaoImpl();
        return instancia;
    }
    
    @Override
    public void salvar (EntityManager em, Aluno aluno){
        em.getTransaction().begin();
        try{
            em.persist(aluno);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
    
    @Override
    public Aluno buscar (EntityManager em, Object cpf){
        Aluno aluno = new Aluno(null, null);
        em.getTransaction().begin();
        try{
            aluno = em.find(Aluno.class, cpf);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        return aluno;
    }
            
            
    @Override
    public void alterar (EntityManager em, Aluno aluno){
        em.getTransaction().begin();
        try{
            em.merge(aluno);
            em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}
