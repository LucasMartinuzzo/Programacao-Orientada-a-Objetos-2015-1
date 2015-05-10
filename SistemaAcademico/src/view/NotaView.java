/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import java.util.Scanner;
import model.dao.AlunoDao;
import model.dao.AtividadeDao;
import model.dao.NotaDao;
import model.pojo.Aluno;
import model.pojo.Atividade;
import model.pojo.Nota;

/**
 *
 * @author Filipe
 */
public class NotaView {
    private NotaDao notaDao;
    private AlunoDao alunoDao;
    private AtividadeDao atividadeDao;
    
    private static Scanner scanner = new Scanner (System.in);
            
    public Boolean cadastrar () {
        System.out.println("CADASTRO DE NOTAS\nCadastre uma nova nota:\n");
        System.out.println("ID: ");
        String id = scanner.nextLine();
        System.out.println("Nota: ");
        Double ValorDaNota = scanner.nextDouble();
        Aluno aluno = this.obterCadastrado();
        if (aluno == null)
            return false;
        Atividade atividade = this.obterCadastrada();
        if (atividade == null)
            return false;

        Nota nota = new Nota (id, ValorDaNota, aluno, atividade );
        return this.notaDao.salvar(nota);
    }

   public void pesquisar () {
       System.out.println("PESQUISAR NOTA \nEntre com o ID da Nota: ");
        String id = scanner.nextLine();
        if (this.notaDao.indiceNota(id) != -1)
            System.out.println(this.notaDao.obterNota(id).toString());
        else
            System.out.println("NOTA NÃO ENCONTRADA!"); 
    }

    public void remover(){
        System.out.println("REMOVER NOTA\nEntre com o ID da Nota: ");
        String id = scanner.nextLine();
        if (notaDao.remover(notaDao.obterNota(id)))
            System.out.println("NOTA REMOVIDA COM SUCESSO!");                
        else
            System.out.println("NOTA NÃO ENCONTRADA!");
    }

    public void listar () {
        System.out.println("LISTA DE NOTAS DISPONÍVEIS\n");
        List<Nota> listaAluno = notaDao.obterTodos();
        for (Nota nota: listaAluno) {
            System.out.println(nota.toString() + "\n");
        }
    }
    public Atividade obterCadastrada () {
    while (true) {
        System.out.println("Atividade: ");
        String entrada = scanner.nextLine();
        if (entrada.equals("cancelar"))
            break;
        Atividade atividade = this.atividadeDao.obterAtividade(entrada);
        if (atividade != null)
            return atividade;
        else {
            System.out.println("ESTA ATIVIDADE NÃO ESTÁ CADASTRADA!");
            System.out.println("Digite novamente (''cancelar'' para cancelar): ");
        }
    }
    return null;
    }
    
    public Aluno obterCadastrado () {
        while (true) {
            System.out.println("Aluno: ");
            String entrada = scanner.nextLine();
            if (entrada.equals("cancelar"))
                break;
            Aluno aluno = this.alunoDao.obterAluno(entrada);
            if (aluno != null)
                return aluno;
            else {
                System.out.println("ESTE ALUNO NÃO ESTÁ CADASTRADO!");
                System.out.println("Digite novamente (''cancelar'' para cancelar): ");
            }
        }
        return null;
    }
}
