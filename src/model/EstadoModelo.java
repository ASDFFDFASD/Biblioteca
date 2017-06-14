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
public class EstadoModelo {
    private EntityManagerFactory emf;
    private EntityManager em;

    public EstadoModelo() {
        this.emf = Persistence.createEntityManagerFactory("biblioteca");
        this.em = this.emf.createEntityManager();
    }
    
    public Estado agregarModelo(String descripcion){
        Estado est = new Estado();
        est.setDescripcionEstado(descripcion);
        
        em.getTransaction().begin();
        em.persist(est);
        em.getTransaction().commit();
        return est;
    }
    
    public boolean eliminarModelo(int codigoModelo){
        Estado est = em.find(Estado.class, codigoModelo);
        
        em.getTransaction().begin();
        em.remove(est);
        em.getTransaction().commit();
        return true;
    }
    
}
