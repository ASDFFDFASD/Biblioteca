/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author luis
 */
@Entity
@Table(name = "autor")
public class Autor implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cod_autor;

    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;

    public Autor() {
    }

    public Autor(int cod_autor, String nombre, String apellido_paterno, String apellido_materno) {
        this.cod_autor = cod_autor;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
    }

    public int getCod_autor() {
        return cod_autor;
    }

    public void setCod_autor(int cod_autor) {
        this.cod_autor = cod_autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    @Override
    public String toString() {
        return "Autor{" + "cod_autor=" + cod_autor + ", nombre=" + nombre + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + '}';

    }

    
}
