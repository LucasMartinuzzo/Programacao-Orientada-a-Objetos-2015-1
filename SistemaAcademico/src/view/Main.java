/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;

/**
 *
 * @author Filipe
 */
public class Main {

    /*private void imprimirMenu(){
        System.out.println("CADASTROS - 1");
        System.out.println("CONSULTAS - 2");
        System.out.println("REMOÇÕES - 3");
        System.out.println("MODIFICAÇÕES - 4");
       
    }*/
    
    private void imprimirMenuCadastro(){
        System.out.println("CADASTRAR ALUNOS - 1");
        System.out.println("CADASTRAR TURMAS - 2");
        System.out.println("CADASTRAR PROFESSOR - 3");
        System.out.println("CADASTRAR ATIVIDADE - 4");
        System.out.println("CADASTRAR FALTA - 5");
        System.out.println("CADASTAR NOTA - 6 ");
        System.out.println("CADASTRAR DISCIPLINA - 7");
        
        Scanner entrada = new Scanner(System.in);
        Integer i = entrada.nextInt();
            switch(i){
                case 1:{}
                case 2:{}
                case 3:{}
                case 4:{}
                case 5:{}
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
            // main.imprimirMenu();
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
