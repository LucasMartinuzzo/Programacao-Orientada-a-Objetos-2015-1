package model.dao;

import java.util.Collections;
import java.util.List;
import model.pojo.Aluno;


/**
 *
 * @author Filipe
 */
public class AlunoDaoImpl implements AlunoDao {
    
    private List<Aluno> listaAluno;
       
    @Override
    public Boolean salvar (Aluno aluno) {
        if (this.indiceAluno(aluno.getCpf()) == -1 ){
           this.listaAluno.add(aluno);
           Collections.sort(this.listaAluno);
           return true;
        }
        return false;
    }
    
    @Override
    public Boolean remover(Aluno aluno){
        return this.listaAluno.remove(aluno);
    }
    
    @Override
    public int indiceAluno (String cpf) {
        return Collections.binarySearch(this.listaAluno, new Aluno(null, cpf));
    }
    
    @Override
    public Aluno obterAluno (String cpf) {
        if (this.indiceAluno(cpf) != -1)
            return this.listaAluno.get(this.indiceAluno(cpf));
        return null;
    }
    
    @Override
    public List<Aluno> obterTodos () {
        return listaAluno;
    }
    
}