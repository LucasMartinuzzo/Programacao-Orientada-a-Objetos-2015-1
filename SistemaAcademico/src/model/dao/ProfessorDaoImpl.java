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

