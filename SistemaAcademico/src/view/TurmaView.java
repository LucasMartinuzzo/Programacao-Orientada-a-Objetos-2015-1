package view;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import model.dao.AlunoDaoImpl;
import model.dao.DisciplinaDaoImpl;
import model.dao.ProfessorDaoImpl;
import model.dao.TurmaDaoImpl;
import model.pojo.Aluno;
import model.pojo.Atividade;
import model.pojo.Disciplina;
import model.pojo.Falta;
import model.pojo.Nota;
import model.pojo.Professor;
import model.pojo.Turma;

public class TurmaView {

    private static Scanner scanner = new Scanner (System.in);
    private TurmaDaoImpl daoTurma = TurmaDaoImpl.getInstancia();
    private DisciplinaDaoImpl daoDisciplina = DisciplinaDaoImpl.getInstancia();
    private ProfessorDaoImpl daoProfessor = ProfessorDaoImpl.getInstancia();
    private AlunoDaoImpl daoAluno = AlunoDaoImpl.getInstancia();

    public void cadastrar (EntityManager em){
        System.out.println("CADASTRO DE TURMA");
        System.out.println("Disciplina (Nome): ");
        String nomeDisciplina = scanner.nextLine();
        Disciplina disciplina = daoDisciplina.buscar(em, nomeDisciplina);
        if (disciplina != null){
            System.out.println("Professor (CPF): ");
            String cpfProfessor = scanner.nextLine();
            Professor professor = daoProfessor.buscar(em, cpfProfessor);
            if (professor != null){
                System.out.println("Ano: ");
                Integer ano = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Período: ");
                Integer periodo = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Local: ");
                String local = scanner.nextLine();
                System.out.println("Horário: ");
                String horario = scanner.nextLine();
                System.out.println("Número de Vagas: ");
                Integer numeroDeVagas = scanner.nextInt();
                scanner.nextLine();
                Turma turma = new Turma (ano, periodo, local, horario,numeroDeVagas, disciplina, professor);
                disciplina.getTurma().add(turma);
                daoTurma.salvar(em, turma);
                daoDisciplina.alterar(em, disciplina);
                System.out.println ("Cadastro efetuado com sucesso.");
            }else
                System.out.println ("Professor não cadastrado (CPF inválido).");
        }else
            System.out.println("Disciplina não cadastrada (nome inválido).");
    }
    
