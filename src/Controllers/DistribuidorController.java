/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import model.DistribuidorModelo;

/**
 *
 * @author Luis
 * @version 1.0
 * 10-07-2017
 */
public class DistribuidorController {
    
    /**
     * Metodo que conecta la vista del distribuidor con el modelo de distribuidor
     * @param rutDistribuidor String Rut del Distribuidor
     * @param nombreDistribuidor String Nombre del distribuidor
     * @param calleDistribuidor String Calle del Distribuidor
     * @param numeroCalle String Numero de calle del Distribuidor
     * @param comuna String Comuna donde esta Ubicado el distribuidor
     * @param pais String Pais del distribuidor
     * @param fono String Numero de contacto del distribuidor
     * @param anoContrato String fecha del ano de contrato del distribuidor
     * @return  boolean Retorna true si se han agregado correctamente los datos.
     */
    public boolean agregarDistribuidor(String rutDistribuidor, String nombreDistribuidor, String calleDistribuidor, String numeroCalle,
                                        String comuna,String pais, String fono, String anoContrato){
        DistribuidorModelo dis = new DistribuidorModelo();
        dis.crearDistribuidor(rutDistribuidor, nombreDistribuidor, calleDistribuidor, numeroCalle,comuna, pais, fono, anoContrato);
                
    return true;
}
    
    
}
