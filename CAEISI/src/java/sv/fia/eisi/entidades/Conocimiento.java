/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author antonio
 */
@Entity
@Table(name = "conocimiento")
@NamedQueries({
    @NamedQuery(name = "Conocimiento.findAll", query = "SELECT c FROM Conocimiento c")})
public class Conocimiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_conocimiento")
    private Long numeroConocimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "nombre_conocimiento")
    private String nombreConocimiento;
    @Size(max = 255)
    @Column(name = "descripcion_conocimiento")
    private String descripcionConocimiento;
    @JoinTable(name = "conocimiento_docente", joinColumns = {
        @JoinColumn(name = "numero_conocimiento", referencedColumnName = "numero_conocimiento")}, inverseJoinColumns = {
        @JoinColumn(name = "isss_empleado", referencedColumnName = "isss_empleado")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<EmpleadoDocente> empleadoDocenteList;
    @JoinTable(name = "conocimiento_curso", joinColumns = {
        @JoinColumn(name = "numero_conocimiento", referencedColumnName = "numero_conocimiento")}, inverseJoinColumns = {
        @JoinColumn(name = "codigo_curso", referencedColumnName = "codigo_curso")})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Curso> cursoList;

    public Conocimiento() {
    }

    public Conocimiento(Long numeroConocimiento) {
        this.numeroConocimiento = numeroConocimiento;
    }

    public Conocimiento(Long numeroConocimiento, String nombreConocimiento) {
        this.numeroConocimiento = numeroConocimiento;
        this.nombreConocimiento = nombreConocimiento;
    }

    public Long getNumeroConocimiento() {
        return numeroConocimiento;
    }

    public void setNumeroConocimiento(Long numeroConocimiento) {
        this.numeroConocimiento = numeroConocimiento;
    }

    public String getNombreConocimiento() {
        return nombreConocimiento;
    }

    public void setNombreConocimiento(String nombreConocimiento) {
        this.nombreConocimiento = nombreConocimiento;
    }

    public String getDescripcionConocimiento() {
        return descripcionConocimiento;
    }

    public void setDescripcionConocimiento(String descripcionConocimiento) {
        this.descripcionConocimiento = descripcionConocimiento;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroConocimiento != null ? numeroConocimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conocimiento)) {
            return false;
        }
        Conocimiento other = (Conocimiento) object;
        if ((this.numeroConocimiento == null && other.numeroConocimiento != null) || (this.numeroConocimiento != null && !this.numeroConocimiento.equals(other.numeroConocimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.fia.eisi.entidades.Conocimiento[ numeroConocimiento=" + numeroConocimiento + " ]";
    }
    
}
