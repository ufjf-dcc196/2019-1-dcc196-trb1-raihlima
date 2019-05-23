package act.arquivos.trabalholab.Dados;

public class Periodo {
    int ano;
    int semestre;
    private Curso linguas;
    private Curso exatas;
    private Curso saude;
    private Curso humanidades;

    public Periodo(){
        this.semestre=0;
        this.ano=0;
        this.exatas = new Curso("Exatas",0,0);
        this.linguas = new Curso("Línguas",0,0);
        this.saude = new Curso("Saúde",0,0);
        this.humanidades = new Curso("Humanidades",0,0);
    }

    public Periodo(int ano, int semestre) {
        this.ano = ano;
        this.semestre = semestre;
        this.exatas = new Curso("Exatas",0,0);
        this.linguas = new Curso("Línguas",0,0);
        this.saude = new Curso("Saúde",0,0);
        this.humanidades = new Curso("Humanidades",0,0);
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
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

    public int getTotalHoras(){
        return this.saude.getHoras() + this.exatas.getHoras() + this.humanidades.getHoras() + this.linguas.getHoras();
    }
}
