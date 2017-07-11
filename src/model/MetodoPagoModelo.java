/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author luis
 * @version 1.0
 */
public class MetodoPagoModelo {

    private EntityManagerFactory emf;
    private EntityManager em;

    /**
     * Constructor de la clase MetodoPagoModelo, que conecta al instanciarse a
     * la base de datos.
     */
    public MetodoPagoModelo() {

        this.emf = Persistence.createEntityManagerFactory("biblioteca");
        this.em = this.emf.createEntityManager();
    }

    /**
     * Metodo que permite ingresar un nuevo metodo de pago a la base de datos.
     *
     * @param nombreMetodo String nombre del metodo a guardar.
     * @return boolean retorna true si se ha guardado correctamente.
     */
    public boolean agregarMetodo(String nombreMetodo) {
        MetodoPago metod = new MetodoPago();
        metod.setDescripcionMetodo(nombreMetodo);    
      
            this.em.getTransaction().begin();
            this.em.persist(metod);
            this.em.getTransaction().commit();
      
        return true;
    }

    /**
     * Metodo que permite eliminar de la base de datos un metodo de pago
     * mediante su ID.
     *
     * @param codMetodo Int Codigo del metodo de pago.
     * @return boolean retorna true si la eliminación se realizó con exito, de
     * lo contrario, retorna false.
     */
    public boolean eliminarMetodo(int codMetodo) {
        MetodoPago metod = em.find(MetodoPago.class, codMetodo);

        this.em.getTransaction().begin();
        this.em.remove(metod);

        this.em.getTransaction().commit();
        return true;
    }

    /**
     * Consulta a la base de datos que retorna los metodos contenidos en ella.
     *
     * @return List<MetodoPago> Retorna una lista del tipo metodo de pago con
     * los valores de la base de datos.
     */
    public Class<MetodoPago> consultarMetodos() {

        ArrayList<MetodoPago> metodos;
        em.getTransaction().begin();
        Class<MetodoPago> merge = em.merge(MetodoPago.class);

        return merge;
    }
}
