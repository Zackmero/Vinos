package mx.vinos.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.vinos.modelo.Rol;
import mx.vinos.modelo.Venta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-17T10:39:39")
@StaticMetamodel(Vendedor.class)
public class Vendedor_ { 

    public static volatile SingularAttribute<Vendedor, Rol> rolId;
    public static volatile SingularAttribute<Vendedor, String> codigoPostal;
    public static volatile ListAttribute<Vendedor, Venta> ventaList;
    public static volatile SingularAttribute<Vendedor, String> apellido;
    public static volatile SingularAttribute<Vendedor, String> fechaContratacion;
    public static volatile SingularAttribute<Vendedor, String> direccion;
    public static volatile SingularAttribute<Vendedor, Integer> id;
    public static volatile SingularAttribute<Vendedor, String> telefono;
    public static volatile SingularAttribute<Vendedor, String> nombre;
    public static volatile SingularAttribute<Vendedor, Integer> edad;

}