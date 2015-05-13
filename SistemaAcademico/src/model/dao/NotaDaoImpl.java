package model.dao;

import java.util.Collections;
import java.util.List;
import model.pojo.Nota;

/**
 *
 * @author Pedro
 */
public class NotaDaoImpl implements Dao {
    
    private static List<Nota> listaNota;
    
    @Override
    public Boolean salvar (Object objeto) {
        Nota nota = (Nota) objeto;
        if (this.indice(nota.getId()) == -1) {
            listaNota.add(nota);
            Collections.sort(listaNota);
            return true;
        }
        return false;
    }
    
    @Override
    public Boolean remover (Object objeto) {
        Nota nota = (Nota) objeto;
        return listaNota.remove(nota);
    }
    
    @Override
    public int indice (String id) {
        return Collections.binarySearch(listaNota, new Nota (id, null, null, null));
    }
    
    @Override
    public Object obter (String id) {
        if (this.indice(id) != -1)
            return listaNota.get(this.indice(id));
        return null;
    }
    
    @Override
    public List<Object> obterTodos () {
        return (List<Object>) (Object) listaNota;
    }
}