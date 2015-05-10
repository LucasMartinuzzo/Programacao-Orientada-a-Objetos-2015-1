package model.dao;

import java.util.List;
import model.pojo.Disciplina;
import model.pojo.Professor;
        
/**
 *
 * @author Pedro
 */
public interface ProfessorDao {
    Boolean salvar (Professor professor);
    Boolean remover (Professor professor);
    int indiceProfessor (String cpf);
    Professor obterProfessor (String cpf);
    List<Professor> obterTodos ();
    Boolean adicionarDisciplina (Professor professor, Disciplina disciplina);
    Boolean removerDisciplina (Professor professor, Disciplina disciplina); 
}
