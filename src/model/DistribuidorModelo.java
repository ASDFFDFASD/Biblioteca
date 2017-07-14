/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Luis
 * @version 1.2 12-07-2017
 */
public class DistribuidorModelo {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    /**
     * Metodo que al instanciarse inicia la conexion con la base de datos.
     */
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
     * @return Distribuidor Retorna el objeto guardado en la base de datos
     */
    public Distribuidor crearDistribuidor(String rut_distribuidor, String nombre, String calle, String numero,
            String comuna, String pais, String fono, String ano_contrato){
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
    /**
     * Metodo que recibe por parametros un "Integer" que contendra un codigo 
     * del distribuidor, en este caso un rut, para proceder a buscarlo en la base de datos
     * y eliminarlo.
     * @param codigoDistribuidor Integer Contendra el rut del distribuidor.
     * @return boolean Retornara true si se encontrado y eliminado con exito el distribuidor desde
     * la base de datos.
     */
    
    public boolean eliminarDistribuidor(String codigoDistribuidor){
        Distribuidor dis = entityManager.find(Distribuidor.class, codigoDistribuidor);
        
        entityManager.getTransaction().begin();
        entityManager.remove(dis);
        entityManager.getTransaction().commit();
        return true;
    }
    /**
     * Obtiene los distribuidores de la BD y los devuelve en un List de tipo Distribuidor.
     * @return List de tipo Distribuidor
     */
    public List<Distribuidor> consultarDistribuidores(){
        List<Distribuidor> distribuidores = entityManager.createQuery("Select d from Distribuidor d").getResultList();
        return distribuidores;
    }
    
    /**
     * Busca y edita los valores del distribuidor dentro de la Bd, mediante su rut.
     * @param rutDistribuidor String Rut e ID del distribuidor
     * @param nombreDistribuidor String Nombre del Distribuidor
     * @param calleDistribuidor String Calle del Distribuidor
     * @param numeroCalle String Numero de calle del distribuidor.
     * @param comuna String Comuna del distribuidor
     * @param pais String Pais del distribuidor
     * @param fono String Fono de contacto del distribuidor
     * @param anoContrato String ano de inicio de contrato con el distribuidor
     * @return boolean retorna true si el se han editado correctamente los valores del distribuidor en la BD.
     */
    public boolean EditarDistribuidor(String rutDistribuidor, String nombreDistribuidor, String calleDistribuidor, String numeroCalle, String comuna,
            String pais, String fono, String anoContrato){
        Distribuidor dis = entityManager.find(Distribuidor.class, rutDistribuidor);
        
        dis.setNombre(nombreDistribuidor);
        dis.setCalle(calleDistribuidor);
        dis.setNumero(numeroCalle);
        dis.setComuna(comuna);
        dis.setPais(pais);
        dis.setFono(fono);
        dis.setAno_contrato(anoContrato);
        entityManager.getTransaction().begin();
        entityManager.merge(dis);
        entityManager.getTransaction().commit();
        return true;     
    }
    
}
