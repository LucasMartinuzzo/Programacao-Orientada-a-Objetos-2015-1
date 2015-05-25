/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojo.Aluno;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Filipe
 */
public class AlunoDaoImplTest {

    @Test
    public void insereAuloNaListaAluno(){
        AlunoDaoImpl alunoDao = AlunoDaoImpl.getInstancia();
        Aluno aluno = new Aluno("1","1");
        alunoDao.inserir(aluno);
        assertEquals(aluno,alunoDao.obter("1"));
    }
    
    @Test
    public void retornaIndice0SeAluno1TiverNaPosição0() {
        AlunoDaoImpl alunoDao = AlunoDaoImpl.getInstancia();
        Aluno aluno = new Aluno("1","1");
        alunoDao.inserir(aluno);
        assertEquals(0,alunoDao.indice("1"));
    }
    
    @Test
    public void retornaAula1SeObterCpf1() {
        AlunoDaoImpl alunoDao = AlunoDaoImpl.getInstancia();
        Aluno aluno = new Aluno("1","1");
        alunoDao.inserir(aluno);
        assertEquals(aluno,alunoDao.obter("1"));
    }
  
    @Test
    public void retornaListaDeAlunos() {
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
 }
