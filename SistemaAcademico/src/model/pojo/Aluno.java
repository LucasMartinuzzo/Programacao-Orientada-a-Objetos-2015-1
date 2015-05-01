/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pojo;

import java.util.List;
/**
 *
 * @author JeanPablo
 */
public class Aluno {
    private String nome;
    private String CPF;
    private List<Turma> turma; 
    private List<Falta> falta;
    private List<Nota> nota;
}
