package br.com.entra21.bean;

/**
 * @author Crispim Paiano dos Santos
 */
public class AlunosBean {
    
    private int id;
    private String nome, codMatricula, condicao;

    private float nota1, nota2, nota3;
    private byte frequencia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodMatricula() {
        return codMatricula;
    }

    public void setCodMatricula(String codMatricula) {
        this.codMatricula = codMatricula;
    }

    public float getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public float getNota3() {
        return nota3;
    }

    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }

    public byte getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(byte frequencia) {
        this.frequencia = frequencia;
    }
    
    public String getCondicao() {
        
        float media = (nota1+nota2+nota3)/3;
        if(frequencia<65){
            condicao="Reprovado por frequência";
        }else if(media<5){
            condicao="Reprovado por média";
        }else if(media<7){
            condicao="Em exame";
        }else{
            condicao="Aprovado";
        }
        
        return condicao;
    }
    
}
