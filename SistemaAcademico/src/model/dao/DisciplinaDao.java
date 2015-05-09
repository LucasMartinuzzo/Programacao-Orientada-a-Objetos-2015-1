/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.pojo.Turma;
import model.pojo.Disciplina;

/**
 *
 * @author Lucas
 */
public interface DisciplinaDao {
    public Boolean adicionarTurma (Turma turma);
    public Boolean removerTurma (Turma turma);
    public void carregar ();
    public void salvar ();
}
