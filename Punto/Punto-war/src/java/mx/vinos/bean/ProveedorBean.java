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
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import mx.vinos.BL.ProveedorBLLocal;
import mx.vinos.modelo.Proveedor;

/**
 *
 * @author Migue
 */
@Named(value = "proveedorBean")
@SessionScoped
public class ProveedorBean implements Serializable {

    @EJB
    private ProveedorBLLocal proveedorBL;

    private Proveedor proveedor = new Proveedor();

    /**
     * Creates a new instance of ProveedorBean
     */
    public ProveedorBean() {
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public String agregar() {

        proveedorBL.agregar(proveedor);

        proveedor = new Proveedor();
        return "proveedorPage.xhtml";
    }

    public String editar() {

        proveedorBL.editar(proveedor);
        proveedor = new Proveedor();

        return "proveedorPage.xhtml";
    }

    public String eliminar() {

        proveedorBL.eliminar(proveedor);
        proveedor = new Proveedor();

        return "proveedorPage.xhtml";
    }

    public List<Proveedor> getProveedorAll() {

        return proveedorBL.getAll();
    }

    public String permisoPage() {

        return "proveedorPage.xhtml";
    }

    public void prepararEliminar(Proveedor p) {

        proveedor = p;
    }

    public void prepararEditar(Proveedor p) {

        proveedor = p;
    }

    public void prepararNuevo() {

        proveedor = new Proveedor();
    }

}
