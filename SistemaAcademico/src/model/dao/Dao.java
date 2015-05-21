package model.dao;

import java.util.List;
import java.io.IOException;

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
    void salvar () throws IOException;
    void carregar () throws IOException;
    void imprimir ();
}