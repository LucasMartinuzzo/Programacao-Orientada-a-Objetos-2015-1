package model.dao;

import java.util.List;
import model.pojo.Falta;

/**
 *
 * @author Filipe
 */
public interface FaltaDao {

    List<Falta> obterTodas ();
    Falta obterFalta (String id);
    int indiceFalta (String id);
    Boolean remover(Falta falta);
    Boolean salvar (Falta falta);

}
