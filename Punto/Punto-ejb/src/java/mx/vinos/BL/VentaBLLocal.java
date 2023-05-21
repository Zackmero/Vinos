/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.vinos.BL;

import java.util.List;
import javax.ejb.Local;
import mx.vinos.error.Codigo;
import mx.vinos.modelo.Venta;

/**
 *
 * @author Migue
 */
@Local
public interface VentaBLLocal {

    Codigo agregar(Venta venta);

    Codigo eliminar(Venta venta);

    Codigo editar(Venta venta);

    Venta buscarPorId(int id);
    
    
   List<Venta>getAll();
}
