/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.MenuAutor;
import Views.ViewAutor;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import model.Autor;
import model.AutorModelo;



/**
 *
 * @author Luis
 */
public class AutorController {
    /**
     * Vaviable de autor Modelo
     */
    private AutorModelo autor;
 /**
  * Constructor de la clase
  */
    public AutorController() {
        this.autor = new AutorModelo();
    }
    
  /**
   * Metodo que envia los datos a la clase AutorModelo y crea un nuevo autor
   * retornando un nuevo objeto del tipo cliente
   * @param nombre Nombre del nuevo autor   
   * @param apellidoPaterno Apellido Paterno del nuevo autor
   * @param apellidoMaterno Apellido Materno del nuevo autor
   * @return  Objeto Autor.
   */
    public Autor crearAutor(String nombre, String apellidoPaterno, String apellidoMaterno){
        Autor autor = this.autor.crearAutor(nombre, apellidoPaterno, apellidoMaterno);
        
        return autor;
    }
    
    /**
     * Metodo que conecta con el AutorModelo y elimina el autor por el ID recibido en este metodo
     * @param ID ID del autor en la BD
     * @return boolean TRUE si se ha eliminado correctamente
     */
    public boolean eliminarAutor(int ID){
        boolean eliminado = this.autor.eliminarAutor(ID);
       return eliminado;
    }
    
    /**
     * Metodo que recibe un objeto por parametros y se comunica con el AutorModelo,
     * pasando los atributos necesarios.
     * @param autor Objeto Autor con los datos a reemplazar
     * @return Autor objeto autor con los datos editados
     */
    public Autor editarAutor(Autor autor){
        Autor editado = this.autor.editarAutor(autor.getCod_autor(),
                autor.getNombre(),
                autor.getApellido_paterno(),
                autor.getApellido_materno());
        
        return editado;    
    }
    
/**
 * Metodo que se comunica con el modelo y retorna el objeto con los datos
 * @param Id Id del autor
 * @return Autor objeto del tipop auitor encontrado
 */
    public Autor porID(int Id){
        Autor autor = this.autor.porId(Id);
       return autor; 
    }

    
    
}
