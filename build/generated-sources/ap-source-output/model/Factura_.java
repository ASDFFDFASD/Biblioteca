package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-10T20:47:04")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, Integer> precioNeto;
    public static volatile SingularAttribute<Factura, String> rutDistribuidor;
    public static volatile SingularAttribute<Factura, Date> fechaCompra;
    public static volatile SingularAttribute<Factura, Integer> costoIva;
    public static volatile SingularAttribute<Factura, Integer> codiogMetodo;
    public static volatile SingularAttribute<Factura, Integer> folioFactura;
    public static volatile SingularAttribute<Factura, Integer> precioTotal;
    public static volatile SingularAttribute<Factura, Date> horaCompra;

}