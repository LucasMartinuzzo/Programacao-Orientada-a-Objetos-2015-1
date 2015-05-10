package view;

import java.util.List;
import java.util.Scanner;
import model.dao.AulaDao;
import model.pojo.Aula;

/**
 *
 * @author JeanPablo
 */
public class AulaView {
    
        private AulaDao aulaDao;
    
        public Boolean cadastrar () {
            System.out.println("CADASTRO DE AULAS\nCadastre uma nova aula:\n");
            Scanner scanner = new Scanner(System.in);
            System.out.println("ID: ");
            String id = scanner.nextLine();
            System.out.println("Dia da semana: ");
            String diaDaSemana = scanner.nextLine();
            System.out.println("Hora: ");
            String hora = scanner.nextLine();
            System.out.println("Local: ");
            String local = scanner.nextLine();
            Aula aula = new Aula (id, diaDaSemana, hora, local);
            return this.aulaDao.salvar(aula);
        }
        
        public void pesquisar () {
            
        }
        
        public void listar () {
            List<Aula> listaAula = aulaDao.obterTodas();
            for (Aula aula: listaAula) {
                aula.toString();
            }
        }
}
