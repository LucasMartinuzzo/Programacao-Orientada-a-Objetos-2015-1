/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.pojo.Aluno;
import model.pojo.Nota;
import model.pojo.Turma;

/**
 *
 * @author Filipe
 */
public interface AlunoDao {
  public boolean adicaoValida(Nota nota);
  public void adicionaNota(Nota nota);
  public Nota retornaNota (Nota nota);
  public Double NotaFinal(Turma turma);
 }
