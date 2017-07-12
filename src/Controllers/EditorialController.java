/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.awt.Component;
import java.util.List;
import javax.swing.JOptionPane;
import model.Editorial;
import model.EditorialModelo;

/**
 *
 * @author Luis
 * @version 1.0
 * 11-07-2017
 */
public class EditorialController {
    /**
     * Metodo que conecta La vista con el Modelo de la editorial.
     * @param nombreEditorial String Nombre de la editorial.
     * @return boolean Retorna true si se han ingresado correctamente los datos.
     */
    public boolean agregarEditorial(String nombreEditorial){
        boolean correcto = false;
        if (nombreEditorial != null && !nombreEditorial.equals("")) {
             EditorialModelo edit = new EditorialModelo();
            
                    edit.crearEditorial(nombreEditorial);
            correcto = true;
        } else {
            Component cmpnt = null;
           JOptionPane.showMessageDialog(cmpnt, "Los campos estan vacios.");
        }
        
        
       
        return correcto;
    }
    
    
    public List<Editorial> consultarEditoriales(){
        EditorialModelo edit = new EditorialModelo();
        List<Editorial> lista = edit.consultarEditoriales();
        return lista;
    }
}
