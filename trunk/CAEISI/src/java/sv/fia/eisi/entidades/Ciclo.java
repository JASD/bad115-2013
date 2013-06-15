/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author antonio
 */
@Entity
@Table(name = "ciclo") 
@NamedQueries({
    @NamedQuery(name = "Ciclo.findAll", query = "SELECT c FROM Ciclo c"),
    @NamedQuery(name = "Ciclo.ultimo", query = "SELECT c.cicloPK.anoCiclo FROM Ciclo c WHERE c.estadoCiclo='1'"),
    @NamedQuery(name = "CicloNumero.ultimo", query = "SELECT c.cicloPK.numeroCiclo FROM Ciclo c WHERE c.estadoCiclo='1'"),
    @NamedQuery(name = "CicloFechaf.ultimo", query = "SELECT c.fechaFinCiclo FROM Ciclo c WHERE c.estadoCiclo='1'"),
    @NamedQuery(name = "CicloFechai.ultimo", query = "SELECT c.fechaInicioCiclo FROM Ciclo c WHERE c.estadoCiclo='1'")})
public class Ciclo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId 
    protected CicloPK cicloPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio_ciclo")
    @Temporal(TemporalType.DATE)
    private Date fechaInicioCiclo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin_ciclo")
    @Temporal(TemporalType.DATE)
    private Date fechaFinCiclo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_ciclo")
    private boolean estadoCiclo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciclo", fetch = FetchType.LAZY)
    private List<CoordinacionCurso> coordinacionCursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciclo", fetch = FetchType.LAZY)
    private List<ReunionGrupo> reunionGrupoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ciclo", fetch = FetchType.LAZY)
    private List<AsignacionGrupo> asignacionGrupoList;

    public Ciclo() {
    }

    public Ciclo(CicloPK cicloPK) {
        this.cicloPK = cicloPK;
    }

    public Ciclo(CicloPK cicloPK, Date fechaInicioCiclo, Date fechaFinCiclo, boolean estadoCiclo) {
        this.cicloPK = cicloPK;
        this.fechaInicioCiclo = fechaInicioCiclo;
        this.fechaFinCiclo = fechaFinCiclo;
        this.estadoCiclo = estadoCiclo;
    }

    public Ciclo(long anoCiclo, short numeroCiclo) {
        this.cicloPK = new CicloPK(anoCiclo, numeroCiclo);
    }

    public CicloPK getCicloPK() {
        return cicloPK;
    }

    public void setCicloPK(CicloPK cicloPK) {
        this.cicloPK = cicloPK;
    }

    public Date getFechaInicioCiclo() {
        return fechaInicioCiclo;
    }

    public void setFechaInicioCiclo(Date fechaInicioCiclo) {
        this.fechaInicioCiclo = fechaInicioCiclo;
    }

    public Date getFechaFinCiclo() {
        return fechaFinCiclo;
    }

    public void setFechaFinCiclo(Date fechaFinCiclo) {
        this.fechaFinCiclo = fechaFinCiclo;
    }

    public boolean getEstadoCiclo() {
        return estadoCiclo;
    }

    public void setEstadoCiclo(boolean estadoCiclo) {
        this.estadoCiclo = estadoCiclo;
    }

    public List<CoordinacionCurso> getCoordinacionCursoList() {
        return coordinacionCursoList;
    }

    public void setCoordinacionCursoList(List<CoordinacionCurso> coordinacionCursoList) {
        this.coordinacionCursoList = coordinacionCursoList;
    }

    public List<ReunionGrupo> getReunionGrupoList() {
        return reunionGrupoList;
    }

    public void setReunionGrupoList(List<ReunionGrupo> reunionGrupoList) {
        this.reunionGrupoList = reunionGrupoList;
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
        hash += (cicloPK != null ? cicloPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciclo)) {
            return false;
        }
        Ciclo other = (Ciclo) object;
        if ((this.cicloPK == null && other.cicloPK != null) || (this.cicloPK != null && !this.cicloPK.equals(other.cicloPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.fia.eisi.entidades.Ciclo[ cicloPK=" + cicloPK + " ]";
    }
    
}
