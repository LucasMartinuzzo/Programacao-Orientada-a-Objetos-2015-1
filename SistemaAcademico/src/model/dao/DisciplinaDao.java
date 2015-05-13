package model.dao;

import java.util.List;
import model.pojo.Disciplina;

/**
 *
 * @author Lucas
 */
public interface DisciplinaDao {
    Integer indiceDisciplina(String nome);
    Disciplina obterDisciplina(String nome);
    List<Disciplina> obterTodos();
    Boolean salvar(Disciplina disciplina);
    Boolean remover(Disciplina disciplina);
}
