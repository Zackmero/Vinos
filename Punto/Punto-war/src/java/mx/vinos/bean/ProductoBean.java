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
import mx.vinos.BL.ProductoBLLocal;
import mx.vinos.BL.ProveedorBLLocal;
import mx.vinos.modelo.Producto;

/**
 *
 * @author Migue
 */
@Named(value = "productoBean")
@SessionScoped
public class ProductoBean implements Serializable{

    @EJB
    private ProveedorBLLocal proveedorBL;

    @EJB
    private ProductoBLLocal productoBL;

    private Producto producto = new Producto();

    private int provedorSelec;
    
    private String titulo;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * Creates a new instance of ProductoBean
     */
    public ProductoBean() {

    }

    public String agregar() {
        
        producto.setProveedorid(proveedorBL.buscarPorId(provedorSelec));
        productoBL.agregar(producto);
        provedorSelec=0;

        return "productoLista.xhtml";
    }

    public int getProvedorSelec() {
        return provedorSelec;
    }

    public void setProvedorSelec(int provedorSelec) {
        this.provedorSelec = provedorSelec;
    }

  public String editar() {
    producto.setProveedorid(proveedorBL.buscarPorId(provedorSelec));

    productoBL.editar(producto);

    producto = new Producto();
    provedorSelec = 0;

    return "productoLista.xhtml";
}

public String eliminar() {
    productoBL.eliminar(producto);

    producto = new Producto();
    provedorSelec = 0;

    return "productoLista.xhtml";
}

    public List<Producto> getAll() {

        return productoBL.getAll();

    }

    public String permisoPage() {

        return "productoLista.xhtml";
    }

    public void prepararEliminar(Producto p) {

        producto = p;
    }

    public void prepararEditar(Producto p) {

        producto = p;
    }

    public void prepararNuevo() {

        producto = new Producto();
        titulo = "nuevo producto";
    }
    
    
    public void prepararTitulo(){
        
        titulo =  "Productos Entrepise";
    }
}
