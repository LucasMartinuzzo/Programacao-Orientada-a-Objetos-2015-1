package view;

import java.util.Scanner;
import model.dao.Dao;
import model.pojo.Aluno;
import model.pojo.Atividade;
import model.pojo.Disciplina;
import model.pojo.Falta;
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
    
    private void imprimirMenuCadastro(){
        while (true) {
            System.out.println("1 - CADASTRAR ALUNOS");
            System.out.println("2 - CADASTRAR TURMAS");
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
                System.out.println("\nInforme o ID da turma: ");
                //VERIFICAR SE PODE SER O ID EM VEZ DE DISCIPLINA, ANO E PERÍODO!
                Turma turma = (Turma) this.turmaDao.obter(entrada.nextLine());
                if (turma != null) {
                    for (Aluno aluno: turma.getAluno()) {
                        System.out.println("\nAluno: " + aluno.getNome());
                        System.out.println("Notas:");
                        for (Atividade atividade: turma.getAtividade())
                            //System.out.println(" *" + atividade.getNome() + ": " + );
                        System.out.println(" *FINAL: " + aluno.NotaFinal(turma));
                        //System.out.println("\nFaltas: " + aluno);
                        consultaEfetuada = true;
                    }
                }
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
                            //for(Atividade atividade : turma.getAtividade()){
                            //    
                            //}
                            aluno.toString();
                            for(Falta faltaConsultada : aluno.getFalta()){
                                if(faltaConsultada.getTurma() == turma){
                                    System.out.println("Falta: " + faltaConsultada.getFalta());
                                    break;
                                }
                            }
                            System.out.println("Nota: " + aluno.NotaFinal(turma));
                            break;
                        }
                    }
                }
            }
            case 3:{
            
            }
            case 4:{
            
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
    
    private void imprimirMenuModificar(){
        System.out.println("MODIFICAR ALUNOS - 1");
        System.out.println("MODIFICAR TURMAS - 2");
        System.out.println("MODIFICAR PROFESSOR - 3");
        System.out.println("MODIFICAR ATIVIDADE - 4");
        System.out.println("MODIFICAR FALTA - 5");
        System.out.println("MODIFICAR NOTA - 6 ");
        System.out.println("MODIFICAR DISCIPLINA - 7");
    
        Scanner entrada = new Scanner(System.in);
        Integer opcao = entrada.nextInt();
        switch(opcao){
            case 1:{}
            case 2:{}
            case 3:{}
            case 4:{}
            case 5:{}
            case 6:{}
            case 7:{}

        }
    }

    public static void main(String[] args){
        Integer i;
        Main main = new Main();    
        Scanner entrada = new Scanner(System.in);
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
                    case 4: {
                        main.imprimirMenuModificar();
                    }



            }
    }
    
        
    
    
    }
}
