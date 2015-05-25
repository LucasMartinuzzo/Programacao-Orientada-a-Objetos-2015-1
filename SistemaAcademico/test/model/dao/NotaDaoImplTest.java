/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojo.Aluno;
import model.pojo.Atividade;
import model.pojo.Disciplina;
import model.pojo.Nota;
import model.pojo.Professor;
import model.pojo.Turma;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Filipe
 */
public class NotaDaoImplTest {
        
    @Test
    public void insereNotaNaListaNota() {
        NotaDaoImpl notaDao = NotaDaoImpl.getInstancia();
        Nota nota = new Nota("1",1.0,new Aluno("1","1"),new Atividade("1","1","1","1",1.0, new Turma("1",1,1,1,new Disciplina("1","1",1),new Professor("1","1","1"),null,null)));
        notaDao.inserir(nota);
        assertEquals(nota,notaDao.obter("1"));
    }
    
    @Test
    public void retornaIndice0SeNota1TiverNaPosição0() {
        NotaDaoImpl notaDao = NotaDaoImpl.getInstancia();
        Nota nota = new Nota("1",1.0,new Aluno("1","1"),new Atividade("1","1","1","1",1.0, new Turma("1",1,1,1,new Disciplina("1","1",1),new Professor("1","1","1"),null,null)));
        notaDao.inserir(nota);
        assertEquals(nota,notaDao.indice("1"));
    }

    
    @Test
    public void retornaNota1SeObterId1() {
        NotaDaoImpl notaDao = NotaDaoImpl.getInstancia();
        Nota nota = new Nota("1",1.0,new Aluno("1","1"),new Atividade("1","1","1","1",1.0, new Turma("1",1,1,1,new Disciplina("1","1",1),new Professor("1","1","1"),null,null)));
        notaDao.inserir(nota);
        assertEquals(nota,notaDao.obter("1"));
    }
    
    @Test
    public void retornaListaDeNota() {
        List<Nota> lista = new ArrayList<>();
        NotaDaoImpl notaDao = NotaDaoImpl.getInstancia();
        Nota nota1 = new Nota("1",1.0,new Aluno("1","1"),new Atividade("1","1","1","1",1.0, new Turma("1",1,1,1,new Disciplina("1","1",1),new Professor("1","1","1"),null,null)));
        notaDao.inserir(nota1);
        Nota nota2 = new Nota("2",2.0,new Aluno("2","2"),new Atividade("2","2","2","2",2.0, new Turma("2",2,2,2,new Disciplina("2","2",2),new Professor("2","2","2"),null,null)));
        notaDao.inserir(nota2);
        Nota nota3 = new Nota("3",3.0,new Aluno("3","3"),new Atividade("3","3","3","3",3.0, new Turma("3",3,3,3,new Disciplina("3","3",3),new Professor("3","3","3"),null,null)));
        notaDao.inserir(nota3);
        List<Nota> listaNota = (List<Nota>) NotaDaoImpl.getInstancia().obterTodos();
        for(Nota nota5 : listaNota){
            lista.add(nota5); 
        }
        assertEquals(lista,listaNota);
    }
}
