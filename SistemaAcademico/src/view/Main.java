package view;

import java.util.Scanner;

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
        System.out.println("CONSULTAR OS ALUNOS DE UMA TURMA COM SUAS RESPECTIVAS NOTAS E FALTAS - 1");
        System.out.println("CONSULTAR A SITUAÇÃO DO ALUNO EM DETERMINADA DISCIPLINA - 2");
        System.out.println("CONSULTAR A QUANTIDADE DE TURMAS OFERECIDAS DE UMA DISCIPLINA - 3");
        System.out.println("CONSULTAR O NÚMERO DE DISCIPLINAS JÁ LECIONADAS POR UM PROFESSOR - 4");
    
        Scanner entrada = new Scanner(System.in);
        Integer i = entrada.nextInt();
        switch(i){
            case 1:{}
            case 2:{}
            case 3:{}
            case 4:{}

        }
    }
    
    private void imprimirMenuRemover(){
        System.out.println("REMOVER ALUNOS - 1");
        System.out.println("REMOVER TURMAS - 2");
        System.out.println("REMOVER PROFESSOR - 3");
        System.out.println("REMOVER ATIVIDADE - 4");
        System.out.println("REMOVER FALTA - 5");
        System.out.println("REMOVER NOTA - 6 ");
        System.out.println("REMOVER DISCIPLINA - 7");
        
        Scanner entrada = new Scanner(System.in);
        Integer i = entrada.nextInt();
        switch(i){
            case 1:{}
            case 2:{}
            case 3:{}
            case 4:{}
            case 5:{}
            case 6:{}
            case 7:{}

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
        Integer i = entrada.nextInt();
        switch(i){
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
