/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.vinos.BL;

import java.util.List;
import javax.ejb.Local;
import mx.vinos.error.Codigo;
import mx.vinos.modelo.Vendedor;

/**
 *
 * @author Migue
 */
@Local
public interface VendedorBLLocal {

    Codigo agregar(Vendedor vendedor);

    Codigo eliminar(Vendedor vendedor);

    Codigo editar(Vendedor vendedor);

    Vendedor buscarPorId(int id);

    List<Vendedor> getAll();

}
