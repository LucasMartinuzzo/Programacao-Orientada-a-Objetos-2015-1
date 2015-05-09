/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.Collections;
import java.util.List;
import model.pojo.Disciplina;
import model.pojo.Professor;

/**
 *
 * @author Pedro
 */
public class ProfessorDaoImpl implements ProfessorDao{
    private List<Professor> listaProfessor;
    
    @Override
    public Boolean salvar (Professor professor){
        if(!(this.contemProfessor(professor.getCpf()))){
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
    public Boolean contemProfessor (String cpf){
    //IMPLEMENTAR MAIS TARDE
        return false;
    }
    
    @Override
    public Professor obterProfessor (String cpf){
    //IMPLEMENTAR MAIS TARDE    
    }
    
    @Override
    public List<Professor> obterTodos (){
        return listaProfessor;
    }
    
    @Override
    public Boolean adicionarDisciplina (Professor professor, Disciplina disciplina){
        if (!(professor.getDisciplina().contains(disciplina))) {
            disciplina.getProfessor().add(professor);
            return professor.getDisciplina().add(disciplina);
        }
        return false;
    }
    
    @Override
    public Boolean removerDisciplina (Professor professor, Disciplina disciplina){
        professor.getDisciplina().remove(disciplina);
        return disciplina.getProfessor().remove(professor);
    }
}
