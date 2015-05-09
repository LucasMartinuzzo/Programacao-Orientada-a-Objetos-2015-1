/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JeanPablo
 */
public class TurmaTest {
    
    public TurmaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Turma.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Turma instance = null;
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAno method, of class Turma.
     */
    @Test
    public void testGetAno() {
        System.out.println("getAno");
        Turma instance = null;
        Integer expResult = null;
        Integer result = instance.getAno();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAno method, of class Turma.
     */
    @Test
    public void testSetAno() {
        System.out.println("setAno");
        Integer ano = null;
        Turma instance = null;
        instance.setAno(ano);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPeriodo method, of class Turma.
     */
    @Test
    public void testGetPeriodo() {
        System.out.println("getPeriodo");
        Turma instance = null;
        Integer expResult = null;
        Integer result = instance.getPeriodo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPeriodo method, of class Turma.
     */
    @Test
    public void testSetPeriodo() {
        System.out.println("setPeriodo");
        Integer periodo = null;
        Turma instance = null;
        instance.setPeriodo(periodo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumeroDeVagas method, of class Turma.
     */
    @Test
    public void testGetNumeroDeVagas() {
        System.out.println("getNumeroDeVagas");
        Turma instance = null;
        Integer expResult = null;
        Integer result = instance.getNumeroDeVagas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumeroDeVagas method, of class Turma.
     */
    @Test
    public void testSetNumeroDeVagas() {
        System.out.println("setNumeroDeVagas");
        Integer numeroDeVagas = null;
        Turma instance = null;
        instance.setNumeroDeVagas(numeroDeVagas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDisciplina method, of class Turma.
     */
    @Test
    public void testGetDisciplina() {
        System.out.println("getDisciplina");
        Turma instance = null;
        Disciplina expResult = null;
        Disciplina result = instance.getDisciplina();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDisciplina method, of class Turma.
     */
    @Test
    public void testSetDisciplina() {
        System.out.println("setDisciplina");
        Disciplina disciplina = null;
        Turma instance = null;
        instance.setDisciplina(disciplina);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProfessor method, of class Turma.
     */
    @Test
    public void testGetProfessor() {
        System.out.println("getProfessor");
        Turma instance = null;
        Professor expResult = null;
        Professor result = instance.getProfessor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProfessor method, of class Turma.
     */
    @Test
    public void testSetProfessor() {
        System.out.println("setProfessor");
        Professor professor = null;
        Turma instance = null;
        instance.setProfessor(professor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAula method, of class Turma.
     */
    @Test
    public void testGetAula() {
        System.out.println("getAula");
        Turma instance = null;
        List<Aula> expResult = null;
        List<Aula> result = instance.getAula();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAluno method, of class Turma.
     */
    @Test
    public void testGetAluno() {
        System.out.println("getAluno");
        Turma instance = null;
        List<Aluno> expResult = null;
        List<Aluno> result = instance.getAluno();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAtividade method, of class Turma.
     */
    @Test
    public void testGetAtividade() {
        System.out.println("getAtividade");
        Turma instance = null;
        List<Atividade> expResult = null;
        List<Atividade> result = instance.getAtividade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Turma.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Object ObjTurma = null;
        Turma instance = null;
        int expResult = 0;
        int result = instance.compareTo(ObjTurma);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
