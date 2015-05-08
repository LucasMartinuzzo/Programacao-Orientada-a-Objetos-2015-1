/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.pojo.Aluno;
import model.pojo.Nota;
import model.pojo.Turma;


/**
 *
 * @author Filipe
 */
public class AlunoDaoImple implements AlunoDao {
    
    private Aluno aluno;
   // private List<Turma> turma; 
   // private List<Falta> falta;
    //private List<Nota> nota;
    
    /*Pois o professor pode lançar duas notas de valores diferentes para um
    aluno para a mesma atividade*/
    @Override
    public boolean adicaoValida(Nota nota) {
        for (Nota notaConsultada: this.aluno.getNota()) {
            if (notaConsultada.getAtividade().equals(nota.getAtividade()))
                    return false;
        }
        return true; 
    }
//    @Override
//    public boolean adicaoValida(Aluno aluno, Nota nota) {
//        for (Aluno aluno1: this.listaAluno) {
//                if (aluno1.getNota().equals(nota))
//                    return false;
//        }
//        return true;
//    }
    @Override
    public void adicionaNota(Nota nota){
        this.aluno.getNota().add(nota);
    }
//    @Override
//        public void adicionaNota(Aluno aluno, Nota nota){
//            this.listaAluno.get(this.listaAluno.indexOf(aluno)).getNota().add(nota);
//    }
    
    @Override
    public Nota retornaNota (Nota nota) {
        return this.aluno.getNota().get(this.aluno.getNota().indexOf(nota)); // elemento nota na lista de nota 
    }
    
//    @Override
//    public Nota retornaNota (Aluno aluno, Nota nota ) {
//            if (this.listaAluno.get(this.listaAluno.indexOf(aluno)).getNota().contains(nota))
//                return this.listaAluno.get(this.listaAluno.indexOf(aluno)).getNota()
//                       .get(this.listaAluno.get(this.listaAluno.indexOf(aluno))
//                       .getNota().indexOf(nota));       
//            return null;
//    }
        
//    public void setNota (Nota notaAntiga, Nota notaNova) {
//        Nota notaNaLista = this.retornaNota(notaAntiga);
//        notaNaLista = notaNova;
//    }
    @Override
    public Double NotaFinal(Turma turma){
        Double somaNotas = 0.0;
        for(Nota notaConsultada: this.aluno.getNota())
            if(notaConsultada.getAtividade().getTurma().equals(turma))
                somaNotas += notaConsultada.getNota();
                
        
        return somaNotas;
     }
//    @Override
//    public Double NotaFinal(Aluno aluno, Turma turma){
//        Double somaNotas = 0.0;
//        if(this.listaAluno.contains(aluno))
//            for(Nota notaConsultada: this.listaAluno.get(this.listaAluno.indexOf(aluno)).getNota())
//                if(notaConsultada.getAtividade().getTurma().ehIgual(turma))
//                    somaNotas += notaConsultada.getNota();
//        return somaNotas;
//     }
}