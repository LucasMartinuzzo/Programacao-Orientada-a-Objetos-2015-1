package view;

import java.util.Scanner;
import javax.persistence.EntityManager;
import model.dao.ProfessorDaoImpl;
import model.pojo.Professor;

public class ProfessorView {

    private static Scanner scanner = new Scanner (System.in);
    private ProfessorDaoImpl daoProfessor = ProfessorDaoImpl.getInstancia();
    
    public void cadastrar (EntityManager em){
        System.out.println("CADASTRO DE PROFESSOR");
        System.out.println("CPF: ");
        String cpf = scanner.nextLine();
        if (daoProfessor.buscar(em,cpf) == null){
            System.out.println("Nome ");
            String nome = scanner.nextLine();
            System.out.println("Departamento: ");
            String departamento = scanner.nextLine();
            Professor professor = new Professor (cpf, nome, departamento);
            daoProfessor.salvar(em, professor);
            System.out.println("Cadastro efetuado com sucesso.");
        }else
            System.out.println("ERRO: CPF já cadastrado.");
    }
}
