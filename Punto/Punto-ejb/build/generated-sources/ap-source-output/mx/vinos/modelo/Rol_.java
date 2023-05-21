package mx.vinos.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.vinos.modelo.Permisorol;
import mx.vinos.modelo.Vendedor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-17T10:39:39")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile ListAttribute<Rol, Permisorol> permisorolList;
    public static volatile ListAttribute<Rol, Vendedor> vendedorList;
    public static volatile SingularAttribute<Rol, Integer> id;
    public static volatile SingularAttribute<Rol, String> rol;

}