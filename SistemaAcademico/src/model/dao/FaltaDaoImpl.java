package model.dao;

import java.util.Collections;
import java.util.List;
import model.pojo.Falta;

/**
 *
 * @author Filipe
 */
public class FaltaDaoImpl implements FaltaDao{

    private List<Falta> listaFalta;
       
    @Override
    public Boolean salvar (Falta falta) {
        if (this.indiceFalta(falta.getId()) == -1 ){
           this.listaFalta.add(falta);
           Collections.sort(this.listaFalta);
           return true;
        }
        return false;
    }
    
    @Override
    public Boolean remover(Falta falta){
        return this.listaFalta.remove(falta);
    }
    
    @Override
    public int indiceFalta (String id) {
        return Collections.binarySearch(this.listaFalta, new Falta(id, null, null));
    }
    
     @Override
    public Falta obterFalta (String id) {
        if (this.indiceFalta(id) != -1)
            return this.listaFalta.get(this.indiceFalta(id));
        return null;
    }
    
    @Override
    public List<Falta> obterTodas () {
        return listaFalta;
    }    
}