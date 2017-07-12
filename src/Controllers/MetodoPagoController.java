/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.List;
import model.MetodoPago;
import model.MetodoPagoModelo;

/**
 *
 * @author Luis
 */
public class MetodoPagoController {
/**
 * Metodo de agregar que ingresa un nuevo metodo de pago conectando La vista con el modelo.
 * @param nombreMetodo String Nombre del nuevo Metodo.
 * @return  boolean Retorna true si se han ingresado los nuevos datos.
 */
    public boolean guardar(String nombreMetodo){
        boolean correcto=false;
        if (nombreMetodo == null) {
            correcto = false;  
        }else if ("".equals(nombreMetodo)) {
            correcto = false;   
        }else{
            
            MetodoPagoModelo guardar = new MetodoPagoModelo();    
            guardar.agregarMetodo(nombreMetodo);
            correcto = true;
        }
        
        return correcto;
    }
}
