/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import model.IdiomaModelo;

/**
 *
 * @author Luis
 */
public class IdiomaController {
    
    /**
     * Metodo que agrega un nuevo idioma conectando la vista junto al modelo.
     * @param idioma String Idioma 
     * @return boolean Retorna true si se han ingresado correctamente los datos a la BD.
     */
    public boolean agregarIdioma(String idioma){
        boolean correcto = false;
        IdiomaModelo idiom = new IdiomaModelo();
        correcto = idiom.agregarIdioma(idioma);
            
        
        
        
        
        return correcto;
        
    }
}
