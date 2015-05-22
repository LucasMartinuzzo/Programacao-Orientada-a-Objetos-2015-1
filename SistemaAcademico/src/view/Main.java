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
            System.out.println("OUTRO - VOLTAR");

            System.out.println("\nOpção: ");
            Scanner entrada = new Scanner(System.in);
            Integer opcao = entrada.nextInt();
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
                default:{}
            }
            if (opcao < 1 || opcao > 7)
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
            System.out.println("2 - ATRIBUIR PROFESSOR À DISCIPLINA");
            System.out.println("OUTRO - VOLTAR");

            System.out.println("\nOpção: ");
            Scanner entrada = new Scanner(System.in);
            Integer opcao = entrada.nextInt();
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
                default:{}
            }
            if (opcao < 1 || opcao > 2)
                break;
            if (!relacionamentoEfetuado)
                System.out.println("\nINFORMAÇÕES INVÁLIDAS!\n");
        
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
    
    private void imprimirMenuRemover(){
        while(true){
            
            System.out.println("1 - REMOVER ALUNOS");
            System.out.println("2 - REMOVER TURMAS");
            System.out.println("3 - REMOVER PROFESSOR");
            System.out.println("4 - REMOVER ATIVIDADE");
            System.out.println("5 - REMOVER FALTA");
            System.out.println("6 - REMOVER NOTA");
            System.out.println("7 - REMOVER DISCIPLINA");
            System.out.println("OUTRO - VOLTAR");

            Scanner entrada = new Scanner(System.in);
            Integer opcao = entrada.nextInt();
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
                default:{}
            }
            if (opcao < 1 || opcao > 7)
                break;
        }
    }     

    public static void main(String[] args) throws IOException{
        Integer i;
        Main main = new Main();    
        Scanner entrada = new Scanner(System.in);
        //// main.carregarArquivo();
        while(true){
            System.out.println("1 - CADASTROS");
            System.out.println("2 - CONSULTAS");
            System.out.println("3 - REMOÇÕES");
            System.out.println("4 - RELACIONAMENTOS");
            System.out.println("5 - SAIR");
            
            System.out.println("\nOpção:");
            i = entrada.nextInt();
            switch(i){
                    case 1: {
                        main.imprimirMenuCadastro();
                        break;
                    }
                    case 2: {
                        main.imprimirMenuConsultar();
                        break;
                    }
                    case 3: {
                        main.imprimirMenuRemover();
                        break;
                    }
                    case 4:{
                        main.imprimirMenuRelacionamentos();
                        break;
                    }
                    case 5:{
                    //Opção "sair" com main.salvarArquivo()    
                    }
                    
            }
        }    
    }
}
