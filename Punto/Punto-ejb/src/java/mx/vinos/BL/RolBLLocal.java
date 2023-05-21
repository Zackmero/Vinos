/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.vinos.BL;

import javax.ejb.Local;
import mx.vinos.error.Codigo;
import mx.vinos.modelo.Rol;

/**
 *
 * @author Migue
 */
@Local
public interface RolBLLocal {

    Codigo agregar(Rol rol);
    
      Codigo eliminar(Rol rol);
      
        Codigo editar(Rol rol);
        
           Rol buscarPorId(int id);
    
}
