package model.dao;

import java.util.Collections;
import java.util.List;
import model.pojo.Disciplina;
import model.pojo.Turma;

/**
 *
 * @author Lucas
 */
public class DisciplinaDaoImpl implements DisciplinaDao{
    private List<Disciplina> listaDisciplina;
    
    @Override
    public Integer indiceDisciplina (String nome){
        return Collections.binarySearch(listaDisciplina, new Disciplina(nome, null, null));
    }
    
    @Override
    public Disciplina obterDisciplina (String nome){
        if (this.indiceDisciplina(nome) != -1)
            return this.listaDisciplina.get(this.indiceDisciplina(nome));
        return null;
    }
    
    @Override
    public List<Disciplina> obterTodos (){
        return listaDisciplina;
    }
    
    @Override
    public Boolean salvar(Disciplina disciplina){
        if(!listaDisciplina.contains(disciplina)){
            listaDisciplina.add(disciplina);
            Collections.sort(this.listaDisciplina);
            return true;
        }
        return false;
    }
    
    @Override
    public Boolean remover(Disciplina disciplina){
        return listaDisciplina.remove(disciplina);
    }
    
    @Override
    public Boolean adicionarTurma (Turma turma) {
        Disciplina disciplina = turma.getDisciplina();
        if (!disciplina.getTurma().contains(turma))
            return disciplina.getTurma().add(turma);
        return false;
    }

    @Override
    public Boolean removerTurma (Turma turma) {
        Disciplina disciplina = turma.getDisciplina();
        return disciplina.getTurma().remove(turma);
    }
}
