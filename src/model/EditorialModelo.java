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
public class EditorialModelo {
    private EntityManagerFactory emf;
    private EntityManager em;

    public EditorialModelo() {
        this.emf = Persistence.createEntityManagerFactory("biblioteca");
        this.em = this.emf.createEntityManager();
    }
    
    public Editorial crearEditorial(int codigoEditorial, String nombreEditorial){
        Editorial ed = new Editorial();
        ed.setCodigoEditorial(codigoEditorial);
        ed.setNombreEditorial(nombreEditorial);
        
        em.getTransaction().begin();
        em.persist(ed);
        em.getTransaction().commit();
        
        return ed;
    }
    
    public boolean eliminarEditorial(int codigoEditorial){
        Editorial ed = em.find(Editorial.class, codigoEditorial);
   
        em.getTransaction().begin();
        em.remove(ed);
        em.getTransaction().commit();
        return true;
        
    }
    
    
}
