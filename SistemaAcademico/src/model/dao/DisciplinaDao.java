/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Turma;
import model.pojo.Disciplina;

/**
 *
 * @author Lucas
 */
public interface DisciplinaDao {
    int indiceDisciplina (String nome);
    Disciplina obterDisciplina(String nome);
    Boolean salvar(Disciplina disciplina);
    List<Disciplina> obterTodos ();
    Boolean remover(Disciplina disciplina);
    Boolean adicionarTurma (Turma turma);
    Boolean removerTurma (Turma turma);
}
