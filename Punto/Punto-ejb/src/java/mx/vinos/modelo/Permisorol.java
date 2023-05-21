/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.vinos.modelo;

import mx.vinos.modelo.Permiso;
import mx.vinos.modelo.Rol;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Migue
 */
@Entity
@Table(name = "permisorol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permisorol.findAll", query = "SELECT p FROM Permisorol p")
    , @NamedQuery(name = "Permisorol.findById", query = "SELECT p FROM Permisorol p WHERE p.id = :id")})
public class Permisorol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "permiso_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Permiso permisoId;
    @JoinColumn(name = "rol_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Rol rolId;

    public Permisorol() {
    }

    public Permisorol(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Permiso getPermisoId() {
        return permisoId;
    }

    public void setPermisoId(Permiso permisoId) {
        this.permisoId = permisoId;
    }

    public Rol getRolId() {
        return rolId;
    }

    public void setRolId(Rol rolId) {
        this.rolId = rolId;
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
        if (!(object instanceof Permisorol)) {
            return false;
        }
        Permisorol other = (Permisorol) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.vinos.BL.Permisorol[ id=" + id + " ]";
    }
    
}
