package view;


import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import model.dao.AlunoDaoImpl;
import model.dao.AtividadeDaoImpl;
import model.dao.AulaDaoImpl;
import model.dao.Dao;
import model.dao.DisciplinaDaoImpl;
import model.dao.FaltaDaoImpl;
import model.dao.NotaDaoImpl;
import model.dao.ProfessorDaoImpl;
import model.dao.TurmaDaoImpl;
import model.pojo.Aluno;
import model.pojo.Atividade;
import model.pojo.Disciplina;
import model.pojo.Falta;
import model.pojo.Nota;
import model.pojo.Professor;
import model.pojo.Turma;

/**
 *
 * @author Filipe
 */
public class Main {
    
    private TurmaView turmaView = new TurmaView();
    private AlunoView alunoView = new AlunoView();
    private ProfessorView professorView = new ProfessorView();
    private AtividadeView atividadeView = new AtividadeView();
    private FaltaView faltaView = new FaltaView();
    private NotaView notaView = new NotaView();
    private DisciplinaView disciplinaView = new DisciplinaView();
    private AulaView aulaView = new AulaView();
    //private AulaView aulaView;
    //private Dao turmaDao;
    //private Dao alunoDao;
    //private Dao professorDao;
    //private Dao atividadeDao;
    //private Dao faltaDao;
    //private Dao notaDao;
    //private Dao disciplinaDao;
    //private Dao aulaDao;
    
    
    private void carregarArquivo() throws IOException{
        DisciplinaDaoImpl.getInstancia().carregar();
        ProfessorDaoImpl.getInstancia().carregar();
        AulaDaoImpl.getInstancia().carregar();
        TurmaDaoImpl.getInstancia().carregar();
        FaltaDaoImpl.getInstancia().carregar();
        AlunoDaoImpl.getInstancia().carregar();
        AtividadeDaoImpl.getInstancia().carregar();
        NotaDaoImpl.getInstancia().carregar();
    }
    
    private void salvarArquivo() throws IOException{
        DisciplinaDaoImpl.getInstancia().salvar();
        ProfessorDaoImpl.getInstancia().salvar();
        AulaDaoImpl.getInstancia().salvar();
        TurmaDaoImpl.getInstancia().salvar();
        FaltaDaoImpl.getInstancia().salvar();
        AlunoDaoImpl.getInstancia().salvar();
        AtividadeDaoImpl.getInstancia().salvar();
        NotaDaoImpl.getInstancia().salvar();
    }
    
    private void imprimirMenuCadastro(){
        while (true) {
            System.out.println("1 - CADASTRAR ALUNO");
            System.out.println("2 - CADASTRAR TURMA");
            System.out.println("3 - CADASTRAR PROFESSOR");
            System.out.println("4 - CADASTRAR ATIVIDADE");
            System.out.println("5 - CADASTRAR FALTA");
            System.out.println("6 - CADASTRAR NOTA");
            System.out.println("7 - CADASTRAR DISCIPLINA");
            System.out.println("8 - CADASTRAR AULA");
            System.out.println("OUTRO - VOLTAR");

            System.out.println("\nOpção: ");
            Scanner entrada = new Scanner(System.in);
            Integer opcao = entrada.nextInt();
            entrada.nextLine();
            Boolean cadastroEfetuado = false;
            switch(opcao) {
                case 1:{
                    cadastroEfetuado = this.alunoView.cadastrar();
                    AlunoDaoImpl.getInstancia().imprimir();
                    break;
                }
                case 2:{
                    cadastroEfetuado = this.turmaView.cadastrar();
                    TurmaDaoImpl.getInstancia().imprimir();
                    break;
                }
                case 3:{
                    cadastroEfetuado = this.professorView.cadastrar();
                    ProfessorDaoImpl.getInstancia().imprimir();
                    break;
                }
                case 4:{
                    cadastroEfetuado = this.atividadeView.cadastrar();
                    AtividadeDaoImpl.getInstancia().imprimir();
                    break;
                }
                case 5:{
                    cadastroEfetuado = this.faltaView.cadastrar();
                    FaltaDaoImpl.getInstancia().imprimir();
                    break;
                }
                case 6:{
                    cadastroEfetuado = this.notaView.cadastrar();
                    NotaDaoImpl.getInstancia().imprimir();
                    break;
                }
                case 7:{
                    cadastroEfetuado = this.disciplinaView.cadastrar();
                    DisciplinaDaoImpl.getInstancia().imprimir();
                    break;
                }
                case 8:{
                    cadastroEfetuado = this.aulaView.cadastrar();
                    AulaDaoImpl.getInstancia().imprimir();
                    break;
                }
                default:{}
            }
            if (opcao < 1 || opcao > 8)
                break;
            if (cadastroEfetuado)
                System.out.println("\nCADASTRO EFETUADO COM SUCESSO!\n");
            else
                System.out.println("\nCADASTRO NÃO EFETUADO!\n");
        }
    }
    
