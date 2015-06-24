package view;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import model.dao.AlunoDaoImpl;
import model.dao.Dao;
import model.pojo.Aluno;

public class AlunoView {

    private static Scanner scanner = new Scanner (System.in);
    private AlunoDaoImpl daoAluno = AlunoDaoImpl.getInstancia();
    
    public void cadastrar (EntityManager em){
        System.out.println("CADASTRO DE ALUNO");
        System.out.println("CPF: ");
        String cpf = scanner.nextLine();
        if (daoAluno.buscar(em,cpf) == null){
            System.out.println("Nome: ");
            String nome = scanner.nextLine();
            Aluno aluno = new Aluno (cpf, nome);
            daoAluno.salvar(em, aluno);
            System.out.println("Cadastro efetuado com sucesso.");
        }else
            System.out.println("CPF já cadastrado.");
    }
    
    public void alterar (EntityManager em){
        System.out.println("ALTERAÇÃO DE ALUNO");
        if(daoAluno.obterTodos(em).isEmpty()){
            System.out.println("Não existem alunos cadastrados.");
            return;
        }
        System.out.println("Lista de alunos cadastrados: ");
        this.imprimir(daoAluno.obterTodos(em));
        System.out.println("Aluno (CPF): ");
        String cpf = scanner.nextLine();
        Aluno aluno = daoAluno.buscar(em, cpf);
        if(aluno != null){
            System.out.println("Atualize o nome do aluno.");
            System.out.println("Nome: ");
            String nome = scanner.nextLine();
            aluno.setNome(nome);
            daoAluno.alterar(em, aluno);
            System.out.println("Alteração efetuada com sucesso.");
        }else
            System.out.println("Aluno não cadastrado (CPF inválido).");
    }
    
    public void imprimir (List<?> lista){
        for(Object objeto: lista)
            System.out.println(objeto);
    }
}
