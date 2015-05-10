/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Aula;

/**
 *
 * @author JeanPablo
 */
public interface AulaDao {
    Boolean salvar (Aula aula);
    Boolean remover (Aula aula);
    int indiceAula (String id);
    Aula obterAula (String id);
    List<Aula> obterTodas ();
}