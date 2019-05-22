package act.arquivos.trabalholab.Dados;

import java.util.ArrayList;
import java.util.List;

public class Aluno {

    private String nome;
    private String ano;
    private String semestre;
    private List <Periodo> listaPeriodos;


    public Aluno(){
        this.listaPeriodos = new ArrayList<>();
    }

    public Aluno(String nome, String ano, String semestre) {
        this.nome = nome;
        this.ano = ano;
        this.semestre = semestre;
        this.listaPeriodos = new ArrayList<>();
    }

    public Aluno(String nome, String ano, String semestre, Curso linguas, Curso exatas, Curso saude, Curso humanidades) {
        this.nome = nome;
        this.ano = ano;
        this.semestre = semestre;
        this.listaPeriodos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public List<Periodo> getListaPeriodos() {
        return listaPeriodos;
    }

    public void setListaPeriodos(List<Periodo> listaPeriodos) {
        this.listaPeriodos = listaPeriodos;
    }

    public void addPeriodo(Periodo p){
        this.listaPeriodos.add(p);
    }
}
