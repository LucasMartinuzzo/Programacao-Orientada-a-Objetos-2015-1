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
    
    public void pesquisar () {
        System.out.println("PESQUISA DE TURMAS\nEntre com o ID da turma: ");
        String id = scanner.nextLine();
        if (this.turmaDao.indiceTurma(id) != -1)
            System.out.println(this.turmaDao.obterTurma(id).toString());
        else
            System.out.println("TURMA NÃO ENCONTRADA!");
    }
        
    public void listar () {
        System.out.println("LISTA DE TURMAS DISPONÍVEIS\n");
        List<Turma> listaTurma = turmaDao.obterTodas();
        for (Turma turma: listaTurma) {
            System.out.println(turma.toString() + "\n");
        }
    }

    public Disciplina obterCadastrada () {
        while (true) {
            System.out.println("Disciplina: ");
            String entrada = scanner.nextLine();
            if (entrada.equals("cancelar"))
                break;
            Disciplina disciplina = this.disciplinaDao.obterDisciplina(entrada);
            if (disciplina != null)
                return disciplina;
            else {
                System.out.println("ESTA DISCIPLINA NÃO ESTÁ CADASTRADA!");
                System.out.println("Digite novamente (''cancelar'' para cancelar): ");
            }
        }
        return null;
    }
    
    public Professor obterCadastrado () {
        while (true) {
            System.out.println("Professor: ");
            String entrada = scanner.nextLine();
            if (entrada.equals("cancelar"))
                break;
            Professor professor = this.professorDao.obterProfessor(entrada);
            if (professor != null)
                return professor;
            else {
                System.out.println("ESTE PROFESSOR NÃO ESTÁ CADASTRADO!");
                System.out.println("Digite novamente (''cancelar'' para cancelar): ");
            }
        }
        return null;
    }
}