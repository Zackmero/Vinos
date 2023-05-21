/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.vinos.BL;

import javax.ejb.Stateless;
import mx.vinos.DAO.RolDAO;
import mx.vinos.error.Codigo;
import mx.vinos.modelo.Rol;

/**
 *
 * @author Migue
 */
@Stateless
public class RolBL implements RolBLLocal {

    @Override
    public Codigo agregar(Rol rol) {

        RolDAO rd = new RolDAO();
        rd.crear(rol);

        /* for(Permisorol pr : rol.getPermisorolList()){
            prd.crear(pr);
        }*/
        return Codigo.OK;
    }

    @Override
    public Codigo eliminar(Rol rol) {
        RolDAO rd = new RolDAO();
        rd.eliminar(rol);

        /* for(Permisorol pr : rol.getPermisorolList()){
            prd.crear(pr);
        }*/
        return Codigo.OK;
    }

    @Override
    public Codigo editar(Rol rol) {

        RolDAO rd = new RolDAO();
        rd.editar(rol);

        /* for(Permisorol pr : rol.getPermisorolList()){
            prd.crear(pr);
        }*/
        return Codigo.OK;

    }

    @Override
    public Rol buscarPorId(int id) {

        RolDAO rd = new RolDAO();
        return rd.getPorId(id);

    }

}
