package view;

import java.util.List;
import java.util.Scanner;
import model.dao.DisciplinaDao;
import model.dao.ProfessorDao;
import model.dao.TurmaDao;
import model.pojo.Disciplina;
import model.pojo.Professor;
import model.pojo.Turma;

/**
 *
 * @author JeanPablo
 */
public class TurmaView {
    
    private TurmaDao turmaDao;
    private DisciplinaDao disciplinaDao;
    private ProfessorDao professorDao;
    private static Scanner scanner = new Scanner (System.in);
    
    public Boolean cadastrar () {
        System.out.println("CADASTRO DE TURMAS\nCadastre uma nova turma:\n");
        System.out.println("ID: ");
        String id = scanner.nextLine();
        System.out.println("Ano: ");
        Integer ano = scanner.nextInt();
        System.out.println("Período: ");
        Integer periodo = scanner.nextInt();
        System.out.println("Número de vagas: ");
        Integer numeroDeVagas = scanner.nextInt();
        Disciplina disciplina = this.obterCadastrada();
        if (disciplina == null)
            return false;
        Professor professor = this.obterCadastrado();
        if (professor == null)
            return false;
        Turma turma = new Turma (id, ano, periodo, numeroDeVagas, disciplina, professor, /*aula*/);
        return this.turmaDao.salvar(turma);
    }
}
