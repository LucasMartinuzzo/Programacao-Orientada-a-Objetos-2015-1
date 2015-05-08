/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Aluno;
import model.pojo.Atividade;
import model.pojo.Nota;

/**
 *
 * @author Mônicka
 */
public class AtividadeDaoImpl implements AtividadeDao{
    
    private List<Atividade> listaAtividade;
    
    public void constarLancamentoDeNotas(Atividade atividade){
         Boolean notasLancadas = this.listaAtividade.get(this.listaAtividade.indexOf(atividade)).notasLancadas();
         notasLancadas = true;
    }

    public Boolean adicaoValida(Nota nota) {
        if (this.notasLancadas)
            return false;
        for (Nota notaConsultada: this.nota) {
            if (notaConsultada.getAluno().equals(nota.getAluno()))
                return false;
        }
        return true;
    }
    
    /*Pois o professor pode lançar duas notas de valores diferentes para uma
    atividade para o mesmo aluno ou tentar lançar uma nota já lançada.*/   
    public Boolean adicaoValida(Nota nota, Atividade atividade) {
        if(!this.listaAtividade.contains(y)) 
            return false;
        if (this.listaAtividade.get(this.listaAtividade.indexOf(atividade)).notasLancadas())
            return false;
        Atividade atividadeConsultada = this.listaAtividade.get(this.listaAtividade.indexOf(atividade));
        for (Nota notaConsultada: atividadeConsultada.getNota()) {
            if (notaConsultada.getAluno().equals(nota.getAluno()))
                return false;
        }
        return true;
    }    
    
    //FALTA FAZER AS DUAS PROXIMAS
    public Boolean adicionaNota(Nota nota){
        if (this.adicaoValida(nota))
            return this.nota.add(nota);
        return false;
    }
    
    public Nota retornaNota (Nota nota) {
        return this.nota.get(this.nota.indexOf(nota));
    }
    
}
