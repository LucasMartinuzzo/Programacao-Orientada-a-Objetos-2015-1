/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojo.Atividade;
import model.pojo.Disciplina;
import model.pojo.Professor;
import model.pojo.Turma;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Filipe
 */
public class AtividadeDaoImplTest {
    
    @Test
    public void insereAtividadeNaListaAtividade(){
        AtividadeDaoImpl atividadeDao = AtividadeDaoImpl.getInstancia();
        Atividade atividade = new Atividade("1","1","1","1",1.0, new Turma("1",1,1,1,new Disciplina("1","1",1),new Professor("1","1","1"),null,null));
        atividadeDao.inserir(atividade);
        assertEquals(atividade,atividadeDao.obter("1"));
    }
    
    @Test
    public void retornaIndice0SeAtividade1TiverNaPosição0() {
        AtividadeDaoImpl atividadeDao = AtividadeDaoImpl.getInstancia();
        Atividade atividade = new Atividade("1","1","1","1",1.0, new Turma("1",1,1,1,new Disciplina("1","1",1),new Professor("1","1","1"),null,null));
        atividadeDao.inserir(atividade);
        assertEquals(0,atividadeDao.indice("1"));
    }
    
    @Test
    public void retornaAtividade1SeObterId1() {
        AtividadeDaoImpl atividadeDao = AtividadeDaoImpl.getInstancia();
        Atividade atividade = new Atividade("1","1","1","1",1.0, new Turma("1",1,1,1,new Disciplina("1","1",1),new Professor("1","1","1"),null,null));
        atividadeDao.inserir(atividade);
        assertEquals(atividade,atividadeDao.obter("1"));
    }
  
    @Test
    public void retornaListaDeAtividade() {
        List<Atividade> lista = new ArrayList<>();
        AtividadeDaoImpl atividadeDao = AtividadeDaoImpl.getInstancia();
        Atividade atividade1 = new Atividade("1","1","1","1",1.0, new Turma("1",1,1,1,new Disciplina("1","1",1),new Professor("1","1","1"),null,null));
        atividadeDao.inserir(atividade1);
        Atividade atividade2 = new Atividade("2","2","2","2",2.0, new Turma("2",2,2,2,new Disciplina("2","2",2),new Professor("2","2","2"),null,null));
        atividadeDao.inserir(atividade2);
        Atividade atividade3 = new Atividade("3","3","3","3",3.0, new Turma("3",3,3,3,new Disciplina("3","3",3),new Professor("3","3","3"),null,null));
        atividadeDao.inserir(atividade3);
        List<Atividade> listaAtividade = (List<Atividade>) AtividadeDaoImpl.getInstancia().obterTodos();
        for(Atividade atividade5 : listaAtividade){
            lista.add(atividade5); 
        }
        assertEquals(lista,listaAtividade);
    }   
}
