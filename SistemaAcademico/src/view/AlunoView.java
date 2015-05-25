package view;

import java.util.Scanner;
import model.dao.AlunoDaoImpl;
import model.pojo.Aluno;

public class AlunoView {
    
    private static Scanner scanner = new Scanner (System.in);
        
    public Boolean cadastrar () {
        System.out.println("CADASTRO DE ALUNOS\nCadastre um novo aluno:\n");
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        String cpf = this.validarId();
        if (cpf == null)
            return false;
        Aluno aluno = new Aluno (nome, cpf);
        return AlunoDaoImpl.getInstancia().inserir(aluno);
    }
    
    public String validarId () {
        while (true) {
            System.out.println("CPF (''cancelar'' para cancelar): ");
            String id = scanner.nextLine();
            if (id.equals("cancelar"))
                break;
            if (AlunoDaoImpl.getInstancia().indice(id) <= -1)
                return id;
            else
                System.out.println("\nUM(A) ALUNO(A) COM ESTE CPF JÁ ESTÁ CADASTRADO(A)!"
                        + " TENTE NOVAMENTE!\n");
        }
        return null;
    }
}