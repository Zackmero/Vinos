/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.vinos.BL;

import java.util.List;
import javax.ejb.Local;
import mx.vinos.error.Codigo;
import mx.vinos.modelo.Proveedor;

/**
 *
 * @author Migue
 */
@Local
public interface ProveedorBLLocal {

    Codigo agregar(Proveedor proveedor);

    Codigo editar(Proveedor proveedor);

    Codigo eliminar(Proveedor proveedor);

    Proveedor buscarPorId(int id);

    List<Proveedor> getAll();
    
    
}
