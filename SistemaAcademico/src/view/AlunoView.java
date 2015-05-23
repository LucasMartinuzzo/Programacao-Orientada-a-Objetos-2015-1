package view;

import java.util.List;
import java.util.Scanner;
import model.dao.AlunoDaoImpl;
import model.dao.Dao;
import model.dao.DisciplinaDaoImpl;
import model.dao.TurmaDaoImpl;
import model.pojo.Aluno;
import model.pojo.Disciplina;
import model.pojo.Falta;
import model.pojo.Turma;


public class AlunoView {
    //private Dao alunoDao;
    private static Scanner scanner = new Scanner (System.in);
    //private Dao disciplinaDao;
        
    public Boolean cadastrar () {
        System.out.println("CADASTRO DE ALUNOS\nCadastre um novo aluno:\n");
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("CPF: ");
        String cpf = scanner.nextLine();
        Aluno aluno = new Aluno (nome, cpf);
        return AlunoDaoImpl.getInstancia().inserir(aluno);
       
        //return this.alunoDao.inserir(aluno);
    }
    
    
    public Boolean matricularAluno(){
        System.out.println("MATRÍCULA DE ALUNOS\nMatricule um aluno:\n");
        System.out.println("Informe o CPF do aluno: ");
        Aluno aluno = (Aluno) AlunoDaoImpl.getInstancia().obter(scanner.nextLine());
        if (aluno != null) {
            System.out.println("Informe a turma na qual será efetuada a matrícula: ");
            Turma turma = (Turma) TurmaDaoImpl.getInstancia().obter(scanner.nextLine());
            if(turma != null)
                return turma.adicionarAluno(aluno);
        }
        return false;
    }

    public void pesquisar () {
        System.out.println("PESQUISA DE ALUNOS\nEntre com o CPF do aluno: ");
        String cpf = scanner.nextLine();
        if(AlunoDaoImpl.getInstancia().indice(cpf) != -1)
            System.out.println(AlunoDaoImpl.getInstancia().obter(cpf).toString());
        //if (this.alunoDao.indice(cpf) != -1)
            //System.out.println(this.alunoDao.obter(cpf).toString());
        else
            System.out.println("ALUNO NÃO ENCONTRADO!\n"); 
    }

    public void remover(){
        System.out.println("REMOÇÃO DE ALUNOS\nEntre com o CPF do aluno: ");
        String cpf = scanner.nextLine();
        if(AlunoDaoImpl.getInstancia().remover(AlunoDaoImpl.getInstancia().obter(cpf)))
        //if (alunoDao.remover(alunoDao.obter(cpf)))
            System.out.println("ALUNO REMOVIDO COM SUCESSO!");                
        else
            System.out.println("ALUNO NÃO ENCONTRADO, REMOÇÃO NÃO EFETUADA!\n");
    }

    public void listar () {
        System.out.println("LISTA DE ALUNOS DISPONÍVEIS\n");
        List<Aluno> listaAluno = (List<Aluno>) (Aluno) AlunoDaoImpl.getInstancia().obterTodos();
        //List<Aluno> listaAluno = (List<Aluno>) (Aluno) alunoDao.obterTodos();
        for (Aluno aluno: listaAluno) {
            System.out.println(aluno.toString() + "\n");
        }
    }
    
    public Boolean consultarSituacaoAluno(){
        System.out.println("Informe o cpf do aluno: ");
        Aluno aluno = (Aluno) AlunoDaoImpl.getInstancia().obter(scanner.nextLine());
        System.out.println("Informe o nome da disciplina: ");
        Disciplina disciplina = (Disciplina) DisciplinaDaoImpl.getInstancia().obter(scanner.nextLine());
        //Disciplina disciplina = (Disciplina) this.disciplinaDao.obter(scanner.nextLine());
        if(disciplina != null && aluno != null){
            for(Turma turma : disciplina.getTurma()){
                for(Aluno alunoConsultado : turma.getAluno()){
                    if(alunoConsultado.equals(aluno)){
                        aluno.toString();
                        for(Falta faltaConsultada : aluno.getFalta()){
                            if(faltaConsultada.getTurma().equals(turma)){
                                System.out.println("Falta: " + faltaConsultada.getFalta());
                                System.out.println("Nota: " + aluno.NotaFinal(turma));
                                if(((faltaConsultada.getFalta()/disciplina.getCargaHoraria())<=0.25)
                                        && (aluno.NotaFinal(turma)<6))
                                    System.out.println("Aluno aprovado!");
                                else
                                    System.out.println("Aluno não aprovado!");
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

}


