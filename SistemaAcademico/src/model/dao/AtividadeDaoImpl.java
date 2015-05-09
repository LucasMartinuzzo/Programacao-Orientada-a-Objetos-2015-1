/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.pojo.Atividade;
import model.pojo.Nota;
import model.pojo.Turma;

/**
 *
 * @author Mônicka
 */
public class AtividadeDaoImpl implements AtividadeDao{
    
    private List<Atividade> listaAtividade;
    
    public AtividadeDaoImpl(){
        this.listaAtividade = new ArrayList<>();
    }
    
    
    @Override
    public Boolean salvar(Atividade atividade) {
        if (!this.contemAtividade(atividade.getId()))
           return this.listaAtividade.add(atividade);
        return false;
    }
    
    
    @Override
    public Boolean remover(Atividade atividade){
        if(!this.contemAtividade(atividade.getId()))
            return this.listaAtividade.remove(atividade);
        return false;
    }
    
    
    @Override
    public Boolean contemAtividade(String id) {
        //ORDENAR LISTA DE TURMAS PELO ID E APLICAR BUSCA BINÁRIA BASEADA NESTE.
        return false;
    }
    
    @Override
    public Turma obterAtividade(String id) {
        if (this.contemAtividade(id))
            return this.listaAtividade.get(this.listaAtividade.indexOf(/*?????*/));
        return null;
    }
    
    @Override
    public List<Atividade> obterTodas () {
        return listaAtividade;
    }
    
    @Override
    public void constarLancamentoDeNotas(Atividade atividade){
        Boolean notasLancadas = atividade.notasLancadas();
        notasLancadas = true;
    }

    
    /*Pois o professor pode lançar duas notas de valores diferentes para uma
    atividade para o mesmo aluno ou tentar lançar uma nota já lançada.*/
    @Override
    public Boolean adicaoValida(Atividade atividade, Nota nota) {
        if (atividade.notasLancadas())
            return false;
        for (Nota notaConsultada: atividade.getNota()) {
            if (notaConsultada.getAluno().equals(nota.getAluno()))
                return false;
        }
        return true;
    }
    
       
    @Override
    public Boolean adicionaNota(Atividade atividade, Nota nota){
        if (this.adicaoValida(atividade, nota))
            return atividade.getNota().add(nota);
        return false;
    }
    
    @Override
    public Nota retornaNota (Atividade atividade, Nota nota) {
        return atividade.getNota().get(atividade.getNota().indexOf(nota));
    }
    
}
