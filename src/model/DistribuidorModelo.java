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
 * @author Luis
 */
public class DistribuidorModelo {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public DistribuidorModelo() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("biblioteca");
        this.entityManager = this.entityManagerFactory.createEntityManager();
    }
    /**
     * Conecta con la base de datos y guarda los atributos ingresados.
     * @param rut_distribuidor String rut del distribuidor
     * @param nombre String Nombre del distribuidor
     * @param calle String nombre de la calle donde esta ubicado el distribuidor
     * @param numero String numero de la calle donde esta ubicado el distribuidor
     * @param comuna String Nombre de la comuna donde esta ubicado el distribuidor
     * @param pais String Nombre del pais donde esta ubicado el distribuidor
     * @param fono String Numero de contacto del distribuidor 
     * @param ano_contrato Date Fecha desde la cual el distribuidor inicio trabajos con la empresa.
     * @return 
     */
    public Distribuidor crearDistribuidor(String rut_distribuidor, String nombre, String calle, String numero,
            String comuna, String pais, String fono, Date ano_contrato){
        //Instanciar la clase Distribuidor, ademas de iniciarse la conexion.
        Distribuidor distribuidor = new Distribuidor();
        
        //Agregar los valores al objeto distribuidor
        distribuidor.setRut_distribuidor(rut_distribuidor);
        distribuidor.setNombre(nombre);
        distribuidor.setCalle(calle);
        distribuidor.setNumero(numero);
        distribuidor.setComuna(comuna);
        distribuidor.setPais(pais);
        distribuidor.setFono(fono);
        distribuidor.setAno_contrato(ano_contrato);
        
        //guardado y confirmacion de los datos en la base de datos
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(distribuidor);
        this.entityManager.getTransaction().commit();
        
        //retornar el objeto distribuidor
        return distribuidor;
        
    }
    
    public boolean eliminarDistribuidor(int codigoDistribuidor){
        Distribuidor dis = entityManager.find(Distribuidor.class, codigoDistribuidor);
        
        entityManager.getTransaction().begin();
        entityManager.remove(dis);
        entityManager.getTransaction().commit();
        return true;
    }
    
}
