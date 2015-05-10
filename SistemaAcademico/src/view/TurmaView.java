package view;

import java.util.Scanner;
import model.dao.TurmaDao;
import model.pojo.Turma;

/**
 *
 * @author JeanPablo
 */
public class TurmaView {
    
    private TurmaDao turmaDao;
    
    public Boolean cadastrar () {
        System.out.println("CADASTRO DE TURMAS\nCadastre uma nova turma:\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("ID: ");
        String id = scanner.nextLine();
        System.out.println("Ano: ");
        Integer ano = scanner.nextInt();
        System.out.println("Período: ");
        Integer periodo = scanner.nextInt();
        System.out.println("Número de vagas: ");
        Integer numeroDeVagas = scanner.nextInt();
        //COMO FAZER PARA OS ATRIBUTOS QUE SÃO NOSSOS OBJETOS (por exemplo, disciplina)?
        Turma turma = new Turma (id, ano, periodo, numeroDeVagas, /*RESTO*/);
        return this.turmaDao.salvar(turma);
    }
}