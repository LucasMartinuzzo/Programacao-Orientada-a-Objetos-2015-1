package view;

import java.util.List;
import java.util.Scanner;
import model.dao.Dao;
import model.pojo.Disciplina;

/**
 *
 * @author Lucas
 */
public class DisciplinaView {
    private Dao disciplinaDao;
    private static Scanner scanner = new Scanner (System.in);
    
    public Boolean cadastrar(){
        System.out.println("CADASTRO DE DISCIPLINAS\nCadastre uma nova disciplina:\n");
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Ementa: ");
        String ementa = scanner.nextLine();
        System.out.println("Carga Horária: ");
        Integer cargaHoraria = scanner.nextInt();
        Disciplina disciplina = new Disciplina(nome, ementa, cargaHoraria);
        return this.disciplinaDao.inserir(disciplina);
    }
    public void pesquisar () {
        System.out.println("PESQUISA DE DISCIPLINAS\nEntre com o nome da disciplina: ");
            String nome = scanner.nextLine();
            if (this.disciplinaDao.indice(nome) != -1)
                System.out.println(this.disciplinaDao.obter(nome).toString());
            else
                System.out.println("DISCIPLINA NÃO ENCONTRADA!");
        }
    public void remover(){
        System.out.println("REMOÇÃO DE DISCIPLINA\nEntre com o nome da Disciplina: ");
        String nome = scanner.nextLine();
        if (disciplinaDao.remover(disciplinaDao.obter(nome)))
            System.out.println("DISCIPLINA REMOVIDA COM SUCESSO!");                
        else
            System.out.println("DISCIPLINA NÃO ENCONTRADA, REMOÇÃO NÃO EFETUADA!");
    }
    public void listar () {
        System.out.println("LISTA DE DISCIPLINAS DISPONÍVEIS\n");
        List<Disciplina> listaDisciplina = (List<Disciplina>) (Disciplina) disciplinaDao.obterTodos();
        for(Disciplina disc: listaDisciplina) {
            System.out.println(disc.toString() + "\n");
        }
    }
}
