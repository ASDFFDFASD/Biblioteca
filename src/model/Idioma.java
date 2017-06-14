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
@Table(name = "idioma")
public class Idioma implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_idioma")
    private int codIdioma;
    
    @Column(name = "lengua")
    private String idioma;

    public Idioma() {
    }

    public Idioma(int codIdioma, String idioma) {
        this.codIdioma = codIdioma;
        this.idioma = idioma;
    }

    public int getCodIdioma() {
        return codIdioma;
    }

    public void setCodIdioma(int codIdioma) {
        this.codIdioma = codIdioma;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    
    @Override
    public String toString(){
        return "Idioma{ Codigo Idioma: " + codIdioma + ", Lengua: " + idioma;
    }
}
