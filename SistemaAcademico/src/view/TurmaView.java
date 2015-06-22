package view;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import model.dao.DisciplinaDaoImpl;
import model.dao.ProfessorDaoImpl;
import model.dao.TurmaDaoImpl;
import model.pojo.Disciplina;
import model.pojo.Professor;
import model.pojo.Turma;

public class TurmaView {

    private static Scanner scanner = new Scanner (System.in);
    private TurmaDaoImpl daoTurma = TurmaDaoImpl.getInstancia();
    private DisciplinaDaoImpl daoDisciplina = DisciplinaDaoImpl.getInstancia();
    private ProfessorDaoImpl daoProfessor = ProfessorDaoImpl.getInstancia();

    public void cadastrar (EntityManager em){
        System.out.println("CADASTRO DE TURMA");
        System.out.println("Disciplina (Nome): ");
        String nomeDisciplina = scanner.nextLine();
        Disciplina disciplina = daoDisciplina.buscar(em, nomeDisciplina);
        if (disciplina != null){
            System.out.println("Professor (CPF): ");
            String cpfProfessor = scanner.nextLine();
            Professor professor = daoProfessor.buscar(em, cpfProfessor);
            if (professor != null){
                System.out.println("Ano: ");
                Integer ano = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Período: ");
                Integer periodo = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Local: ");
                String local = scanner.nextLine();
                System.out.println("Horário: ");
                String horario = scanner.nextLine();
                System.out.println("Número de Vagas: ");
                Integer numeroDeVagas = scanner.nextInt();
                scanner.nextLine();
                Turma turma = new Turma (ano, periodo, local, horario,numeroDeVagas, disciplina, professor);
                disciplina.getTurma().add(turma);
                daoTurma.salvar(em, turma);
                daoDisciplina.alterar(em, disciplina);
                System.out.println ("Cadastro efetuado com sucesso.");
            }else
                System.out.println ("ERRO: Professor não cadastrado (CPF inválido).");
        }else
            System.out.println("ERRO: Disciplina não cadastrada (nome inválido).");
    }
    
    public void imprimir (List<Turma> list){
        for(Turma turma: list)
            System.out.println(turma);
    }
}