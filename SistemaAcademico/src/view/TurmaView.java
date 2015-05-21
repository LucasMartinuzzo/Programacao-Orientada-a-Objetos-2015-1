package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import model.dao.AlunoDaoImpl;
import model.dao.AulaDaoImpl;
import model.dao.Dao;
import model.dao.ProfessorDaoImpl;
import model.dao.TurmaDaoImpl;
import model.pojo.Aluno;
import model.pojo.Atividade;
import model.pojo.Aula;
import model.pojo.Disciplina;
import model.pojo.Falta;
import model.pojo.Nota;
import model.pojo.Professor;
import model.pojo.Turma;

/**
 *
 * @author JeanPablo
 */
public class TurmaView {    
    //private Dao turmaDao;
    //private Dao disciplinaDao;
    //private Dao professorDao;
    //private Dao aulaDao;
    //private Dao alunoDao;
    
    private static Scanner scanner = new Scanner (System.in);
    
    public Boolean cadastrar () {
        Turma turma;
        System.out.println("CADASTRO DE TURMAS\nCadastre uma nova turma:\n");
        System.out.println("ID: ");
        String id = scanner.nextLine();
        System.out.println("Ano: ");
        Integer ano = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Período: ");
        Integer periodo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Número de vagas: ");
        Integer numeroDeVagas = scanner.nextInt();
        scanner.nextLine();
        System.out.println("\nPara as próximas etapas do cadastro, "
                + "entre com o código identificador (ID) do item procurado.");
        
        System.out.println("Disciplina (ID: nome):");
        Disciplina disciplina = (Disciplina) this.obterCadastrado(TurmaDaoImpl.getInstancia());
        //Disciplina disciplina = (Disciplina) this.obterCadastrado(this.disciplinaDao);
        if (disciplina == null)
            return false;
        System.out.println("Professor (ID: CPF):");
        Professor professor = (Professor) this.obterCadastrado(ProfessorDaoImpl.getInstancia());
        if (professor == null)
            return false;
        
        System.out.println("***** PARA CONTINUAR, DETERMINE AS AULAS A SEREM ADICIONADAS *****");
        List<Aula> listaAula = (List<Aula>) (Aula) this.montarListaDeCadastrados(AulaDaoImpl.getInstancia());
        //List<Aula> listaAula = (List<Aula>) (Aula) this.montarListaDeCadastrados(this.aulaDao);
        System.out.println("******************************************************************\n");
        
        System.out.println("***** DESEJA ADICIONAR UMA LISTA DE ALUNOS AGORA? (ID: CPF) *****");
        System.out.println("Digite ''sim'' para adicionar ou qualquer outro para não: ");
        if (scanner.nextLine().equals("sim")) {
            System.out.println("\n");
            List<Aluno> listaAluno = (List<Aluno>) (Aluno) this.montarListaDeCadastrados(AlunoDaoImpl.getInstancia());
            //List<Aluno> listaAluno = (List<Aluno>) (Aluno) this.montarListaDeCadastrados(this.alunoDao);
            turma = new Turma (id, ano, periodo, numeroDeVagas, disciplina, professor,
                    listaAula, listaAluno);
            System.out.println("******************************************************************");
        }
        else
            turma = new Turma (id, ano, periodo, numeroDeVagas, disciplina, professor, listaAula);
        return TurmaDaoImpl.getInstancia().inserir(turma);
        //return this.turmaDao.inserir(turma);
    }
    
    public void pesquisar () {
        System.out.println("PESQUISA DE TURMAS\nEntre com o ID da turma: ");
        String id = scanner.nextLine();
        if(TurmaDaoImpl.getInstancia().indice(id) != -1)
            System.out.println(TurmaDaoImpl.getInstancia().obter(id).toString());
        //if (this.turmaDao.indice(id) != -1)
        //    System.out.println(this.turmaDao.obter(id).toString());
        else
            System.out.println("TURMA NÃO ENCONTRADA!\n");
    }
    
    
    public void remover(){
        System.out.println("REMOÇÃO DE TURMAS\nEntre com o ID da turma: ");
        String cpf = scanner.nextLine();
        if(ProfessorDaoImpl.getInstancia().remover(ProfessorDaoImpl.getInstancia().obter(cpf)))
        //if (professorDao.remover(professorDao.obter(cpf)))
            System.out.println("TURMA REMOVIDA COM SUCESSO!");                
        else
            System.out.println("TURMA NÃO ENCONTRADA, REMOÇÃO NÃO EFETUADA!\n");
    }
    
    public void listar () {
        System.out.println("LISTA DE TURMAS DISPONÍVEIS\n");
        List<Turma> listaTurma = (List<Turma>) (Turma) TurmaDaoImpl.getInstancia().obterTodos();
        //List<Turma> listaTurma = (List<Turma>) (Turma) turmaDao.obterTodos();
        for (Turma turma: listaTurma) {
            System.out.println(turma.toString() + "\n");
        }
    }
    
    public Boolean listarAlunos () {
        Turma turma = null;
        System.out.println("\nIdentifique a turma procurada: ");
        System.out.println("* Disciplina: ");
        String disciplina = scanner.nextLine();
        System.out.println("* Ano: ");
        Integer ano = scanner.nextInt();
        scanner.nextLine();
        System.out.println("* Período: ");
        Integer periodo = scanner.nextInt();
        scanner.nextLine();
        for (Turma turmaConsultada: (List<Turma>) (Turma) TurmaDaoImpl.getInstancia().obterTodos()) {
            if (turmaConsultada.getDisciplina().getNome().equals(disciplina))
                if (turmaConsultada.getAno().equals(ano))
                    if (turmaConsultada.getPeriodo().equals(periodo))
                        turma = turmaConsultada;
        }
        if (turma != null) {
            for (Aluno aluno: turma.getAluno()) {
                System.out.println("\nAluno: " + aluno.getNome());
                System.out.println("Notas:");
                Collections.sort(aluno.getNota(), new Atividade());
                for (Atividade atividade: turma.getAtividade()) {
                    Integer indiceNota = Collections.binarySearch(atividade.getNota(),
                            new Nota (null, null, aluno, null));
                    System.out.println(" *" + atividade.getNome() + ": " + 
                            atividade.getNota().get(indiceNota).getNota());
                    System.out.println(" *FINAL: " + aluno.NotaFinal(turma));
                }
                Collections.sort(aluno.getFalta(), new Aluno());
                Integer indiceFalta = Collections.binarySearch(aluno.getFalta(),
                            new Falta (null, null, turma));
                System.out.println("Faltas: " + aluno.getFalta().get(indiceFalta));
                return true;
            }
        }
        return false;
    }

    public Object obterCadastrado (Dao dao) {    
        while (true) {
            System.out.println("ID (''cancelar'' para cancelar): ");
            String entrada = scanner.nextLine();
            if (entrada.equals("cancelar"))
                break;
            Object objeto = dao.obter(entrada);
            if (objeto != null)
                return objeto;
            else
                System.out.println("ITEM NÃO CADASTRADO! TENTE NOVAMENTE.\n");
        }
        return null;
    }
    
    public List<Object> montarListaDeCadastrados (Dao dao) {
        List<Object> listaObjeto = new ArrayList<>();
        while (true) {
            System.out.println("Continuar? ");
            System.out.println("Digite ''sim'' para continuar ou qualquer outro para não: ");
            if (scanner.nextLine().equals("sim")) {
                Object objeto = this.obterCadastrado(dao);
                if (objeto != null)
                    listaObjeto.add(objeto);
            }
            else
                break;
        }
        return listaObjeto;
    }
}
