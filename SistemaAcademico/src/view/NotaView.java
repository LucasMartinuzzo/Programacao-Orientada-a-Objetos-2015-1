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
        if (daoAtividade.obterTodos(em).isEmpty()){
            System.out.println("Não existem atividades cadastradas.");
            return;
        }
        System.out.println("Lista de atividades cadastradas: ");
        this.imprimir(daoAtividade.obterTodos(em));
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
            System.out.println("Atividade não cadastrada (ID inválido).");
    }
    
    public void alterar (EntityManager em){
        System.out.println("ALTERAÇÃO DE NOTA");
        if(daoNota.obterTodos(em).isEmpty()){
            System.out.println("Não existem notas cadastradas.");
            return;
        }
        System.out.println("Lista de notas cadastradas: ");
        this.imprimir(daoNota.obterTodos(em));
        System.out.println("Nota (ID): ");
        Integer id = scanner.nextInt();
        scanner.nextLine();
        Nota nota = daoNota.buscar(em, id);
        if(nota != null){
            System.out.println("Atualize o valor da nota.");
            System.out.println("Valor: ");
            Double valor = scanner.nextDouble();
            scanner.nextLine();
            nota.setNota(valor);
            daoNota.alterar(em, nota);
            System.out.println("Alteração efetuada com sucesso.");
        }else
            System.out.println("Nota não cadastrada (ID inválido).");
    }
    
    public void imprimir (List<?> lista){
        for(Object objeto: lista)
            System.out.println(objeto);
    }
}


