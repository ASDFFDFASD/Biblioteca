/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author luis
 * @version 1.0 12-07-2017
 */
public class FacturaModelo {
    //Variable que permite la Administracion de las Entidades.
    private EntityManagerFactory  emf;
    //Variable que administra las entidades.
    private EntityManager em ;

    /**
     * Constructor que permite la administracion de las entidades.
     */
    public FacturaModelo() {
        this.emf = Persistence.createEntityManagerFactory("biblioteca");
        this.em = this.emf.createEntityManager();
    }
    
    /**
     * Metodo que permite crear un nuevo objeto del tipo Factura y persistirlo en la BD.
     * @param precioNeto INT precio neto de la factura a persistir.
     * @param costoIva INT costo del iva de la factura a persistir.
     * @param precioTotal int precio total de la factura a persistir.
     * @param fechaCompra Date Fecha de la compra en la factura a persistir.
     * @param hora Date Hora de la compra en la factura a persistir.
     * @param codMetodo INT codigo del metodo de pago con el cual se pago.
     * @param rutDistribuidor String rut del distribuidor involucrado a persistir.
     * @return Factura Retorna un objeto del tipo Factura con los datos guardados.
     */
    public Factura crearFactura(int precioNeto, int costoIva, int precioTotal,
            Date fechaCompra, Date hora, int codMetodo, String rutDistribuidor ){
    
        Factura fac = new Factura();
        fac.setPrecioNeto(precioNeto);
        fac.setCostoIva(costoIva);
        fac.setPrecioTotal(precioTotal);
        fac.setFechaCompra(fechaCompra);
        fac.setHoraCompra(hora);
        fac.setCodiogMetodo(codMetodo);
        fac.setRutDistribuidor(rutDistribuidor);
        
        em.getTransaction().begin();
        em.persist(fac);
        em.getTransaction().commit();
        
        return fac;
}
    /**
     * Metodo que busca en la BD con un ID, un objeto Factura y lo elimina de esta.
     * @param folioFactura ID de la factura.
     * @return boolean Retorna TRUE si se han eliminado exitosamente los valores de la BD.
     */
    public boolean eliminarFactura(int folioFactura){
        Factura fac = em.find(Factura.class, folioFactura);
        
        em.getTransaction().begin();
        em.remove(fac);
        em.getTransaction().commit();
        
        return true;  
    }

   
    
    
    
   
    
}
