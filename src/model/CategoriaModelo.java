/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author luis
 * @version 1.2
 * 10-07-2017
 */
public class CategoriaModelo {
    
    private EntityManagerFactory emf;
    private EntityManager em;

    /**
     * Constructor de la clase categoria modelo vacio, pero que inicializa la conexión a la base
     * de datos apendas instanciar un objeto desde otra clse.
     */
    public CategoriaModelo() {
        this.emf = Persistence.createEntityManagerFactory("biblioteca");
        this.em = this.emf.createEntityManager();
    }
    
    /**
     * Metodo que permite el conectar a la base de datos
     * y guardar los datos pasados por los parametros.
     * @param nombreCategoria String Variable que guarda el nombre de la categoria.
     * @return Categoria retorna un objeto del tipo "Categoria" el cual fue guardado.
     */
    public boolean crearCategoria(String nombreCategoria){
        Categoria cat = new Categoria();
        cat.setNombreCategoria(nombreCategoria);
        
        em.getTransaction().begin();
        em.persist(cat);
        em.getTransaction().commit();
        
        return true;
    }
    
    /**
     * Metodo que recibe por parametros un Integer que luego
     * buscara en la base de datos una tupla con el valor del parametro,y procedera
     * a eliminarlo.
     * @param codigoCategoria Int Variable que contendra el Codigo de la categoria.
     * @return Boolean retornara true si la eliminación fue realizada con exito.
     */
    public boolean eliminarCategoria(int codigoCategoria){
        Categoria cat = em.find(Categoria.class, codigoCategoria);
        
        
        em.getTransaction().begin();
        em.remove(cat);
        em.getTransaction().commit();
        
        return true;
    }
    
    /**
     * Metodo que obtiene todas las categorias de la base de datos y los retorna en un List de tipo Categorias.
     * @return List de Categoria
     */
    public List<Categoria> consultarCategorias(){
        List<Categoria> categorias = em.createQuery("Select c from Categoria c").getResultList();
        return categorias;
    }
    
    /**
     * Modifica los valores de una Categoria dentro de la Base de datos, reemplazandolos por los pasados por los parametros.
     * @param codCategoria Int codigo e ID de la categoria dentro de la base de datos.
     * @param nombreCategoria String Nombre de la categoria.
     * @return boolean TRUE si se ha modificado correctamente la categoria en la BD.
     */
    public boolean editarCategoria(int codCategoria, String nombreCategoria){
        Categoria cat = em.find(Categoria.class, codCategoria);
        cat.setNombreCategoria(nombreCategoria);
        
        em.getTransaction().begin();
        em.merge(cat);
        em.getTransaction().commit();
        return true;
}
    
}
