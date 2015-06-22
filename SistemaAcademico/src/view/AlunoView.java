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
        System.out.println ("Lista de alunos cadastrados: ");
        System.out.println("CPF: ");
        String cpf = scanner.nextLine();
        if (daoAluno.buscar(em,cpf) == null){
            System.out.println("Nome: ");
            String nome = scanner.nextLine();
            Aluno aluno = new Aluno (cpf, nome);
            daoAluno.salvar(em, aluno);
            System.out.println("Cadastro efetuado com sucesso.");
        }else
            System.out.println("ERRO: CPF já cadastrado.");
    }
    
    public void imprimir (List<Aluno> list){
        for(Aluno aluno: list)
            System.out.println(aluno);
    }
}
