package model.dao;

import javax.persistence.EntityManager;

public interface Dao<T>{
    void salvar (EntityManager em, T t);
    T buscar (EntityManager em, Object objeto);
    void alterar (EntityManager em, T t);
}