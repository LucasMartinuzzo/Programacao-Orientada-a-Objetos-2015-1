package view;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import model.dao.AtividadeDaoImpl;
import model.dao.TurmaDaoImpl;
import model.dao.Dao;
import model.pojo.Atividade;
import model.pojo.Turma;

public class AtividadeView {

    private static Scanner scanner = new Scanner (System.in);
    private AtividadeDaoImpl daoAtividade = AtividadeDaoImpl.getInstancia();
    private TurmaDaoImpl daoTurma = TurmaDaoImpl.getInstancia();
    
    public void cadastrar (EntityManager em){
        System.out.println("CADASTRO DE ATIVIDADE");
        if (daoTurma.obterTodos(em).isEmpty()){
            System.out.println("Não existem turmas cadastradas.");
            return;
        }
        System.out.println("Lista de turmas cadastradas: ");
        this.imprimir(daoTurma.obterTodos(em));
        System.out.println("Turma (ID): ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        Turma turma = daoTurma.buscar(em, id);
        if (turma != null){
            System.out.println("Nome: ");
            String nome = scanner.nextLine();
            System.out.println("Tipo: ");
            String tipo = scanner.nextLine();
            System.out.println("Data (DD/MM): ");
            String data = scanner.nextLine();
            System.out.println("Valor: ");
            Double valor = scanner.nextDouble();
            scanner.nextLine();
            Atividade atividade = new Atividade (nome, tipo, data, valor, turma);
            turma.getAtividade().add(atividade);
            daoAtividade.salvar(em, atividade);
            daoTurma.alterar(em, turma);
            System.out.println ("Cadastro efetuado com sucesso.");
        }else
            System.out.println("Turma não cadastrada (ID inválido).");
    }
    
    public void alterar (EntityManager em){
        System.out.println("ALTERAÇÃO DE ATIVIDADE");
        this.listar(em);
        System.out.println("Atividade (ID): ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        Atividade atividade = daoAtividade.buscar(em, id);
        if(atividade != null){
            Integer opcao = 1; 
            while(opcao >= 1 && opcao <= 4){
                System.out.println("Atualize os dados da atividade.");
                System.out.println("1 - Alterar nome");
                System.out.println("2 - Alterar tipo");
                System.out.println("3 - Alterar data");
                System.out.println("4 - Alterar valor");
                System.out.println("Outro - Finalizar");
                opcao = scanner.nextInt();
                scanner.nextLine();
                switch(opcao) {
                    case 1:{
                        System.out.println("Nome: ");
                        String nome = scanner.nextLine();
                        atividade.setNome(nome);
                        break;
                    }
                    case 2:{
                        System.out.println("Tipo: ");
                        String tipo = scanner.nextLine();
                        atividade.setTipo(tipo);
                        break;
                    }
                    case 3:{
                        System.out.println("Data: ");
                        String data = scanner.nextLine();
                        atividade.setData(data);
                        break;
                    }
                    case 4:{
                        System.out.println("Valor: ");
                        Double valor = scanner.nextDouble();
                        scanner.nextLine();
                        atividade.setValor(valor);
                        break;
                    }
                    default:{
                    }
                }
            }
            daoAtividade.alterar(em, atividade);
            System.out.println("Alteração efetuada com sucesso.");
        }else
            System.out.println("Atividade não cadastrada (ID inválido).");
    }
    
    public void imprimir (List<?> lista){
        for(Object objeto: lista)
            System.out.println(objeto);
    }
    
    public void listar(EntityManager em) {
        if(daoAtividade.obterTodos(em).isEmpty()){
            System.out.println("Não existem atividades cadastradas.");
            return;
        }
        System.out.println("Lista de atividades cadastradas: ");
        this.imprimir(daoAtividade.obterTodos(em));
    }
}

