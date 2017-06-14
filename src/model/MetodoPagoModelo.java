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
 */
public class MetodoPagoModelo {
private EntityManagerFactory emf;
private EntityManager em;

    public MetodoPagoModelo() {
        this.emf = Persistence.createEntityManagerFactory("biblioteca");
        this.em = this.emf.createEntityManager();
    }

    public MetodoPago agregarMetodo(String detalle){
        MetodoPago metod = new MetodoPago();
        metod.setDescripcionMetodo(detalle);
        
        em.getTransaction().begin();
        em.persist(metod);
        em.getTransaction().commit();
        return metod;
    }

    public boolean eliminarMetodo(int codMetodo){
        MetodoPago metod = em.find(MetodoPago.class, codMetodo);
        
        em.getTransaction().begin();
        em.remove(metod);
        em.getTransaction().commit();
        return true;
    }
}
