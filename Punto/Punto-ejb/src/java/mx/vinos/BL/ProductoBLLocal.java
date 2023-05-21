/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.vinos.BL;

import java.util.List;
import javax.ejb.Local;
import mx.vinos.error.Codigo;
import mx.vinos.modelo.Producto;

/**
 *
 * @author Migue
 */
@Local
public interface ProductoBLLocal {

    Codigo agregar(Producto producto);

    Codigo editar(Producto producto);

    Codigo eliminar(Producto producto);

    Producto buscarPorId(int id);

    List<Producto> getAll();


    
}
