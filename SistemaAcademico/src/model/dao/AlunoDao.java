/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Aluno;
import model.pojo.Nota;
import model.pojo.Turma;

/**
 *
 * @author Filipe
 */
public interface AlunoDao {

  Boolean salvar (Aluno aluno);
  Turma obterAluno (String cpf);
  Boolean remover(Aluno aluno);
  Boolean contemAluno (String cpf);
  List<Aluno> obterTodos ();
  Boolean adicaoValida(Aluno aluno, Nota nota);
  void adicionaNota(Aluno aluno, Nota nota);
  Nota retornaNota (Aluno aluno, Nota nota);
  Double NotaFinal(Aluno aluno, Turma turma);
 
}
