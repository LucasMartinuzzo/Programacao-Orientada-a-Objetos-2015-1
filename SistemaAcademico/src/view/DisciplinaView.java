package view;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import model.dao.DisciplinaDaoImpl;
import model.dao.ProfessorDaoImpl;
import model.pojo.Disciplina;
import model.pojo.Professor;

public class DisciplinaView {

    private static Scanner scanner = new Scanner (System.in);
    private DisciplinaDaoImpl daoDisciplina = DisciplinaDaoImpl.getInstancia();
    private ProfessorDaoImpl daoProfessor = ProfessorDaoImpl.getInstancia();
    
    public void cadastrar (EntityManager em){
        System.out.println("CADASTRO DE DISCIPLINA");
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        if (daoDisciplina.buscar(em,nome) == null){
            System.out.println("Ementa: ");
            String ementa = scanner.nextLine();
            System.out.println("Carga Horária: ");
            Integer cargaHoraria = scanner.nextInt();
            scanner.nextLine();
            Disciplina disciplina = new Disciplina (nome, ementa, cargaHoraria);
            daoDisciplina.salvar(em, disciplina);
            System.out.println("Cadastro efetuado com sucesso.");
        }else
            System.out.println("Nome de disciplina já cadastrado.");
    }
    
    public void imprimir (List<?> lista){
        for(Object objeto: lista)
            System.out.println(objeto);
    }

    public void atribuirProfessor (EntityManager em){
        System.out.println("Informe o nome da disciplina: ");
        Disciplina disciplina = daoDisciplina.buscar(em, scanner.nextLine());
        if (disciplina != null){
            System.out.println("Informe o CPF do professor a ser atribuído à disciplina: ");
            Professor professor = daoProfessor.buscar(em, scanner.nextLine());
            if (professor != null){
                if (professor.adicionarDisciplina(disciplina)){
                    daoProfessor.alterar(em, professor);
                    System.out.println("Atribuição efetuada com sucesso.");
                }else
                    System.out.println("Esse professor já foi atribuído a essa disciplina");
            }else
                System.out.println("Professor não encontrado.");
        }else
            System.out.println("Disciplina não encontrada.");
    }    

    public void quantidadeTurmas (EntityManager em){
        System.out.println("Informe o nome da disciplina: ");
        Disciplina disciplina = daoDisciplina.buscar(em, scanner.nextLine());
        if (disciplina != null){
            if (!disciplina.getTurma().isEmpty()){
                System.out.println("Lista de turmas da disciplina " + disciplina.getNome() + ":");
                this.imprimir(disciplina.getTurma());
                System.out.println("Total de turmas: " + disciplina.getTurma().size());
            }else
                System.out.println("Não há turmas dessa disciplina cadastradas.");
        }else
            System.out.println("Disciplina inválida.");
    }
}
