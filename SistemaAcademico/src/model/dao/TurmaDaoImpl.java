package model.dao;

import java.util.Collections;
import java.util.List;
import model.pojo.Turma;

/**
 *
 * @author JeanPablo
 */
public class TurmaDaoImpl implements Dao {
    
    private static List<Turma> listaTurma;
    
    @Override
    public Boolean inserir (Object objeto) {
        Turma turma = (Turma) objeto;
        if (this.indice(turma.getId()) == -1) {
            listaTurma.add(turma);
            Collections.sort(listaTurma);
            return true;
        }
        return false;
    }
    
    @Override
    public Boolean remover (Object objeto) {
        Turma turma = (Turma) objeto;
        return listaTurma.remove(turma);
    }
    
    @Override
    public int indice (String id) {
        return Collections.binarySearch(listaTurma, new Turma (id, null, 
                null, null, null, null, null));
    }
    
    @Override
    public Object obter (String id) {
        if (this.indice(id) != -1)
            return listaTurma.get(this.indice(id));
        return null;
    }
    
    @Override
    public List<Object> obterTodos () {
        return (List<Object>) (Object) listaTurma;
    }
    
    @Override
    public void salvar (){
    //*Implementar*//
    }
    
    @Override
    public void carregar (){
    //*Implementar*//
    }
}