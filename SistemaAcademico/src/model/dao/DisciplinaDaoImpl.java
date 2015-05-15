package model.dao;

import java.util.Collections;
import java.util.List;
import model.pojo.Disciplina;

/**
 *
 * @author Lucas
 */
public class DisciplinaDaoImpl implements Dao {
    
    private static List<Disciplina> listaDisciplina;
    
    @Override
    public Boolean inserir (Object objeto) {
        Disciplina disciplina = (Disciplina) objeto;
        if (this.indice(disciplina.getNome()) == -1) {
            listaDisciplina.add(disciplina);
            Collections.sort(listaDisciplina);
            return true;
        }
        return false;
    }
    
    @Override
    public Boolean remover (Object objeto) {
        Disciplina disciplina = (Disciplina) objeto;
        return listaDisciplina.remove(disciplina);
    }
    
    @Override
    public int indice (String nome) {
        return Collections.binarySearch(listaDisciplina, new Disciplina (nome, null, null));
    }
    
    @Override
    public Object obter (String nome) {
        if (this.indice(nome) != -1)
            return listaDisciplina.get(this.indice(nome));
        return null;
    }
    
    @Override
    public List<Object> obterTodos () {
        return (List<Object>) (Object) listaDisciplina;
    }
}