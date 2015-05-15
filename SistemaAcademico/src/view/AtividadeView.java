package view;

import java.util.List;
import java.util.Scanner;
import model.dao.Dao;
import model.pojo.Atividade;
import model.pojo.Turma;


/**
 *
 * @author Mônicka
 */
public class AtividadeView {
    private Dao atividadeDao;
    private Dao turmaDao;
    private static Scanner scanner = new Scanner (System.in);

    public Boolean cadastrar () {
        System.out.println("CADASTRO DE ATIVIDADES\nCadastre uma nova atividade:\n");
        System.out.println("ID: ");
        String id = scanner.nextLine();
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Tipo: ");
        String tipo = scanner.nextLine();
        System.out.println("Data(DD/MM/AAAA): ");
        String data = scanner.nextLine();
        System.out.println("Valor: ");
        Double valor = scanner.nextDouble();
        System.out.println("Turma:");
        Turma turma = (Turma) this.obterCadastrado(this.turmaDao);
        if(turma == null)
            return false;
        Atividade atividade = new Atividade (id, nome, tipo, data, valor, turma);
        return this.atividadeDao.inserir(atividade);
    }

    public void pesquisar () {
        System.out.println("PESQUISA DE ATIVIDADES\nEntre com o ID da atividade: ");
        String id = scanner.nextLine();
        if (this.atividadeDao.indice(id) != -1)
            System.out.println(this.atividadeDao.obter(id).toString());
        else
            System.out.println("ATIVIDADE NÃO ENCONTRADA!");
    }

    public void remover(){
        System.out.println("REMOÇÃO DE ATIVIDADE\nEntre com o ID da atividade: ");
        String id = scanner.nextLine();
        if (atividadeDao.remover(atividadeDao.obter(id)))
            System.out.println("ATIVIDADE REMOVIDA COM SUCESSO!");                
        else
            System.out.println("ATIVIDADE NÃO ENCONTRADA, REMOÇÃO NÃO EFETUADA!\n");
    }

    public void listar () {
        System.out.println("LISTA DE ATIVIDADES DISPONÍVEIS\n");
        List<Atividade> listaAtividade = (List<Atividade>) (Atividade) atividadeDao.obterTodos();
        for (Atividade atividade: listaAtividade) {
            System.out.println(atividade.toString() + "\n");
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
