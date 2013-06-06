/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author antonio
 */
@Entity
@Table(name = "local")
@NamedQueries({
    @NamedQuery(name = "Local.findAll", query = "SELECT l FROM Local l")})
public class Local implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "codigo_local")
    private String codigoLocal;
    @Column(name = "capacidad_local")
    private BigInteger capacidadLocal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esta_disponible_local")
    private boolean estaDisponibleLocal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "local", fetch = FetchType.LAZY)
    private List<ReunionGrupo> reunionGrupoList;

    public Local() {
    }

    public Local(String codigoLocal) {
        this.codigoLocal = codigoLocal;
    }

    public Local(String codigoLocal, boolean estaDisponibleLocal) {
        this.codigoLocal = codigoLocal;
        this.estaDisponibleLocal = estaDisponibleLocal;
    }

    public String getCodigoLocal() {
        return codigoLocal;
    }

    public void setCodigoLocal(String codigoLocal) {
        this.codigoLocal = codigoLocal;
    }

    public BigInteger getCapacidadLocal() {
        return capacidadLocal;
    }

    public void setCapacidadLocal(BigInteger capacidadLocal) {
        this.capacidadLocal = capacidadLocal;
    }

    public boolean getEstaDisponibleLocal() {
        return estaDisponibleLocal;
    }

    public void setEstaDisponibleLocal(boolean estaDisponibleLocal) {
        this.estaDisponibleLocal = estaDisponibleLocal;
    }

    public List<ReunionGrupo> getReunionGrupoList() {
        return reunionGrupoList;
    }

    public void setReunionGrupoList(List<ReunionGrupo> reunionGrupoList) {
        this.reunionGrupoList = reunionGrupoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoLocal != null ? codigoLocal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Local)) {
            return false;
        }
        Local other = (Local) object;
        if ((this.codigoLocal == null && other.codigoLocal != null) || (this.codigoLocal != null && !this.codigoLocal.equals(other.codigoLocal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.fia.eisi.entidades.Local[ codigoLocal=" + codigoLocal + " ]";
    }
    
}
