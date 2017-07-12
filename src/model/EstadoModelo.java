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

/**
 * 
 * @author luis
 * @version 1.2
 */
public class EstadoModelo {
    private EntityManagerFactory emf;
    private EntityManager em;

    /**
     * Constructor de la clase EstadoModelo la cual se conecta a la base de datos.
     */
    public EstadoModelo() {
        this.emf = Persistence.createEntityManagerFactory("biblioteca");
        this.em = this.emf.createEntityManager();
    }
    /**
     * Metodo que permite insertar un nuevo estado en la base de datos.
     * @param descripcion String Descripcion del estado que recibe como parametro.
     * @return Estado retorna un objeto del tipo Estado.
     */
    public boolean agregarModelo(String descripcion){
        Estado est = new Estado();
        est.setDescripcionEstado(descripcion);
        
        em.getTransaction().begin();
        em.persist(est);
        em.getTransaction().commit();
        return true;
    }
    
    /**
     * Metodo que permite Eliminar un Metodo de pago de la BD
     * @param codigoModelo INT ID del Metodo de Pago.
     * @return boolean Retorna true si se ha eliminado exitosamente el Metodo de Pago.
     */
    public boolean eliminarModelo(int codigoModelo){
        Estado est = em.find(Estado.class, codigoModelo);
        
        em.getTransaction().begin();
        em.remove(est);
        em.getTransaction().commit();
        return true;
    }
     /**
      * Obtiene todos los estados desde la BD y los retorna en un List de tipo Estado.
      * @return List de Tipo ESTADO.
      */
    public List<Estado> consultarEstados(){
        List<Estado> estados = em.createQuery("Select e from Estado e").getResultList();
        return estados;
    }
    
    /**
     * Busca un Estado por su ID y lo reemplaza por el valor ingresado en el segundo parametro.
     * @param codEstado INT ID del Estado 
     * @param descripcionEstado String Descripcion del Estado.
     * @return  boolean Retornara TRUE si se han realizado los cambios exitosamente.
     */
    public boolean editarEstado(int codEstado, String descripcionEstado){
        Estado est = em.find(Estado.class, codEstado);
        est.setDescripcionEstado(descripcionEstado);
        
        em.getTransaction().begin();
        em.merge(est);
        em.getTransaction().commit();
        
        return true;
    }
            
    
}
