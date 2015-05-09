/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.pojo.Atividade;
import model.pojo.Nota;

/**
 *
 * @author Mônicka
 */
public class AtividadeDaoImpl implements AtividadeDao{
    
    private List<Atividade> listaAtividade;
       
    
    @Override
    public Boolean salvar(Atividade atividade) {
        if (this.indiceAtividade(atividade.getId()) == -1){
            this.listaAtividade.add(atividade);
            Collections.sort(this.listaAtividade);
            return true;
        }
        return false;
    }
    
    
    @Override
    public Boolean remover(Atividade atividade){
        return this.listaAtividade.remove(atividade);
    }
    
    
    @Override
    public int indiceAtividade(String id) {
        return Collections.binarySearch(this.listaAtividade, new Atividade(id, null, null, null, null, null));
    }
    
    @Override
    public Atividade obterAtividade(String id) {
        if (this.indiceAtividade(id) != -1)
            return this.listaAtividade.get(this.listaAtividade.indexOf(this.indiceAtividade(id)));
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
