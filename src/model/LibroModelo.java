/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author luis
 * @version 1.1 
 */
public class LibroModelo {
    private EntityManagerFactory emf;
    private EntityManager em;
/**
 * Constructor de la clase que permite conectarse a la base de datos mediante las entity.
 */
    public LibroModelo() {
        this.emf = Persistence.createEntityManagerFactory("biblioteca");
        this.em = this.emf.createEntityManager();
    }
    /**
     * Metodo que permite ingresar un nuevo libre a la base de datos, mediante las entity y el objeto libro.
     * @param isbn String Contiene el codigo ISBN con el cual se identifica al libro.
     * @param titulo Strign Contiene el título del libro que se desea ingresar a la BD. 
     * @param paginas String Contiene el numero de páginas que contiene el libro. 
     * @param precio int Contiene el valor del libro.
     * @param ano Date parametro tipo Date que almacena el año de publicación del libro.
     * @param cod_estado int Contiene la FK del estado del libro.
     * @param codeditorial int Contiene la FK de la editorial que produjo el libro.
     * @return Libro Devuelve un objeto del Tipo libro que contiene los atributos y valores ingresados en el metodo.
     */
    public Libro agregarLibro(String isbn, String titulo, String paginas,int precio
            , Date ano, int cod_estado, int codeditorial){
        
        Libro libro = new Libro();
        libro.setIsbn(isbn);
        libro.setTituloLibro(titulo);
        libro.setNumeroPaginas(paginas);
        libro.setPrecioLibro(precio);
        libro.setAnoPublicacion(ano);
        libro.setCodigoEstado(cod_estado);
        libro.setCodigoEditorial(codeditorial);
        
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
        return libro;
    }
    /**
     * Metodo que permite eliminar un libro de la base de datos, mediante su numero de serie unico.
     * @param numeroSerie int Contiene el numero de serie unico del libro.
     * @return  boolean retorna true si se ha eliminado con exito el libro de la base de datos,
     * de lo contrario retorna false.
     */
    public boolean eliminarLibro(int numeroSerie){
        Libro libro = em.find(Libro.class, numeroSerie);
        em.getTransaction().begin();
        em.remove(libro);
        em.getTransaction().commit();
        return true;
        
    }
    
}
