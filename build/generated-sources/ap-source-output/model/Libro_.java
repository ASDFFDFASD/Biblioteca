package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Autor;
import model.Categoria;
import model.Idioma;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-10T20:47:04")
@StaticMetamodel(Libro.class)
public class Libro_ { 

    public static volatile SingularAttribute<Libro, Date> anoPublicacion;
    public static volatile ListAttribute<Libro, Autor> compra;
    public static volatile SingularAttribute<Libro, Integer> precioLibro;
    public static volatile SingularAttribute<Libro, String> isbn;
    public static volatile ListAttribute<Libro, Categoria> categoria;
    public static volatile SingularAttribute<Libro, String> numeroPaginas;
    public static volatile ListAttribute<Libro, Idioma> idioma;
    public static volatile SingularAttribute<Libro, Integer> codigoEstado;
    public static volatile SingularAttribute<Libro, Integer> codigoEditorial;
    public static volatile SingularAttribute<Libro, Integer> serieLibro;
    public static volatile SingularAttribute<Libro, String> tituloLibro;
    public static volatile ListAttribute<Libro, Autor> autor;

}