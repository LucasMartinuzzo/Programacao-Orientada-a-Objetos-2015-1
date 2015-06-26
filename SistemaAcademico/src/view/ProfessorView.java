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
        if(!cpf.trim().isEmpty())
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
        else
            System.out.println("O campo CPF deve ser preenchido.");
    }
    
    public void alterar (EntityManager em){
        System.out.println("ALTERAÇÃO DE PROFESSOR");
        this.listar(em);
        System.out.println("Professor (CPF): ");
        String cpf = scanner.nextLine();
        Professor professor = daoProfessor.buscar(em, cpf);
        if(professor != null){
            Integer opcao = 1; 
            while(opcao >= 1 && opcao <= 2){
                System.out.println("Atualize os dados da professor.");
                System.out.println("1 - Alterar nome");
                System.out.println("2 - Alterar departamento");
                System.out.println("Outro - Finalizar");
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch(opcao) {
                    case 1:{
                        System.out.println("Nome: ");
                        String nome = scanner.nextLine();
                        professor.setNome(nome);
                        break;
                    }
                    case 2:{
                        System.out.println("Departamento: ");
                        String departamento = scanner.nextLine();
                        professor.setDepartamento(departamento);
                        break;
                    }
                    default:{
                    }
                }
            }
            daoProfessor.alterar(em, professor);
            System.out.println("Alteração efetuada com sucesso.");
        }else
            System.out.println("Professor não cadastrado (CPF inválido).");
    }
    
    public void imprimir (List<?> lista){
        for(Object objeto: lista)
            System.out.println(objeto);
    }
    
    public void listar(EntityManager em) {
        if(daoProfessor.obterTodos(em).isEmpty()){
            System.out.println("Não existem professores cadastrados.");
            return;
        }
        System.out.println("Lista de professores cadastrados: ");
        this.imprimir(daoProfessor.obterTodos(em));
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
                        System.out.println(disciplina);
                        cont++;
                    }
                System.out.println("Total de disciplinas lecionadas: " + cont);
            }else
                System.out.println("Esse professor não lencionou nenhuma disciplina.");
        }else
            System.out.println("Professor inválido.");
    }
}
