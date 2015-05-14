package view;

import java.util.List;
import java.util.Scanner;
import model.dao.Dao;
import model.pojo.Falta;
import model.pojo.Turma;

/**
 *
 * @author Filipe
 */
public class FaltaView {
    private Dao faltaDao;
    private Dao turmaDao;
    private static Scanner scanner = new Scanner (System.in);
    
    public Boolean cadastrar () {
        System.out.println("CADASTRO DE FALTA\nCadastre uma nova falta:\n");
        System.out.println("ID: ");
        String id = scanner.nextLine();
        System.out.println("Falta: ");
        Integer numeroDeFalta = scanner.nextInt();
        System.out.println("Turma:");
        Turma turma = (Turma) this.obterCadastrado(this.turmaDao);
        if (turma == null)
            return false;

        Falta falta = new Falta (id, numeroDeFalta,turma);
        return this.faltaDao.salvar(falta);
    }

    public void pesquisar () {
        System.out.println("PESQUISAR REGISTROS DE FALTA \nEntre com o ID da Falta: ");
        String id = scanner.nextLine();
        if (this.faltaDao.indice(id) != -1)
            System.out.println(this.faltaDao.obter(id).toString());
        else
            System.out.println("FALTA NÃO ENCONTRADA!"); 
    }

    public void remover(){
        System.out.println("REMOVER REGISTRO DE FALTA\nEntre com o ID da Falta: ");
        String id = scanner.nextLine();
        if (faltaDao.remover(faltaDao.obter(id)))
            System.out.println("FALTA REMOVIDA COM SUCESSO!");                
        else
            System.out.println("FALTA NÃO ENCONTRADA!");
    }

    public void listar () {
        System.out.println("LISTA DE FALTAS DISPONÍVEIS\n");
        List<Falta> listaAluno = (List<Falta>) (Falta) faltaDao.obterTodos();
        for (Falta falta: listaAluno) {
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
