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
public class HorarioPK implements Serializable {
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

    public HorarioPK() {
    }

    public HorarioPK(String diaHorario, Date horaInicioHorario, Date horaFinHorario) {
        this.diaHorario = diaHorario;
        this.horaInicioHorario = horaInicioHorario;
        this.horaFinHorario = horaFinHorario;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (diaHorario != null ? diaHorario.hashCode() : 0);
        hash += (horaInicioHorario != null ? horaInicioHorario.hashCode() : 0);
        hash += (horaFinHorario != null ? horaFinHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorarioPK)) {
            return false;
        }
        HorarioPK other = (HorarioPK) object;
        if ((this.diaHorario == null && other.diaHorario != null) || (this.diaHorario != null && !this.diaHorario.equals(other.diaHorario))) {
            return false;
        }
        if ((this.horaInicioHorario == null && other.horaInicioHorario != null) || (this.horaInicioHorario != null && !this.horaInicioHorario.equals(other.horaInicioHorario))) {
            return false;
        }
        if ((this.horaFinHorario == null && other.horaFinHorario != null) || (this.horaFinHorario != null && !this.horaFinHorario.equals(other.horaFinHorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.fia.eisi.entidades.HorarioPK[ diaHorario=" + diaHorario + ", horaInicioHorario=" + horaInicioHorario + ", horaFinHorario=" + horaFinHorario + " ]";
    }
    
}
