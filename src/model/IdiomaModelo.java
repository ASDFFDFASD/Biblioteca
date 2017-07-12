/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import model.Idioma;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Luis
 * @version 1.2
 * 7-07-2017
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
    public boolean agregarIdioma(String idioma){
        Idioma idm = new Idioma();
        idm.setIdioma(idioma);
        
        em.getTransaction().begin();
        em.persist(idm);
        em.getTransaction().commit();
        return true;
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
    /**
     * Retorna todos los Idioomas contenidos en la BD en forma de un List de tipo Idioma.
     * @return List de tipo Idioma.
     */
    public List<Idioma> consultarIdiomas(){
        List<Idioma> idiomas = em.createQuery("Select i from Idioma i").getResultList();
        return idiomas;
    }
    
    /**
     * Busca un Idioma mediante el ID en la BD y lo edita con los nuevos datos.
     * @param codIdioma int ID del idioma
     * @param lengua String Nuevo dato a guardar en la BD
     * @return boolean Retorna true si se ha realizado la edicion correctamente.
     */
    public boolean editarIdioma(int codIdioma, String lengua){
        Idioma idioma = em.find(Idioma.class, codIdioma);
        
        idioma.setIdioma(lengua);
        em.getTransaction().begin();
        em.merge(idioma);
        em.getTransaction().commit();
       return true; 
        
    }
    
}
