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

/**
 *
 * @author antonio
 */
@Embeddable
public class CicloPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano_ciclo")
    private long anoCiclo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_ciclo")
    private short numeroCiclo;

    public CicloPK() {
    }

    public CicloPK(long anoCiclo, short numeroCiclo) {
        this.anoCiclo = anoCiclo;
        this.numeroCiclo = numeroCiclo;
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
        hash += (int) anoCiclo;
        hash += (int) numeroCiclo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CicloPK)) {
            return false;
        }
        CicloPK other = (CicloPK) object;
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
        return "sv.fia.eisi.entidades.CicloPK[ anoCiclo=" + anoCiclo + ", numeroCiclo=" + numeroCiclo + " ]";
    }
    
}
