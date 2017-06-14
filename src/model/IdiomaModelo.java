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
public class IdiomaModelo {
    private EntityManagerFactory emf;
    private EntityManager em;

    public IdiomaModelo() {
        this.emf = Persistence.createEntityManagerFactory("biblioteca");
        this.em = this. emf.createEntityManager();
    }
    
    public Idioma agregarIdioma(String idioma){
        Idioma idm = new Idioma();
        idm.setIdioma(idioma);
        
        em.getTransaction().begin();
        em.persist(idm);
        em.getTransaction().commit();
        return idm;
    }
    
    public boolean eliminarIdioma(int codIdiom){
        Idioma idm = em.find(Idioma.class, codIdiom);
        
        em.getTransaction().begin();
        em.remove(idm);
        em.getTransaction().commit();
        return true;
    }
    
    
}
