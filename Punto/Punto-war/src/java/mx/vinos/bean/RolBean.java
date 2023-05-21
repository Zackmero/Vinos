/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.vinos.bean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import mx.vinos.BL.PermisoBLLocal;
import mx.vinos.BL.RolBLLocal;
import mx.vinos.modelo.Permisorol;
import mx.vinos.modelo.Rol;

/**
 *
 * @author Migue
 */
@Named(value = "rolBean")
@RequestScoped
public class RolBean {

    @EJB
    private PermisoBLLocal permisoBL;

    @EJB
    private RolBLLocal rolBL;

    /**
     * Creates a new instance of RolBean
     */
    public RolBean() {
    }

    public String agregar() {

        Rol rol = new Rol(0, "prueba ");
        
        List<Permisorol> lista = new ArrayList<>();
        Permisorol pr = new Permisorol();
        pr.setRolId(rol);
        pr.setPermisoId(permisoBL.buscarPorId(4));
        lista.add(pr);
        
        rol.setPermisorolList(lista);
        rolBL.agregar(rol);

        return "index.xhtml";
    }
    
    
    
    
   public String eliminar() {
    // Buscar el rol por ID
    Rol rol = rolBL.buscarPorId(3);

    // Eliminar el rol y sus permisos asociados
    rolBL.eliminar(rol);

    return "index.xhtml";
}
    
    
    
    
 public String editar() {
        
    // Buscar el rol por ID
    Rol rol = rolBL.buscarPorId(3);

    // Actualizar los datos del rol

    
    // Actualizar la lista de permisos asociados al rol
    List<Permisorol> lista = rol.getPermisorolList();
    
    lista.clear(); // Limpiar la lista actual de permisos asociados

    Permisorol pr = new Permisorol(5);
    pr.setRolId(rol);
    pr.setPermisoId(permisoBL.buscarPorId(4));
    lista.add(pr);
    rol.setPermisorolList(lista);
    // Guardar los cambios en la base de datos
    rolBL.editar(rol);

    return "index.xhtml";
}
 
 
 
 
 public String getTodo(){
     
     
     
     return null;
 }
    
    
        
    }
    
    


