package model.dao;

import java.util.Collections;
import java.util.List;
import model.pojo.Professor;

/**
 *
 * @author Pedro
 */
public class ProfessorDaoImpl implements ProfessorDao{
    private List<Professor> listaProfessor;
    
    @Override
    public Boolean salvar (Professor professor){
        if(this.indiceProfessor(professor.getCpf()) == -1){
            this.listaProfessor.add(professor);
            Collections.sort(this.listaProfessor);
            return true;
        }
        return false;
    }
    
    @Override
    public Boolean remover (Professor professor){
        return this.listaProfessor.remove(professor);
    }
    
    @Override
    public int indiceProfessor (String cpf){
        return Collections.binarySearch(listaProfessor, new Professor(null, cpf, null));
    }
    
    @Override
    public Professor obterProfessor (String cpf){
        if (this.indiceProfessor(cpf) != -1)
            return this.listaProfessor.get(this.indiceProfessor(cpf));
        return null;
    }
    
    @Override
    public List<Professor> obterTodos (){
        return listaProfessor;
    }
}