    private void imprimirMenuRelacionamentos(){
        while(true){
            System.out.println("1 - MATRICULAR ALUNO");
            System.out.println("2 - ATRIBUIR PROFESSOR A DISCIPLINA");
            System.out.println("3 - ATRIBUIR AULA A TURMA");
            System.out.println("OUTRO - VOLTAR");

            System.out.println("\nOpção: ");
            Scanner entrada = new Scanner(System.in);
            Integer opcao = entrada.nextInt();
            entrada.nextLine();
            Boolean relacionamentoEfetuado = false;
            switch(opcao){
                case 1:{
                    relacionamentoEfetuado = this.alunoView.matricularAluno();
                    break;
                }
                case 2:{
                    relacionamentoEfetuado = this.disciplinaView.atribuirProfessor();
                    break;
                }
                case 3:{
                    relacionamentoEfetuado = this.turmaView.atribuirAula();
                    break;
                }
                default:{}
            }
            if (opcao < 1 || opcao > 3)
                break;
            if (relacionamentoEfetuado)
                System.out.println("\nCONCLUÍDO COM ÊXITO!\n");
            else {
                System.out.println("\nIMPOSSÍVEL CONCLUIR!");
                System.out.println("Possíveis causas:");
                System.out.println("- A informação digitada não corresponde a um item cadastrado;");
                System.out.println("- A operação já foi realizada anteriormente;");
                System.out.println("- Em caso de matrícula de aluno, a turma solicitada não possui"
                        + "vagas remanescentes.");
            }
            
        }
    }
    
    private void imprimirMenuConsultar(){
        while(true){
            System.out.println("1 - CONSULTAR OS ALUNOS DE UMA TURMA COM SUAS RESPECTIVAS NOTAS E FALTAS");
            System.out.println("2 - CONSULTAR A SITUAÇÃO DO ALUNO EM DETERMINADA DISCIPLINA");
            System.out.println("3 - CONSULTAR A QUANTIDADE DE TURMAS OFERECIDAS DE UMA DISCIPLINA");
            System.out.println("4 - CONSULTAR O NÚMERO DE DISCIPLINAS JÁ LECIONADAS POR UM PROFESSOR");
            System.out.println("OUTRO - VOLTAR");

            System.out.println("\nOpção: ");
            Scanner entrada = new Scanner(System.in);
            Integer opcao = entrada.nextInt();
            entrada.nextLine();
            Boolean consultaEfetuada = false;
            switch(opcao){
                case 1:{
                    consultaEfetuada = this.turmaView.listarAlunos();
                    break;
                }
                case 2:{
                    consultaEfetuada = this.alunoView.consultarSituacaoAluno();
                    break;
                }
                case 3:{
                    consultaEfetuada = this.disciplinaView.quantidadeTurmas();
                    break;
                }
                case 4:{
                    consultaEfetuada = this.professorView.quantidadeDisciplina();
                    break;
                }
                default:{}
            }
            if (opcao < 1 || opcao > 4)
                break;
            if (!consultaEfetuada)
                System.out.println("\nINFORMAÇÕES INVÁLIDAS PARA CONSULTA!\n");
        
        }
    }
    
    /*private void imprimirMenuRemover(){
        while(true){
            
            System.out.println("1 - REMOVER ALUNOS");
            System.out.println("2 - REMOVER TURMAS");
            System.out.println("3 - REMOVER PROFESSOR");
            System.out.println("4 - REMOVER ATIVIDADE");
            System.out.println("5 - REMOVER FALTA");
            System.out.println("6 - REMOVER NOTA");
            System.out.println("7 - REMOVER DISCIPLINA");
            System.out.println("OUTRO - VOLTAR");

            System.out.println("\nOpção: ");
            Scanner entrada = new Scanner(System.in);
            Integer opcao = entrada.nextInt();
            entrada.nextLine();
            switch(opcao){
                case 1:{
                    this.alunoView.remover();
                    AlunoDaoImpl.getInstancia().imprimir();
                    break;
                }
                case 2:{
                    this.turmaView.remover();
                    TurmaDaoImpl.getInstancia().imprimir();
                    break;
                }
                case 3:{
                    this.professorView.remover();
                    ProfessorDaoImpl.getInstancia().imprimir();
                    break;
                }
                case 4:{
                    this.atividadeView.remover();
                    AtividadeDaoImpl.getInstancia().imprimir();
                    break;
                }
                case 5:{
                    this.faltaView.remover();
                    FaltaDaoImpl.getInstancia().imprimir();
                    break;
                }
                case 6:{
                    this.notaView.remover();
                    NotaDaoImpl.getInstancia().imprimir();
                    break;
                }
                case 7:{
                    this.disciplinaView.remover();
                    DisciplinaDaoImpl.getInstancia().imprimir();
                    break;
                }
                case 8:{
                    this.aulaView.cadastrar();
                    AulaDaoImpl.getInstancia().imprimir();
                    break;
                }
                default:{}
            }
            if (opcao < 1 || opcao > 8)
                break;
        }
    }*/     

