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
import javax.persistence.Query;


/**
 *
 * @author luis
 * @version 1.1
 * 07-07-2017
 */
public class MetodoPagoModelo {

    private EntityManagerFactory emf;
    private EntityManager em;

    /**
     * Constructor de la clase MetodoPagoModelo, que conecta al instanciarse a
     * la base de datos.
     */
    public MetodoPagoModelo() {

        this.emf = Persistence.createEntityManagerFactory("biblioteca");
        this.em = this.emf.createEntityManager();
    }

    /**
     * Metodo que permite ingresar un nuevo metodo de pago a la base de datos.
     *
     * @param nombreMetodo String nombre del metodo a guardar.
     * @return boolean retorna true si se ha guardado correctamente.
     */
    public boolean agregarMetodo(String nombreMetodo) {
        MetodoPago metod = new MetodoPago();
        metod.setDescripcionMetodo(nombreMetodo);    
      
            this.em.getTransaction().begin();
            this.em.persist(metod);
            this.em.getTransaction().commit();
      
        return true;
    }

    /**
     * Metodo que permite eliminar de la base de datos un metodo de pago
     * mediante su ID.
     *
     * @param codMetodo Int Codigo del metodo de pago.
     * @return boolean retorna true si la eliminación se realizó con exito, de
     * lo contrario, retorna false.
     */
    public boolean eliminarMetodo(int codMetodo) {
        MetodoPago metod = em.find(MetodoPago.class, codMetodo);

        this.em.getTransaction().begin();
        this.em.remove(metod);

        this.em.getTransaction().commit();
        return true;
    }
    
    /**
     * Busca un Metodo de Pago en la BD y lo edita por los nuevos valores.
     * @param codMetodo int ID del Metodo de Pago.
     * @param nombreMetodo String Nuevo valor a guardar.
     * @return boolean Retorna true si se ha realizado la edicion exitosamente.
     */
    public boolean editarMetodo(int codMetodo, String nombreMetodo){
        MetodoPago metodo = em.find(MetodoPago.class, codMetodo);
        metodo.setDescripcionMetodo(nombreMetodo);
        
        em.getTransaction().begin();
        em.merge(metodo);
        em.getTransaction().commit();
        
        return true;
    }
    
    /**
     * Obtiene todos los metodos de pago de la BD y los devuelve en forma de List de tipo MetodoPago.
     * @return List de tipo MetodoPago.
     */
    public List<MetodoPago> consultarMetodos(){
        List<MetodoPago> metodos = em.createQuery("Select m from MetodoPago m").getResultList();
        return metodos;
    }

    
}
