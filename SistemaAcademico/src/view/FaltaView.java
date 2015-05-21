package view;

import java.util.List;
import java.util.Scanner;
import model.dao.AlunoDaoImpl;
import model.dao.Dao;
import model.dao.FaltaDaoImpl;
import model.dao.TurmaDaoImpl;
import model.pojo.Aluno;
import model.pojo.Falta;
import model.pojo.Turma;

/**
 *
 * @author Filipe
 */
public class FaltaView {
    //private Dao faltaDao;
    //private Dao turmaDao;
    //private Dao alunoDao;
    private static Scanner scanner = new Scanner (System.in);
    
    public Boolean cadastrar () {
        System.out.println("CADASTRO DE FALTA");
        while (true) {
            System.out.println("Aluno:");
            Aluno aluno = (Aluno) this.obterCadastrado(AlunoDaoImpl.getInstancia());
            if (aluno == null)
                return false;
            System.out.println("Turma:");
            Turma turma = (Turma) this.obterCadastrado(TurmaDaoImpl.getInstancia());
            if (turma == null)
                return false;
            if (turma.getAluno().contains(aluno)) {
                System.out.println("\nAtualize o registro de faltas do aluno:\n");
                System.out.println("ID: ");
                String id = scanner.nextLine();
                System.out.println("Número de faltas: ");
                Integer numeroDeFalta = scanner.nextInt();
                Falta falta = new Falta (id, numeroDeFalta,turma);
                return FaltaDaoImpl.getInstancia().inserir(falta);
                //return this.faltaDao.inserir(falta);
            }
            else
                System.out.println("ESTE ALUNO NÃO ESTÁ MATRICULADO NA TURMA INFORMADA! TENTE NOVAMENTE\n");
        }
    }

    public void pesquisar () {
        System.out.println("PESQUISAR REGISTROS DE FALTA \nEntre com o ID da Falta: ");
        String id = scanner.nextLine();
        if(FaltaDaoImpl.getInstancia().indice(id) != -1)
            System.out.println(FaltaDaoImpl.getInstancia().obter(id).toString());
        //if (this.faltaDao.indice(id) != -1)
        //    System.out.println(this.faltaDao.obter(id).toString());
        else
            System.out.println("FALTA NÃO ENCONTRADA!"); 
    }

    public void remover(){
        System.out.println("REMOVER REGISTRO DE FALTA\nEntre com o ID da Falta: ");
        String id = scanner.nextLine();
        if(FaltaDaoImpl.getInstancia().remover(FaltaDaoImpl.getInstancia().obter(id)))
        //if (faltaDao.remover(faltaDao.obter(id)))
            System.out.println("FALTA REMOVIDA COM SUCESSO!");                
        else
            System.out.println("FALTA NÃO ENCONTRADA, REMOÇÃO NÃO EFETUADA!\n");
    }

    public void listar () {
        System.out.println("LISTA DE FALTAS DISPONÍVEIS\n");
        List<Falta> listaFalta = (List<Falta>) (Falta) FaltaDaoImpl.getInstancia().obterTodos();
        //List<Falta> listaFalta = (List<Falta>) (Falta) faltaDao.obterTodos();
        for (Falta falta: listaFalta) {
            System.out.println(falta.toString() + "\n");
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
}
