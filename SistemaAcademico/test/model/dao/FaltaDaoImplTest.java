/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojo.Disciplina;
import model.pojo.Falta;
import model.pojo.Professor;
import model.pojo.Turma;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Filipe
 */
public class FaltaDaoImplTest {
    
    @Test
    public void insereFaltaNaListaFalta() {
        FaltaDaoImpl faltaDao = FaltaDaoImpl.getInstancia();
        Falta falta = new Falta("1",1,new Turma("1",1,1,1,new Disciplina("1","1",1),new Professor("1","1","1"),null,null));
        faltaDao.inserir(falta);
        assertEquals(falta,faltaDao.obter("1"));
    }
    
    @Test
    public void retornaIndice0SeFalta1TiverNaPosição0() {
        FaltaDaoImpl faltaDao = FaltaDaoImpl.getInstancia();
        Falta falta = new Falta("1",1,new Turma("1",1,1,1,new Disciplina("1","1",1),new Professor("1","1","1"),null,null));
        faltaDao.inserir(falta);
        assertEquals(0,faltaDao.indice("1"));
    }

    @Test
    public void retornaFalta1SeObterId1() {
        FaltaDaoImpl faltaDao = FaltaDaoImpl.getInstancia();
        Falta falta = new Falta("1",1,new Turma("1",1,1,1,new Disciplina("1","1",1),new Professor("1","1","1"),null,null));
        faltaDao.inserir(falta);
        assertEquals(falta,faltaDao.obter("1"));
    }
    
    @Test
    public void retornaListaDeFaltas() {
        List<Falta> lista = new ArrayList<>();
        TurmaDaoImpl faltaDao = TurmaDaoImpl.getInstancia();
        Falta falta1 = new Falta("1",1,new Turma("1",1,1,1,new Disciplina("1","1",1),new Professor("1","1","1"),null,null));
        faltaDao.inserir(falta1);
        Falta falta2 = new Falta("2",2,new Turma("2",2,2,2,new Disciplina("2","2",2),new Professor("2","2","2"),null,null));
        faltaDao.inserir(falta2);
        Falta falta3 = new Falta("3",3,new Turma("3",3,3,3,new Disciplina("3","3",3),new Professor("3","3","3"),null,null));
        faltaDao.inserir(falta3);
        List<Falta> listaFalta = (List<Falta>) FaltaDaoImpl.getInstancia().obterTodos();
        for(Falta falta5 : listaFalta){
            lista.add(falta5); 
        }
        assertEquals(lista,listaFalta);
    }
    
}
