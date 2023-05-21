/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.vinos.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import mx.vinos.BL.ProductoBLLocal;
import mx.vinos.BL.VendedorBLLocal;
import mx.vinos.BL.VentaBLLocal;
import mx.vinos.modelo.Venta;
import mx.vinos.modelo.Ventaproducto;

/**
 *
 * @author Migue
 */
@Named(value = "ventaBean")
@SessionScoped
public class VentaBean  implements Serializable{

    @EJB
    private VendedorBLLocal vendedorBL;

    @EJB
    private ProductoBLLocal productoBL;

    @EJB
    private VentaBLLocal ventaBL;

    private Venta venta = new Venta();

    private int productoSelec;

    private int vendedorSelec;

    public VentaBean() {
    }

    public String agregar() {

        venta.setProductoId(productoBL.buscarPorId(productoSelec));
        venta.setVendedorId(vendedorBL.buscarPorId(vendedorSelec));
        ventaBL.agregar(venta);
        productoSelec = 0;
        vendedorSelec = 0;

        return "ventaPage.xhtml";
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public void setProductoSelec(int productoSelec) {
        this.productoSelec = productoSelec;
    }

    public void setVendedorSelec(int vendedorSelec) {
        this.vendedorSelec = vendedorSelec;
    }

    public int getProductoSelec() {
        return productoSelec;
    }

    public int getVendedorSelec() {
        return vendedorSelec;
    }

    public String eliminar() {
        ventaBL.eliminar(venta);

        venta = new Venta();
        productoSelec = 0;
        vendedorSelec = 0;

        return "ventaPage.xhtml";
    }

    public String editar() {
        venta.setProductoId(productoBL.buscarPorId(productoSelec));
        venta.setVendedorId(vendedorBL.buscarPorId(vendedorSelec));
        ventaBL.editar(venta);

        venta = new Venta();
        productoSelec = 0;
        vendedorSelec = 0;

        return "ventaPage.xhtml";
    }

    public List<Venta> getVentaAll() {

        return ventaBL.getAll();

    }

    public String vistaPage() {

        return "ventaPage.xhtml";
    }

    public void prepararNuevo() {

        venta = new Venta();
    }

    public void prepararEditar(Venta v) {

        venta = v;
    }

    public void prepararEliminar(Venta v) {

        venta = v;
    }

}
