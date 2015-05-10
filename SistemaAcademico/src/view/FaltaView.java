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

/**
 *
 * @author Filipe
 */
public class FaltaView {
    private FaltaDao faltaDao;
    private static Scanner scanner = new Scanner (System.in);
    
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
        
        public void pesquisar () {
            System.out.println("PESQUISAR REGISTROS DE FALTA \nEntre com o ID da Falta: ");
            String id = scanner.nextLine();
            if (this.faltaDao.indiceFalta(id) != -1)
                System.out.println(this.faltaDao.obterFalta(id).toString());
            else
                System.out.println("FALTA NÃO ENCONTRADA!"); 
        }
        
        public void remover(){
            System.out.println("REMOVER REGISTRO DE NOTA\nEntre com o ID da Falta: ");
            String id = scanner.nextLine();
            if (faltaDao.remover(faltaDao.obterFalta(id)))
                System.out.println("FALTA REMOVIDA COM SUCESSO!");                
            else
                System.out.println("FALTA NÃO ENCONTRADA!");
        }
        
        public void listar () {
            System.out.println("LISTA DE NOTAS DISPONÍVEIS\n");
            List<Falta> listaAluno = faltaDao.obterTodas();
            for (Falta falta: listaAluno) {
                System.out.println(falta.toString() + "\n");
            }
        }
}
