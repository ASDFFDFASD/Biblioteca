/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;


import javax.swing.JOptionPane;
import model.AutorModelo;

/**
 *
 * @author Luis
 * @version 1.0
 * 10-07-2017
 */
public class AutorController{
    
    /**
     * Metodo que conecta a la vista con el modelo y agrega un nuevo autor a la base de datos.
     * @param nombre String Nombre del autor
     * @param ApellidoPaterno String Apellido paterno del autor
     * @param ApellidoMaterno String Apellido Materno del autor
     * @return boolean Retorna true si se ha agregado correctamente el autor a la base de datos en la capa modelo.
     */
    public boolean nuevoAutor(String nombre, String ApellidoPaterno, String ApellidoMaterno){
        AutorModelo autor = new AutorModelo();
        boolean correcto = false;       
        if (autor.crearAutor(nombre, ApellidoPaterno, ApellidoMaterno)) {
            correcto = true;
        } else {
            correcto = false;
        }
        return correcto;     
    }
            
}
