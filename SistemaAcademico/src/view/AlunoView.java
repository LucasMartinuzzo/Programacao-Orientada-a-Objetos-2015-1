package view;

import java.util.List;
import java.util.Scanner;
import model.dao.AlunoDao;
import model.pojo.Aluno;

public class AlunoView {
    private AlunoDao alunoDao;
    
        public Boolean cadastrar () {
            System.out.println("CADASTRO DE Alunos\nCadastre um novo aluno:\n");
            Scanner scanner = new Scanner(System.in);
            System.out.println("CPF: ");
            String cpf = scanner.nextLine();
            System.out.println("Nome do aluno: ");
            String nomeDoAluno = scanner.nextLine();
            
            // falta fazer os objetos;
            Aluno aluno = new Aluno (cpf, nomeDoAluno);
            return this.alunoDao.salvar(aluno);
        }
        
       /* public void pesquisar () {
            
        }
        
        public void listar () {
            List<Aula> listaAula = aulaDao.obterTodas();
            for (Aula aula: listaAula) {
                aula.toString();
            }*/
        }
    
    
}
