package view;

import java.util.Scanner;
import javax.persistence.EntityManager;
import model.dao.AlunoDaoImpl;
import model.dao.Dao;
import model.dao.FaltaDaoImpl;
import model.dao.TurmaDaoImpl;
import model.pojo.Aluno;
import model.pojo.Falta;
import model.pojo.Turma;

public class FaltaView {

    private static Scanner scanner = new Scanner (System.in);
    private FaltaDaoImpl daoFalta = FaltaDaoImpl.getInstancia();
    private TurmaDaoImpl daoTurma = TurmaDaoImpl.getInstancia();
    private AlunoDaoImpl daoAluno = AlunoDaoImpl.getInstancia();
    
    public void cadastrar (EntityManager em){
        System.out.println("CADASTRO DE FALTAS");
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
            Boolean aux = false;
            for (Aluno aluno: turma.getAluno()) {
                aux = false;
                for (Falta faltaConsultada: aluno.getFalta()){
                    if (faltaConsultada.getTurma().equals(turma)){
                        aux = true;
                        break;
                    }
                }
                if (aux == true)
                    continue;
                else{
                    System.out.println ("Número de Faltas de " + aluno.getNome() + ":");
                    Integer nfaltas = scanner.nextInt();
                    scanner.nextLine();
                    Falta falta = new Falta (nfaltas, turma);
                    aluno.getFalta().add(falta);
                    daoFalta.salvar(em, falta);
                    daoAluno.alterar(em,aluno);
                }
            }              
            System.out.println ("Cadastros efetuados com sucesso.");
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


