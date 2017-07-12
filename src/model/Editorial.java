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
@Table(name = "editorial")
public class Editorial implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_editorial")
    private int codigoEditorial;
    
    @Column(name = "nombre")
    private String nombreEditorial;

    public Editorial() {
    }

    public int getCodigoEditorial() {
        return codigoEditorial;
    }

    public void setCodigoEditorial(int codigoEditorial) {
        this.codigoEditorial = codigoEditorial;
    }

    public String getNombreEditorial() {
        return nombreEditorial;
    }

    public void setNombreEditorial(String nombreEditorial) {
        this.nombreEditorial = nombreEditorial;
    }

    @Override
    public String toString() {
        return "Editorial{" + "codigoEditorial=" + codigoEditorial + ", nombreEditorial=" + nombreEditorial + '}';
    }
    

    
    
    
}
