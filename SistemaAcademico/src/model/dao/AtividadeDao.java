/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.pojo.Nota;

/**
 *
 * @author Mônicka
 */
public interface AtividadeDao {
    
    void constarLancamentoDeNotas();
    Boolean adicaoValida(Nota nota);
    Boolean adicionaNota(Nota nota);
    Nota retornaNota (Nota nota);
}
