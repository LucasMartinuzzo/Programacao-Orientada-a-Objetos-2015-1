package model.dao;

import java.util.Collections;
import java.util.List;
import model.pojo.Atividade;

/**
 *
 * @author Mônicka
 */
public class AtividadeDaoImpl implements Dao {
    
    private static List<Atividade> listaAtividade;
    
    @Override
    public Boolean inserir (Object objeto) {
        Atividade atividade = (Atividade) objeto;
        if (this.indice(atividade.getId()) == -1) {
            listaAtividade.add(atividade);
            Collections.sort(listaAtividade);
            return true;
        }
        return false;
    }
    
    @Override
    public Boolean remover (Object objeto) {
        Atividade atividade = (Atividade) objeto;
        return listaAtividade.remove(atividade);
    }
    
    @Override
    public int indice (String id) {
        return Collections.binarySearch(listaAtividade, new Atividade (id, null, 
                null, null, null, null));
    }
    
    @Override
    public Object obter (String id) {
        if (this.indice(id) != -1)
            return listaAtividade.get(this.indice(id));
        return null;
    }
    
    @Override
    public List<Object> obterTodos () {
        return (List<Object>) (Object) listaAtividade;
    }
}