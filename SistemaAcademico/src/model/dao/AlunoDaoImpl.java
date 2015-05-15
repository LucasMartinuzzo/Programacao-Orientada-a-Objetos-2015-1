package model.dao;

import java.util.Collections;
import java.util.List;
import model.pojo.Aluno;


/**
 *
 * @author Filipe
 */
public class AlunoDaoImpl implements Dao {
    
    private static List<Aluno> listaAluno;
    
    @Override
    public Boolean inserir (Object objeto) {
        Aluno aluno = (Aluno) objeto;
        if (this.indice(aluno.getCpf()) == -1) {
            listaAluno.add(aluno);
            Collections.sort(listaAluno);
            return true;
        }
        return false;
    }
    
    @Override
    public Boolean remover (Object objeto) {
        Aluno aluno = (Aluno) objeto;
        return listaAluno.remove(aluno);
    }
    
    @Override
    public int indice (String cpf) {
        return Collections.binarySearch(listaAluno, new Aluno (null, cpf));
    }
    
    @Override
    public Object obter (String cpf) {
        if (this.indice(cpf) != -1)
            return listaAluno.get(this.indice(cpf));
        return null;
    }
    
    @Override
    public List<Object> obterTodos () {
        return (List<Object>) (Object) listaAluno;
    }
    
    @Override
    public void salvar (){
    //*Implementar*//
    }
    
    @Override
    public void carregar (){
    //*Implementar*//
    }
}