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
public class CoordinacionCursoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "codigo_curso")
    private String codigoCurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano_ciclo")
    private long anoCiclo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_ciclo")
    private short numeroCiclo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "isss_empleado")
    private String isssEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo_actividad")
    private String codigoActividad;

    public CoordinacionCursoPK() {
    }

    public CoordinacionCursoPK(String codigoCurso, long anoCiclo, short numeroCiclo, String isssEmpleado, String codigoActividad) {
        this.codigoCurso = codigoCurso;
        this.anoCiclo = anoCiclo;
        this.numeroCiclo = numeroCiclo;
        this.isssEmpleado = isssEmpleado;
        this.codigoActividad = codigoActividad;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
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

    public String getIsssEmpleado() {
        return isssEmpleado;
    }

    public void setIsssEmpleado(String isssEmpleado) {
        this.isssEmpleado = isssEmpleado;
    }

    public String getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(String codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCurso != null ? codigoCurso.hashCode() : 0);
        hash += (int) anoCiclo;
        hash += (int) numeroCiclo;
        hash += (isssEmpleado != null ? isssEmpleado.hashCode() : 0);
        hash += (codigoActividad != null ? codigoActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CoordinacionCursoPK)) {
            return false;
        }
        CoordinacionCursoPK other = (CoordinacionCursoPK) object;
        if ((this.codigoCurso == null && other.codigoCurso != null) || (this.codigoCurso != null && !this.codigoCurso.equals(other.codigoCurso))) {
            return false;
        }
        if (this.anoCiclo != other.anoCiclo) {
            return false;
        }
        if (this.numeroCiclo != other.numeroCiclo) {
            return false;
        }
        if ((this.isssEmpleado == null && other.isssEmpleado != null) || (this.isssEmpleado != null && !this.isssEmpleado.equals(other.isssEmpleado))) {
            return false;
        }
        if ((this.codigoActividad == null && other.codigoActividad != null) || (this.codigoActividad != null && !this.codigoActividad.equals(other.codigoActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.fia.eisi.entidades.CoordinacionCursoPK[ codigoCurso=" + codigoCurso + ", anoCiclo=" + anoCiclo + ", numeroCiclo=" + numeroCiclo + ", isssEmpleado=" + isssEmpleado + ", codigoActividad=" + codigoActividad + " ]";
    }
    
}
