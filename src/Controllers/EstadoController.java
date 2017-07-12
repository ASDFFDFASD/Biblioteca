/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import model.EstadoModelo;

/**
 *
 * @author Luis
 */
public class EstadoController {
    /**
     * Metodo que conecta la vista con el modelo agregando los datos a la BD.
     * @param descripcionEstado String Descripcion del estado.
     * @return  boolean Retorna true si se han agregado correctamente los datos.
     */
    public boolean agregarEstado(String descripcionEstado){
        boolean correcto = false;
        EstadoModelo estado = new  EstadoModelo();
        
        correcto = estado.agregarModelo(descripcionEstado);
      
        return correcto;
    }
}
