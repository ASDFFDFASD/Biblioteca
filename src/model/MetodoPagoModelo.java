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
public class MetodoPagoModelo {
private EntityManagerFactory emf;
private EntityManager em;

/**
 * Constructor de la clase MetodoPagoModelo, que conecta al instanciarse a la base de datos.
 */
    public MetodoPagoModelo() {
        this.emf = Persistence.createEntityManagerFactory("biblioteca");
        this.em = this.emf.createEntityManager();
    }

    /**
     * Metodo que permite ingresar un nuevo metodo de pago a la base de datos.
     * @param detalle String Contiene la descripcion del metodo de pago.
     * @return MetodoPago Retorna un objeto del tipo MetodoPago con los valores introdcidos en el metodo.
     */
    public MetodoPago agregarMetodo(String detalle){
        MetodoPago metod = new MetodoPago();
        metod.setDescripcionMetodo(detalle);
        
        em.getTransaction().begin();
        em.persist(metod);
        em.getTransaction().commit();
        return metod;
    }

    /**
     * Metodo que permite eliminar de la base de datos un metodo de pago mediante su ID.
     * @param codMetodo Int Codigo del metodo de pago.
     * @return boolean retorna true si la eliminación se realizó con exito, de lo contrario, retorna false.
     */
    public boolean eliminarMetodo(int codMetodo){
        MetodoPago metod = em.find(MetodoPago.class, codMetodo);
        
        em.getTransaction().begin();
        em.remove(metod);
        em.getTransaction().commit();
        return true;
    }
}
