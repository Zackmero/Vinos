package mx.vinos.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import mx.vinos.BL.PermisoBLLocal;
import mx.vinos.BL.RolBLLocal;
import mx.vinos.modelo.Permisorol;
import mx.vinos.modelo.Rol;

@Named(value = "rolBean")
@RequestScoped
public class RolBean {

   
    @EJB
    private RolBLLocal rolBL;
    
    private Rol rol = new Rol();
    

    public RolBean() {
    }

    public Rol getRol() {
        return rol;
    }
    
    public void setRol(Rol rol){
        this.rol=rol;
    }

    public String agregar() {
        System.out.println("Llego a aqui en rolbean");
        rolBL.agregar(rol);
        rol = new Rol();
        return "rolPage.xhtml";
    }
    public String editar() {
        
        rolBL.editar(rol);
        rol = new Rol();
        return "rolPage.xhtml";
    }
    public String eliminar() {
        rol.setRol("xxx");
        rolBL.eliminar(rol);
        rol = new Rol();
        return "rolPage.xhtml";
    }

    public List<Rol> getRolAll() {
        return rolBL.getAll();
    }

    public String permisoPage() {

        return "rolPage.xhtml";
    }

    

    public void prepararEditar(Rol r) {

        rol = r;
    }

    public void prepararEliminar(Rol r) {

        rol = r;
    }

}
