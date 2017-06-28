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
 * @author 
 * @version 1.0
 */
public class IdiomaModelo {
    private EntityManagerFactory emf;
    private EntityManager em;
/**
 * Constructor de la clase que conecta a la base de datos.
 */
    public IdiomaModelo() {
        this.emf = Persistence.createEntityManagerFactory("biblioteca");
        this.em = this. emf.createEntityManager();
    }
    /**
     * Metodo que permite ingresar los datos de idioma a la base de datos, mediante los entity.
     * @param idioma String contiene el nombre del idioma el cual va ha ser ingresado a la base de datos.
     * @return  Idioma objeto idioma, que contiene los datos del objeto ingresado.
     */
    public Idioma agregarIdioma(String idioma){
        Idioma idm = new Idioma();
        idm.setIdioma(idioma);
        
        em.getTransaction().begin();
        em.persist(idm);
        em.getTransaction().commit();
        return idm;
    }
    
    /**
     * Metodo que permite eliminar de la base de datos el idioma, mediante el id.
     * @param codIdiom Int contiene el Id del idioma el cual se desea eliminar de la base de datos.
     * @return boolean Retorna true si la eliminación fue realizada con exito, y retorna false si se produjo algun error.
     */
    public boolean eliminarIdioma(int codIdiom){
        Idioma idm = em.find(Idioma.class, codIdiom);
        
        em.getTransaction().begin();
        em.remove(idm);
        em.getTransaction().commit();
        return true;
    }
    
    
}
