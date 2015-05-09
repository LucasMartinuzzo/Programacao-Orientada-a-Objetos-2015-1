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
    public Boolean contemDisciplina (String nome);
    public Disciplina obterDisciplina(String nome);
    public Boolean salvarDisciplina(Disciplina disciplina);
    public Boolean removeDisciplina(Disciplina disciplina);
    public Boolean adicionarTurma (Turma turma);
    public Boolean removerTurma (Turma turma);
}
