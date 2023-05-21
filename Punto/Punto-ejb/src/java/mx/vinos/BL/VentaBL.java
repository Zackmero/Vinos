/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.vinos.BL;

import java.util.List;
import javax.ejb.Stateless;
import mx.vinos.DAO.VentaDAO;
import mx.vinos.error.Codigo;
import mx.vinos.modelo.Venta;

/**
 *
 * @author Migue
 */
@Stateless
public class VentaBL implements VentaBLLocal {

    @Override
    public Codigo agregar(Venta venta) {

        VentaDAO rd = new VentaDAO();
        rd.crear(venta);

        return Codigo.OK;
    }

    @Override
    public Codigo eliminar(Venta venta) {
        VentaDAO rd = new VentaDAO();
        rd.eliminar(venta);

        return Codigo.OK;
    }

    @Override
    public Codigo editar(Venta venta) {
        VentaDAO rd = new VentaDAO();
        rd.editar(venta);
        return Codigo.OK;

    }

    @Override
    public Venta buscarPorId(int id) {

        VentaDAO pd = new VentaDAO();
        return pd.getPorId(id);

    }
    
    
        @Override
    public List<Venta>getAll() {
        
       VentaDAO pr = new VentaDAO();
        
        return pr.getTodo();
    }
    
}
