package model.dao;

import java.util.Collections;
import java.util.List;
import model.pojo.Professor;

/**
 *
 * @author Pedro
 */
public class ProfessorDaoImpl implements Dao {
    
    private static List<Professor> listaProfessor;
    
    @Override
    public Boolean salvar (Object objeto) {
        Professor professor = (Professor) objeto;
        if (this.indice(professor.getCpf()) == -1) {
            listaProfessor.add(professor);
            Collections.sort(listaProfessor);
            return true;
        }
        return false;
    }
    
    @Override
    public Boolean remover (Object objeto) {
        Professor professor = (Professor) objeto;
        return listaProfessor.remove(professor);
    }
    
    @Override
    public int indice (String cpf) {
        return Collections.binarySearch(listaProfessor, new Professor (null, cpf, null));
    }
    
    @Override
    public Object obter (String cpf) {
        if (this.indice(cpf) != -1)
            return listaProfessor.get(this.indice(cpf));
        return null;
    }
    
    @Override
    public List<Object> obterTodos () {
        return (List<Object>) (Object) listaProfessor;
    }
}
