/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author luis
 */
@Entity
@Table(name = "libro")
public class Libro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero_serie")
    private int serieLibro;
    
    
    
    
    
    
    
    
    
    @Column(name = "isbn")
    private String isbn;
    
    @Column(name = "titulo")
    private String tituloLibro;
    
    @Column(name = "paginas")
    private String numeroPaginas;
    
    @Column(name = "precio")
    private int precioLibro;
    
    @Column(name = "ano")
    private Date anoPublicacion;
    
    @Column(name = "cod_estado")
    private int codigoEstado;
    
    @Column(name = "cod_editorial")
    private int codigoEditorial;

    
    @ManyToMany
    @JoinTable(name = "idioma_libro",
            joinColumns = @JoinColumn(name = "codigo_idioma", referencedColumnName = "codigo_idioma"),
            inverseJoinColumns = @JoinColumn(name = "serie", referencedColumnName = "numero_serie"))
    private List<Idioma> idioma;
    
    @ManyToMany
    @JoinTable(name = "categoria_libro",
            joinColumns = @JoinColumn(name = "cod_categoria" ,referencedColumnName = "cod_categoria"),
            inverseJoinColumns = @JoinColumn(name  =  "serie",referencedColumnName = "numero_serie"))
    private List<Categoria> categoria;
    
    @ManyToMany
    @JoinTable(name = "autor_libro",
            joinColumns = @JoinColumn(name = "cod_autor" , referencedColumnName = "cod_autor"),
            inverseJoinColumns = @JoinColumn(name = "serie", referencedColumnName = "numero_serie"))
    private List<Autor> autor;
       
    
    public Libro() {
    }

    public Libro(int serieLibro, String isbn, String tituloLibro, String numeroPaginas, int precioLibro, Date anoPublicacion, int codigoEstado, int codigoEditorial) {
        this.serieLibro = serieLibro;
        this.isbn = isbn;
        this.tituloLibro = tituloLibro;
        this.numeroPaginas = numeroPaginas;
        this.precioLibro = precioLibro;
        this.anoPublicacion = anoPublicacion;
        this.codigoEstado = codigoEstado;
        this.codigoEditorial = codigoEditorial;
    }

    public int getSerieLibro() {
        return serieLibro;
    }

    public void setSerieLibro(int serieLibro) {
        this.serieLibro = serieLibro;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public String getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(String numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public int getPrecioLibro() {
        return precioLibro;
    }

    public void setPrecioLibro(int precioLibro) {
        this.precioLibro = precioLibro;
    }

    public Date getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(Date anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    public int getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(int codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public int getCodigoEditorial() {
        return codigoEditorial;
    }

    public void setCodigoEditorial(int codigoEditorial) {
        this.codigoEditorial = codigoEditorial;
    }
    
    
    @Override
    public String toString(){
        return"Libro{ n°Serie: " + serieLibro + ", ISBN: " + isbn + ", Titulo: " + tituloLibro + "\n"
                + "Paginas: " + numeroPaginas + ", Precio: " +precioLibro + ", Año Publicacion: " + anoPublicacion + "\n"
                + ", Codigo Estado: " + codigoEstado + ", Codigo Editorial: " + codigoEditorial;
    }
}
