package view;

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
        System.out.println("Lista de turmas cadastradas: ");
        if (this.imprimirCadastrados(em, daoTurma) == false){
            System.out.println("ERRO: Não existem turmas cadastradas.");
            return;
        }
        System.out.println("Turma (ID): ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        Turma turma = daoTurma.buscar(em, id);
        if (turma != null){
            System.out.println("Nome: ");
            String nome = scanner.nextLine();
            System.out.println("Tipo: ");
            String tipo = scanner.nextLine();
            System.out.println("Data (DD/MM/AAAA): ");
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
            System.out.println("ERRO: Turma não cadastrada (ID inválido).");
    }
    
    public Boolean imprimirCadastrados (EntityManager em, Dao dao){
        Integer id = 1;
        for ( ; dao.buscar(em, id) != null; id++)
            System.out.println(dao.buscar(em,id));
        if (id == 1)
            return false;
        return true;
    }
}

