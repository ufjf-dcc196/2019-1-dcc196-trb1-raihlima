package act.arquivos.trabalholab.Dados;

class Disciplina {
    private String nome;
    private String horas;

    public Disciplina() {
    }

    public Disciplina(String nome, String horas) {
        this.nome = nome;
        this.horas = horas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }
}
