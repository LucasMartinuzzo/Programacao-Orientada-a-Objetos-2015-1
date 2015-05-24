/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Collections;
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
        System.out.println("CADASTRO DE NOTAS");
        System.out.println("Atividade (ID):");
        Atividade atividade = (Atividade) this.obterCadastrado(AtividadeDaoImpl.getInstancia());
        if (atividade == null)
            return false;
        
        for (Aluno aluno: atividade.getTurma().getAluno()) {
            Collections.sort(aluno.getNota(), new Atividade());
            if (Collections.binarySearch(aluno.getNota(), new Nota (null, null, null, atividade),
                    new Atividade()) <= -1) {
                System.out.println("\nAtualize a nota do aluno abaixo nessa atividade:\n");
                System.out.println(aluno.toString() + "\n");
                String id = this.validarId();
                if (id == null) {
                    System.out.println("\nO registro de notas da atividade ainda não foi concluído"
                            + " para todos os alunos. Você pode retomar a operação a qualquer momento.");
                    return true;
                }
                System.out.println("Nota:");
                Double valorDaNota = scanner.nextDouble();
                scanner.nextLine();
                Nota nota = new Nota (id, valorDaNota, aluno, atividade);
                aluno.getNota().add(nota);
                //aluno.adicionarNota(nota);
                atividade.getNota().add(nota);
                //atividade.adicionarNota(nota);
                NotaDaoImpl.getInstancia().inserir(nota);
                //this.notaDao.inserir(nota);
            }
        }
        return true;
    }

   public void pesquisar () {
       System.out.println("PESQUISA DE NOTAS \nEntre com o ID da Nota: ");
        String id = scanner.nextLine();
        if(NotaDaoImpl.getInstancia().indice(id) >= 0)
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
        List<Nota> listaAluno = (List<Nota>) NotaDaoImpl.getInstancia().obterTodos();
        //List<Nota> listaAluno = (List<Nota>) (Nota) notaDao.obterTodos();
        for (Nota nota: listaAluno) {
            System.out.println(nota.toString() + "\n");
        }
    }
    
    public String validarId () {
        while (true) {
            System.out.println("ID (''cancelar'' para cancelar): ");
            String id = scanner.nextLine();
            if (id.equals("cancelar"))
                break;
            if (NotaDaoImpl.getInstancia().indice(id) <= -1)
                return id;
            else
                System.out.println("\nUMA NOTA COM ESTE ID JÁ ESTÁ CADASTRADA! TENTE NOVAMENTE!\n");
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
