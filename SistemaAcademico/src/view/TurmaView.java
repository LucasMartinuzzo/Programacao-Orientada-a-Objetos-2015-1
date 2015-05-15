package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.dao.Dao;
import model.pojo.Aluno;
import model.pojo.Aula;
import model.pojo.Disciplina;
import model.pojo.Professor;
import model.pojo.Turma;

/**
 *
 * @author JeanPablo
 */
public class TurmaView {
    
    private Dao turmaDao;
    private Dao disciplinaDao;
    private Dao professorDao;
    private Dao aulaDao;
    private Dao alunoDao;
    
    private static Scanner scanner = new Scanner (System.in);
    
    public Boolean cadastrar () {
        Turma turma;
        System.out.println("CADASTRO DE TURMAS\nCadastre uma nova turma:\n");
        System.out.println("ID: ");
        String id = scanner.nextLine();
        System.out.println("Ano: ");
        Integer ano = scanner.nextInt();
        System.out.println("Período: ");
        Integer periodo = scanner.nextInt();
        System.out.println("Número de vagas: ");
        Integer numeroDeVagas = scanner.nextInt();
        
        System.out.println("\nPara as próximas etapas do cadastro, "
                + "entre com o código identificador (ID) do item procurado.");
        
        System.out.println("Disciplina (ID: nome):");
        Disciplina disciplina = (Disciplina) this.obterCadastrado(this.disciplinaDao);
        if (disciplina == null)
            return false;
        System.out.println("Professor (ID: CPF):");
        Professor professor = (Professor) this.obterCadastrado(this.professorDao);
        if (professor == null)
            return false;
        
        System.out.println("***** PARA CONTINUAR, DETERMINE AS AULAS A SEREM ADICIONADAS *****");
        List<Aula> listaAula = (List<Aula>) (Aula) this.montarListaDeCadastrados(this.aulaDao);
        System.out.println("******************************************************************\n");
        
        System.out.println("***** DESEJA ADICIONAR UMA LISTA DE ALUNOS AGORA? (ID: CPF) *****");
        System.out.println("Digite ''sim'' para adicionar ou qualquer outro para não: ");
        if (scanner.nextLine().equals("sim")) {
            System.out.println("\n");
            List<Aluno> listaAluno = (List<Aluno>) (Aluno) this.montarListaDeCadastrados(this.alunoDao);
            turma = new Turma (id, ano, periodo, numeroDeVagas, disciplina, professor,
                    listaAula, listaAluno);
            System.out.println("******************************************************************");
        }
        else
            turma = new Turma (id, ano, periodo, numeroDeVagas, disciplina, professor, listaAula);
        return this.turmaDao.inserir(turma);
    }
    
    public void pesquisar () {
        System.out.println("PESQUISA DE TURMAS\nEntre com o ID da turma: ");
        String id = scanner.nextLine();
        if (this.turmaDao.indice(id) != -1)
            System.out.println(this.turmaDao.obter(id).toString());
        else
            System.out.println("TURMA NÃO ENCONTRADA!");
    }
        
    public void listar () {
        System.out.println("LISTA DE TURMAS DISPONÍVEIS\n");
        List<Turma> listaTurma = (List<Turma>) (Turma) turmaDao.obterTodos();
        for (Turma turma: listaTurma) {
            System.out.println(turma.toString() + "\n");
        }
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
            System.out.println("Continuar?");
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
