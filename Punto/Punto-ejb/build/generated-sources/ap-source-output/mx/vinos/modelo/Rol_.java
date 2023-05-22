package mx.vinos.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.vinos.modelo.Permisorol;
import mx.vinos.modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-05-22T16:35:11")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile ListAttribute<Rol, Usuario> usuarioList;
    public static volatile ListAttribute<Rol, Permisorol> permisorolList;
    public static volatile SingularAttribute<Rol, Integer> id;
    public static volatile SingularAttribute<Rol, String> rol;

}