package model.dao;

import java.util.Collections;
import java.util.List;
import model.pojo.Atividade;

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
    
}
