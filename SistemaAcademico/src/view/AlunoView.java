package view;

import java.util.List;
import java.util.Scanner;
import model.dao.AlunoDao;
import model.pojo.Aluno;

public class AlunoView {
    private AlunoDao alunoDao;
   private static final Scanner scanner = new Scanner (System.in);
    private Object aluno;
    
        public Boolean cadastrar () {
            System.out.println("CADASTRO DE Alunos\nCadastre um novo aluno:\n");
            System.out.println("CPF: ");
            String cpf = scanner.nextLine();
            System.out.println("Nome do aluno: ");
            String nomeDoAluno = scanner.nextLine();
            
            // falta fazer os objetos;
            Aluno aluno = new Aluno (nomeDoAluno, cpf);
            return this.alunoDao.salvar(aluno);
        }
        
        public void pesquisar () {
           System.out.println("PESQUISA DE ALUNO\nEntre com o CPF da aluno: ");
            String cpf = scanner.nextLine();
            if (this.alunoDao.indiceAluno(cpf) != -1)
                System.out.println(this.alunoDao.obterAluno(cpf).toString());
            else
                System.out.println("ALUNO NÃO ENCONTRADO!"); 
        }
        
        public void remover(){
            System.out.println("REMOÇÃO DE ALUNO\nEntre com o CPF do Aluno: ");
            String cpf = scanner.nextLine();
            if (alunoDao.remover(alunoDao.obterAluno(cpf)))
                System.out.println("ALUNO REMOVIDO COM SUCESSO!");                
            else
                System.out.println("ALUNO NÃO ENCONTRADO!");
        }
        
        public void listar () {
            System.out.println("LISTA DE ATIVIDADES DISPONÍVEIS\n");
            List<Aluno> listaAluno = alunoDao.obterTodos();
            for (Aluno atividade: listaAluno) {
                System.out.println(aluno.toString() + "\n");
            }
        }
    
}
