/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.pojo.Aluno;
import model.pojo.Atividade;
import model.pojo.Aula;

/**
 *
 * @author JeanPablo
 */
public interface TurmaDao {
    Boolean adicionarAula (Aula aula);
    Boolean removerAula (Aula aula);
    Aula retornaAula (Aula aula);
    Boolean adicaoDeAlunoValida (Aluno aluno);
    Boolean adicionarAluno (Aluno aluno);
    Boolean removerAluno (Aluno aluno);
    Boolean adicionarAtividade (Atividade atividade);
    Boolean removerAtividade (Atividade atividade);
    Atividade retornaAtividade (Atividade atividade);
}
