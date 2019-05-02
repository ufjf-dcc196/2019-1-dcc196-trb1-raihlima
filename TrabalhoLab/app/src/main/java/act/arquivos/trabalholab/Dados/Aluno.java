package act.arquivos.trabalholab.Dados;

public class Aluno {

    private String nome;
    private String ano;
    private String semestre;
    private Curso linguas;
    private Curso exatas;
    private Curso saude;
    private Curso humanidades;

    public Aluno(){
        this.exatas = new Curso("Exatas",0,0);
        this.linguas = new Curso("Línguas",0,0);
        this.saude = new Curso("Saúde",0,0);
        this.humanidades = new Curso("Humanidades",0,0);
    }

    public Aluno(String nome, String ano, String semestre) {
        this.nome = nome;
        this.ano = ano;
        this.semestre = semestre;
        this.exatas = new Curso("Exatas",0,0);
        this.linguas = new Curso("Línguas",0,0);
        this.saude = new Curso("Saúde",0,0);
        this.humanidades = new Curso("Humanidades",0,0);
    }

    public Aluno(String nome, String ano, String semestre, Curso linguas, Curso exatas, Curso saude, Curso humanidades) {
        this.nome = nome;
        this.ano = ano;
        this.semestre = semestre;
        this.linguas = linguas;
        this.exatas = exatas;
        this.saude = saude;
        this.humanidades = humanidades;
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

    public Curso getLinguas() {
        return linguas;
    }

    public void setLinguas(Curso linguas) {
        this.linguas = linguas;
    }

    public Curso getExatas() {
        return exatas;
    }

    public void setExatas(Curso exatas) {
        this.exatas = exatas;
    }

    public Curso getSaude() {
        return saude;
    }

    public void setSaude(Curso saude) {
        this.saude = saude;
    }

    public Curso getHumanidades() {
        return humanidades;
    }

    public void setHumanidades(Curso humanidades) {
        this.humanidades = humanidades;
    }
}
