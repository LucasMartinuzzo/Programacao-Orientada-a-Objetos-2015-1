package model.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.pojo.Professor;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author Pedro
 */
public class ProfessorDaoImpl implements Dao {
    private static List<Professor> listaProfessor = new ArrayList<>();
    private static ProfessorDaoImpl instancia = null;
    
    public static ProfessorDaoImpl getInstancia(){//TALVEZ ISSO DÊ ERRO
        if(ProfessorDaoImpl.instancia == null)
            instancia = new ProfessorDaoImpl();
        return instancia;
    }
    @Override
    public Boolean inserir (Object objeto) {
        Professor professor = (Professor) objeto;
        if (this.indice(professor.getCpf()) == -1) {
            listaProfessor.add(professor);
            Collections.sort(listaProfessor);
            return true;
        }
        return false;
    }
    
    @Override
    public Boolean remover (Object objeto) {
        Professor professor = (Professor) objeto;
        return listaProfessor.remove(professor);
    }
    
    @Override
    public int indice (String cpf) {
        return Collections.binarySearch(listaProfessor, new Professor (null, cpf, null));
    }
    
    @Override
    public Object obter (String cpf) {
        if (this.indice(cpf) != -1)
            return listaProfessor.get(this.indice(cpf));
        return null;
    }
    
    @Override
    public List<Object> obterTodos () {
        return (List<Object>) (Object) listaProfessor;
    }
    
    @Override
    public void salvar () throws IOException{
        File file = new File("Professor.txt");
        if(!file.exists())
            file.createNewFile();
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        for(Professor professor: this.listaProfessor){
            bw.write(professor.getNome());
            bw.newLine();
            bw.write(professor.getCpf());
            bw.newLine();
            bw.write(professor.getDepartamento());
            bw.newLine();
            if (professor.getDisciplina().isEmpty())
                bw.write("NULL");
            else
                for(int i = 0; i< professor.getDisciplina().size(); i++){
                    bw.write(professor.getDisciplina().get(i).getNome());
                    bw.write(",");
                }
            bw.newLine();
        }
        bw.close();
        fw.close();
    }
    
    @Override
    public void carregar () throws IOException{
        File file = new File ("Professor.txt");
        FileReader fr = new FileReader (file);
        BufferedReader br = new BufferedReader (fr);
        while (br.ready()){
            String nome = br.readLine();
            String cpf = br.readLine();
            String departamento = br.readLine();
            Professor professor = new Professor(nome,cpf,departamento);
            this.inserir(professor);
            String[] disciplina = br.readLine().split(",");
            for(String d: disciplina)
                if(!(d.equals("NULL")))
                    professor.adicionarDisciplina(DisciplinaDaoImpl.getInstancia().obter(d));
        }
        br.close();
        fr.close();
    }
}