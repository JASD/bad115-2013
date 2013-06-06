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
@Table(name = "coordinacion_curso")
@NamedQueries({
    @NamedQuery(name = "CoordinacionCurso.findAll", query = "SELECT c FROM CoordinacionCurso c")})
public class CoordinacionCurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoordinacionCursoPK coordinacionCursoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_coordinacion_curso")
    @Temporal(TemporalType.DATE)
    private Date fechaCoordinacionCurso;
    @JoinColumn(name = "isss_empleado", referencedColumnName = "isss_empleado", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmpleadoDocente empleadoDocente;
    @JoinColumn(name = "codigo_curso", referencedColumnName = "codigo_curso", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Curso curso;
    @JoinColumns({
        @JoinColumn(name = "ano_ciclo", referencedColumnName = "ano_ciclo", insertable = false, updatable = false),
        @JoinColumn(name = "numero_ciclo", referencedColumnName = "numero_ciclo", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ciclo ciclo;
    @JoinColumn(name = "codigo_actividad", referencedColumnName = "codigo_actividad", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Actividad actividad;

    public CoordinacionCurso() {
    }

    public CoordinacionCurso(CoordinacionCursoPK coordinacionCursoPK) {
        this.coordinacionCursoPK = coordinacionCursoPK;
    }

    public CoordinacionCurso(CoordinacionCursoPK coordinacionCursoPK, Date fechaCoordinacionCurso) {
        this.coordinacionCursoPK = coordinacionCursoPK;
        this.fechaCoordinacionCurso = fechaCoordinacionCurso;
    }

    public CoordinacionCurso(String codigoCurso, long anoCiclo, short numeroCiclo, String isssEmpleado, String codigoActividad) {
        this.coordinacionCursoPK = new CoordinacionCursoPK(codigoCurso, anoCiclo, numeroCiclo, isssEmpleado, codigoActividad);
    }

    public CoordinacionCursoPK getCoordinacionCursoPK() {
        return coordinacionCursoPK;
    }

    public void setCoordinacionCursoPK(CoordinacionCursoPK coordinacionCursoPK) {
        this.coordinacionCursoPK = coordinacionCursoPK;
    }

    public Date getFechaCoordinacionCurso() {
        return fechaCoordinacionCurso;
    }

    public void setFechaCoordinacionCurso(Date fechaCoordinacionCurso) {
        this.fechaCoordinacionCurso = fechaCoordinacionCurso;
    }

    public EmpleadoDocente getEmpleadoDocente() {
        return empleadoDocente;
    }

    public void setEmpleadoDocente(EmpleadoDocente empleadoDocente) {
        this.empleadoDocente = empleadoDocente;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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
        hash += (coordinacionCursoPK != null ? coordinacionCursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoordinacionCurso)) {
            return false;
        }
        CoordinacionCurso other = (CoordinacionCurso) object;
        if ((this.coordinacionCursoPK == null && other.coordinacionCursoPK != null) || (this.coordinacionCursoPK != null && !this.coordinacionCursoPK.equals(other.coordinacionCursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.fia.eisi.entidades.CoordinacionCurso[ coordinacionCursoPK=" + coordinacionCursoPK + " ]";
    }
    
}
