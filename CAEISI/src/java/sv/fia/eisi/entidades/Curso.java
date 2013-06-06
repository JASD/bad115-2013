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
import javax.persistence.ManyToMany;
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
@Table(name = "curso")
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c")})
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "codigo_curso")
    private String codigoCurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "nombre_curso")
    private String nombreCurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esta_activo_curso")
    private boolean estaActivoCurso;
    @ManyToMany(mappedBy = "cursoList", fetch = FetchType.LAZY)
    private List<Conocimiento> conocimientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoCurso", fetch = FetchType.LAZY)
    private List<GrupoAcademico> grupoAcademicoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso", fetch = FetchType.LAZY)
    private List<CoordinacionCurso> coordinacionCursoList;
    @JoinColumn(name = "codigo_departamento", referencedColumnName = "codigo_departamento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Departamento codigoDepartamento;

    public Curso() {
    }

    public Curso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public Curso(String codigoCurso, String nombreCurso, boolean estaActivoCurso) {
        this.codigoCurso = codigoCurso;
        this.nombreCurso = nombreCurso;
        this.estaActivoCurso = estaActivoCurso;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public boolean getEstaActivoCurso() {
        return estaActivoCurso;
    }

    public void setEstaActivoCurso(boolean estaActivoCurso) {
        this.estaActivoCurso = estaActivoCurso;
    }

    public List<Conocimiento> getConocimientoList() {
        return conocimientoList;
    }

    public void setConocimientoList(List<Conocimiento> conocimientoList) {
        this.conocimientoList = conocimientoList;
    }

    public List<GrupoAcademico> getGrupoAcademicoList() {
        return grupoAcademicoList;
    }

    public void setGrupoAcademicoList(List<GrupoAcademico> grupoAcademicoList) {
        this.grupoAcademicoList = grupoAcademicoList;
    }

    public List<CoordinacionCurso> getCoordinacionCursoList() {
        return coordinacionCursoList;
    }

    public void setCoordinacionCursoList(List<CoordinacionCurso> coordinacionCursoList) {
        this.coordinacionCursoList = coordinacionCursoList;
    }

    public Departamento getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(Departamento codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCurso != null ? codigoCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.codigoCurso == null && other.codigoCurso != null) || (this.codigoCurso != null && !this.codigoCurso.equals(other.codigoCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.fia.eisi.entidades.Curso[ codigoCurso=" + codigoCurso + " ]";
    }
    
}
