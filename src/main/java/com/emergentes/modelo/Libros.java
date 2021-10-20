
package com.emergentes.modelo;

public class Libros {
    private String titulo;
    private String autor;
    private String resumen ;
    private String medio;
    private int id;

    public Libros() {
        int id =0;
        String titulo =" ";
        String autor = " ";
        String resumen = " ";
        String medio = " ";
    }

    public Libros(int id,String titulo, String autor, String resumen, String medio) {
        this.titulo = titulo;
        this.autor = autor;
        this.resumen = resumen;
        this.medio = medio;
        this.id= id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getMedio() {
        return medio;
    }

    public void setMedio(String medio) {
        this.medio = medio;
    }
}
