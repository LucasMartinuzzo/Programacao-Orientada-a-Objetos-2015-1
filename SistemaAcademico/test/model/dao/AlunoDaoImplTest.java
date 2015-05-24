/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojo.Aluno;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Filipe
 */
public class AlunoDaoImplTest {

    
    /**
     * Test of getInstancia method, of class AlunoDaoImpl.
     */
    @Test
    public void testGetInstancia() {
        
    }

    /**
     * Test of inserir method, of class AlunoDaoImpl.
     */
    @Test
    public void testInserir() {
    }

    
    /**
     * Test of indice method, of class AlunoDaoImpl.
     */
    @Test
    public void testIndice() {
        AlunoDaoImpl alunoDao = AlunoDaoImpl.getInstancia();
        Aluno aluno = new Aluno("1","1");
        alunoDao.inserir(aluno);
        assertEquals(0,alunoDao.indice("1"));
    }

    /**
     * Test of obter method, of class AlunoDaoImpl.
     */
    @Test
    public void testObter() {
        AlunoDaoImpl alunoDao = AlunoDaoImpl.getInstancia();
        Aluno aluno = new Aluno("1","1");
        alunoDao.inserir(aluno);
        assertEquals(aluno,alunoDao.obter("1"));
    }
    
    /**
    * Test of obterTodos method, of class AlunoDaoImpl.
    */
    @Test
    public void testObterTodos() {
        List<Aluno> lista = new ArrayList<>();
        AlunoDaoImpl alunoDao = AlunoDaoImpl.getInstancia();
        Aluno aluno1 = new Aluno("1","1");
        alunoDao.inserir(aluno1);
        Aluno aluno2 = new Aluno("2","2");
        alunoDao.inserir(aluno2);
        Aluno aluno3 = new Aluno("3","3");
        alunoDao.inserir(aluno3);
        List<Aluno> listaAluno = (List<Aluno>) AlunoDaoImpl.getInstancia().obterTodos();
        for(Aluno aluno5 : listaAluno){
            lista.add(aluno5); 
        }
        assertEquals(lista,listaAluno);
    }

    /**
     * Test of salvar method, of class AlunoDaoImpl.
     */
    @Test
    public void testSalvar() throws Exception {
    }

    /**
     * Test of carregar method, of class AlunoDaoImpl.
     */
    @Test
    public void testCarregar() throws Exception {
    }
    
}
