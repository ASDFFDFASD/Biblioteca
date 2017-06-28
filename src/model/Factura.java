/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author luis
 * @version 1.1
 */
@Entity
@Table(name = "factura")
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "folio_factura")
    private int folioFactura;
    
    @Column(name = "precio_neto	")
    private int precioNeto;
    
    @Column(name = "costo_iva")
    private int costoIva;
    
    @Column(name = "precio_total")
    private int precioTotal;
    
    @Column(name = "fecha_compra")
    private Date fechaCompra;
    
    @Column(name = "hora")
    private Date horaCompra;
    
    @Column(name = "cod_metod")
    private int codiogMetodo;
    
    @Column(name = "rut_distribuidor")
    private String rutDistribuidor;
    
 

    public Factura() {
    }

    public Factura(int folioFactura, int precioNeto, int costoIva, int precioTotal, Date fechaCompra, Date horaCompra, int codiogMetodo, String rutDistribuidor) {
        this.folioFactura = folioFactura;
        this.precioNeto = precioNeto;
        this.costoIva = costoIva;
        this.precioTotal = precioTotal;
        this.fechaCompra = fechaCompra;
        this.horaCompra = horaCompra;
        this.codiogMetodo = codiogMetodo;
        this.rutDistribuidor = rutDistribuidor;
    }

    public int getFolioFactura() {
        return folioFactura;
    }

    public void setFolioFactura(int folioFactura) {
        this.folioFactura = folioFactura;
    }

    public int getPrecioNeto() {
        return precioNeto;
    }

    public void setPrecioNeto(int precioNeto) {
        this.precioNeto = precioNeto;
    }

    public int getCostoIva() {
        return costoIva;
    }

    public void setCostoIva(int costoIva) {
        this.costoIva = costoIva;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Date getHoraCompra() {
        return horaCompra;
    }

    public void setHoraCompra(Date horaCompra) {
        this.horaCompra = horaCompra;
    }

    public int getCodiogMetodo() {
        return codiogMetodo;
    }

    public void setCodiogMetodo(int codiogMetodo) {
        this.codiogMetodo = codiogMetodo;
    }

    public String getRutDistribuidor() {
        return rutDistribuidor;
    }

    public void setRutDistribuidor(String rutDistribuidor) {
        this.rutDistribuidor = rutDistribuidor;
    }
    
    
}
