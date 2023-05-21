
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import mx.vinos.BL.RolBLLocal;
import mx.vinos.BL.VendedorBLLocal;
import mx.vinos.modelo.Vendedor;

@Named(value = "vendedorBean")
@RequestScoped
public class VendedorBean {

    @EJB
    private VendedorBLLocal vendedorBL;

    @EJB
    private RolBLLocal rolBL;

    /**
     * Creates a new instance of VendedorBean
     */
    public VendedorBean() {
    }

    public String agregar() {

        Vendedor vendedor = new Vendedor();
        
        vendedor.setId(0);
        vendedor.setNombre("Juan");
        vendedor.setApellido("Pérez");
        vendedor.setEdad(10);
        vendedor.setFechaContratacion("10-10-10");
        vendedor.setDireccion("sisis");
        vendedor.setCodigoPostal("45900");
        vendedor.setTelefono("23123123");
        vendedor.setRolId(rolBL.buscarPorId(1)); // Asignar un rol existente al vendedor

        vendedorBL.agregar(vendedor);

        return "index.xhtml";
    }

    public String eliminar() {
        // Buscar el vendedor por ID
        Vendedor vendedor = vendedorBL.buscarPorId(1);

        // Eliminar el vendedor
        vendedorBL.eliminar(vendedor);

        return "index.xhtml";
    }

    public String editar() {
        // Buscar el vendedor por ID
        Vendedor vendedor = vendedorBL.buscarPorId(1);

        // Actualizar los datos del vendedor
        vendedor.setNombre("Pedro");
        vendedor.setApellido("García");
        vendedor.setRolId(rolBL.buscarPorId(2)); // Cambiar el rol del vendedor

        // Guardar los cambios en la base de datos
        vendedorBL.editar(vendedor);

        return "index.xhtml";
    }
    
    
    public List<Vendedor> getAll(){
        
        return vendedorBL.getAll();
        
    }

}
