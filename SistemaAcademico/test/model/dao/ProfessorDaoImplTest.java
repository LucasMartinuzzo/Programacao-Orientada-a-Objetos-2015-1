/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojo.Professor;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Filipe
 */
public class ProfessorDaoImplTest {
    
    @Test
    public void insereProfessorNaListaProfessor() {
        ProfessorDaoImpl professorDao = ProfessorDaoImpl.getInstancia();
        Professor professor = new Professor("1","1","1");
        professorDao.inserir(professor);
        assertEquals(professor,professorDao.obter("1"));
    }
    
    
    @Test
    public void retornaIndice0SeProfessor1TiverNaPosição0() {
        ProfessorDaoImpl professorDao = ProfessorDaoImpl.getInstancia();
        Professor professor = new Professor("1","1","1");
        professorDao.inserir(professor);
        assertEquals(0,professorDao.indice("1"));
    }

    
    @Test
    public void retornaProfessor1SeObterCpf1() {
        ProfessorDaoImpl professorDao = ProfessorDaoImpl.getInstancia();
        Professor professor = new Professor("1","1","1");
        professorDao.inserir(professor);
        assertEquals(professor,professorDao.obter("1"));
    }
    
    @Test
    public void retornaListaDeProfessores() {
        List<Professor> lista = new ArrayList<>();
        ProfessorDaoImpl professorDao = ProfessorDaoImpl.getInstancia();
        Professor professor1 = new Professor("1","1","1");
        professorDao.inserir(professor1);
        Professor professor2 = new Professor("2","2","2");
        professorDao.inserir(professor2);
        Professor professor3 = new Professor("3","3","3");
        professorDao.inserir(professor3);
        List<Professor> listaProfessor = (List<Professor>) ProfessorDaoImpl.getInstancia().obterTodos();
        for(Professor professor5 : listaProfessor){
            lista.add(professor5); 
        }
        assertEquals(lista,listaProfessor);
    }
}
