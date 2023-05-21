/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.vinos.bean;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import mx.vinos.BL.PermisoBLLocal;
import mx.vinos.modelo.Permiso;

/**
 *
 * @author Migue
 */
@Named(value = "permisoBean")
@SessionScoped
public class PermisoBean  implements Serializable {

    @EJB
    private PermisoBLLocal permisoBL;
    private Permiso permiso = new Permiso();
    private String titulo = "Nuevo Permiso";

    /**
     * Creates a new instance of PermisoBean
     */
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

        return "permisoPage.xhtml";
    }

    public String eliminar() {
  
        permiso.setTipoPermiso("xxx");
        permisoBL.eliminar(permiso);

        permiso = new Permiso();

        return "permisoPage.xhtml";
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

        return "permisoPage.xhtml";

    }

    public String permisoPage() {

        return "permisoPage.xhtml";
    }

    public List<Permiso> getPermisoAll() {

        return permisoBL.getTodo();

    }
    
    
     public String Cerrar() {

        return "index.xhtml";
    }

}
