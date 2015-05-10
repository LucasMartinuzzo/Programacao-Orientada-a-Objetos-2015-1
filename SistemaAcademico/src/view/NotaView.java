/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import java.util.Scanner;
import model.dao.NotaDao;
import model.pojo.Nota;

/**
 *
 * @author Filipe
 */
public class NotaView {
    private NotaDao notaDao;
    
    private static Scanner scanner = new Scanner (System.in);
    
        public Boolean cadastrar () {
            System.out.println("CADASTRO DE NOTAS\nCadastre uma nova nota:\n");
            System.out.println("ID: ");
            String id = scanner.nextLine();
            System.out.println("Nota: ");
            Double ValorDaNota = scanner.nextDouble();
            
                        
            Nota nota = new Nota (id, ValorDaNota,);
            return this.notaDao.salvar(nota);
        }
        
       public void pesquisar () {
           System.out.println("PESQUISAR NOTA \nEntre com o ID da Nota: ");
            String id = scanner.nextLine();
            if (this.notaDao.indiceNota(id) != -1)
                System.out.println(this.notaDao.obterNota(id).toString());
            else
                System.out.println("NOTA NÃO ENCONTRADA!"); 
        }
        
        public void remover(){
            System.out.println("REMOVER NOTA\nEntre com o ID da Nota: ");
            String id = scanner.nextLine();
            if (notaDao.remover(notaDao.obterNota(id)))
                System.out.println("NOTA REMOVIDA COM SUCESSO!");                
            else
                System.out.println("NOTA NÃO ENCONTRADA!");
        }
        
        public void listar () {
            System.out.println("LISTA DE NOTAS DISPONÍVEIS\n");
            List<Nota> listaAluno = notaDao.obterTodos();
            for (Nota nota: listaAluno) {
                System.out.println(nota.toString() + "\n");
            }
        }
}
