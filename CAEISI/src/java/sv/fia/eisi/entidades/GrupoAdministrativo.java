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
@Table(name = "grupo_administrativo")
@NamedQueries({
    @NamedQuery(name = "GrupoAdministrativo.findAll", query = "SELECT g FROM GrupoAdministrativo g")})
public class GrupoAdministrativo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "codigo_grupo")
    private String codigoGrupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "nombre_grupo_administrativo")
    private String nombreGrupoAdministrativo;
    @Size(max = 128)
    @Column(name = "objetivo_grupo_administrativo")
    private String objetivoGrupoAdministrativo;
    @JoinColumn(name = "codigo_grupo", referencedColumnName = "codigo_grupo", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Grupo grupo;

    public GrupoAdministrativo() {
    }

    public GrupoAdministrativo(String codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public GrupoAdministrativo(String codigoGrupo, String nombreGrupoAdministrativo) {
        this.codigoGrupo = codigoGrupo;
        this.nombreGrupoAdministrativo = nombreGrupoAdministrativo;
    }

    public String getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(String codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public String getNombreGrupoAdministrativo() {
        return nombreGrupoAdministrativo;
    }

    public void setNombreGrupoAdministrativo(String nombreGrupoAdministrativo) {
        this.nombreGrupoAdministrativo = nombreGrupoAdministrativo;
    }

    public String getObjetivoGrupoAdministrativo() {
        return objetivoGrupoAdministrativo;
    }

    public void setObjetivoGrupoAdministrativo(String objetivoGrupoAdministrativo) {
        this.objetivoGrupoAdministrativo = objetivoGrupoAdministrativo;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
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
        if (!(object instanceof GrupoAdministrativo)) {
            return false;
        }
        GrupoAdministrativo other = (GrupoAdministrativo) object;
        if ((this.codigoGrupo == null && other.codigoGrupo != null) || (this.codigoGrupo != null && !this.codigoGrupo.equals(other.codigoGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.fia.eisi.entidades.GrupoAdministrativo[ codigoGrupo=" + codigoGrupo + " ]";
    }
    
}
