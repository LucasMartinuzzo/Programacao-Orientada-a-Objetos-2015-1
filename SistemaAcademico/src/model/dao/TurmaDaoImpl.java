/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.pojo.Aluno;
import model.pojo.Atividade;
import model.pojo.Aula;
import model.pojo.Turma;

/**
 *
 * @author JeanPablo
 */
public class TurmaDaoImpl implements TurmaDao {
    
    private Turma turma;
    
    @Override
    public Boolean adicionarAula (Aula aula) {
        if (this.turma.aula.contains(aula) == false)
            return this.turma.aula.add(aula);
        return false;
    }
    
    @Override
    public Boolean removerAula (Aula aula) {
        return this.turma.aula.remove(aula);
    }
    
    @Override
    public Aula retornaAula (Aula aula) {
        return this.turma.aula.get(this.turma.aula.indexOf(aula));
    }
    
    @Override
    public Boolean adicaoDeAlunoValida (Aluno aluno) {
        return (this.turma.getAluno().contains(aluno) == false || 
                this.turma.getAluno().size() < this.turma.getNumeroDeVagas());
    }
    
    @Override
    public Boolean adicionarAluno (Aluno aluno) {
        if (this.adicaoDeAlunoValida(aluno)) {
            aluno.getTurma().add(this.turma);
            return this.turma.getAluno().add(aluno);
        }
        return false;
    }
    
    @Override
    public Boolean removerAluno (Aluno aluno) {
        if (this.turma.getAluno().remove(aluno))
            return aluno.getTurma().remove(this.turma);
        return false;
    }
    
    @Override
    public Boolean adicionarAtividade (Atividade atividade) {
        if (this.turma.getAtividade().contains(atividade) == false)
            return this.turma.getAtividade().add(atividade);
        return false;
    }
    
    @Override
    public Boolean removerAtividade (Atividade atividade) {
        return this.turma.getAtividade().remove(atividade);
    }
    
    @Override
    public Atividade retornaAtividade (Atividade atividade) {
        return this.turma.getAtividade().get(this.turma.getAtividade().indexOf(atividade));
    }
}