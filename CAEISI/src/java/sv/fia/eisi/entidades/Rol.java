/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author antonio
 */
@Entity
@Table(name = "rol")
@NamedQueries({
    @NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r")})
public class Rol implements Serializable, GrantedAuthority {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_rol")
    private Integer numeroRol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "nombre_rol")
    private String nombreRol;
    @JoinTable(name = "usuario_rol", joinColumns = {
        @JoinColumn(name = "numero_rol", referencedColumnName = "numero_rol")}, inverseJoinColumns = {
        @JoinColumn(name = "nombre_usuario", referencedColumnName = "nombre_usuario")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;

    public Rol() {
    }

    public Rol(Integer numeroRol) {
        this.numeroRol = numeroRol;
    }

    public Rol(Integer numeroRol, String nombreRol) {
        this.numeroRol = numeroRol;
        this.nombreRol = nombreRol;
    }

    public Integer getNumeroRol() {
        return numeroRol;
    }

    public void setNumeroRol(Integer numeroRol) {
        this.numeroRol = numeroRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroRol != null ? numeroRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rol)) {
            return false;
        }
        Rol other = (Rol) object;
        if ((this.numeroRol == null && other.numeroRol != null) || (this.numeroRol != null && !this.numeroRol.equals(other.numeroRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.fia.eisi.entidades.Rol[ numeroRol=" + numeroRol + " ]";
    }

    @Override
    public String getAuthority() {
        return nombreRol;
    }
    
}
