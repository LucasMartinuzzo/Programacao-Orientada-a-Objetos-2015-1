package view;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import model.dao.ProfessorDaoImpl;
import model.pojo.Disciplina;
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
            System.out.println("CPF já cadastrado.");
    }
    
    public void imprimir (List<?> lista){
        for(Object objeto: lista)
            System.out.println(objeto);
    }
    
    public void quantidadeDisciplinasLecionadas (EntityManager em){
        System.out.println("Informe o CPF do professor: ");
        Integer cont = 0;
        Professor professor = daoProfessor.buscar(em, scanner.nextLine());
        if (professor != null){
            if (!professor.getDisciplina().isEmpty()){
                System.out.println("Lista de disciplinas lecionadas pelo professor " + professor.getNome() + ":");
                for (Disciplina disciplina : professor.getDisciplina())
                    if (!disciplina.getTurma().isEmpty()){
                        this.imprimir(professor.getDisciplina());
                        cont++;
                    }
                System.out.println("Total de disciplinas lecionadas: " + cont);
            }else
                System.out.println("Esse professor não lencionou nenhuma disciplina.");
        }else
            System.out.println("Professor inválido.");
    }
}
