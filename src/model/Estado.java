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
 * @version 1.0
 */
@Entity
@Table(name="estado")
public class Estado implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cod_estado")
    private int idEstado;
    
    @Column(name="descripcion")
    private String descripcionEstado;

    public Estado() {
    }

    public Estado(int idEstado, String descripcionEstado) {
        this.idEstado = idEstado;
        this.descripcionEstado = descripcionEstado;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }
    
    @Override
    public String toString(){
        return "Estado{Id Estado: " + idEstado + ", Descripcion Estado: " + descripcionEstado;
    }
    
    
}
