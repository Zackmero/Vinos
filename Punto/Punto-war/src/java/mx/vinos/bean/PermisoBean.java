
package mx.vinos.bean;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import mx.vinos.BL.PermisoBLLocal;
import mx.vinos.modelo.Permiso;


@Named(value = "permisoBean")
@SessionScoped
public class PermisoBean  implements Serializable {

    @EJB
    private PermisoBLLocal permisoBL;
    private Permiso permiso = new Permiso();
    private String titulo = "Nuevo Permiso";

   
    public PermisoBean() {
    }

    public Permiso getPermiso() {
        return permiso;
    }

    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    public String getTitulo() {
        return titulo;
    }

    public String agregar() {
        permisoBL.agregar(permiso);
        permiso = new Permiso();
        return "PermisoList.xhtml";
    }

    public String eliminar() {
        permiso.setTipoPermiso("xxx");
        permisoBL.eliminar(permiso);
        permiso = new Permiso();
        return "PermisoList.xhtml";
    }

    public void prepararEditar(Permiso p) {
        titulo = "editando";
        permiso = p;
    }

    public void prepararEliminar(Permiso p) {

        permiso = p;
    }

    public String editar() {
        permisoBL.editar(permiso);
        permiso = new Permiso();
        return "PermisoList.xhtml";
    }

    public String permisoPage() {
        return "PermisList.xhtml";
    }

    public List<Permiso> getPermisoAll() {
        return permisoBL.getTodo();

    }
     public String Cerrar() {
        return "index.xhtml";
    }

}
