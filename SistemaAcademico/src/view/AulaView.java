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
        private static Scanner scanner = new Scanner (System.in);
    
        public Boolean cadastrar () {
            System.out.println("CADASTRO DE AULAS\nCadastre uma nova aula:\n");
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
            System.out.println("PESQUISA DE AULAS\nEntre com o ID da aula: ");
            String id = scanner.nextLine();
            if (this.aulaDao.indiceAula(id) != -1)
                System.out.println(this.aulaDao.obterAula(id).toString());
            else
                System.out.println("AULA NÃO ENCONTRADA!");
        }
        
        public void remover () {
            System.out.println("REMOÇÃO DE AULA\nEntre com o ID da aula: ");
            String id = scanner.nextLine();
            if (this.aulaDao.remover(this.aulaDao.obterAula(id)))
                System.out.println(this.aulaDao.obterAula(id).toString());
            else
                System.out.println("AULA NÃO ENCONTRADA!");
        }
        
        public void listar () {
            System.out.println("LISTA DE AULAS DISPONÍVEIS\n");
            List<Aula> listaAula = aulaDao.obterTodas();
            for (Aula aula: listaAula) {
                System.out.println(aula.toString() + "\n");
            }
        }
}