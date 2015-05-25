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
        String cpf = this.validarId();
        if (cpf == null)
            return false;
        Aluno aluno = new Aluno (nome, cpf);
        return AlunoDaoImpl.getInstancia().inserir(aluno);
       
        //return this.alunoDao.inserir(aluno);
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
        List<Aluno> listaAluno = (List<Aluno>) AlunoDaoImpl.getInstancia().obterTodos();
        //List<Aluno> listaAluno = (List<Aluno>) (Aluno) alunoDao.obterTodos();
        for (Aluno aluno: listaAluno) {
            System.out.println(aluno.toString() + "\n");
        }
    }
    
    public String validarId () {
        while (true) {
            System.out.println("CPF (''cancelar'' para cancelar): ");
            String id = scanner.nextLine();
            if (id.equals("cancelar"))
                break;
            if (AlunoDaoImpl.getInstancia().indice(id) <= -1)
                return id;
            else
                System.out.println("\nUM(A) ALUNO(A) COM ESTE CPF JÁ ESTÁ CADASTRADO(A)!"
                        + " TENTE NOVAMENTE!\n");
        }
        return null;
    }
}