    //APAGAR
    public void imprimirLista () {
        while(true){
            
            System.out.println("1 - IMPRIMIR LISTA DE TURMAS DE UM ALUNO");
            System.out.println("2 - IMPRIMIR LISTA DE FALTAS DE UM ALUNO");
            System.out.println("3 - IMPRIMIR LISTA DE NOTAS DE UM ALUNO");
            System.out.println("4 - IMPRIMIR LISTA DE NOTAS DE UMA ATIVIDADE");
            System.out.println("5 - IMPRIMIR LISTA DE PROFESSORES DE UMA DISCIPLINA");
            System.out.println("6 - IMPRIMIR LISTA DE TURMAS DE UMA DISCIPLINA");
            System.out.println("7 - IMPRIMIR LISTA DE DISCIPLINAS DE UM PROFESSOR");
            System.out.println("8 - IMPRIMIR LISTA DE AULAS DE UMA TURMA");
            System.out.println("9 - IMPRIMIR LISTA DE ALUNOS DE UMA TURMA");
            System.out.println("10 - IMPRIMIR LISTA DE ATIVIDADES DE UMA TURMA");
            System.out.println("OUTRO - VOLTAR");

            Scanner entrada = new Scanner(System.in);
            Integer opcao = entrada.nextInt();
            entrada.nextLine();
            switch(opcao){
                case 1:{
                    System.out.println("CPF:");
                    Aluno aluno = (Aluno) AlunoDaoImpl.getInstancia().obter(entrada.nextLine());
                    aluno.imprimirListaTurmas();
                    break;
                }
                case 2:{
                    System.out.println("CPF:");
                    Aluno aluno = (Aluno) AlunoDaoImpl.getInstancia().obter(entrada.nextLine());
                    aluno.imprimirListaFaltas();
                    break;
                }
                case 3:{
                    System.out.println("CPF:");
                    Aluno aluno = (Aluno) AlunoDaoImpl.getInstancia().obter(entrada.nextLine());
                    aluno.imprimirListaAlunos(); //NOME ERRADO: IMPRIME NOTAS
                    break;
                }
                case 4:{
                    System.out.println("ID:");
                    Atividade atividade = (Atividade) AtividadeDaoImpl.getInstancia().obter(entrada.nextLine());
                    atividade.imprimirListaNotas();
                    break;
                }
                case 5:{
                    System.out.println("NOME:");
                    Disciplina disciplina = (Disciplina) DisciplinaDaoImpl.getInstancia().obter(entrada.nextLine());
                    disciplina.imprimirListaProfessores();
                    break;
                }
                case 6:{
                    System.out.println("NOME:");
                    Disciplina disciplina = (Disciplina) DisciplinaDaoImpl.getInstancia().obter(entrada.nextLine());
                    disciplina.imprimirListaTurmas();
                    break;
                }
                case 7:{
                    System.out.println("CPF:");
                    Professor professor = (Professor) ProfessorDaoImpl.getInstancia().obter(entrada.nextLine());
                    professor.imprimirListaDisciplinas();
                    
                    break;
                }
                case 8:{
                    System.out.println("ID:");
                    Turma turma = (Turma) TurmaDaoImpl.getInstancia().obter(entrada.nextLine());
                    turma.imprimirListaAulas();
                    break;
                }
                case 9:{
                    System.out.println("ID:");
                    Turma turma = (Turma) TurmaDaoImpl.getInstancia().obter(entrada.nextLine());
                    turma.imprimirListaAlunos();
                    break;
                }
                case 10:{
                    System.out.println("ID:");
                    Turma turma = (Turma) TurmaDaoImpl.getInstancia().obter(entrada.nextLine());
                    turma.imprimirListaAtividades();
                    break;
                }
                default:{}
            }
            if (opcao < 1 || opcao > 10)
                break;
        }
    }
    
    public static void main(String[] args) throws IOException{
        Integer opcao;
        Main main = new Main();    
        Scanner entrada = new Scanner(System.in);
        //// main.carregarArquivo();
        while(true){
            System.out.println("1 - CADASTROS");
            System.out.println("2 - CONSULTAS");
            //System.out.println("3 - REMOÇÕES");
            System.out.println("3 - RELACIONAMENTOS");
            System.out.println("4 - SAIR");
            System.out.println("5 - IMPRIMIR (TEMPORÁRIO)"); //APAGAR!
            
            System.out.println("\nOpção:");
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch(opcao){
                    case 1: {
                        main.imprimirMenuCadastro();
                        break;
                    }
                    case 2: {
                        main.imprimirMenuConsultar();
                        break;
                    }
                    /*case 3: {
                        main.imprimirMenuRemover();
                        break;
                    }*/
                    case 3:{
                        main.imprimirMenuRelacionamentos();
                        break;
                    }
                    case 4:{
                    //Opção "sair" com main.salvarArquivo()    
                    }
                    case 5:{ //APAGAR!
                        main.imprimirLista();
                    }
            }
        }    
    }
}
