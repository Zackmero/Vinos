/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.vinos.BL;

import java.util.List;
import javax.ejb.Stateless;
import mx.vinos.DAO.ProveedorDAO;
import mx.vinos.error.Codigo;
import mx.vinos.modelo.Proveedor;

/**
 *
 * @author Migue
 */
@Stateless
public class ProveedorBL implements ProveedorBLLocal {

    @Override
    public Codigo agregar(Proveedor proveedor) {

        ProveedorDAO pr = new ProveedorDAO();
        pr.crear(proveedor);

        return Codigo.OK;
    }

    @Override
    public Codigo editar(Proveedor proveedor) {

        ProveedorDAO pr = new ProveedorDAO();
        pr.editar(proveedor);

        return Codigo.OK;

    }

    @Override
    public Codigo eliminar(Proveedor proveedor) {

        ProveedorDAO pr = new ProveedorDAO();
        pr.eliminar(proveedor);

        return Codigo.OK;

    }

    @Override
    public Proveedor buscarPorId(int id) {

        ProveedorDAO pr = new ProveedorDAO();

        return pr.getPorId(id);

    }

    @Override
    public List<Proveedor> getAll() {
        
        ProveedorDAO pr = new ProveedorDAO();
        
        return pr.getTodo();
    }

    

}
