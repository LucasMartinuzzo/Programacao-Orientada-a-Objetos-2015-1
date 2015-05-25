package view;

import java.util.ArrayList;
import java.util.Collections;
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
        System.out.println("CADASTRO DE FALTAS");
        System.out.println("Turma (ID):");
        Turma turma = (Turma) this.obterCadastrado(TurmaDaoImpl.getInstancia());
        if (turma == null)
            return false;
        if (!turma.faltasLancadas()) {
            for (Aluno aluno: turma.getAluno()) {
                Collections.sort(aluno.getFalta(), new Falta());
                if (Collections.binarySearch(aluno.getFalta(), new Falta (null, null, turma),
                        new Falta()) <= -1) {
                    System.out.println("\nAtualize o registro de faltas do aluno abaixo:\n");
                    System.out.println(aluno.toString() + "\n");
                    String id = this.validarId();
                    if (id == null) {
                        System.out.println("\nO registro de faltas ainda não foi concluído para todos os"
                                + " alunos da turma. Você pode retomar a operação a qualquer momento.");
                        return true;
                    }
                    System.out.println("Número de faltas: ");
                    Integer numeroDeFalta = scanner.nextInt();
                    scanner.nextLine();
                    Falta falta = new Falta (id, numeroDeFalta, turma);
                    aluno.getFalta().add(falta);
                    //aluno.adicionarFalta(falta);
                    FaltaDaoImpl.getInstancia().inserir(falta);
                    //this.faltaDao.inserir(falta);
                }
            }
            return true;
        }
        else {
            System.out.println("\nAS FALTAS CORRESPONDENTES AOS ALUNOS DESTA TURMA JÁ FORAM LANÇADAS!");
            return false;
        }
    }

    public void pesquisar () {
        System.out.println("PESQUISA DE REGISTROS DE FALTA \nEntre com o ID da Falta: ");
        String id = scanner.nextLine();
        if(FaltaDaoImpl.getInstancia().indice(id) != -1)
            System.out.println(FaltaDaoImpl.getInstancia().obter(id).toString());
        //if (this.faltaDao.indice(id) != -1)
        //    System.out.println(this.faltaDao.obter(id).toString());
        else
            System.out.println("FALTA NÃO ENCONTRADA!\n"); 
    }

    public void remover(){
        System.out.println("REMOÇÃO DE REGISTROS DE FALTA\nEntre com o ID da Falta: ");
        String id = scanner.nextLine();
        if(FaltaDaoImpl.getInstancia().remover(FaltaDaoImpl.getInstancia().obter(id)))
        //if (faltaDao.remover(faltaDao.obter(id)))
            System.out.println("FALTA REMOVIDA COM SUCESSO!");                
        else
            System.out.println("FALTA NÃO ENCONTRADA, REMOÇÃO NÃO EFETUADA!\n");
    }

    public void listar () {
        System.out.println("LISTA DE FALTAS DISPONÍVEIS\n");
        List<Falta> listaFalta = (List<Falta>) FaltaDaoImpl.getInstancia().obterTodos();
        //List<Falta> listaFalta = (List<Falta>) (Falta) faltaDao.obterTodos();
        for (Falta falta: listaFalta) {
            System.out.println(falta.toString() + "\n");
        }
    }
    
    public String validarId () {
        while (true) {
            System.out.println("ID (''cancelar'' para cancelar o lançamento de faltas para todos os"
                    + " alunos desta turma): ");
            String id = scanner.nextLine();
            if (id.equals("cancelar"))
                break;
            if (FaltaDaoImpl.getInstancia().indice(id) <= -1)
                return id;
            else
                System.out.println("\nUM REGISTRO DE FALTAS COM ESTE ID JÁ ESTÁ CADASTRADO!"
                        + " TENTE NOVAMENTE!\n");
        }
        return null;
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
