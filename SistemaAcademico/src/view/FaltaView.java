/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import java.util.Scanner;
import model.dao.FaltaDao;
import model.pojo.Falta;
import model.pojo.Nota;



/**
 *
 * @author Filipe
 */
public class FaltaView {
    private FaltaDao faltaDao;
    
        public Boolean cadastrar () {
            System.out.println("CADASTRO DE AULAS\nCadastre uma nova falta:\n");
            Scanner scanner = new Scanner(System.in);
            System.out.println("ID: ");
            String id = scanner.nextLine();
            System.out.println("Falta: ");
            Integer NumeroDeFalta = scanner.nextInt();
           
            
            Falta falta = new Falta (id, NumeroDeFalta, /*qerwfaergervraev*/);
            return this.faltaDao.salvar(falta);
        }
        
        public void pesquisar (String id) {
            faltaDao.obterFalta(id);
        //falt
        
        }
        
        public void listar () {
            List<Falta> listaDeFalta = faltaDao.obterTodas();
            for (Falta falta: listaDeFalta) {
                falta.toString();
            }
        }
}
