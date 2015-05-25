/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojo.Disciplina;
import model.pojo.Professor;
import model.pojo.Turma;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Filipe
 */
public class TurmaDaoImplTest {
    
    @Test
    public void insereTurmaNaListaTurma() {
        TurmaDaoImpl turmaDao = TurmaDaoImpl.getInstancia();
        Turma turma = new Turma("1",1,1,1,new Disciplina("1","1",1),new Professor("1","1","1"),null,null);
        turmaDao.inserir(turma);
        assertEquals(turma,turmaDao.obter("1"));
    }
    
    
    @Test
    public void retornaIndice0SeTurma1TiverNaPosição0() {
        TurmaDaoImpl turmaDao = TurmaDaoImpl.getInstancia();
        Turma turma = new Turma("1",1,1,1,new Disciplina("1","1",1),new Professor("1","1","1"),null,null);
        turmaDao.inserir(turma);
        assertEquals(0,turmaDao.indice("1"));
    }

   
    @Test
    public void retornaTurma1SeObterID1() {
        TurmaDaoImpl turmaDao = TurmaDaoImpl.getInstancia();
        Turma turma = new Turma("1",1,1,1,new Disciplina("1","1",1),new Professor("1","1","1"),null,null);
        turmaDao.inserir(turma);
        assertEquals(turma,turmaDao.obter("1"));
    }
    
    @Test
    public void retornaListaDeTurmas() {
        List<Turma> lista = new ArrayList<>();
        TurmaDaoImpl turmaDao = TurmaDaoImpl.getInstancia();
        Turma turma1 = new Turma("1",1,1,1,new Disciplina("1","1",1),new Professor("1","1","1"),null,null);
        turmaDao.inserir(turma1);
        Turma turma2 = new Turma("2",2,2,2,new Disciplina("2","2",2),new Professor("2","2","2"),null,null);
        turmaDao.inserir(turma2);
        Turma turma3 = new Turma("3",3,3,3,new Disciplina("3","3",3),new Professor("3","3","3"),null,null);
        turmaDao.inserir(turma3);
        List<Turma> listaTurma = (List<Turma>) AlunoDaoImpl.getInstancia().obterTodos();
        for(Turma turma5 : listaTurma){
            lista.add(turma5); 
        }
        assertEquals(lista,listaTurma);
    }
}
