
package model;

public class Orientacao {
    private int idOrientacao;
    private String descricaoOrientacao;
    private String orientadoOrientacao;
    private Professor professor;
    
    public Orientacao(){
        professor = new Professor();
    }

    public int getIdOrientacao() {
        return idOrientacao;
    }

    public void setIdOrientacao(int idOrientacao) {
        this.idOrientacao = idOrientacao;
    }

    public String getDescricaoOrientacao() {
        return descricaoOrientacao;
    }

    public void setDescricaoOrientacao(String descricaoOrientacao) {
        this.descricaoOrientacao = descricaoOrientacao;
    }

    public String getOrientadoOrientacao() {
        return orientadoOrientacao;
    }

    public void setOrientadoOrientacao(String orientadoOrientacao) {
        this.orientadoOrientacao = orientadoOrientacao;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    
}
