package model.dao;

import java.util.Collections;
import java.util.List;
import model.pojo.Falta;

/**
 *
 * @author Filipe
 */
public class FaltaDaoImpl implements Dao {
    
    private static List<Falta> listaFalta;
    
    @Override
    public Boolean inserir (Object objeto) {
        Falta falta = (Falta) objeto;
        if (this.indice(falta.getId()) == -1) {
            listaFalta.add(falta);
            Collections.sort(listaFalta);
            return true;
        }
        return false;
    }
    
    @Override 
    public Boolean remover (Object objeto) {
        Falta falta = (Falta) objeto;
        return listaFalta.remove(falta);
    }
    
    @Override
    public int indice (String id) {
        return Collections.binarySearch(listaFalta, new Falta (id, null, null));
    }
    
    @Override
    public Object obter (String id) {
        if (this.indice(id) != -1)
            return listaFalta.get(this.indice(id));
        return null;
    }
    
    @Override
    public List<Object> obterTodos () {
        return (List<Object>) (Object) listaFalta;
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