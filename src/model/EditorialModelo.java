/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author luis
 * @version 1.2 10-07-2017
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
     * Metodo que perite guardar los datos de la editorial pasados por los
     * parametros en la base de datos
     *
     * @param nombreEditorial String Correcsponde al nombre de la editorial.
     * @return Editorial Retorna el Objeto Editorial Guardado en BD
     */
    public Editorial crearEditorial(String nombreEditorial) {
        Editorial ed = new Editorial();
        ed.setNombreEditorial(nombreEditorial);

        em.getTransaction().begin();
        em.persist(ed);

        em.getTransaction().commit();

        return ed;
    }

    /**
     * Metodo que permite eliminar de la base de datos la editorial con su ID.
     *
     * @param codigoEditorial INT Id de la editorial.
     * @return boolean retorna true si se ha eliminado exitosamente el objeto
     */
    public boolean eliminarEditorial(int codigoEditorial) {
        Editorial ed = em.find(Editorial.class, codigoEditorial);

        em.getTransaction().begin();
        em.remove(ed);
        em.getTransaction().commit();
        return true;

    }

    /**
     * Edita el nombre de la editorial por el nuevo nombre, conservando el ID.
     *
     * @param codigoEditorial Int Codigo de la editorial.
     * @param nombreEditorial String Nuevo nombre de la editorial a guardar en
     * la BD.
     * @return Retorna TRUE si se han guardado correctamente los datos.
     */
    public boolean editarEditorial(int codigoEditorial, String nombreEditorial) {
        boolean correcto = false;

        Editorial ed = em.find(Editorial.class, codigoEditorial);

        ed.setNombreEditorial(nombreEditorial);
        em.getTransaction().begin();
        em.merge(ed);
        em.getTransaction().commit();

        return correcto;
    }
 /**
  * Metodo para obtener todas las editoriales desde la BD.
  * @return Retorna un LIST con los onjetos Editoriales contenidos en la BD.
  */
    public List<Editorial> consultarEditoriales() {
        List<Editorial> lista = em.createQuery("Select e from Editorial e").getResultList();

        return lista;
    }

}
