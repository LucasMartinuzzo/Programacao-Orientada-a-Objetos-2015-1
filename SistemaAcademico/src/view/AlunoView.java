package view;

import java.util.List;
import java.util.Scanner;
import model.dao.Dao;
import model.pojo.Aluno;

public class AlunoView {
    private Dao alunoDao;
    private static Scanner scanner = new Scanner (System.in);
    
    public Boolean cadastrar () {
        System.out.println("CADASTRO DE ALUNOS\nCadastre um novo aluno:\n");
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("CPF: ");
        String cpf = scanner.nextLine();
        Aluno aluno = new Aluno (nome, cpf);
        return this.alunoDao.inserir(aluno);
    }

    public void pesquisar () {
       System.out.println("PESQUISA DE ALUNO\nEntre com o CPF do aluno: ");
        String cpf = scanner.nextLine();
        if (this.alunoDao.indice(cpf) != -1)
            System.out.println(this.alunoDao.obter(cpf).toString());
        else
            System.out.println("ALUNO NÃO ENCONTRADO!"); 
    }

    public void remover(){
        System.out.println("REMOÇÃO DE ALUNO\nEntre com o CPF do aluno: ");
        String cpf = scanner.nextLine();
        if (alunoDao.remover(alunoDao.obter(cpf)))
            System.out.println("ALUNO REMOVIDO COM SUCESSO!");                
        else
            System.out.println("ALUNO NÃO ENCONTRADO!");
    }

    public void listar () {
        System.out.println("LISTA DE ALUNOS DISPONÍVEIS\n");
        List<Aluno> listaAluno = (List<Aluno>) (Aluno) alunoDao.obterTodos();
        for (Aluno aluno: listaAluno) {
            System.out.println(aluno.toString() + "\n");
        }
    }
}
