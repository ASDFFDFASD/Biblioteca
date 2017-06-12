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
public class CategoriaModelo {
    
    private EntityManagerFactory emf;
    private EntityManager em;

    public CategoriaModelo() {
        this.emf = Persistence.createEntityManagerFactory("biblioteca");
        this.em = this.emf.createEntityManager();
    }
    
    public Categoria crearCategoria(int codigoCategoria, String nombreCategoria){
        Categoria cat = new Categoria();
        cat.setCodigoCategoria(codigoCategoria);
        cat.setNombreCategoria(nombreCategoria);
        
        em.getTransaction().begin();
        em.persist(cat);
        em.getTransaction().commit();
        
        return cat;
    }
    
    public boolean eliminarCategoria(int codigoCategoria){
        Categoria cat = em.find(Categoria.class, codigoCategoria);
        
        
        em.getTransaction().begin();
        em.remove(cat);
        em.getTransaction().commit();
        
        return true;
    }
    
    
}
