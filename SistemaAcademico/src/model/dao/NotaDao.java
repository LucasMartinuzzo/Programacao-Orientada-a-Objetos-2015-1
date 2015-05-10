package model.dao;

import java.util.List;
import model.pojo.Nota;

/**
 *
 * @author Pedro
 */
public interface NotaDao {
    Boolean salvar (Nota nota);
    Boolean remover (Nota nota);
    int indiceNota (String id);
    Nota obterNota (String id);
    List<Nota> obterTodos ();
}