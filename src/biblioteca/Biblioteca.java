/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import Views.MenuPrincipal;
import java.util.Date;
import java.util.Scanner;
import model.Autor;
import model.AutorModelo;
import model.Categoria;
import model.CategoriaModelo;
import model.Distribuidor;
import model.DistribuidorModelo;

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
           
            MenuPrincipal menu = new MenuPrincipal();
    menu.setVisible(true);
            
        /*
           
        System.out.println("Acontinuacion se haran pruebas de persistencia en");
        System.out.println("la base de datos:");
        System.out.println("----------------------------------------------");
        System.out.println("");
        System.out.println("Primero ingresamos los datos de Distribuidor:");
        
        
        // Objeto encargado de capturar los datos
        Scanner scanner = new Scanner(System.in); 
        /*System.out.print("Ingrese Nombre: ");
        String rut = scanner.nextLine();
        */
//        System.out.print("Ingrese nombre: ");
//        String nombre = scanner.nextLine();
//        
//         System.out.print("Ingrese calle: ");
//        String apellidoPaterno = scanner.nextLine();
//        
//         System.out.print("Ingrese numero: ");
//        String apellidoMaterno = scanner.nextLine();
        /*
         System.out.print("Ingrese comuna: ");
        String comuna = scanner.nextLine();
        
         System.out.print("Ingrese pais: ");
        String pais = scanner.nextLine();
 
         System.out.print("Ingrese fono: ");
        String fono = scanner.nextLine();
        *//*
         System.out.print("Ingrese año contrato: ");
        String anoContrato = scanner.nextLine();
        /*System.out.print("Ingrese Apellido Materno: ");
        String apellidoMaterno = scanner.nextLine();
        */
        // Pedirle a la capa modelo que guarde los datos del cliente
        
//        AutorModelo autorModelo = new AutorModelo();
//        Autor autor = autorModelo.crearAutor(nombre,apellidoPaterno,apellidoMaterno);
//       
//        System.out.println("----------------------------------------------");
//        System.out.println("Los datos han sido gurdados exitosamente");
//        System.out.println(autor.toString());
//        AutorModelo autorModelo = new AutorModelo();
//        Autor autor = autorModelo.crearAutor(nombre,apellidoPaterno,apellidoMaterno);
//       
//        System.out.println("----------------------------------------------");
//        System.out.println("Los datos han sido gurdados exitosamente");
//        System.out.println(autor.toString());
        
       /* DistribuidorModelo distribuidor = new DistribuidorModelo();
        Distribuidor dis = distribuidor.crearDistribuidor(rut,nombre, calle, numero, comuna, pais, fono, anoContrato);
        System.out.println(dis.toString());*/
       
    }
    
}
