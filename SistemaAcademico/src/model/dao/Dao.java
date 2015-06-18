package model.dao;

public interface Dao<T>{
    void salvar (T t);
    T buscar (Object objeto);
    void alterar (T t);
}