/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author luis
 * @version 1.0
 */
public class AutorModelo {
     private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

   /**
    * Constructor de AutorModelo que conecta a la base de datos
    */
    /**
     * 
     */
    public AutorModelo() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("biblioteca");
        this.entityManager = this.entityManagerFactory.createEntityManager();
    }
    /**
     * Recibe los datos del autor y los envia hacia la base de datos 
     * para guardarlos
     * @param nombre  String Nombre del autor
     * @param apellido_paterno String Apellido Paterno del autor
     * @param apellido_materno String Apellido Materno del autor
     * @return Autor retorna un objeto del tipo autor
     */
    
    public Autor crearAutor(String nombre, String apellido_paterno, String apellido_materno){
        //Instanciar objeto de clase Autor
        Autor autor = new Autor();
        //Agregar los datos al objeto autor
        autor.setNombre(nombre);
        autor.setApellido_paterno(apellido_paterno);
        autor.setApellido_materno(apellido_materno);
        
        //guarda los datos en la base de datos
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(autor);
        this.entityManager.getTransaction().commit();
        return autor;
    }
    /**
     * Recibe un codigo de autor y lo busca en la base de datos para eliminarlo
     * y confirar su eliminacion
     * @param cod_autor INT codigo de identificacion del autor
     * @return boolean retorna si el autor fue eliminado correctamente
     */
    public boolean eliminarAutor(int cod_autor){
        Autor autor = entityManager.find(Autor.class, cod_autor);
        
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(autor);
        this.entityManager.getTransaction().commit();
        
        return true;
    }
}
