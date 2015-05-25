/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojo.Disciplina;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Filipe
 */
public class DisciplinaDaoImplTest {
    
    
    @Test
    public void insereDisciplinaNaListaDisciplina() {
        
        DisciplinaDaoImpl disciplinaDao = DisciplinaDaoImpl.getInstancia();
        Disciplina disciplina = new Disciplina("1","1",1);
        disciplinaDao.inserir(disciplina);
        assertEquals(disciplina,disciplinaDao.obter("1"));
    }
    
    
    @Test
    public void retornaIndice0SeDisciplina1TiverNaPosição0() {
        
        DisciplinaDaoImpl disciplinaDao = DisciplinaDaoImpl.getInstancia();
        Disciplina disciplina = new Disciplina("1","1",1);
        disciplinaDao.inserir(disciplina);
        assertEquals(disciplina,disciplinaDao.indice("1"));
    }

    
    @Test
    public void retornaDisciplina1SeObterNome1() {
        
        DisciplinaDaoImpl disciplinaDao = DisciplinaDaoImpl.getInstancia();
        Disciplina disciplina = new Disciplina("1","1",1);
        disciplinaDao.inserir(disciplina);
        assertEquals(disciplina,disciplinaDao.obter("1"));
    }
    
    
    @Test
    public void retornaListaDeDisciplina() {
        
        List<Disciplina> lista = new ArrayList<>();
        DisciplinaDaoImpl disciplinaDao = DisciplinaDaoImpl.getInstancia();
        Disciplina disciplina1 = new Disciplina("1","1",1);
        disciplinaDao.inserir(disciplina1);
        Disciplina disciplina2 = new Disciplina("2","2",2);
        disciplinaDao.inserir(disciplina2);
        Disciplina disciplina3 = new Disciplina("3","3",3);
        disciplinaDao.inserir(disciplina3);
        List<Disciplina> listaDisciplina = (List<Disciplina>) DisciplinaDaoImpl.getInstancia().obterTodos();
        for(Disciplina aluno5 : listaDisciplina){
            lista.add(aluno5); 
        }
        assertEquals(lista,listaDisciplina);
    }
}

  