package mx.vinos.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.vinos.modelo.Producto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-22T16:35:11")
@StaticMetamodel(Proveedor.class)
public class Proveedor_ { 

    public static volatile SingularAttribute<Proveedor, String> marca;
    public static volatile ListAttribute<Proveedor, Producto> productoList;
    public static volatile SingularAttribute<Proveedor, Integer> id;
    public static volatile SingularAttribute<Proveedor, String> telefono;
    public static volatile SingularAttribute<Proveedor, String> nombre;

}