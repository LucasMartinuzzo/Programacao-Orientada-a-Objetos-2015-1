/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.pojo.Aluno;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Filipe
 */
public class AlunoDaoImplTest {
    
//    public AlunoDaoImplTest() {
//    }
    AlunoDaoImpl m;
    Aluno aluno;
    
    @Before
    public void setUp() {
       m = new AlunoDaoImpl();
       Mockery mockery = Mockery();
       //aluno = new Aluno("filipe","123.634.727-63");
       
       m.listaAluno.add(aluno)     
    }
    
    
    
    
    
    
    

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
        assertFalse(m.inserir(this.aluno));
    }

    /**
     * Test of remover method, of class AlunoDaoImpl.
     */
    @Test
    public void testRemover() {
    }

    /**
     * Test of indice method, of class AlunoDaoImpl.
     */
    @Test
    public void testIndice() {
        assertEquals(1, m.indice("132.634.727-63"));
    }

    /**
     * Test of obter method, of class AlunoDaoImpl.
     */
    @Test
    public void testObter() {
    }

    /**
     * Test of obterTodos method, of class AlunoDaoImpl.
     */
    @Test
    public void testObterTodos() {
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
