package model.dao;

import java.util.Collections;
import java.util.List;
import model.pojo.Aula;

/**
 *
 * @author JeanPablo
 */
public class AulaDaoImpl implements AulaDao {
    
    private List<Aula> listaAula;
    
    @Override
    public Boolean salvar(Aula aula) {
        if (this.indiceAula(aula.getId()) == -1) {
            this.listaAula.add(aula);
            Collections.sort(this.listaAula);
            return true;
        }
        return false;
    }

    @Override
    public Boolean remover(Aula aula) {
        return this.listaAula.remove(aula);
    }

    @Override
    public int indiceAula(String id) {
        return Collections.binarySearch(this.listaAula, new Aula (id, null, 
                null, null));
    }

    @Override
    public Aula obterAula(String id) {
        if (this.indiceAula(id) != -1)
            return this.listaAula.get(this.indiceAula(id));
        return null;
    }

    @Override
    public List<Aula> obterTodas() {
        return listaAula;
    }
}
