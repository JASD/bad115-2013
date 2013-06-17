/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author antonio
 */
@Entity
@Table(name = "empleado")
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "isss_empleado")
    private String isssEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "primer_nombre_empleado")
    private String primerNombreEmpleado;
    @Size(max = 64)
    @Column(name = "segundo_nombre_empleado")
    private String segundoNombreEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "primer_apellido_empleado")
    private String primerApellidoEmpleado;
    @Size(max = 64)
    @Column(name = "segundo_apellido_empleado")
    private String segundoApellidoEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "grado_academico_empleado")
    private String gradoAcademicoEmpleado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "correo_empleado")
    private String correoEmpleado;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "empleado", fetch = FetchType.LAZY)
    private EmpleadoDocente empleadoDocente;
    @JoinColumn(name = "codigo_contrato", referencedColumnName = "codigo_contrato")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Contrato codigoContrato;

    public Empleado() {
    }

    public Empleado(String isssEmpleado) {
        this.isssEmpleado = isssEmpleado;
    }

    public Empleado(String isssEmpleado, String primerNombreEmpleado, String primerApellidoEmpleado, String gradoAcademicoEmpleado, String correoEmpleado) {
        this.isssEmpleado = isssEmpleado;
        this.primerNombreEmpleado = primerNombreEmpleado;
        this.primerApellidoEmpleado = primerApellidoEmpleado;
        this.gradoAcademicoEmpleado = gradoAcademicoEmpleado;
        this.correoEmpleado = correoEmpleado;
    }

    public String getIsssEmpleado() {
        return isssEmpleado;
    }

    public void setIsssEmpleado(String isssEmpleado) {
        this.isssEmpleado = isssEmpleado;
    }

    public String getPrimerNombreEmpleado() {
        return primerNombreEmpleado;
    }

    public void setPrimerNombreEmpleado(String primerNombreEmpleado) {
        this.primerNombreEmpleado = primerNombreEmpleado;
    }

    public String getSegundoNombreEmpleado() {
        return segundoNombreEmpleado;
    }

    public void setSegundoNombreEmpleado(String segundoNombreEmpleado) {
        this.segundoNombreEmpleado = segundoNombreEmpleado;
    }

    public String getPrimerApellidoEmpleado() {
        return primerApellidoEmpleado;
    }

    public void setPrimerApellidoEmpleado(String primerApellidoEmpleado) {
        this.primerApellidoEmpleado = primerApellidoEmpleado;
    }

    public String getSegundoApellidoEmpleado() {
        return segundoApellidoEmpleado;
    }

    public void setSegundoApellidoEmpleado(String segundoApellidoEmpleado) {
        this.segundoApellidoEmpleado = segundoApellidoEmpleado;
    }

    public String getGradoAcademicoEmpleado() {
        return gradoAcademicoEmpleado;
    }

    public void setGradoAcademicoEmpleado(String gradoAcademicoEmpleado) {
        this.gradoAcademicoEmpleado = gradoAcademicoEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public EmpleadoDocente getEmpleadoDocente() {
        return empleadoDocente;
    }

    public void setEmpleadoDocente(EmpleadoDocente empleadoDocente) {
        this.empleadoDocente = empleadoDocente;
    }

    public Contrato getCodigoContrato() {
        return codigoContrato;
    }

    public void setCodigoContrato(Contrato codigoContrato) {
        this.codigoContrato = codigoContrato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isssEmpleado != null ? isssEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.isssEmpleado == null && other.isssEmpleado != null) || (this.isssEmpleado != null && !this.isssEmpleado.equals(other.isssEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.fia.eisi.entidades.Empleado[ isssEmpleado=" + isssEmpleado + " ]";
    }
    
}
