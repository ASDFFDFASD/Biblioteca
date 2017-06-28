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
    public Estado agregarModelo(String descripcion){
        Estado est = new Estado();
        est.setDescripcionEstado(descripcion);
        
        em.getTransaction().begin();
        em.persist(est);
        em.getTransaction().commit();
        return est;
    }
    
    /**
     * Metodo que permite
     * @param codigoModelo
     * @return 
     */
    public boolean eliminarModelo(int codigoModelo){
        Estado est = em.find(Estado.class, codigoModelo);
        
        em.getTransaction().begin();
        em.remove(est);
        em.getTransaction().commit();
        return true;
    }
    
}
