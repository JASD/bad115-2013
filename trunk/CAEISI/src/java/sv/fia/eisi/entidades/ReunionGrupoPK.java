/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author antonio
 */
@Embeddable
public class ReunionGrupoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "dia_horario")
    private String diaHorario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_inicio_horario")
    @Temporal(TemporalType.TIME)
    private Date horaInicioHorario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_fin_horario")
    @Temporal(TemporalType.TIME)
    private Date horaFinHorario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "codigo_local")
    private String codigoLocal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "codigo_grupo")
    private String codigoGrupo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano_ciclo")
    private long anoCiclo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_ciclo")
    private short numeroCiclo;

    public ReunionGrupoPK() {
    }

    public ReunionGrupoPK(String diaHorario, Date horaInicioHorario, Date horaFinHorario, String codigoLocal, String codigoGrupo, long anoCiclo, short numeroCiclo) {
        this.diaHorario = diaHorario;
        this.horaInicioHorario = horaInicioHorario;
        this.horaFinHorario = horaFinHorario;
        this.codigoLocal = codigoLocal;
        this.codigoGrupo = codigoGrupo;
        this.anoCiclo = anoCiclo;
        this.numeroCiclo = numeroCiclo;
    }

    public String getDiaHorario() {
        return diaHorario;
    }

    public void setDiaHorario(String diaHorario) {
        this.diaHorario = diaHorario;
    }

    public Date getHoraInicioHorario() {
        return horaInicioHorario;
    }

    public void setHoraInicioHorario(Date horaInicioHorario) {
        this.horaInicioHorario = horaInicioHorario;
    }

    public Date getHoraFinHorario() {
        return horaFinHorario;
    }

    public void setHoraFinHorario(Date horaFinHorario) {
        this.horaFinHorario = horaFinHorario;
    }

    public String getCodigoLocal() {
        return codigoLocal;
    }

    public void setCodigoLocal(String codigoLocal) {
        this.codigoLocal = codigoLocal;
    }

    public String getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(String codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public long getAnoCiclo() {
        return anoCiclo;
    }

    public void setAnoCiclo(long anoCiclo) {
        this.anoCiclo = anoCiclo;
    }

    public short getNumeroCiclo() {
        return numeroCiclo;
    }

    public void setNumeroCiclo(short numeroCiclo) {
        this.numeroCiclo = numeroCiclo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diaHorario != null ? diaHorario.hashCode() : 0);
        hash += (horaInicioHorario != null ? horaInicioHorario.hashCode() : 0);
        hash += (horaFinHorario != null ? horaFinHorario.hashCode() : 0);
        hash += (codigoLocal != null ? codigoLocal.hashCode() : 0);
        hash += (codigoGrupo != null ? codigoGrupo.hashCode() : 0);
        hash += (int) anoCiclo;
        hash += (int) numeroCiclo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReunionGrupoPK)) {
            return false;
        }
        ReunionGrupoPK other = (ReunionGrupoPK) object;
        if ((this.diaHorario == null && other.diaHorario != null) || (this.diaHorario != null && !this.diaHorario.equals(other.diaHorario))) {
            return false;
        }
        if ((this.horaInicioHorario == null && other.horaInicioHorario != null) || (this.horaInicioHorario != null && !this.horaInicioHorario.equals(other.horaInicioHorario))) {
            return false;
        }
        if ((this.horaFinHorario == null && other.horaFinHorario != null) || (this.horaFinHorario != null && !this.horaFinHorario.equals(other.horaFinHorario))) {
            return false;
        }
        if ((this.codigoLocal == null && other.codigoLocal != null) || (this.codigoLocal != null && !this.codigoLocal.equals(other.codigoLocal))) {
            return false;
        }
        if ((this.codigoGrupo == null && other.codigoGrupo != null) || (this.codigoGrupo != null && !this.codigoGrupo.equals(other.codigoGrupo))) {
            return false;
        }
        if (this.anoCiclo != other.anoCiclo) {
            return false;
        }
        if (this.numeroCiclo != other.numeroCiclo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.fia.eisi.entidades.ReunionGrupoPK[ diaHorario=" + diaHorario + ", horaInicioHorario=" + horaInicioHorario + ", horaFinHorario=" + horaFinHorario + ", codigoLocal=" + codigoLocal + ", codigoGrupo=" + codigoGrupo + ", anoCiclo=" + anoCiclo + ", numeroCiclo=" + numeroCiclo + " ]";
    }
    
}
