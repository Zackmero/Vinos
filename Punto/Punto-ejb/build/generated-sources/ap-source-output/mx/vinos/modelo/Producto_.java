package mx.vinos.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.vinos.modelo.Proveedor;
import mx.vinos.modelo.Venta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-21T17:26:42")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, Proveedor> proveedorid;
    public static volatile ListAttribute<Producto, Venta> ventaList;
    public static volatile SingularAttribute<Producto, Integer> precioUnidad;
    public static volatile SingularAttribute<Producto, Integer> id;
    public static volatile SingularAttribute<Producto, Integer> unidadesEnExistencia;
    public static volatile SingularAttribute<Producto, String> nombreProducto;

}