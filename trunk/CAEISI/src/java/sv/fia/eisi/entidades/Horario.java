/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author antonio
 */
@Entity
@Table(name = "horario")
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h")})
public class Horario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HorarioPK horarioPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "horario", fetch = FetchType.LAZY)
    private List<ReunionGrupo> reunionGrupoList;

    public Horario() {
    }

    public Horario(HorarioPK horarioPK) {
        this.horarioPK = horarioPK;
    }

    public Horario(String diaHorario, Date horaInicioHorario, Date horaFinHorario) {
        this.horarioPK = new HorarioPK(diaHorario, horaInicioHorario, horaFinHorario);
    }

    public HorarioPK getHorarioPK() {
        return horarioPK;
    }

    public void setHorarioPK(HorarioPK horarioPK) {
        this.horarioPK = horarioPK;
    }

    public List<ReunionGrupo> getReunionGrupoList() {
        return reunionGrupoList;
    }

    public void setReunionGrupoList(List<ReunionGrupo> reunionGrupoList) {
        this.reunionGrupoList = reunionGrupoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (horarioPK != null ? horarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.horarioPK == null && other.horarioPK != null) || (this.horarioPK != null && !this.horarioPK.equals(other.horarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.fia.eisi.entidades.Horario[ horarioPK=" + horarioPK + " ]";
    }
    
}
