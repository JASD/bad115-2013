/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
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
@Table(name = "grupo_academico")
@NamedQueries({
    @NamedQuery(name = "GrupoAcademico.findAll", query = "SELECT g FROM GrupoAcademico g")})
public class GrupoAcademico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "codigo_grupo")
    private String codigoGrupo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_grupo_academico")
    private short numeroGrupoAcademico;
    @Size(max = 128)
    @Column(name = "tema_grupo_academico")
    private String temaGrupoAcademico;
    @JoinColumn(name = "codigo_grupo", referencedColumnName = "codigo_grupo", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Grupo grupo;
    @JoinColumn(name = "codigo_curso", referencedColumnName = "codigo_curso")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Curso codigoCurso;

    public GrupoAcademico() {
    }

    public GrupoAcademico(String codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public GrupoAcademico(String codigoGrupo, short numeroGrupoAcademico) {
        this.codigoGrupo = codigoGrupo;
        this.numeroGrupoAcademico = numeroGrupoAcademico;
    }

    public String getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(String codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public short getNumeroGrupoAcademico() {
        return numeroGrupoAcademico;
    }

    public void setNumeroGrupoAcademico(short numeroGrupoAcademico) {
        this.numeroGrupoAcademico = numeroGrupoAcademico;
    }

    public String getTemaGrupoAcademico() {
        return temaGrupoAcademico;
    }

    public void setTemaGrupoAcademico(String temaGrupoAcademico) {
        this.temaGrupoAcademico = temaGrupoAcademico;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Curso getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Curso codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoGrupo != null ? codigoGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoAcademico)) {
            return false;
        }
        GrupoAcademico other = (GrupoAcademico) object;
        if ((this.codigoGrupo == null && other.codigoGrupo != null) || (this.codigoGrupo != null && !this.codigoGrupo.equals(other.codigoGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.fia.eisi.entidades.GrupoAcademico[ codigoGrupo=" + codigoGrupo + " ]";
    }
    
}
