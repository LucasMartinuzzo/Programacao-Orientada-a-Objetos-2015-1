/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//// MUDAR TIPO DE DATA DE CALENDAR PARA STRING

package view;

import java.util.List;
import java.util.Scanner;
import model.dao.AtividadeDao;
import model.pojo.Atividade;


/**
 *
 * @author Mônicka
 */
public class AtividadeView {
        private AtividadeDao atividadeDao;
        private static Scanner scanner = new Scanner (System.in);
    
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
//            System.out.println("ID da Turma: ");
//            String idTurma = scanner.nextLine();
           
                       
            Atividade atividade = new Atividade (id, nome, tipo, data, valor,  );
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
