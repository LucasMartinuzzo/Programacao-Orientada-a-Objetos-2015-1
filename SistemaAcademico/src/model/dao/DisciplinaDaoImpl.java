/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Disciplina;
import model.pojo.Turma;

/**
 *
 * @author Lucas
 */
public class DisciplinaDaoImpl implements DisciplinaDao{
    private List<Disciplina> listaDisciplina;
    //private Disciplina disciplina;
    @Override
    public Boolean contemDisciplina (String nome) {
        /*Implementar*/
    }
    
    @Override
    public Disciplina obterDisciplina (String nome) {
        if (this.contemDisciplina(nome))
            return this.listaDisciplina.get(this.listaDisciplina.indexOf(/**/));
        return null;
    }
    public Disciplina obterDisciplina(Disciplina disciplina){
        return listaDisciplina.get(indexOf(disciplina));
    };
    
    @Override
    public Boolean salvarDisciplina(Disciplina disciplina){
        if(!listaDisciplina.contains(disciplina))
            return listaDisciplina.add(disciplina);
        return false;
    }
    
    @Override
    public Boolean removeDisciplina(Disciplina disciplina){
        return listaDisciplina.remove(disciplina);
    }
            
    @Override
    public Boolean adicionarTurma (Turma turma) {
        Disciplina disciplina = obterDisciplina(turma.getDisciplina());
        if (disciplina.getTurma().contains(turma) == false)
            return disciplina.getTurma().add(turma);
        return false;
    }

    @Override
    public Boolean removerTurma (Turma turma) {
        Disciplina disciplina = obterDisciplina(turma.getDisciplina());
        return disciplina.getTurma().remove(turma);
    }
}
