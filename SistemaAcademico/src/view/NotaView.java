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
    
        public Boolean cadastrar () {
            System.out.println("CADASTRO DE NOTAS\nCadastre uma nova nota:\n");
            Scanner scanner = new Scanner(System.in);
            System.out.println("ID: ");
            String id = scanner.nextLine();
            System.out.println("Nota: ");
            Double ValorDaNota = scanner.nextDouble();
            
                        
            Nota nota = new Nota (id, ValorDaNota,);
            return this.notaDao.salvar(nota);
        }
        
        public void pesquisar (String id) {
           //Nota print = notaDao.obterNota (id);
           
        }
        
        public void listar () {
            List<Nota> listaNota = notaDao.obterTodos();
            for (Nota aula: listaNota) {
                aula.toString();
            }
        }
}
