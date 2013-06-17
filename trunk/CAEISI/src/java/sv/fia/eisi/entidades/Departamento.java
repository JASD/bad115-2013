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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "departamento")
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d")})
public class Departamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "codigo_departamento")
    private String codigoDepartamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "nombre_departamento")
    private String nombreDepartamento;
    @OneToMany(mappedBy = "codigoDepartamento", fetch = FetchType.LAZY)
    private List<EmpleadoDocente> empleadoDocenteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoDepartamento", fetch = FetchType.LAZY)
    private List<Curso> cursoList;
    @JoinColumn(name = "isss_empleado", referencedColumnName = "isss_empleado")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EmpleadoDocente isssEmpleado;

    public Departamento() {
    }

    public Departamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public Departamento(String codigoDepartamento, String nombreDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public List<EmpleadoDocente> getEmpleadoDocenteList() {
        return empleadoDocenteList;
    }

    public void setEmpleadoDocenteList(List<EmpleadoDocente> empleadoDocenteList) {
        this.empleadoDocenteList = empleadoDocenteList;
    }

    public List<Curso> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<Curso> cursoList) {
        this.cursoList = cursoList;
    }

    public EmpleadoDocente getIsssEmpleado() {
        return isssEmpleado;
    }

    public void setIsssEmpleado(EmpleadoDocente isssEmpleado) {
        this.isssEmpleado = isssEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoDepartamento != null ? codigoDepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.codigoDepartamento == null && other.codigoDepartamento != null) || (this.codigoDepartamento != null && !this.codigoDepartamento.equals(other.codigoDepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombreDepartamento;
    }
    
}