    public void alterar (EntityManager em){
        System.out.println("ALTERAÇÃO DE TURMA");
        this.listar(em);
        System.out.println("Turma (ID): ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        Turma turma = daoTurma.buscar(em, id);
        if(turma != null){
            Integer opcao = 1; 
            while(opcao >= 1 && opcao <= 5){
                System.out.println("Atualize os dados da turma.");
                System.out.println("1 - Alterar ano");
                System.out.println("2 - Alterar período");
                System.out.println("3 - Alterar local");
                System.out.println("4 - Alterar horário");
                System.out.println("5 - Número de vagas");
                System.out.println("Outro - Finalizar");
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch(opcao) {
                    case 1:{
                        System.out.println("Ano: ");
                        Integer ano = scanner.nextInt();
                        scanner.nextLine();
                        turma.setAno(ano);
                        break;
                    }
                    case 2:{
                        System.out.println("Período: ");
                        Integer periodo = scanner.nextInt();
                        scanner.nextLine();
                        turma.setPeriodo(periodo);
                        break;
                    }
                    case 3:{
                        System.out.println("Local: ");
                        String local = scanner.nextLine();
                        turma.setLocal(local);
                        break;
                    }
                    case 4:{
                        System.out.println("Horário: ");
                        String horario = scanner.nextLine();
                        turma.setHorario(horario);
                        break;
                    }
                    case 5:{
                        System.out.println("Número de vagas: ");
                        Integer numVagas = scanner.nextInt();
                        scanner.nextLine();
                        turma.setNumeroDeVagas(numVagas);
                        break;
                    }
                    default:{
                    }
                }
            }
            daoTurma.alterar(em, turma);
            System.out.println("Alteração efetuada com sucesso.");
        }else
            System.out.println("Turma não cadastrada (ID inválido).");
    }
    
    public void imprimir (List<?> lista){
        for(Object objeto: lista)
            System.out.println(objeto);
    }
    
    public void listar(EntityManager em) {
        if(daoTurma.obterTodos(em).isEmpty()){
            System.out.println("Não existem turmas cadastradas.");
            return;
        }
        System.out.println("Lista de turmas cadastradas: ");
        this.imprimir(daoTurma.obterTodos(em));
    }
    
    public void matricularAluno (EntityManager em){
        System.out.println("Informe o CPF do aluno: ");
        Aluno aluno = daoAluno.buscar(em, scanner.nextLine());
        if (aluno != null){
            if (daoTurma.obterTodos(em).isEmpty()){
                System.out.println("Não existem turmas cadastradas.");
                return;
            }
            System.out.println("Lista de turmas cadastradas:");
            this.imprimir(daoTurma.obterTodos(em));
            System.out.println("Informe o ID da turma na qual será efetuada a matrícula:");
            Turma turma = daoTurma.buscar(em, scanner.nextInt());
            scanner.nextLine();
            if (turma != null){
                if (turma.adicionarAluno(aluno)){
                    daoTurma.alterar(em, turma);
                    System.out.println("Matrícula efetuada com sucesso.");
                }else 
                    if (turma.getNumeroDeVagas() > turma.getAluno().size())
                        System.out.println("Esse aluno já está matriculado em uma turma dessa disciplina.");
                    else
                        System.out.println("Não há vagas disponíveis nessa turma.");
            }else
                System.out.println("Turma não encontrada.");
        }else
            System.out.println("Aluno não encontrado.");
    }
    
    public void imprimirSituacaoAluno (Aluno aluno, Turma turma){
        System.out.println("Aluno: " + aluno.getNome() + aluno.getCpf());
        System.out.println("Notas: ");
        for (Atividade atividade : turma.getAtividade()){
            for (Nota nota: atividade.getNota())
                if (nota.getAluno().equals(aluno)){
                    System.out.println("Atividade " + atividade.getNome() + ":" + nota.getNota());
                    break;
                }
        }
        System.out.println("Nota Final: " + aluno.notaFinal(turma));
        for (Falta falta : aluno.getFalta())
            if (falta.getTurma().equals(turma)){
                System.out.println("Faltas: " + falta.getFalta());
                break;
            }
    }
    
    public void consultarTurma (EntityManager em){
        List<Turma> listaTurma = daoTurma.obterTodos(em);
        if (!listaTurma.isEmpty()){
            System.out.println("Disciplina: ");
            String disciplina = scanner.nextLine();
            System.out.println("Ano:");
            Integer ano = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Período:");
            Integer periodo = scanner.nextInt();
            scanner.nextLine();
            for (Turma turma : listaTurma)
                if (turma.getDisciplina().getNome().equals(disciplina) && turma.getAno().equals(ano) &&
                        turma.getPeriodo().equals(periodo)){
                    System.out.println("Turma " + turma.getId() + ":");
                    for (Aluno aluno : turma.getAluno())
                        this.imprimirSituacaoAluno(aluno, turma);
                }else
                    System.out.println("Não há turmas com essas especificações.");
        }else
            System.out.println("Não há turmas cadastradas.");
    }
    
    public void consultarSituacaoAluno (EntityManager em){
        System.out.println("Informe o CPF do aluno: ");
        Aluno aluno = daoAluno.buscar(em, scanner.nextLine());
        if (aluno != null){
            System.out.println("Informe o nome da disciplina: ");
            Disciplina disciplina = daoDisciplina.buscar(em, scanner.nextLine());
            if (disciplina != null){
                Boolean aux = false;
                Boolean aprovado = true;
                if (!disciplina.getTurma().isEmpty()){
                    for (Turma turma : disciplina.getTurma()){
                        if (turma.getAluno().contains(aluno)){
                            this.imprimirSituacaoAluno(aluno, turma);
                            for(Falta falta : aluno.getFalta())
                                if (falta.getTurma().equals(turma) && 
                                    (falta.getFalta()/disciplina.getCargaHoraria()) > 0.25){
                                    aprovado = false;
                                    break;
                                }
                            if (aluno.notaFinal(turma) < 6)
                                aprovado = false;
                            if (aprovado)
                                System.out.println("Aluno aprovado.");
                            else
                                System.out.println("Aluno reprovado.");
                            aux = true;
                            break;
                        }
                    }
                    if (!aux)
                        System.out.println("O aluno não está matriculado em nenhuma turma dessa disciplina.");
                }else
                    System.out.println("Não há turmas dessa disciplina.");
            }else
                System.out.println("Disciplina não encontrada.");
        }else
            System.out.println("Aluno não encontrado.");
    }
}