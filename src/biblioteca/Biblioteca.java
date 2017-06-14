/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.Scanner;
import model.Autor;
import model.AutorModelo;
import model.Editorial;
import model.EditorialModelo;

/**
 *
 * @author luis
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         // TODO code application logic here
        System.out.println("Acontinuacion se haran pruebas de persistencia en");
        System.out.println("la base de datos:");
        System.out.println("----------------------------------------------");
        System.out.println("");
        System.out.println("Primero ingresamos los datos de un autor:");
        System.out.print("Ingrese nombre: ");
        
        // Objeto encargado de capturar los datos
        Scanner scanner = new Scanner(System.in); 
        String nombre = scanner.nextLine();
        
        System.out.print("Ingrese Apellido Paterno: ");
        String apellidoPaterno = scanner.nextLine();
        
        System.out.print("Ingrese Apellido Materno: ");
        String apellidoMaterno = scanner.nextLine();
        
        // Pedirle a la capa modelo que guarde los datos del cliente
        
        AutorModelo autorModelo = new AutorModelo();
        Autor autor = autorModelo.crearAutor(nombre,apellidoPaterno,apellidoMaterno);
       
        System.out.println("----------------------------------------------");
        System.out.println("Los datos han sido gurdados exitosamente");
        System.out.println(autor.toString());
        
    }
    
}
