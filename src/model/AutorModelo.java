/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author luis
 * @version 1.3 12-07-2017
 *
 */
public class AutorModelo {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    /**
     * Constructor que inicia la administracion de la Entidad.
     */
    public AutorModelo() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("biblioteca");
        this.entityManager = this.entityManagerFactory.createEntityManager();
    }

    /**
     *Este metodo recibe los datos del nuevo autor, los guarda en un nuevo objeto de tipo Autor y procede
     * a persistir estos datos en la BD, mediante un EntityManager.
     * @param nombre String Nombre del autor
     * @param apellido_paterno String Apellido Paterno del autor
     * @param apellido_materno String Apellido Materno del autor
     * @return Autor retorna un objeto del tipo autor
     */
    public Autor crearAutor(String nombre, String apellido_paterno, String apellido_materno) {
        //Instanciar objeto de clase Autor
        Autor autor = new Autor();
        //Agregar los datos al objeto autor
        autor.setNombre(nombre);
        autor.setApellido_paterno(apellido_paterno);
        autor.setApellido_materno(apellido_materno);

        //guarda los datos en la base de datos
        this.entityManager.getTransaction().begin();
        try {
            entityManager.persist(autor);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error: " + e);
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }

        return autor;
    }

    /**
     * Recibe un int con el codigo del autor, busca el la base de datos el valor
     * que coincida y lo asigna a un nuevo objeto de tipo Autor, luego comienza
     * una nueva transaccion mediante el EntityManager y lo elimina de la base
     * de datos.
     *
     * @param cod_autor INT codigo de identificacion del autor
     * @return boolean retorna si el autor fue eliminado correctamente
     */
    public boolean eliminarAutor(int cod_autor) {
        Autor autor = entityManager.find(Autor.class, cod_autor);

        this.entityManager.getTransaction().begin();
        try {
            this.entityManager.remove(autor);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error: " + e);
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }

        return true;
    }

    /**
     * Metodo que busca todos los autores disponibles en la BD y los devuelve en
     * Forma de List de Autor.
     *
     * @return List de objeto Autor.
     */
    public List<Autor> buscarAutores() {
        List<Autor> autores = null;
        try {
            autores = entityManager.createQuery("Select a from Autor a").getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error en la base de datos:" + e);
        }

        return autores;
    }

    /**
     * Permite Editar los datos del autor, reemplazandolo por los datos
     * ingresados en los parametros.
     *
     * @param codAutor INT Codigo e ID del autor en la BD, utilizado para
     * buscarlo.
     * @param nombreAutor String Nombre del autor a reemplazar.
     * @param apellidoPaterno String Apellido Paterno del autor a reemplazar.
     * @param apellidoMaterno String Apellido Materno del autor a reemplazar.
     * @return boolean Retornara TRUE si se ha realizado exitosamente la edición
     * de los datos en la BD.
     */
    public Autor editarAutor(int codAutor, String nombreAutor, String apellidoPaterno, String apellidoMaterno) {
        //Buscar al autor en la BD y asignarlo a un objeto
        Autor autor = this.entityManager.find(Autor.class, codAutor);

        //Modificar el objeto con los nuevos valores
        autor.setNombre(nombreAutor);
        autor.setApellido_paterno(apellidoPaterno);
        autor.setApellido_materno(apellidoMaterno);

        this.entityManager.getTransaction().begin();
        try {
            //Persistir el objeto con los nuevos valores.
            this.entityManager.merge(autor);
            this.entityManager.getTransaction().commit();
            
        } catch (Exception e) {
            //Mostrar mensaje si se produce un error.
            JOptionPane.showMessageDialog(null, "Se ha producido un error en la Base de datos:" + e);
            
        } 

        return autor;
    }

    /**
     * Metodo que busca en la base de datos con el ID ingresado al autor en la BD.
     * @param ID Int ID del autor en la BD.
     * @return Autor objeto encontrado en la BD.
     */
    public Autor porId(int ID){
        Autor autor = this.entityManager.find(Autor.class, ID);
        return autor;
        
    }
}
