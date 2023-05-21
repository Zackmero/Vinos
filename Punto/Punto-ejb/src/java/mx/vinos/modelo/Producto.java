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
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findById", query = "SELECT p FROM Producto p WHERE p.id = :id")
    , @NamedQuery(name = "Producto.findByNombreProducto", query = "SELECT p FROM Producto p WHERE p.nombreProducto = :nombreProducto")
    , @NamedQuery(name = "Producto.findByPrecioUnidad", query = "SELECT p FROM Producto p WHERE p.precioUnidad = :precioUnidad")
    , @NamedQuery(name = "Producto.findByUnidadesEnExistencia", query = "SELECT p FROM Producto p WHERE p.unidadesEnExistencia = :unidadesEnExistencia")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombreProducto")
    private String nombreProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precioUnidad")
    private int precioUnidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unidadesEnExistencia")
    private int unidadesEnExistencia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productoId")
    private List<Venta> ventaList;
    @JoinColumn(name = "Proveedor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Proveedor proveedorid;

    public Producto() {
    }

    public Producto(Integer id) {
        this.id = id;
    }

    public Producto(Integer id, String nombreProducto, int precioUnidad, int unidadesEnExistencia) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.precioUnidad = precioUnidad;
        this.unidadesEnExistencia = unidadesEnExistencia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(int precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public int getUnidadesEnExistencia() {
        return unidadesEnExistencia;
    }

    public void setUnidadesEnExistencia(int unidadesEnExistencia) {
        this.unidadesEnExistencia = unidadesEnExistencia;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    public Proveedor getProveedorid() {
        return proveedorid;
    }

    public void setProveedorid(Proveedor proveedorid) {
        this.proveedorid = proveedorid;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.vinos.BL.Producto[ id=" + id + " ]";
    }
    
}
