package mx.vinos.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.vinos.modelo.Producto;
import mx.vinos.modelo.Vendedor;
import mx.vinos.modelo.Ventaproducto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-21T17:26:42")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, String> fecha;
    public static volatile SingularAttribute<Venta, Producto> productoId;
    public static volatile SingularAttribute<Venta, Double> totalVenta;
    public static volatile ListAttribute<Venta, Ventaproducto> ventaproductoList;
    public static volatile SingularAttribute<Venta, Integer> id;
    public static volatile SingularAttribute<Venta, Vendedor> vendedorId;

}