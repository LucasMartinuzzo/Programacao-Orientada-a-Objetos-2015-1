package model.dao;

import java.util.List;
import model.pojo.Aula;

/**
 *
 * @author JeanPablo
 */
public interface AulaDao {
    Boolean salvar (Aula aula);
    Boolean remover (Aula aula);
    int indiceAula (String id);
    Aula obterAula (String id);
    List<Aula> obterTodas ();
}