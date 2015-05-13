
package view;

import java.util.List;
import java.util.Scanner;
import model.dao.AtividadeDao;
import model.dao.TurmaDao;
import model.pojo.Atividade;
import model.pojo.Turma;


/**
 *
 * @author Mônicka
 */
public class AtividadeView {
    private AtividadeDao atividadeDao;
    private static Scanner scanner = new Scanner (System.in);
    private TurmaDao turmaDao;


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
        Turma turma = this.obterCadastrada();
        if(turma == null)
            return false;
        Atividade atividade = new Atividade (id, nome, tipo, data, valor, turma);
        return this.atividadeDao.salvar(atividade);
    }

    public void pesquisar () {
        System.out.println("PESQUISA DE ATIVIDADES\nEntre com o ID da atividade: ");
        String id = scanner.nextLine();
        if (this.atividadeDao.indiceAtividade(id) != -1)
            System.out.println(this.atividadeDao.obterAtividade(id).toString());
        else
            System.out.println("ATIVIDADE NÃO ENCONTRADA!");
    }


    public Turma obterCadastrada () {
    while (true) {
        System.out.println("Turma: ");
        String entrada = scanner.nextLine();
        if (entrada.equals("cancelar"))
            break;
        Turma turma = this.turmaDao.obterTurma(entrada);
        if (turma != null)
            return turma;
        else {
            System.out.println("ESTA TURMA NÃO ESTÁ CADASTRADA!");
            System.out.println("Digite novamente (''cancelar'' para cancelar): ");
        }
    }
    return null;
}



    public void remover(){
        System.out.println("REMOÇÃO DE ATIVIDADE\nEntre com o ID da atividade: ");
        String id = scanner.nextLine();
        if (atividadeDao.remover(atividadeDao.obterAtividade(id)))
            System.out.println("ATIVIDADE REMOVIDA COM SUCESSO!");                
        else
            System.out.println("ATIVIDADE NÃO ENCONTRADA!");
    }

    public void listar () {
        System.out.println("LISTA DE ATIVIDADES DISPONÍVEIS\n");
        List<Atividade> listaAtividade = atividadeDao.obterTodas();
        for (Atividade atividade: listaAtividade) {
            System.out.println(atividade.toString() + "\n");
        }
    }
}
