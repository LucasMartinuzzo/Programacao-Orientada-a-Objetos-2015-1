package model.dao;

import java.util.List;
import model.pojo.Aluno;

/**
 *
 * @author Filipe
 */
public interface AlunoDao {

  Boolean salvar (Aluno aluno);
  Aluno obterAluno (String cpf);
  Boolean remover(Aluno aluno);
  int indiceAluno (String cpf);
  List<Aluno> obterTodos ();
 
}
