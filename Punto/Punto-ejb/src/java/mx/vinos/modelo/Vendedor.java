/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.vinos.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Migue
 */
@Entity
@Table(name = "vendedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v")
    , @NamedQuery(name = "Vendedor.findById", query = "SELECT v FROM Vendedor v WHERE v.id = :id")
    , @NamedQuery(name = "Vendedor.findByNombre", query = "SELECT v FROM Vendedor v WHERE v.nombre = :nombre")
    , @NamedQuery(name = "Vendedor.findByApellido", query = "SELECT v FROM Vendedor v WHERE v.apellido = :apellido")
    , @NamedQuery(name = "Vendedor.findByEdad", query = "SELECT v FROM Vendedor v WHERE v.edad = :edad")
    , @NamedQuery(name = "Vendedor.findByFechaContratacion", query = "SELECT v FROM Vendedor v WHERE v.fechaContratacion = :fechaContratacion")
    , @NamedQuery(name = "Vendedor.findByDireccion", query = "SELECT v FROM Vendedor v WHERE v.direccion = :direccion")
    , @NamedQuery(name = "Vendedor.findByCodigoPostal", query = "SELECT v FROM Vendedor v WHERE v.codigoPostal = :codigoPostal")
    , @NamedQuery(name = "Vendedor.findByTelefono", query = "SELECT v FROM Vendedor v WHERE v.telefono = :telefono")})
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "fechaContratacion")
    private String fechaContratacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "codigoPostal")
    private String codigoPostal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telefono")
    private String telefono;
    @JoinColumn(name = "rol_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Rol rolId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendedorId")
    private List<Venta> ventaList;

    public Vendedor() {
    }

    public Vendedor(Integer id) {
        this.id = id;
    }

    public Vendedor(Integer id, String nombre, String apellido, int edad, String fechaContratacion, String direccion, String codigoPostal, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaContratacion = fechaContratacion;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.telefono = telefono;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Rol getRolId() {
        return rolId;
    }

    public void setRolId(Rol rolId) {
        this.rolId = rolId;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.vinos.BL.Vendedor[ id=" + id + " ]";
    }
    
}
