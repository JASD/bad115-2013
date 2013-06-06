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
@Table(name = "actividad")
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a")})
public class Actividad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo_actividad")
    private String codigoActividad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "nombre_actividad")
    private String nombreActividad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_horas")
    private short numeroHoras;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "tipo_actividad")
    private String tipoActividad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividad", fetch = FetchType.LAZY)
    private List<CoordinacionCurso> coordinacionCursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "actividad", fetch = FetchType.LAZY)
    private List<AsignacionGrupo> asignacionGrupoList;

    public Actividad() {
    }

    public Actividad(String codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    public Actividad(String codigoActividad, String nombreActividad, short numeroHoras, String tipoActividad) {
        this.codigoActividad = codigoActividad;
        this.nombreActividad = nombreActividad;
        this.numeroHoras = numeroHoras;
        this.tipoActividad = tipoActividad;
    }

    public String getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(String codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public short getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(short numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    public String getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(String tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public List<CoordinacionCurso> getCoordinacionCursoList() {
        return coordinacionCursoList;
    }

    public void setCoordinacionCursoList(List<CoordinacionCurso> coordinacionCursoList) {
        this.coordinacionCursoList = coordinacionCursoList;
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
        hash += (codigoActividad != null ? codigoActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.codigoActividad == null && other.codigoActividad != null) || (this.codigoActividad != null && !this.codigoActividad.equals(other.codigoActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.fia.eisi.entidades.Actividad[ codigoActividad=" + codigoActividad + " ]";
    }
    
}
