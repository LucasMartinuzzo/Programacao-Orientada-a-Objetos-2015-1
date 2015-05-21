/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import java.util.Scanner;
import model.dao.AlunoDaoImpl;
import model.dao.AtividadeDaoImpl;
import model.dao.Dao;
import model.dao.NotaDaoImpl;
import model.pojo.Aluno;
import model.pojo.Atividade;
import model.pojo.Nota;

/**
 *
 * @author Filipe
 */
public class NotaView {
    //private Dao notaDao;
    //private Dao alunoDao;
    //private Dao atividadeDao;
    
    private static Scanner scanner = new Scanner (System.in);
            
    public Boolean cadastrar () {
        System.out.println("CADASTRO DE NOTAS\nCadastre uma nova nota:\n");
        System.out.println("ID: ");
        String id = scanner.nextLine();
        System.out.println("Nota: ");
        Double valorDaNota = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Aluno (ID: CPF):");
        Aluno aluno = (Aluno) this.obterCadastrado(AlunoDaoImpl.getInstancia());
        if (aluno == null)
            return false;
        System.out.println("Atividade:");
        Atividade atividade = (Atividade) this.obterCadastrado(AtividadeDaoImpl.getInstancia());
        if (atividade == null)
            return false;

        Nota nota = new Nota (id, valorDaNota, aluno, atividade );
        return NotaDaoImpl.getInstancia().inserir(nota);
        //return this.notaDao.inserir(nota);
    }

   public void pesquisar () {
       System.out.println("PESQUISA DE NOTAS \nEntre com o ID da Nota: ");
        String id = scanner.nextLine();
        if(NotaDaoImpl.getInstancia().indice(id) != -1)
            System.out.println(NotaDaoImpl.getInstancia().obter(id).toString());
        //if (this.notaDao.indice(id) != -1)
        //    System.out.println(this.notaDao.obter(id).toString());
        else
            System.out.println("NOTA NÃO ENCONTRADA!\n"); 
    }

    public void remover(){
        System.out.println("REMOÇÃO DE NOTAS\nEntre com o ID da Nota: ");
        String id = scanner.nextLine();
        if(NotaDaoImpl.getInstancia().remover(NotaDaoImpl.getInstancia().obter(id)))
        //if (notaDao.remover(notaDao.obter(id)))
            System.out.println("NOTA REMOVIDA COM SUCESSO!");                
        else
            System.out.println("NOTA NÃO ENCONTRADA, REMOÇÃO NÃO EFETUADA!\n");
    }

    public void listar () {
        System.out.println("LISTA DE NOTAS DISPONÍVEIS\n");
        List<Nota> listaAluno = (List<Nota>) (Nota) NotaDaoImpl.getInstancia().obterTodos();
        //List<Nota> listaAluno = (List<Nota>) (Nota) notaDao.obterTodos();
        for (Nota nota: listaAluno) {
            System.out.println(nota.toString() + "\n");
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
