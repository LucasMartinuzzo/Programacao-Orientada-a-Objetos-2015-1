/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojo.Aula;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Filipe
 */
//String id, String diaDaSemana, String hora, String local
public class AulaDaoImplTest {
    
     
    @Test
    public void insereAulaNaListaAula() {
        AulaDaoImpl aulaDao = AulaDaoImpl.getInstancia();
        Aula aula = new Aula("1","1","1","1");
        aulaDao.inserir(aula);
        assertEquals(aula,aulaDao.obter("1"));
    }
    
    
    @Test
    public void retornaIndice0SeAula1TiverNaPosição0() {
        AulaDaoImpl aulaDao = AulaDaoImpl.getInstancia();
        Aula aula = new Aula("1","1","1","1");
        aulaDao.inserir(aula);
        assertEquals(0,aulaDao.indice("1"));
    }

    @Test
    public void retornaAula1SeObterId1() {
        AulaDaoImpl aulaDao = AulaDaoImpl.getInstancia();
        Aula aula = new Aula("1","1","1","1");
        aulaDao.inserir(aula);
        assertEquals(aula,aulaDao.obter("1"));
    }
    
    
    @Test
    public void retornaListaDeAula() {
        List<Aula> lista = new ArrayList<>();
        AulaDaoImpl aulaDao = AulaDaoImpl.getInstancia();
        Aula aula1 = new Aula("1","1","1","1");
        aulaDao.inserir(aula1);
        Aula aula2 = new Aula("2","2","2","2");
        aulaDao.inserir(aula2);
        Aula aula3 = new Aula("3","3","3","3");
        aulaDao.inserir(aula3);
        List<Aula> listaAula = (List<Aula>) AulaDaoImpl.getInstancia().obterTodos();
        for(Aula aula5 : listaAula){
            lista.add(aula5); 
        }
        assertEquals(lista,listaAula);
    }
    
}
