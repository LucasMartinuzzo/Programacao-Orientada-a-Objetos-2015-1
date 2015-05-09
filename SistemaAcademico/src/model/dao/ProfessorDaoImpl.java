/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.pojo.Disciplina;
import model.pojo.Professor;

/**
 *
 * @author Pedro
 */
public class ProfessorDaoImpl implements ProfessorDao{
    private Professor professor;
    
    @Override
    public Boolean adicionarDisciplina (Disciplina disciplina){
        if (!(professor.getDisciplina().contains(disciplina))) {
            disciplina.getProfessor().add(professor);
            return professor.getDisciplina().add(disciplina);
        }
        return false;
    }
    
    @Override
    public Boolean removerDisciplina (Disciplina disciplina){
        if (professor.getDisciplina().contains(disciplina)){
            professor.getDisciplina().remove(disciplina);
            return disciplina.getProfessor().remove(professor);
        }
        return false;
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
