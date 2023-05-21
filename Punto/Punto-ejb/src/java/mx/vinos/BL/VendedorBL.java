package mx.vinos.BL;

import java.util.List;
import javax.ejb.Stateless;
import mx.vinos.DAO.VendedorDAO;
import mx.vinos.error.Codigo;
import mx.vinos.modelo.Vendedor;

@Stateless
public class VendedorBL implements VendedorBLLocal {

    @Override
    public Codigo agregar(Vendedor vendedor) {

        VendedorDAO rd = new VendedorDAO();
        rd.crear(vendedor);

        return Codigo.OK;
    }

    @Override
    public Codigo eliminar(Vendedor vendedor) {
        VendedorDAO rd = new VendedorDAO();
        rd.eliminar(vendedor);

        return Codigo.OK;
    }

    @Override
    public Codigo editar(Vendedor vendedor) {
        VendedorDAO rd = new VendedorDAO();
        rd.editar(vendedor);
        return Codigo.OK;

    }

    @Override
    public Vendedor buscarPorId(int id) {

        VendedorDAO pd = new VendedorDAO();
        return pd.getPorId(id);

    }

    @Override
    public List<Vendedor> getAll() {
        
        VendedorDAO pd = new VendedorDAO();
        return pd.getTodo();
    }
    
    
    
    

}
