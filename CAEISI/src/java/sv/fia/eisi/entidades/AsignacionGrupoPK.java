/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author antonio
 */
@Embeddable
public class AsignacionGrupoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "codigo_grupo")
    private String codigoGrupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo_actividad")
    private String codigoActividad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "isss_empleado")
    private String isssEmpleado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano_ciclo")
    private long anoCiclo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_ciclo")
    private short numeroCiclo;

    public AsignacionGrupoPK() {
    }

    public AsignacionGrupoPK(String codigoGrupo, String codigoActividad, String isssEmpleado, long anoCiclo, short numeroCiclo) {
        this.codigoGrupo = codigoGrupo;
        this.codigoActividad = codigoActividad;
        this.isssEmpleado = isssEmpleado;
        this.anoCiclo = anoCiclo;
        this.numeroCiclo = numeroCiclo;
    }

    public String getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(String codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public String getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(String codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    public String getIsssEmpleado() {
        return isssEmpleado;
    }

    public void setIsssEmpleado(String isssEmpleado) {
        this.isssEmpleado = isssEmpleado;
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
        hash += (codigoGrupo != null ? codigoGrupo.hashCode() : 0);
        hash += (codigoActividad != null ? codigoActividad.hashCode() : 0);
        hash += (isssEmpleado != null ? isssEmpleado.hashCode() : 0);
        hash += (int) anoCiclo;
        hash += (int) numeroCiclo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionGrupoPK)) {
            return false;
        }
        AsignacionGrupoPK other = (AsignacionGrupoPK) object;
        if ((this.codigoGrupo == null && other.codigoGrupo != null) || (this.codigoGrupo != null && !this.codigoGrupo.equals(other.codigoGrupo))) {
            return false;
        }
        if ((this.codigoActividad == null && other.codigoActividad != null) || (this.codigoActividad != null && !this.codigoActividad.equals(other.codigoActividad))) {
            return false;
        }
        if ((this.isssEmpleado == null && other.isssEmpleado != null) || (this.isssEmpleado != null && !this.isssEmpleado.equals(other.isssEmpleado))) {
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
        return "sv.fia.eisi.entidades.AsignacionGrupoPK[ codigoGrupo=" + codigoGrupo + ", codigoActividad=" + codigoActividad + ", isssEmpleado=" + isssEmpleado + ", anoCiclo=" + anoCiclo + ", numeroCiclo=" + numeroCiclo + " ]";
    }
    
}
