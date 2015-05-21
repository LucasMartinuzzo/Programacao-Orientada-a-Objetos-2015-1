package model.dao;

import java.util.Collections;
import java.util.List;
import model.pojo.Aluno;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import model.pojo.Turma;

/**
 *
 * @author Filipe
 */
public class AlunoDaoImpl implements Dao {
    
    private static List<Aluno> listaAluno = new ArrayList<>();
    private static AlunoDaoImpl instancia = null;
    
    public static AlunoDaoImpl getInstancia(){//TALVEZ ISSO DÊ ERRO
        if(AlunoDaoImpl.instancia == null)
            instancia = new AlunoDaoImpl();
        return instancia;
    }
    
    @Override
    public void imprimir (){
        Aluno aluno;
        System.out.println(this.obterTodos().size());
        for(Object a: this.obterTodos()){
            aluno = (Aluno) a;
            System.out.println(aluno.toString());
        }
    }
    
    @Override
    public Boolean inserir (Object objeto) {
        Aluno aluno = (Aluno) objeto;
        if (this.indice(aluno.getCpf()) <= -1) {
            listaAluno.add(aluno);
            Collections.sort(listaAluno);
            return true;
        }
        return false;
    }
    
    @Override
    public Boolean remover (Object objeto) {
        Aluno aluno = (Aluno) objeto;
        return listaAluno.remove(aluno);
    }
    
    @Override
    public int indice (String cpf) {
        return Collections.binarySearch(listaAluno, new Aluno (null, cpf));
    }
    
    @Override
    public Object obter (String cpf) {
        if (this.indice(cpf) != -1)
            return listaAluno.get(this.indice(cpf));
        return null;
    }
    
    @Override
    public List<Object> obterTodos () {
        return (List<Object>) (Object) listaAluno;
    }
    
    
    @Override
    public void salvar () throws IOException{
        File file = new File("Aluno.txt");
        if(!file.exists())
            file.createNewFile();
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        for(Aluno aluno: this.listaAluno){
            bw.write(aluno.getNome());
            bw.newLine();
            bw.write(aluno.getCpf());
            bw.newLine();
            if (aluno.getTurma().isEmpty())
                bw.write("NULL");
            else
                for(int i = 0; i< aluno.getTurma().size(); i++){
                    bw.write(aluno.getTurma().get(i).getId());
                    bw.write(",");
                }
            bw.newLine();
            if (aluno.getFalta().isEmpty())
                bw.write("NULL");
            else
                for(int i = 0; i< aluno.getFalta().size(); i++){
                    bw.write(aluno.getFalta().get(i).getId());
                    bw.write(",");
                }
            bw.newLine();
        }
        bw.close();
        fw.close();
    }
    
    @Override
    public void carregar () throws IOException{
        File file = new File ("Aluno.txt");
        FileReader fr = new FileReader (file);
        BufferedReader br = new BufferedReader (fr);
        while (br.ready()){
            String nome = br.readLine();
            String cpf = br.readLine();
            Aluno aluno = new Aluno(nome, cpf);
            this.inserir(aluno);
            String[] turma = br.readLine().split(",");
            for(String t: turma)
                if(!(t.equals("NULL")))
                    aluno.adicionarTurma(TurmaDaoImpl.getInstancia().obter(t));
            String[] falta = br.readLine().split(",");
            for(String f: falta)
                if(!(f.equals("NULL")))
                    aluno.adicionarFalta(FaltaDaoImpl.getInstancia().obter(f));
        }
        br.close();
        fr.close();
    }
}