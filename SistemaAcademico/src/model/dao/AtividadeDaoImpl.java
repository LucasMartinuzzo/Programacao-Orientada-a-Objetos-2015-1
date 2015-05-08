/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.pojo.Atividade;
import model.pojo.Nota;

/**
 *
 * @author Mônicka
 */
public class AtividadeDaoImpl implements AtividadeDao{
    
    private Atividade atividade;
    
    @Override
    public void constarLancamentoDeNotas(){
        Boolean notasLancadas = this.atividade.notasLancadas();
        notasLancadas = true;
    }

    
    /*Pois o professor pode lançar duas notas de valores diferentes para uma
    atividade para o mesmo aluno ou tentar lançar uma nota já lançada.*/
    @Override
    public Boolean adicaoValida(Nota nota) {
        if (this.atividade.notasLancadas())
            return false;
        for (Nota notaConsultada: this.atividade.getNota()) {
            if (notaConsultada.getAluno().equals(nota.getAluno()))
                return false;
        }
        return true;
    }
    
       
    @Override
    public Boolean adicionaNota(Nota nota){
        if (this.adicaoValida(nota))
            return this.atividade.getNota().add(nota);
        return false;
    }
    
    @Override
    public Nota retornaNota (Nota nota) {
        return this.atividade.getNota().get(this.atividade.getNota().indexOf(nota));
    }
    
}
