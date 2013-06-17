/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author antonio
 */
@Entity
@Table(name = "asignacion_grupo")
@NamedQueries({
    @NamedQuery(name = "AsignacionGrupo.findAll", query = "SELECT a FROM AsignacionGrupo a"),
    @NamedQuery(name = "AsignacionGrupo.findByCicloAcademico", query = "SELECT a FROM AsignacionGrupo a"
            + " WHERE a.ciclo = :ciclo AND a.grupo.tipoGrupo IN ('DISC', 'TEO', 'LAB', 'TESIS')"
            + "ORDER BY a.empleadoDocente"),
    @NamedQuery(name = "AsignacionGrupo.findByCicloAdminis", query = "SELECT a FROM AsignacionGrupo a"
            + " WHERE a.ciclo = :ciclo AND a.grupo.tipoGrupo IN ('INVEST', 'COMISION', 'COMITE')"
            + "ORDER BY a.empleadoDocente"),
    @NamedQuery(name = "AsignacionGrupo.findByCicloDocenteAcad", query = "SELECT a FROM AsignacionGrupo a"
            + " WHERE a.ciclo = :ciclo AND a.empleadoDocente = :docente AND "
            + "a.grupo.tipoGrupo IN ('DISC', 'TEO', 'LAB', 'TESIS') "
            + "ORDER BY a.grupo.codigoGrupo"),
    @NamedQuery(name = "AsignacionGrupo.findByCicloDocenteAdmin", query = "SELECT a FROM AsignacionGrupo a"
            + " WHERE a.ciclo = :ciclo AND a.empleadoDocente = :docente AND "
            + "a.grupo.tipoGrupo IN ('INVEST', 'COMISION', 'COMITE') "
            + "ORDER BY a.grupo.codigoGrupo")})
public class AsignacionGrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AsignacionGrupoPK asignacionGrupoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_asignacion_grupo")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacionGrupo;
    @JoinColumn(name = "codigo_grupo", referencedColumnName = "codigo_grupo", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Grupo grupo;
    @JoinColumn(name = "isss_empleado", referencedColumnName = "isss_empleado", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmpleadoDocente empleadoDocente;
    @JoinColumns({
        @JoinColumn(name = "ano_ciclo", referencedColumnName = "ano_ciclo", insertable = false, updatable = false),
        @JoinColumn(name = "numero_ciclo", referencedColumnName = "numero_ciclo", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ciclo ciclo;
    @JoinColumn(name = "codigo_actividad", referencedColumnName = "codigo_actividad", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Actividad actividad;

    public AsignacionGrupo() {
    }

    public AsignacionGrupo(AsignacionGrupoPK asignacionGrupoPK) {
        this.asignacionGrupoPK = asignacionGrupoPK;
    }

    public AsignacionGrupo(AsignacionGrupoPK asignacionGrupoPK, Date fechaAsignacionGrupo) {
        this.asignacionGrupoPK = asignacionGrupoPK;
        this.fechaAsignacionGrupo = fechaAsignacionGrupo;
    }

    public AsignacionGrupo(String codigoGrupo, String codigoActividad, String isssEmpleado, long anoCiclo, short numeroCiclo) {
        this.asignacionGrupoPK = new AsignacionGrupoPK(codigoGrupo, codigoActividad, isssEmpleado, anoCiclo, numeroCiclo);
    }

    public AsignacionGrupoPK getAsignacionGrupoPK() {
        return asignacionGrupoPK;
    }

    public void setAsignacionGrupoPK(AsignacionGrupoPK asignacionGrupoPK) {
        this.asignacionGrupoPK = asignacionGrupoPK;
    }

    public Date getFechaAsignacionGrupo() {
        return fechaAsignacionGrupo;
    }

    public void setFechaAsignacionGrupo(Date fechaAsignacionGrupo) {
        this.fechaAsignacionGrupo = fechaAsignacionGrupo;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public EmpleadoDocente getEmpleadoDocente() {
        return empleadoDocente;
    }

    public void setEmpleadoDocente(EmpleadoDocente empleadoDocente) {
        this.empleadoDocente = empleadoDocente;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asignacionGrupoPK != null ? asignacionGrupoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionGrupo)) {
            return false;
        }
        AsignacionGrupo other = (AsignacionGrupo) object;
        if ((this.asignacionGrupoPK == null && other.asignacionGrupoPK != null) || (this.asignacionGrupoPK != null && !this.asignacionGrupoPK.equals(other.asignacionGrupoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.fia.eisi.entidades.AsignacionGrupo[ asignacionGrupoPK=" + asignacionGrupoPK + " ]";
    }
}
