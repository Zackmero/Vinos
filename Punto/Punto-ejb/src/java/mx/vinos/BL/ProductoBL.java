/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.vinos.BL;

import java.util.List;
import javax.ejb.Stateless;
import mx.vinos.DAO.ProductoDAO;
import mx.vinos.error.Codigo;
import mx.vinos.modelo.Producto;

/**
 *
 * @author Migue
 */
@Stateless
public class ProductoBL implements ProductoBLLocal {

    @Override
    public Codigo agregar(Producto producto) {

        ProductoDAO pr = new ProductoDAO();
        pr.crear(producto);

        return Codigo.OK;
    }

    @Override
    public Codigo editar(Producto producto) {

        ProductoDAO pr = new ProductoDAO();
        pr.editar(producto);

        return Codigo.OK;

    }

    @Override
    public Codigo eliminar(Producto producto) {

        ProductoDAO pr = new ProductoDAO();
        pr.eliminar(producto);

        return Codigo.OK;

    }

    @Override
    public Producto buscarPorId(int id) {

        ProductoDAO pr = new ProductoDAO();

        return pr.getPorId(id);

    }

    @Override
    public List<Producto> getAll() {
        
        ProductoDAO pr =  new ProductoDAO();
        
        return pr.getTodo();
    }



}
