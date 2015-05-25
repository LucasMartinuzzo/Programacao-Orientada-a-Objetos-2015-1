package view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import model.dao.AlunoDaoImpl;
import model.dao.AulaDaoImpl;
import model.dao.Dao;
import model.dao.DisciplinaDaoImpl;
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
        System.out.println("CADASTRO DE TURMAS");
        System.out.println("Disciplina (ID: nome):");
        Disciplina disciplina = (Disciplina) this.obterCadastrado(DisciplinaDaoImpl.getInstancia());
        //Disciplina disciplina = (Disciplina) this.obterCadastrado(this.disciplinaDao);
        if (disciplina == null)
            return false;
        System.out.println("Professor (ID: CPF):");
        Professor professor = this.obterCadastrado(disciplina);
        if (professor == null)
            return false;
        
        System.out.println("\nCadastre uma nova turma:\n");
        String id = this.validarId();
        if (id == null)
            return false;
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
                + "entre com o código identificador (ID) do item procurado.\n");
        
        System.out.println("\nDetermine as aulas a serem adicionadas.");
        System.out.println("(Novas aulas podem ser adicionadas a qualquer momento a partir da opção"
                + " \"RELACIONAMENTOS\" no menu principal)\n");
        //List<Aula> listaAula = this.montarListaDeAulas();
        List<Aula> listaAula = (List<Aula>) this.montarListaDeCadastrados(disciplina,
                AulaDaoImpl.getInstancia());
        
        System.out.println("\nDetermine as alunos (ID: CPF) a serem matriculados.");
        System.out.println("(Novos alunos podem ser matriculados a qualquer momento a partir da opção"
                + " \"RELACIONAMENTOS\" no menu principal)\n");
        List<Aluno> listaAluno = (List<Aluno>) this.montarListaDeCadastrados(disciplina,
                AlunoDaoImpl.getInstancia());
        //List<Aluno> listaAluno = (List<Aluno>) (Aluno) this.montarListaDeCadastrados(this.alunoDao);
        Turma turma = new Turma (id, ano, periodo, numeroDeVagas, disciplina, professor, listaAula,
                listaAluno);
        
        disciplina.getTurma().add(turma);
        //disciplina.adicionarTurma(turma);
        return TurmaDaoImpl.getInstancia().inserir(turma);
        //return this.turmaDao.inserir(turma);
    }
    
    public void pesquisar () {
        System.out.println("PESQUISA DE TURMAS\nEntre com o ID da turma: ");
        String id = scanner.nextLine();
        if(TurmaDaoImpl.getInstancia().indice(id) >= 0)
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
        List<Turma> listaTurma = (List<Turma>) TurmaDaoImpl.getInstancia().obterTodos();
        //List<Turma> listaTurma = (List<Turma>) (Turma) turmaDao.obterTodos();
        for (Turma turma: listaTurma) {
            System.out.println(turma.toString() + "\n");
        }
    }
    
    public String validarId () {
        while (true) {
            System.out.println("ID (''cancelar'' para cancelar): ");
            String id = scanner.nextLine();
            if (id.equals("cancelar"))
                break;
            if (TurmaDaoImpl.getInstancia().indice(id) <= -1)
                return id;
            else
                System.out.println("\nUMA TURMA COM ESTE ID JÁ ESTÁ CADASTRADA! TENTE NOVAMENTE!\n");
        }
        return null;
    }
    
    public Boolean matricularAluno(){
        System.out.println("MATRÍCULA DE ALUNOS\nMatricule um aluno:\n");
        System.out.println("Informe o CPF do aluno: ");
        Aluno aluno = (Aluno) AlunoDaoImpl.getInstancia().obter(scanner.nextLine());
        if (aluno != null) {
            System.out.println("Informe a turma na qual será efetuada a matrícula: ");
            Turma turma = (Turma) TurmaDaoImpl.getInstancia().obter(scanner.nextLine());
            if(turma != null)
                if (turma.adicionarAluno(aluno))
                    return true;
                else
                    if (turma.getNumeroDeVagas() > turma.getAluno().size())
                        System.out.println("\nESTE(A) ALUNO(A) JÁ ESTÁ MATRICULADO(A) EM UMA TURMA"
                                + " DESTA DISCIPLINA!");
                    else
                        System.out.println("\nNÃO HÁ VAGAS DISPONÍVEIS NESTA TURMA!");
            else
                System.out.println("\nTURMA NÃO ENCONTRADA!");
        }
        else
            System.out.println("\nALUNO NÃO ENCONTRADO!");
        return false;
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
        List<Turma> listaTurma = (List<Turma>) TurmaDaoImpl.getInstancia().obterTodos();
        for (Turma turmaConsultada: listaTurma) {
            if (turmaConsultada.getDisciplina().getNome().equals(disciplina))
                if (turmaConsultada.getAno().equals(ano))
                    if (turmaConsultada.getPeriodo().equals(periodo))
                        turma = turmaConsultada;
        }
        if (turma != null) {
            if (turma.todasAsNotasLancadas() && turma.faltasLancadas()) {
                for (Aluno aluno: turma.getAluno())
                    this.imprimirSituacaoAluno(aluno, turma);
                return true;
            }
            else
                System.out.println("\nAS NOTAS/FALTAS CORRESPONDENTES À TURMA NÃO FORAM LANÇADAS!");
        }
        return false;
    }
    
    public Boolean consultarSituacaoAluno(){
        System.out.println("Informe o CPF do aluno: ");
        Aluno aluno = (Aluno) AlunoDaoImpl.getInstancia().obter(scanner.nextLine());
        if (aluno != null) {
            System.out.println("Informe o nome da disciplina: ");
            Disciplina disciplina = (Disciplina) DisciplinaDaoImpl.getInstancia().obter(scanner.nextLine());
            //Disciplina disciplina = (Disciplina) this.disciplinaDao.obter(scanner.nextLine());
            if(disciplina != null){
                Turma turma = disciplina.turmaQueContem(aluno);
                if (turma != null) {
                    if (turma.todasAsNotasLancadas() && turma.faltasLancadas()) {
                        this.imprimirSituacaoAluno(aluno, turma);
                        Collections.sort(aluno.getFalta(), new Falta());
                        Falta faltaConsultada = aluno.getFalta().get(Collections.binarySearch(aluno.getFalta(),
                                new Falta (null, null, turma), new Falta()));
                        if(((faltaConsultada.getFalta()/disciplina.getCargaHoraria())<=0.25)
                                && (aluno.NotaFinal(turma)>=6))
                            System.out.println("\nALUNO APROVADO!\n");
                        else
                            System.out.println("\nALUNO REPROVADO!\n");
                    }
                    else
                        System.out.println("\nAS NOTAS/FALTAS CORRESPONDENTES AO ALUNO NÃO FORAM LANÇADAS!");
                    return true;
                }
            }
        }
        return false;
    }
    
    public void imprimirSituacaoAluno(Aluno aluno, Turma turma) {
        System.out.println("\nAluno: " + aluno.getNome());
        System.out.println("Notas:");
        for (Atividade atividade: turma.getAtividade()) {
            Collections.sort(atividade.getNota(), new Nota());
            Integer indiceNota = Collections.binarySearch(atividade.getNota(),
                    new Nota (null, null, aluno, null), new Nota());
            System.out.println(" *" + atividade.getNome() + ": " + 
                    atividade.getNota().get(indiceNota).getNota());
            System.out.println(" *FINAL: " + aluno.NotaFinal(turma));
        }
        Collections.sort(aluno.getFalta(), new Falta());
        Integer indiceFalta = Collections.binarySearch(aluno.getFalta(),
                    new Falta (null, null, turma), new Falta());
        System.out.println("Faltas: " + aluno.getFalta().get(indiceFalta).getFalta());
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
    
    public Professor obterCadastrado (Disciplina disciplina) {
        Professor professor = null;
        while ((professor = (Professor) this.obterCadastrado(ProfessorDaoImpl.getInstancia())) != null) {
            if (professor.getDisciplina().contains(disciplina))
                break;
            else
                System.out.println("ESTE PROFESSOR NÃO ESTÁ VINCULADO A ESTA DISCIPLINA! "
                        + "TENTE NOVAMENTE!\n");
        }
        return professor;
    }
    
    public List<? extends Object> montarListaDeCadastrados (Disciplina disciplina, Dao dao) {
        List<Object> listaObjeto = new ArrayList<>();
        Boolean possivelAdicionar = true;
        while (true) {
            System.out.println("Continuar? ");
            System.out.println("Digite ''sim'' para continuar ou qualquer outro para não: ");
            if (scanner.nextLine().equals("sim")) {
                Object objeto = this.obterCadastrado(dao);
                if (objeto != null) {
                    if (dao instanceof AlunoDaoImpl) {
                        Aluno aluno = (Aluno) objeto;
                        if (disciplina.turmaQueContem(aluno) != null) {
                            System.out.println("ESTE ALUNO JÁ ESTÁ MATRICULADO EM UMA TURMA"
                                    + " DESTA DISCIPLINA!\n");
                            possivelAdicionar = false;
                        }
                    }
                }
                else
                    possivelAdicionar = false;
                if (possivelAdicionar)
                    listaObjeto.add(objeto);
            }
            else
                break;
        }
        return listaObjeto;
    }
    
    public Boolean atribuirAula () {
        System.out.println("Informe o ID da turma: ");
        Turma turma = (Turma) TurmaDaoImpl.getInstancia().obter(scanner.nextLine());
        if(turma != null) {
            System.out.println("Informe o ID da aula a ser atribuída à turma: ");
            Aula aula = (Aula) AulaDaoImpl.getInstancia().obter(scanner.nextLine());
            if (aula != null)
                if (turma.adicionarAula(aula))
                    return true;
                else
                    System.out.println("\nESTA AULA JÁ FOI ATRIBUÍDA A ESTA TURMA ANTERIORMENTE!");
                //turma.imprimirListaAulas();
//                disciplina.getProfessor().add(professor);
//                professor.getDisciplina().add(disciplina);
                //System.out.println("AULA ATRIBUÍDA!");
                //return true;
            else
                System.out.println("\nREGISTRO DE AULA NÃO ENCONTRADO!");
        }
        else
            System.out.println("\nTURMA NÃO ENCONTRADA!");
        return false;
    }
}
