package view;

import java.util.Collections;
import java.util.Scanner;
import model.dao.Dao;
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
    
    private TurmaView turmaView;
    private AlunoView alunoView;
    private ProfessorView professorView;
    private AtividadeView atividadeView;
    private FaltaView faltaView;
    private NotaView notaView;
    private DisciplinaView disciplinaView;
    private AulaView aulaView;
    private Dao turmaDao;
    private Dao alunoDao;
    private Dao professorDao;
    private Dao atividadeDao;
    private Dao faltaDao;
    private Dao notaDao;
    private Dao disciplinaDao;
    private Dao aulaDao;
    
    private void carregarArquivo(){
        DisciplinaDaoImpl.getInstancia().carregar();
        ProfessorDaoImpl.getInstancia().carregar();
        AulaDaoImpl.getInstancia().carregar();
        TurmaDaoImpl.getInstancia().carregar();
        FaltaDaoImpl.getInstancia().carregar();
        AlunoDaoImpl.getInstancia().carregar();
        AtividadeDaoImpl.getInstancia().carregar();
        NotaDaoImpl.getInstancia().carregar();
    }
    
    private void salvarArquivo(){
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
                    break;
                }
                case 2:{
                    cadastroEfetuado = this.turmaView.cadastrar();
                    break;
                }
                case 3:{
                    cadastroEfetuado = this.professorView.cadastrar();
                    break;
                }
                case 4:{
                    cadastroEfetuado = this.atividadeView.cadastrar();
                    break;
                }
                case 5:{
                    cadastroEfetuado = this.faltaView.cadastrar();
                    break;
                }
                case 6:{
                    cadastroEfetuado = this.notaView.cadastrar();
                    break;
                }
                case 7:{
                    cadastroEfetuado = this.disciplinaView.cadastrar();
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
    
    private void imprimirMenuConsultar(){
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
            //Consultar a situação de um aluno em uma disciplina - exibir nota e faltas, e se foi aprovado ou nâo, sabendo
//que e necessario ter nota maior ou igual a 6,0, alem de 75% de frequencia para aprovação;
                String cpf;
                System.out.println("INFORME O CPF DO ALUNO: ");
                cpf = entrada.nextLine();
                Aluno aluno = (Aluno)this.alunoDao.obter(cpf);
                if(aluno == null)
                    return;
                System.out.println("INFORME O NOME DA DISCIPLINA: ");
                String nome;
                nome = entrada.nextLine();
                Disciplina disciplina = (Disciplina) this.disciplinaDao.obter(nome);
                if(disciplina == null)
                    return;
                for(Turma turma : disciplina.getTurma()){
                    for(Aluno alunoConsultado : turma.getAluno()){
                        if(alunoConsultado == aluno){
                            aluno.toString();
                            for(Falta faltaConsultada : aluno.getFalta()){
                                if(faltaConsultada.getTurma() == turma){
                                    System.out.println("Falta: " + faltaConsultada.getFalta());
                                    System.out.println("Nota: " + aluno.NotaFinal(turma));
                                    if(((faltaConsultada.getFalta()/disciplina.getCargaHoraria())<=0.25) && (aluno.NotaFinal(turma)<6))
                                        System.out.println("Aluno aprovado!");
                                    else
                                        System.out.println("Aluno não aprovado!");
                                    break;
                                }
                            }
                            
                        }
                    }
                    break;
                }
                break;
            }
            case 3:{
            // Consultar o numero de turmas ja oferecidas (historicamente) para uma determinada disciplina
                String nome;
                System.out.println("INFORME O NOME DA DISCIPLINA");
                nome =  entrada.nextLine();
                Disciplina disciplina=(Disciplina)this.disciplinaDao.obter(nome);
                if(disciplina == null)
                    return;
                System.out.println("A quantidade de turmas da disciplina " + 
                        nome+" já oferecidas é "+disciplina.getTurma().size()
                        + ".");
                }
            case 4:{
                //Consultar o numero de disciplinas ja lecionadas por um determinado professor.
                String nome;
                System.out.println("INFORME O NOME DO PROFESSOR");
                nome =  entrada.nextLine();
                Professor professor = (Professor) this.professorDao.obter(nome);
                if(professor == null)
                    return;
                System.out.println("A quantidade de disciplinas já lecionadas "
                        + "pelo(a) professsor(a) " + nome + " é " + 
                        professor.getDisciplina().size() + ".");
                
            }
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
                    break;
                }
                case 2:{
                    this.turmaView.remover();
                    break;
                }
                case 3:{
                    this.professorView.remover();
                    break;
                }
                case 4:{
                    this.atividadeView.remover();
                    break;
                }
                case 5:{
                    this.faltaView.remover();
                    break;
                }
                case 6:{
                    this.notaView.remover();
                    break;
                }
                case 7:{
                    this.disciplinaView.remover();
                    break;
                }
                default:{}
            }
            if (opcao < 1 || opcao > 7)
                break;
        }
    }     

    public static void main(String[] args){
        Integer i;
        Main main = new Main();    
        Scanner entrada = new Scanner(System.in);
        main.carregarArquivo();
        while(true){
            System.out.println("CADASTROS - 1");
            System.out.println("CONSULTAS - 2");
            System.out.println("REMOÇÕES - 3");
            System.out.println("MODIFICAÇÕES - 4");
            i = entrada.nextInt();
            switch(i){
                    case 1: {
                        main.imprimirMenuCadastro();
                    }
                    case 2: {
                        main.imprimirMenuConsultar();
                    }
                    case 3: {
                        main.imprimirMenuRemover(); 
                    }
                    //Opção "sair" com main.salvarArquivo()
            }
        }    
    }
}
