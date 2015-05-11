package model.dao;

import java.util.Collections;
import java.util.List;
import model.pojo.Aluno;
import model.pojo.Nota;
import model.pojo.Turma;


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
    
    @Override
    public Boolean adicaoValida(Aluno aluno, Nota nota) {
        return (!aluno.getNota().contains(nota));
    }
    
    @Override
    public void adicionaNota(Aluno aluno, Nota nota){
        aluno.getNota().add(nota);
    }
    
    @Override
    public Nota retornaNota (Aluno aluno, Nota nota) {
       if(aluno.getNota().contains(nota))
            return aluno.getNota().get(aluno.getNota().indexOf(nota)); 
       else
            return null; 
    }

    @Override
    public Double NotaFinal(Aluno aluno, Turma turma){
        Double somaNotas = 0.0;
        for(Nota notaConsultada: aluno.getNota())
            if(notaConsultada.getAtividade().getTurma().equals(turma))
                somaNotas += notaConsultada.getNota();
    return somaNotas;
    }
}