/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.entidades;

import java.io.Serializable;
import java.util.Date;
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

/**
 *
 * @author antonio
 */
@Entity
@Table(name = "reunion_grupo")
@NamedQueries({
    @NamedQuery(name = "ReunionGrupo.findAll", query = "SELECT r FROM ReunionGrupo r")})
public class ReunionGrupo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ReunionGrupoPK reunionGrupoPK;
    @Column(name = "fecha_reunion_grupo")
    @Temporal(TemporalType.DATE)
    private Date fechaReunionGrupo;
    @JoinColumn(name = "codigo_local", referencedColumnName = "codigo_local", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Local local;
    @JoinColumns({
        @JoinColumn(name = "dia_horario", referencedColumnName = "dia_horario", insertable = false, updatable = false),
        @JoinColumn(name = "hora_inicio_horario", referencedColumnName = "hora_inicio_horario", insertable = false, updatable = false),
        @JoinColumn(name = "hora_fin_horario", referencedColumnName = "hora_fin_horario", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Horario horario;
    @JoinColumn(name = "codigo_grupo", referencedColumnName = "codigo_grupo", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Grupo grupo;
    @JoinColumns({
        @JoinColumn(name = "ano_ciclo", referencedColumnName = "ano_ciclo", insertable = false, updatable = false),
        @JoinColumn(name = "numero_ciclo", referencedColumnName = "numero_ciclo", insertable = false, updatable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ciclo ciclo;

    public ReunionGrupo() {
    }

    public ReunionGrupo(ReunionGrupoPK reunionGrupoPK) {
        this.reunionGrupoPK = reunionGrupoPK;
    }

    public ReunionGrupo(String diaHorario, Date horaInicioHorario, Date horaFinHorario, String codigoLocal, String codigoGrupo, long anoCiclo, short numeroCiclo) {
        this.reunionGrupoPK = new ReunionGrupoPK(diaHorario, horaInicioHorario, horaFinHorario, codigoLocal, codigoGrupo, anoCiclo, numeroCiclo);
    }

    public ReunionGrupoPK getReunionGrupoPK() {
        return reunionGrupoPK;
    }

    public void setReunionGrupoPK(ReunionGrupoPK reunionGrupoPK) {
        this.reunionGrupoPK = reunionGrupoPK;
    }

    public Date getFechaReunionGrupo() {
        return fechaReunionGrupo;
    }

    public void setFechaReunionGrupo(Date fechaReunionGrupo) {
        this.fechaReunionGrupo = fechaReunionGrupo;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Ciclo getCiclo() {
        return ciclo;
    }

    public void setCiclo(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reunionGrupoPK != null ? reunionGrupoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReunionGrupo)) {
            return false;
        }
        ReunionGrupo other = (ReunionGrupo) object;
        if ((this.reunionGrupoPK == null && other.reunionGrupoPK != null) || (this.reunionGrupoPK != null && !this.reunionGrupoPK.equals(other.reunionGrupoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.fia.eisi.entidades.ReunionGrupo[ reunionGrupoPK=" + reunionGrupoPK + " ]";
    }
    
}
