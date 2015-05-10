/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.Collections;
import java.util.List;
import model.pojo.Nota;

/**
 *
 * @author Pedro
 */
public class NotaDaoImpl implements NotaDao{
    private List<Nota> listaNota;
    
    @Override
    public Boolean salvar (Nota nota){
        if(this.indiceNota(nota.getId()) == -1){
            this.listaNota.add(nota);
            Collections.sort(this.listaNota);
            return true;
        }
        return false;
    }
    
    @Override
    public Boolean remover (Nota nota){
        return this.listaNota.remove(nota);
    }
    
    @Override
    public int indiceNota (String id){
        return Collections.binarySearch(listaNota, new Nota(id, null, null, null));
    }
    
    @Override
    public Nota obterNota (String id){
        if (this.indiceNota(id) != -1)
            return this.listaNota.get(this.indiceNota(id));
        return null;
    }
    
    @Override
    public List<Nota> obterTodos (){
        return listaNota;
    }
}