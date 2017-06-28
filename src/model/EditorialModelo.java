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

    
    /**
     * Metodo que al instanciar la clase se conecta a la base de datos.
     */
    public EditorialModelo() {
        this.emf = Persistence.createEntityManagerFactory("biblioteca");
        this.em = this.emf.createEntityManager();
    }
    
    /**
     * Metodo que perite guardar los datos de la editorial pasados por los parametros
     * en la base de datos
     * @param nombreEditorial String Correcsponde al nombre de la editorial.
     * @return 
     */
    public Editorial crearEditorial( String nombreEditorial){
        Editorial ed = new Editorial();
        ed.setNombreEditorial(nombreEditorial);
        
        em.getTransaction().begin();
        em.persist(ed);
        em.getTransaction().commit();
        
        return ed;
    }
    
    /**
     * Metodo que permite eliminar de la base de datos 
     * @param codigoEditorial
     * @return 
     */
    public boolean eliminarEditorial(int codigoEditorial){
        Editorial ed = em.find(Editorial.class, codigoEditorial);
   
        em.getTransaction().begin();
        em.remove(ed);
        em.getTransaction().commit();
        return true;
        
    }
    
    
}
