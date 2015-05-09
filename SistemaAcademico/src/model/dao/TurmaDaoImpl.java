/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.Collections;
import java.util.List;
import model.pojo.Aluno;
import model.pojo.Atividade;
import model.pojo.Aula;
import model.pojo.Turma;

/**
 *
 * @author JeanPablo
 */
public class TurmaDaoImpl implements TurmaDao {
    
    /*TRATAR ENTRADAS NULAS*/
    
    private List<Turma> listaTurma;
    
    @Override
    public Boolean salvar (Turma turma) {
        if (!this.contemTurma(turma.getId())) {
            this.listaTurma.add(turma);
            Collections.sort(this.listaTurma);
            return true;
        }
        return false;
    }
    
    @Override
    public Boolean remover (Turma turma) {
        return this.listaTurma.remove(turma);
    }
    
    @Override
    public Boolean contemTurma (String id) {
        //ORDENAR LISTA DE TURMAS PELO ID E APLICAR BUSCA BINÁRIA BASEADA NESTE.
        return false;
    }
    
    @Override
    public Turma obterTurma (String id) {
        if (this.contemTurma(id))
            return this.listaTurma.get(this.listaTurma.indexOf(/*?????*/));
        return null;
    }
    
    @Override
    public List<Turma> obterTodas () {
        return listaTurma;
    }
    
    @Override
    public Boolean adicionarAula (Turma turma, Aula aula) {
        if (turma.getAula().contains(aula) == false)
            return turma.getAula().add(aula);
        return false;
    }
    
    @Override
    public Boolean removerAula (Turma turma, Aula aula) {
        return turma.getAula().remove(aula);
    }
    
    @Override
    public Aula retornaAula (Turma turma, Aula aula) {
        if (turma.getAula().contains(aula))
            return turma.getAula().get(turma.getAula().indexOf(aula));
        else
            return null;
    }
    
    @Override
    public Boolean adicaoDeAlunoValida (Turma turma, Aluno aluno) {
        return (turma.getAluno().contains(aluno) == false || 
                turma.getAluno().size() < turma.getNumeroDeVagas());
    }
    
    @Override
    public Boolean adicionarAluno (Turma turma, Aluno aluno) {
        if (this.adicaoDeAlunoValida(turma, aluno)) {
            aluno.getTurma().add(turma);
            return turma.getAluno().add(aluno);
        }
        return false;
    }
    
    @Override
    public Boolean removerAluno (Turma turma, Aluno aluno) {
        if (turma.getAluno().remove(aluno))
            return aluno.getTurma().remove(turma);
        return false;
    }
    
    @Override
    public Boolean adicionarAtividade (Turma turma, Atividade atividade) {
        if (turma.getAtividade().contains(atividade) == false)
            return turma.getAtividade().add(atividade);
        return false;
    }
    
    @Override
    public Boolean removerAtividade (Turma turma, Atividade atividade) {
        return turma.getAtividade().remove(atividade);
    }
    
    @Override
    public Atividade retornaAtividade (Turma turma, Atividade atividade) {
        if (turma.getAtividade().contains(atividade))
            return turma.getAtividade().get(turma.getAtividade().indexOf(atividade));
        else
            return null;
    }
}