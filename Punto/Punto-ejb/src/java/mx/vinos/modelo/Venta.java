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
@Table(name = "venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findById", query = "SELECT v FROM Venta v WHERE v.id = :id")
    , @NamedQuery(name = "Venta.findByFecha", query = "SELECT v FROM Venta v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Venta.findByTotalVenta", query = "SELECT v FROM Venta v WHERE v.totalVenta = :totalVenta")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "totalVenta")
    private double totalVenta;
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Producto productoId;
    @JoinColumn(name = "vendedor_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Vendedor vendedorId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventaId")
    private List<Ventaproducto> ventaproductoList;

    public Venta() {
    }

    public Venta(Integer id) {
        this.id = id;
    }

    public Venta(Integer id, String fecha, double totalVenta) {
        this.id = id;
        this.fecha = fecha;
        this.totalVenta = totalVenta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Producto getProductoId() {
        return productoId;
    }

    public void setProductoId(Producto productoId) {
        this.productoId = productoId;
    }

    public Vendedor getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(Vendedor vendedorId) {
        this.vendedorId = vendedorId;
    }

    @XmlTransient
    public List<Ventaproducto> getVentaproductoList() {
        return ventaproductoList;
    }

    public void setVentaproductoList(List<Ventaproducto> ventaproductoList) {
        this.ventaproductoList = ventaproductoList;
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
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.vinos.BL.Venta[ id=" + id + " ]";
    }
    
}
