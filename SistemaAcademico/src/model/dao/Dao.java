package model.dao;

import java.util.List;

/**
 *
 * @author JeanPablo
 */
public interface Dao {
    Boolean inserir (Object objeto);
    Boolean remover (Object objeto);
    int indice (String id);
    Object obter (String id);
    List<Object> obterTodos ();
    void salvar ();
    void carregar ();
    
}