/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Atividade;
import model.pojo.Nota;
import model.pojo.Turma;

/**
 *
 * @author Mônicka
 */
public interface AtividadeDao {
    
    List<Atividade> obterTodas();
    Turma obterAtividade(String id);
    Boolean contemAtividade(String id);
    Boolean remover(Atividade atividade);
    Boolean salvar(Atividade atividade);
    void constarLancamentoDeNotas(Atividade atividade);
    Boolean adicaoValida(Atividade atividade, Nota nota);
    Boolean adicionaNota(Atividade atividade, Nota nota);
    Nota retornaNota (Atividade atividade, Nota nota);
}
