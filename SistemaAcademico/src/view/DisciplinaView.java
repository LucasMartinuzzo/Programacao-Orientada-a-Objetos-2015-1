package view;

import java.util.Scanner;
import javax.persistence.EntityManager;
import model.dao.DisciplinaDaoImpl;
import model.pojo.Disciplina;

public class DisciplinaView {

    private static Scanner scanner = new Scanner (System.in);
    private DisciplinaDaoImpl daoDisciplina = DisciplinaDaoImpl.getInstancia();
    
    public void cadastrar (EntityManager em){
        System.out.println("CADASTRO DE DISCIPLINA");
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        if (daoDisciplina.buscar(em,nome) == null){
            System.out.println("Ementa: ");
            String ementa = scanner.nextLine();
            System.out.println("Carga Horária: ");
            Integer cargaHoraria = scanner.nextInt();
            scanner.nextLine();
            Disciplina disciplina = new Disciplina (nome, ementa, cargaHoraria);
            daoDisciplina.salvar(em, disciplina);
            System.out.println("Cadastro efetuado com sucesso.");
        }else
            System.out.println("ERRO: Nome de disciplina já cadastrado.");
    }
}
