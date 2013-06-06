/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author antonio
 */
@Entity
@Table(name = "contrato")
@NamedQueries({
    @NamedQuery(name = "Contrato.findAll", query = "SELECT c FROM Contrato c")})
public class Contrato implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "codigo_contrato")
    private String codigoContrato;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "tiempo_contrato")
    private String tiempoContrato;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horas_contrato")
    private short horasContrato;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoContrato", fetch = FetchType.LAZY)
    private List<Empleado> empleadoList;

    public Contrato() {
    }

    public Contrato(String codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public Contrato(String codigoContrato, String tiempoContrato, short horasContrato) {
        this.codigoContrato = codigoContrato;
        this.tiempoContrato = tiempoContrato;
        this.horasContrato = horasContrato;
    }

    public String getCodigoContrato() {
        return codigoContrato;
    }

    public void setCodigoContrato(String codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    public String getTiempoContrato() {
        return tiempoContrato;
    }

    public void setTiempoContrato(String tiempoContrato) {
        this.tiempoContrato = tiempoContrato;
    }

    public short getHorasContrato() {
        return horasContrato;
    }

    public void setHorasContrato(short horasContrato) {
        this.horasContrato = horasContrato;
    }

    public List<Empleado> getEmpleadoList() {
        return empleadoList;
    }

    public void setEmpleadoList(List<Empleado> empleadoList) {
        this.empleadoList = empleadoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoContrato != null ? codigoContrato.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrato)) {
            return false;
        }
        Contrato other = (Contrato) object;
        if ((this.codigoContrato == null && other.codigoContrato != null) || (this.codigoContrato != null && !this.codigoContrato.equals(other.codigoContrato))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.fia.eisi.entidades.Contrato[ codigoContrato=" + codigoContrato + " ]";
    }
    
}
