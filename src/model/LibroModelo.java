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
 */
public class LibroModelo {
    private EntityManagerFactory emf;
    private EntityManager em;

    public LibroModelo() {
        this.emf = Persistence.createEntityManagerFactory("biblioteca");
        this.em = this.emf.createEntityManager();
    }
    
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
    
    public boolean eliminarLibro(int numeroSerie){
        Libro libro = em.find(Libro.class, numeroSerie);
        em.getTransaction().begin();
        em.remove(libro);
        em.getTransaction().commit();
        return true;
        
    }
    
}
