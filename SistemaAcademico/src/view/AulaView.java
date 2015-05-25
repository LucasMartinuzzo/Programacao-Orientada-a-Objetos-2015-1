package view;

import java.util.Scanner;
import model.dao.AulaDaoImpl;
import model.pojo.Aula;

public class AulaView {

    private static Scanner scanner = new Scanner (System.in);

    public Boolean cadastrar () {
        System.out.println("CADASTRO DE AULAS\nCadastre uma nova aula:\n");
        String id = this.validarId();
        if (id == null)
            return false;
        System.out.println("Dia da semana: ");
        String diaDaSemana = scanner.nextLine();
        System.out.println("Hora: ");
        String hora = scanner.nextLine();
        System.out.println("Local: ");
        String local = scanner.nextLine();
        Aula aula = new Aula (id, diaDaSemana, hora, local);
        return AulaDaoImpl.getInstancia().inserir(aula);
    }
    
    public String validarId () {
        while (true) {
            System.out.println("ID (''cancelar'' para cancelar): ");
            String id = scanner.nextLine();
            if (id.equals("cancelar"))
                break;
            if (AulaDaoImpl.getInstancia().indice(id) <= -1)
                return id;
            else
                System.out.println("\nUMA AULA COM ESTE ID JÁ ESTÁ CADASTRADA! TENTE NOVAMENTE!\n");
        }
        return null;
    }
}
