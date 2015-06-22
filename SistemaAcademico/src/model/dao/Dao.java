package model.dao;

import java.util.List;
import javax.persistence.EntityManager;

public interface Dao<T>{
    void salvar (EntityManager em, T t);
    T buscar (EntityManager em, Object objeto);
    void alterar (EntityManager em, T t);
    List<T> obterTodos (EntityManager em);
}