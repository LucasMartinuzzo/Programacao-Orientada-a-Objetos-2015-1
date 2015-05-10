package model.dao;

import java.util.List;
import model.pojo.Aluno;
import model.pojo.Atividade;
import model.pojo.Aula;
import model.pojo.Turma;

/**
 *
 * @author JeanPablo
 */
public interface TurmaDao {
    Boolean salvar (Turma turma);
    Boolean remover (Turma turma);
    int indiceTurma (String id);
    Turma obterTurma (String id);
    List<Turma> obterTodas ();
    Boolean adicionarAula (Turma turma, Aula aula);
    Boolean removerAula (Turma turma, Aula aula);
    Aula retornaAula (Turma turma, Aula aula);
    Boolean adicaoDeAlunoValida (Turma turma, Aluno aluno);
    Boolean adicionarAluno (Turma turma, Aluno aluno);
    Boolean removerAluno (Turma turma, Aluno aluno);
    Boolean adicionarAtividade (Turma turma, Atividade atividade);
    Boolean removerAtividade (Turma turma, Atividade atividade);
    Atividade retornaAtividade (Turma turma, Atividade atividade);
}