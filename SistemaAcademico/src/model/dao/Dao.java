package model.dao;

import java.util.List;

/**
 *
 * @author JeanPablo
 */
public interface Dao {
    Boolean salvar (Object objeto);
    Boolean remover (Object objeto);
    int indice (String id);
    Object obter (String id);
    List<Object> obterTodos ();
}
