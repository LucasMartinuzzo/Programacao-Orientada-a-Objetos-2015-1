package model.dao;

import java.util.Collections;
import java.util.List;
import model.pojo.Turma;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author JeanPablo
 */
public class TurmaDaoImpl implements Dao {
    
    private static List<Turma> listaTurma;
    
    @Override
    public Boolean inserir (Object objeto) {
        Turma turma = (Turma) objeto;
        if (this.indice(turma.getId()) == -1) {
            listaTurma.add(turma);
            Collections.sort(listaTurma);
            return true;
        }
        return false;
    }
    
    @Override
    public Boolean remover (Object objeto) {
        Turma turma = (Turma) objeto;
        return listaTurma.remove(turma);
    }
    
    @Override
    public int indice (String id) {
        return Collections.binarySearch(listaTurma, new Turma (id, null, 
                null, null, null, null, null));
    }
    
    @Override
    public Object obter (String id) {
        if (this.indice(id) != -1)
            return listaTurma.get(this.indice(id));
        return null;
    }
    
    @Override
    public List<Object> obterTodos () {
        return (List<Object>) (Object) listaTurma;
    }
    
    @Override
    public void salvar () throws IOException{
        File file = new File("Turma.txt");
        if(!file.exists())
            file.createNewFile();
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        for(Turma turma: this.listaTurma){
            bw.write(turma.getId());
            bw.newLine();
            bw.write(turma.getAno().toString());
            bw.newLine();
            bw.write(turma.getPeriodo().toString());
            bw.newLine();
            bw.write(turma.getNumeroDeVagas().toString());
            bw.newLine();
            bw.write(turma.getDisciplina().getNome());
            bw.newLine();
            bw.write(turma.getProfessor().getCpf());
            bw.newLine();
            for(int i = 0; i< turma.getAula().size(); i++){
                bw.write(turma.getAula().get(i).getId());
                bw.write(",");
            }
            bw.newLine();
            for(int i = 0; i< turma.getAluno().size(); i++){
                bw.write(turma.getAluno().get(i).getCpf());
                bw.write(",");
            }
            bw.newLine();
            for(int i = 0; i< turma.getAtividade().size(); i++){
                bw.write(turma.getAtividade().get(i).getId());
                bw.write(",");
            }
            bw.newLine();
        }
        bw.close();
        fw.close();
    }
    
    @Override
    public void carregar (){
    //*Implementar*//
    }
}