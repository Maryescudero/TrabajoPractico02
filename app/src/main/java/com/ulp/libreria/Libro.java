package com.ulp.libreria;

import java.io.Serializable;

public class Libro implements Serializable {
    private String titulo;
    private String autor;
    private int paginas;
    private int anio;
    private String genero;
    private String categoria;
    private int foto; // Recurso drawable para la portada
    private String descripcion;

    public Libro(String titulo, String autor, int paginas, int anio, String genero, String categoria, int foto, String descripcion) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.anio = anio;
        this.genero = genero;
        this.categoria = categoria;
        this.foto = foto;
        this.descripcion = descripcion;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getPaginas() { return paginas; }
    public int getAnio() { return anio; }
    public String getGenero() { return genero; }
    public String getCategoria() { return categoria; }
    public int getFoto() { return foto; }
    public String getDescripcion() { return descripcion; }
}
