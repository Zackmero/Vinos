/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.vinos.BL;

import java.util.List;
import javax.ejb.Local;
import mx.vinos.error.Codigo;
import mx.vinos.modelo.Permiso;

/**
 *
 * @author Migue
 */
@Local
public interface PermisoBLLocal {

    Codigo agregar(Permiso permiso);

    Permiso buscarPorId(int id);
    
    
    Codigo eliminar(Permiso permiso);
    
    Codigo editar (Permiso permiso);

    List<Permiso> getTodo();
    
    
}
