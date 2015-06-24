package view;

import java.util.Scanner;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Main{
    private AlunoView alunoView = new AlunoView();
    private AtividadeView atividadeView = new AtividadeView();
    private DisciplinaView disciplinaView = new DisciplinaView();
    private FaltaView faltaView = new FaltaView();
    private NotaView notaView = new NotaView();
    private ProfessorView professorView = new ProfessorView();
    private TurmaView turmaView = new TurmaView();
    
    private void imprimirMenuCadastro(EntityManager em){
        while (true) {
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Cadastrar atividade");
            System.out.println("3 - Cadastrar disciplina");
            System.out.println("4 - Cadastrar falta");
            System.out.println("5 - Cadastrar nota");
            System.out.println("6 - Cadastrar professor");
            System.out.println("7 - Cadastrar turma");
            System.out.println("Outro - Finalizar");
            System.out.println("\nOpção: ");
            Scanner entrada = new Scanner(System.in);
            Integer opcao = entrada.nextInt();
            entrada.nextLine();
            switch(opcao) {
                case 1:{
                    this.alunoView.cadastrar(em);
                    break;
                }
                case 2:{
                    this.atividadeView.cadastrar(em);
                    break;
                }
                case 3:{
                    this.disciplinaView.cadastrar(em);
                    break;
                }
                case 4:{
                    this.faltaView.cadastrar(em);
                    break;
                }
                case 5:{
                    this.notaView.cadastrar(em);
                    break;
                }
                case 6:{
                    this.professorView.cadastrar(em);
                    break;
                }
                case 7:{
                    this.turmaView.cadastrar(em);
                    break;
                }
                default:{}
            }
            if (opcao < 1 || opcao > 7)
                break;
        }
    }
    
    private void imprimirMenuGerenciamento(EntityManager em){
        while (true){
            System.out.println("1 - Matricular aluno");
            System.out.println("2 - Atribuir professor à disciplina");
            System.out.println("3 - Alterar aluno");
            System.out.println("4 - Alterar atividade");
            System.out.println("5 - Alterar disciplina");
            System.out.println("6 - Alterar falta");
            System.out.println("7 - Alterar nota");
            System.out.println("8 - Alterar professor");
            System.out.println("9 - Alterar turma");
            System.out.println("Outro - Finalizar");
            System.out.println("\nOpção: ");
            Scanner entrada = new Scanner(System.in);
            Integer opcao = entrada.nextInt();
            entrada.nextLine();
            switch(opcao) {
                case 1:{
                    this.turmaView.matricularAluno(em);
                    break;
                }
                case 2:{
                    this.disciplinaView.atribuirProfessor(em);
                    break;
                }
                case 3:{
                    this.alunoView.alterar(em);
                    break;
                }
                case 4:{
                    this.atividadeView.alterar(em);
                    break;
                }
                case 5:{
                    this.disciplinaView.alterar(em);
                    break;
                }
                case 6:{
                    this.faltaView.alterar(em);
                    break;
                }
                case 7:{
                    this.notaView.alterar(em);
                    break;
                }
                case 8:{
                    this.professorView.alterar(em);
                    break;
                }
                case 9:{
                    this.turmaView.alterar(em);
                    break;
                }
                default:{}
            }
            if (opcao < 1 || opcao > 9)
                break;
        }
    }

    private void imprimirMenuListagem(EntityManager em){
        while (true) {
            System.out.println("1 - Listar alunos");
            System.out.println("2 - Listar atividades");
            System.out.println("3 - Listar disciplinas");
            System.out.println("4 - Listar faltas");
            System.out.println("5 - Listar notas");
            System.out.println("6 - Listar professores");
            System.out.println("7 - Listar turmas");
            System.out.println("Outro - Finalizar");
            System.out.println("\nOpção: ");
            Scanner entrada = new Scanner(System.in);
            Integer opcao = entrada.nextInt();
            entrada.nextLine();
            switch(opcao) {
                case 1:{
                    this.alunoView.listar(em);
                    break;
                }
                case 2:{
                    this.atividadeView.listar(em);
                    break;
                }
                case 3:{
                    this.disciplinaView.listar(em);
                    break;
                }
                case 4:{
                    this.faltaView.listar(em);
                    break;
                }
                case 5:{
                    this.notaView.listar(em);
                    break;
                }
                case 6:{
                    this.professorView.listar(em);
                    break;
                }
                case 7:{
                    this.turmaView.listar(em);
                    break;
                }
                default:{}
            }
            if (opcao < 1 || opcao > 7)
                break;
        }
    }    

    private void imprimirMenuConsulta(EntityManager em){
        while(true){
            System.out.println("1 - Consultar alunos de uma turma a partir de seu ano e período");
            System.out.println("2 - Consultar a situação do aluno em determinada disciplina");
            System.out.println("3 - Consultar a quantidade de turmas já oferecidas de uma disciplina");
            System.out.println("4 - Consultar o número de disciplinas já lecionadas por um professor");
            System.out.println("Outro - Finalizar");
            System.out.println("\nOpção: ");
            Scanner entrada = new Scanner(System.in);
            Integer opcao = entrada.nextInt();
            entrada.nextLine();
            switch(opcao){
                case 1:{
                    this.turmaView.consultarTurma(em);
                    break;
                }
                case 2:{
                    this.turmaView.consultarSituacaoAluno(em);
                    break;
                }
                case 3:{
                    this.disciplinaView.quantidadeTurmas(em);
                    break;
                }
                case 4:{
                    this.professorView.quantidadeDisciplinasLecionadas(em);
                    break;
                }
                default:{}
            }
            if (opcao < 1 || opcao > 4)
                break;
        }
    }
    
    public static void main (String[] args){
        Integer opcao;
        Main main = new Main();
        Scanner entrada = new Scanner(System.in);
        EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("SistemaAcademicoPU");
        EntityManager em = emf.createEntityManager();
        java.util.logging.Logger.getLogger("log.hibernate").setLevel(Level.OFF);
        while(true){
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Alterar / Gerenciar");
            System.out.println("3 - Listar");
            System.out.println("4 - Consultar");
            System.out.println("5 - Sair");
            System.out.println("Opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch(opcao){
                case 1:{
                    main.imprimirMenuCadastro(em);
                    break;
                }
                case 2:{
                    main.imprimirMenuGerenciamento(em);
                    break;
                }
                case 3:{
                    main.imprimirMenuListagem(em);
                    break;
                }
                case 4:{
                    main.imprimirMenuConsulta(em);
                    break;
                }
                case 5:{
                    System.out.println("Encerrando o programa...");
                    System.exit(0);
                }
                default:{
                    System.out.println("Digite uma opção válida.");
                }
            }
        }
    }
}

