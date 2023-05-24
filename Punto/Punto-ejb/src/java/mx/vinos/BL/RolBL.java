package mx.vinos.BL;

import java.util.List;
import javax.ejb.Stateless;
import mx.vinos.DAO.RolDAO;
import mx.vinos.error.Codigo;
import mx.vinos.modelo.Rol;
/*
@autor Isaac
*/
@Stateless
public class RolBL implements RolBLLocal {

    @Override
    public Codigo agregar(Rol rol) {

        RolDAO rd = new RolDAO();
        rd.crear(rol);

        return Codigo.OK;
    }

    @Override
    public Codigo eliminar(Rol rol) {
        RolDAO rd = new RolDAO();
        rd.eliminar(rol);

        return Codigo.OK;
    }

    @Override
    public Codigo editar(Rol rol) {

        RolDAO rd = new RolDAO();
        rd.editar(rol);

        return Codigo.OK;

    }

    @Override
    public Rol buscarPorId(int id) {

        RolDAO rd = new RolDAO();
        return rd.getPorId(id);

    }

    @Override
    public List<Rol> getAll() {
        RolDAO rol = new RolDAO();
        return rol.getTodo();
    }

}
