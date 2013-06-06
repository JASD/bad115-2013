/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.entidades;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author antonio
 */
@Entity
@Table(name = "empleado_docente")
@NamedQueries({
    @NamedQuery(name = "EmpleadoDocente.findAll", query = "SELECT e FROM EmpleadoDocente e")})
public class EmpleadoDocente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "isss_empleado")
    private String isssEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "categoria_docente")
    private String categoriaDocente;
    @Size(max = 9)
    @Column(name = "cargo_docente")
    private String cargoDocente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "es_coordinador_docente")
    private boolean esCoordinadorDocente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esta_activo_docente")
    private boolean estaActivoDocente;
    @ManyToMany(mappedBy = "empleadoDocenteList", fetch = FetchType.LAZY)
    private List<Conocimiento> conocimientoList;
    @JoinColumn(name = "nombre_usuario", referencedColumnName = "nombre_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario nombreUsuario;
    @JoinColumn(name = "isss_empleado", referencedColumnName = "isss_empleado", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado empleado;
    @JoinColumn(name = "codigo_departamento", referencedColumnName = "codigo_departamento")
    @ManyToOne(fetch = FetchType.LAZY)
    private Departamento codigoDepartamento;
    @OneToMany(mappedBy = "isssEmpleado", fetch = FetchType.LAZY)
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoDocente", fetch = FetchType.LAZY)
    private List<CoordinacionCurso> coordinacionCursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "isssEmpleado", fetch = FetchType.LAZY)
    private List<Departamento> departamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoDocente", fetch = FetchType.LAZY)
    private List<AsignacionGrupo> asignacionGrupoList;

    public EmpleadoDocente() {
    }

    public EmpleadoDocente(String isssEmpleado) {
        this.isssEmpleado = isssEmpleado;
    }

    public EmpleadoDocente(String isssEmpleado, String categoriaDocente, boolean esCoordinadorDocente, boolean estaActivoDocente) {
        this.isssEmpleado = isssEmpleado;
        this.categoriaDocente = categoriaDocente;
        this.esCoordinadorDocente = esCoordinadorDocente;
        this.estaActivoDocente = estaActivoDocente;
    }

    public String getIsssEmpleado() {
        return isssEmpleado;
    }

    public void setIsssEmpleado(String isssEmpleado) {
        this.isssEmpleado = isssEmpleado;
    }

    public String getCategoriaDocente() {
        return categoriaDocente;
    }

    public void setCategoriaDocente(String categoriaDocente) {
        this.categoriaDocente = categoriaDocente;
    }

    public String getCargoDocente() {
        return cargoDocente;
    }

    public void setCargoDocente(String cargoDocente) {
        this.cargoDocente = cargoDocente;
    }

    public boolean getEsCoordinadorDocente() {
        return esCoordinadorDocente;
    }

    public void setEsCoordinadorDocente(boolean esCoordinadorDocente) {
        this.esCoordinadorDocente = esCoordinadorDocente;
    }

    public boolean getEstaActivoDocente() {
        return estaActivoDocente;
    }

    public void setEstaActivoDocente(boolean estaActivoDocente) {
        this.estaActivoDocente = estaActivoDocente;
    }

    public List<Conocimiento> getConocimientoList() {
        return conocimientoList;
    }

    public void setConocimientoList(List<Conocimiento> conocimientoList) {
        this.conocimientoList = conocimientoList;
    }

    public Usuario getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(Usuario nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Departamento getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(Departamento codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public List<CoordinacionCurso> getCoordinacionCursoList() {
        return coordinacionCursoList;
    }

    public void setCoordinacionCursoList(List<CoordinacionCurso> coordinacionCursoList) {
        this.coordinacionCursoList = coordinacionCursoList;
    }

    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }

    public List<AsignacionGrupo> getAsignacionGrupoList() {
        return asignacionGrupoList;
    }

    public void setAsignacionGrupoList(List<AsignacionGrupo> asignacionGrupoList) {
        this.asignacionGrupoList = asignacionGrupoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isssEmpleado != null ? isssEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoDocente)) {
            return false;
        }
        EmpleadoDocente other = (EmpleadoDocente) object;
        if ((this.isssEmpleado == null && other.isssEmpleado != null) || (this.isssEmpleado != null && !this.isssEmpleado.equals(other.isssEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.fia.eisi.entidades.EmpleadoDocente[ isssEmpleado=" + isssEmpleado + " ]";
    }
    
}
