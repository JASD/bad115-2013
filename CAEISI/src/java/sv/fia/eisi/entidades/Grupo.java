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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author antonio
 */
@Entity
@Table(name = "grupo")
@NamedQueries({
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g")})
public class Grupo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "codigo_grupo")
    private String codigoGrupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "tipo_grupo")
    private String tipoGrupo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "esta_cerrado_grupo")
    private boolean estaCerradoGrupo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "grupo", fetch = FetchType.LAZY)
    private GrupoAcademico grupoAcademico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupo", fetch = FetchType.LAZY)
    private List<ReunionGrupo> reunionGrupoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "grupo", fetch = FetchType.LAZY)
    private GrupoAdministrativo grupoAdministrativo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "grupo", fetch = FetchType.LAZY)
    private List<AsignacionGrupo> asignacionGrupoList;

    public Grupo() {
    }

    public Grupo(String codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public Grupo(String codigoGrupo, String tipoGrupo, boolean estaCerradoGrupo) {
        this.codigoGrupo = codigoGrupo;
        this.tipoGrupo = tipoGrupo;
        this.estaCerradoGrupo = estaCerradoGrupo;
    }

    public String getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(String codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public String getTipoGrupo() {
        return tipoGrupo;
    }

    public void setTipoGrupo(String tipoGrupo) {
        this.tipoGrupo = tipoGrupo;
    }

    public boolean getEstaCerradoGrupo() {
        return estaCerradoGrupo;
    }

    public void setEstaCerradoGrupo(boolean estaCerradoGrupo) {
        this.estaCerradoGrupo = estaCerradoGrupo;
    }

    public GrupoAcademico getGrupoAcademico() {
        return grupoAcademico;
    }

    public void setGrupoAcademico(GrupoAcademico grupoAcademico) {
        this.grupoAcademico = grupoAcademico;
    }

    public List<ReunionGrupo> getReunionGrupoList() {
        return reunionGrupoList;
    }

    public void setReunionGrupoList(List<ReunionGrupo> reunionGrupoList) {
        this.reunionGrupoList = reunionGrupoList;
    }

    public GrupoAdministrativo getGrupoAdministrativo() {
        return grupoAdministrativo;
    }

    public void setGrupoAdministrativo(GrupoAdministrativo grupoAdministrativo) {
        this.grupoAdministrativo = grupoAdministrativo;
    }

    public List<AsignacionGrupo> getAsignacionGrupoList() {
        return asignacionGrupoList;
    }

    public void setAsignacionGrupoList(List<AsignacionGrupo> asignacionGrupoList) {
        this.asignacionGrupoList = asignacionGrupoList;
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
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.codigoGrupo == null && other.codigoGrupo != null) || (this.codigoGrupo != null && !this.codigoGrupo.equals(other.codigoGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.fia.eisi.entidades.Grupo[ codigoGrupo=" + codigoGrupo + " ]";
    }
    
}
