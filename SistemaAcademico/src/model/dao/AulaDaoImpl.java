package model.dao;

import java.util.Collections;
import java.util.List;
import model.pojo.Aula;

/**
 *
 * @author JeanPablo
 */
public class AulaDaoImpl implements Dao {
    
    private static List<Aula> listaAula;
    
    @Override
    public Boolean salvar(Object objeto) {
        Aula aula = (Aula) objeto;
        if (this.indice(aula.getId()) == -1) {
            listaAula.add(aula);
            Collections.sort(listaAula);
            return true;
        }
        return false;
    }

    @Override
    public Boolean remover(Object objeto) {
        Aula aula = (Aula) objeto;
        return listaAula.remove(aula);
    }

    @Override
    public int indice(String id) {
        return Collections.binarySearch(listaAula, new Aula (id, null, 
                null, null));
    }

    @Override
    public Object obter(String id) {
        if (this.indice(id) != -1)
            return listaAula.get(this.indice(id));
        return null;
    }

    @Override
    public List<Object> obterTodos() {
        return (List<Object>) (Object) listaAula;
    }
}
