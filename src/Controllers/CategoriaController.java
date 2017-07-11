/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import model.CategoriaModelo;

/**
 *
 * @author Luis
 * @version 1.0
 * 10-07-2017
 */
public class CategoriaController {
    /**
     * Metodo que conecta la vista con el modelo y agrega una nueva categoria.
     * @param nombreCategoria String Nombre de la categoria a guardar.
     * @return  boolean Retrona true si se ha guardado correctamente la nueva categoria.
     */
    public boolean agregarCategoria(String nombreCategoria){
        CategoriaModelo cat = new CategoriaModelo();
        boolean guardado;
       
        guardado = cat.crearCategoria(nombreCategoria);
        
        return guardado;
    }
    
}
