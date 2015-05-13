/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import java.util.Scanner;
import model.dao.ProfessorDao;
import model.pojo.Professor;

/**
 *
 * @author Pedro
 */
public class ProfessorView {
    private ProfessorDao professorDao;
    private static final Scanner scanner = new Scanner (System.in);
    
    public Boolean cadastrar () {
        System.out.println("CADASTRO DE PROFESSORES\nCadastre um novo professor:\n");
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("CPF: ");
        String cpf = scanner.nextLine();
        System.out.println("Departamento: ");
        String departamento = scanner.nextLine();
        Professor professor = new Professor (nome, cpf, departamento);
        return this.professorDao.salvar(professor);
    }
    
    public void pesquisar () {
        System.out.println("PESQUISA DE PROFESSOR\nEntre com o CPF do professor: ");
        String cpf = scanner.nextLine();
        if (this.professorDao.indiceProfessor(cpf) != -1)
            System.out.println(this.professorDao.obterProfessor(cpf).toString());
        else
            System.out.println("PROFESSOR NÃO ENCONTRADO!"); 
    }
    
    public void remover(){
        System.out.println("REMOÇÃO DE PROFESSOR\nEntre com o CPF do Professor: ");
        String cpf = scanner.nextLine();
        if (professorDao.remover(professorDao.obterProfessor(cpf)))
            System.out.println("PROFESSSOR REMOVIDO COM SUCESSO!");                
        else
            System.out.println("PROFESSOR NÃO ENCONTRADO!");
    }
    
        public void listar () {
            System.out.println("LISTA DE PROFESSORES DISPONÍVEIS\n");
            List<Professor> listaProfessor = professorDao.obterTodos();
            for (Professor professor: listaProfessor)
                System.out.println(professor.toString() + "\n");
        }
}
