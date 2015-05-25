package view;

import java.util.Scanner;
import model.dao.DisciplinaDaoImpl;
import model.dao.ProfessorDaoImpl;
import model.pojo.Disciplina;
import model.pojo.Professor;

public class DisciplinaView {
    
    private static Scanner scanner = new Scanner (System.in);
    
    public Boolean cadastrar(){
        System.out.println("CADASTRO DE DISCIPLINAS\nCadastre uma nova disciplina:\n");
        String nome = this.validarId();
        if (nome == null)
            return false;
        System.out.println("Ementa: ");
        String ementa = scanner.nextLine();
        System.out.println("Carga Horária: ");
        Integer cargaHoraria = scanner.nextInt();
        scanner.nextLine();
        Disciplina disciplina = new Disciplina(nome, ementa, cargaHoraria);
        return DisciplinaDaoImpl.getInstancia().inserir(disciplina);
    }
    
    public String validarId () {
        while (true) {
            System.out.println("Nome (''cancelar'' para cancelar): ");
            String id = scanner.nextLine();
            if (id.equals("cancelar"))
                break;
            if (DisciplinaDaoImpl.getInstancia().indice(id) <= -1)
                return id;
            else
                System.out.println("\nUMA DISCIPLINA COM ESTE NOME JÁ ESTÁ CADASTRADA!"
                        + " TENTE NOVAMENTE!\n");
        }
        return null;
    }
    
    public Boolean quantidadeTurmas(){
        System.out.println("Informe o nome da disciplina: ");
        Disciplina disciplina=(Disciplina)DisciplinaDaoImpl.getInstancia().obter(scanner.nextLine());
        if(disciplina != null){
            System.out.println("A quantidade de turmas da disciplina " + disciplina.getNome() +
                    " já oferecidas é " + disciplina.getTurma().size() + ".");
            return true;
        }
        return false;
    }
    
    public Boolean atribuirProfessor () {
        System.out.println("Informe o nome da disciplina: ");
        Disciplina disciplina = (Disciplina) DisciplinaDaoImpl.getInstancia().obter(scanner.nextLine());
        if(disciplina != null) {
            System.out.println("Informe o CPF do(a) professor(a) a ser atribuído à disciplina: ");
            Professor professor = (Professor) ProfessorDaoImpl.getInstancia().obter(scanner.nextLine());
            if (professor != null)
                if (professor.adicionarDisciplina(disciplina))
                    return true;
                else
                    System.out.println("\nESTE PROFESSOR JÁ FOI ATRIBUÍDO A ESTA DISCIPLINA"
                            + " ANTERIORMENTE!");
            else
                System.out.println("\nPROFESSOR NÃO ECONTRADO!");
        }
        else
            System.out.println("\nDISCIPLINA NÃO ENCONTRADA!");
        return false;
    }
}
