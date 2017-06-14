/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
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
@Table(name = "metodo_pago")
public class MetodoPago implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_metod")
    private int codMetodo;
    @Column(name = "descripcion")
    private String descripcionMetodo;

    public MetodoPago() {
    }

    public MetodoPago(int codMetodo, String descripcionMetodo) {
        this.codMetodo = codMetodo;
        this.descripcionMetodo = descripcionMetodo;
    }

    public int getCodMetodo() {
        return codMetodo;
    }

    public void setCodMetodo(int codMetodo) {
        this.codMetodo = codMetodo;
    }

    public String getDescripcionMetodo() {
        return descripcionMetodo;
    }

    public void setDescripcionMetodo(String descripcionMetodo) {
        this.descripcionMetodo = descripcionMetodo;
    }
    
    @Override
    public String toString(){
        return "Metodo Pago{ Id Metodo: " + codMetodo + ", Descripcion Metodo: " + descripcionMetodo;
    }
    
}
