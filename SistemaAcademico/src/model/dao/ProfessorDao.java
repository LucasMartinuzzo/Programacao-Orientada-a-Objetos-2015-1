package model.dao;

import java.util.List;
import model.pojo.Disciplina;
import model.pojo.Professor;
        
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pedro
 */

public interface ProfessorDao {
    public Boolean adicionarDisciplina (Disciplina disciplina);
    public Boolean removerDisciplina (Disciplina disciplina); 
    public void carregar();
    public void salvar();
}
