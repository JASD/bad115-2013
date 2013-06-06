/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author antonio
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "contrasena_usuario")
    private String contrasenaUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esta_habilitado_usuario")
    private boolean estaHabilitadoUsuario;
    @ManyToMany(mappedBy = "usuarioList", fetch = FetchType.EAGER)
    private List<Rol> rolList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nombreUsuario", fetch = FetchType.LAZY)
    private List<EmpleadoDocente> empleadoDocenteList;
    @JoinColumn(name = "isss_empleado", referencedColumnName = "isss_empleado")
    @ManyToOne(fetch = FetchType.LAZY)
    private EmpleadoDocente isssEmpleado;

    public Usuario() {
    }

    public Usuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Usuario(String nombreUsuario, String contrasenaUsuario, boolean estaHabilitadoUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
        this.estaHabilitadoUsuario = estaHabilitadoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public boolean getEstaHabilitadoUsuario() {
        return estaHabilitadoUsuario;
    }

    public void setEstaHabilitadoUsuario(boolean estaHabilitadoUsuario) {
        this.estaHabilitadoUsuario = estaHabilitadoUsuario;
    }

    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    public List<EmpleadoDocente> getEmpleadoDocenteList() {
        return empleadoDocenteList;
    }

    public void setEmpleadoDocenteList(List<EmpleadoDocente> empleadoDocenteList) {
        this.empleadoDocenteList = empleadoDocenteList;
    }

    public EmpleadoDocente getIsssEmpleado() {
        return isssEmpleado;
    }

    public void setIsssEmpleado(EmpleadoDocente isssEmpleado) {
        this.isssEmpleado = isssEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreUsuario != null ? nombreUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.nombreUsuario == null && other.nombreUsuario != null) || (this.nombreUsuario != null && !this.nombreUsuario.equals(other.nombreUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreUsuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return rolList;
    }

    @Override
    public String getPassword() {
        return contrasenaUsuario;
    }

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return estaHabilitadoUsuario;
    }
}
