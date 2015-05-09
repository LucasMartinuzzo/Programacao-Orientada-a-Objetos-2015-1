/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.pojo.Disciplina;
import model.pojo.Turma;

/**
 *
 * @author Lucas
 */
public class DisciplinaDaoImpl implements DisciplinaDao{
    private Disciplina disciplina;
    
    @Override
    public Boolean adicionarTurma (Turma turma) {
        if (disciplina.getTurma().contains(turma) == false)
            return disciplina.getTurma().add(turma);
        return false;
    }

    /**
     *
     * @param turma
     * @return
     */
    @Override
    public Boolean removerTurma (Turma turma) {
        return disciplina.getTurma().remove(turma);
    }
    @Override
    public void carregar (){
    //IMPLEMENTAR MAIS TARDE
    }
    
    @Override
    public void salvar (){
    //IMPLEMENTAR MAIS TARDE
    }
}
