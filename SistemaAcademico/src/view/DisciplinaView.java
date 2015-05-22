package view;

import java.util.List;
import java.util.Scanner;
import model.dao.Dao;
import model.dao.DisciplinaDaoImpl;
import model.dao.ProfessorDaoImpl;
import model.pojo.Disciplina;
import model.pojo.Professor;

/**
 *
 * @author Lucas
 */
public class DisciplinaView {
    //private Dao disciplinaDao;
    private static Scanner scanner = new Scanner (System.in);
    
    public Boolean cadastrar(){
        System.out.println("CADASTRO DE DISCIPLINAS\nCadastre uma nova disciplina:\n");
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Ementa: ");
        String ementa = scanner.nextLine();
        System.out.println("Carga Horária: ");
        Integer cargaHoraria = scanner.nextInt();
        scanner.nextLine();
        Disciplina disciplina = new Disciplina(nome, ementa, cargaHoraria);
        return DisciplinaDaoImpl.getInstancia().inserir(disciplina);
        //return this.disciplinaDao.inserir(disciplina);
    }
    public void pesquisar () {
        System.out.println("PESQUISA DE DISCIPLINAS\nEntre com o nome da disciplina: ");
            String nome = scanner.nextLine();
            if(DisciplinaDaoImpl.getInstancia().indice(nome) >= 0)
                System.out.println(DisciplinaDaoImpl.getInstancia().obter(nome).toString());
            //if (this.disciplinaDao.indice(nome) != -1)
            //    System.out.println(this.disciplinaDao.obter(nome).toString());
            else
                System.out.println("DISCIPLINA NÃO ENCONTRADA!\n");
        }
    public void remover(){
        System.out.println("REMOÇÃO DE DISCIPLINAS\nEntre com o nome da Disciplina: ");
        String nome = scanner.nextLine();
        if(DisciplinaDaoImpl.getInstancia().remover(DisciplinaDaoImpl.getInstancia().obter(nome)))
        //if (disciplinaDao.remover(disciplinaDao.obter(nome)))
            System.out.println("DISCIPLINA REMOVIDA COM SUCESSO!");                
        else
            System.out.println("DISCIPLINA NÃO ENCONTRADA, REMOÇÃO NÃO EFETUADA!\n");
    }
    public void listar () {
        System.out.println("LISTA DE DISCIPLINAS DISPONÍVEIS\n");
        List<Disciplina> listaDisciplina = (List<Disciplina>) (Disciplina) DisciplinaDaoImpl.getInstancia().obterTodos();
        //List<Disciplina> listaDisciplina = (List<Disciplina>) (Disciplina) disciplinaDao.obterTodos();
        for(Disciplina disc: listaDisciplina) {
            System.out.println(disc.toString() + "\n");
        }
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
    
    public void atribuirProfessor () {
        System.out.println("Informe o nome da disciplina: ");
        Disciplina disciplina = (Disciplina) DisciplinaDaoImpl.getInstancia().obter(scanner.nextLine());
        if(disciplina != null) {
            System.out.println("Informe o CPF do(a) professor(a) a ser atribuído à disciplina: ");
            Professor professor = (Professor) ProfessorDaoImpl.getInstancia().obter(scanner.nextLine());
            if (professor != null) {
                disciplina.getProfessor().add(professor);
                professor.getDisciplina().add(disciplina);
                System.out.println("PROFESSOR ATRIBUÍDO!\n");
            }
            else
                System.out.println("PROFESSOR NÃO ENCONTRADO!\n");
        }
        else
            System.out.println("DISCIPLINA NÃO ENCONTRADA!\n");
    }
}
