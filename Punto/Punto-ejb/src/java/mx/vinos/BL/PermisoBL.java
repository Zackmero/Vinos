/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.vinos.BL;

import java.util.List;
import javax.ejb.Stateless;
import mx.vinos.DAO.PermisoDAO;
import mx.vinos.error.Codigo;
import mx.vinos.modelo.Permiso;

/**
 *
 * @author Migue
 */
@Stateless
public class PermisoBL implements PermisoBLLocal {

    @Override
    public Codigo agregar(Permiso permiso) {

        PermisoDAO pdao = new PermisoDAO();
        pdao.crear(permiso);

        return Codigo.OK;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Permiso buscarPorId(int id) {

        PermisoDAO pd = new PermisoDAO();
        return pd.getPorId(id);

    }

    @Override
    public Codigo eliminar(Permiso permiso) {
       
        
        
        PermisoDAO pd = new PermisoDAO();
        pd.eliminar(permiso);
        
        return Codigo.OK;
        
    }

    @Override
    public Codigo editar(Permiso permiso) {
       
    
        PermisoDAO pd = new PermisoDAO();
        pd.editar(permiso);
        
        return Codigo.OK;

    }

    @Override
    public List<Permiso> getTodo() {
        
        
        PermisoDAO pd = new PermisoDAO();
       
        
        return pd.getTodo(); 
    }
    
    
    
    
    

    
    
}
