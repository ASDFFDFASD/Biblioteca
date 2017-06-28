/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Luis
 */
@Entity
@Table(name = "distribuidor")
public class Distribuidor implements Serializable {

    @Id
    @Column(name = "rut_distribuidor")
    private String rut_distribuidor;

    @Column(name = "nombre")

    private String nombre;

    @Column(name = "calle")
    private String calle;

    @Column(name = "numero")
    private String numero;

    @Column(name = "comuna")
    private String comuna;

    @Column(name = "pais	")
    private String pais;

    @Column(name = "fono")
    private String fono;

    @Column(name = "ano_contrato")
    private String ano_contrato;

    public Distribuidor() {
    }

    public Distribuidor(String rut_distribuidor, String nombre, String calle, String numero, String comuna, String pais, String fono, String ano_contrato) {
        this.rut_distribuidor = rut_distribuidor;
        this.nombre = nombre;
        this.calle = calle;
        this.numero = numero;
        this.comuna = comuna;
        this.pais = pais;
        this.fono = fono;
        this.ano_contrato = ano_contrato;
    }

    public String getRut_distribuidor() {
        return rut_distribuidor;
    }

    public void setRut_distribuidor(String rut_distribuidor) {
        this.rut_distribuidor = rut_distribuidor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }

    public String getAno_contrato() {
        return ano_contrato;
    }

    public void setAno_contrato(String ano_contrato) {
        this.ano_contrato = ano_contrato;
    }

    @Override
    public String toString() {
        return "Distribuidor{" + "rut_Distribuidor=" + rut_distribuidor + ", nombre=" + nombre + ", calle=" + calle + ", numero=" + numero + '}'
                + " comuna= " + comuna + " pais= " + pais + " fono= " + fono + " año_contrato= " + ano_contrato;
    }

}
