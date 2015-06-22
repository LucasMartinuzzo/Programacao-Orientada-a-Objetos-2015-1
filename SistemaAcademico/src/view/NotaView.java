package view;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import model.dao.AlunoDaoImpl;
import model.dao.Dao;
import model.dao.AtividadeDaoImpl;
import model.dao.NotaDaoImpl;
import model.pojo.Aluno;
import model.pojo.Atividade;
import model.pojo.Nota;

public class NotaView {

    private static Scanner scanner = new Scanner (System.in);
    private NotaDaoImpl daoNota = NotaDaoImpl.getInstancia();
    private AlunoDaoImpl daoAluno = AlunoDaoImpl.getInstancia();
    private AtividadeDaoImpl daoAtividade = AtividadeDaoImpl.getInstancia();
    
    public void cadastrar (EntityManager em){
        System.out.println("CADASTRO DE NOTAS");
        System.out.println("Lista de atividades cadastradas: ");
        if (this.imprimirCadastrados(em, daoAtividade) == false){
            System.out.println("ERRO: Não existem atividades cadastradas.");
            return;
        }
        System.out.println("Atividade (ID): ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        Atividade atividade = daoAtividade.buscar(em, id);
        if (atividade != null){
            Boolean aux = false;
            for (Aluno aluno: atividade.getTurma().getAluno()) {
                aux = false;
                for (Nota notaConsultada: aluno.getNota()){
                    if (notaConsultada.getAtividade().equals(atividade)){
                        aux = true;
                        break;
                    }
                }
                if (aux == true)
                    continue;
                else{
                    System.out.println ("Nota de " + aluno.getNome() + ":");
                    Double valor = scanner.nextDouble();
                    scanner.nextLine();
                    Nota nota = new Nota (valor, aluno, atividade);
                    aluno.getNota().add(nota);
                    atividade.getNota().add(nota);
                    daoNota.salvar(em, nota);
                    daoAluno.alterar(em,aluno);
                    daoAtividade.alterar(em, atividade);
                }
            }              
            System.out.println ("Cadastros efetuados com sucesso.");
        }else
            System.out.println("ERRO: Atividade não cadastrada (ID inválido).");
    }
    
    public Boolean imprimirCadastrados (EntityManager em, Dao dao){
        Integer id = 1;
        for ( ; dao.buscar(em, id) != null; id++)
            System.out.println(dao.buscar(em,id));
        if (id == 1)
            return false;
        return true;
    }
    
    public void imprimir (List<Nota> list){
        for(Nota nota: list)
            System.out.println(nota);
    }
}


