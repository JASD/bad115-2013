/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.repositorios;

import java.util.List;
import java.util.ResourceBundle;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sv.fia.eisi.entidades.GrupoAdministrativo;

/**
 *
 * @author Antonio
 */
@Repository
public class GrupoAdministrativoDAO extends AbstractDAO<GrupoAdministrativo> {

    @Autowired
    private SessionFactory sessionFactory;

    public GrupoAdministrativoDAO() {
        super(GrupoAdministrativo.class);
    }

    @Override
    public String create(GrupoAdministrativo entity) {
        String call = ResourceBundle.getBundle("/procedures")
                .getString("InsertarGrupoAdministrativo");
        Query q = sessionFactory.getCurrentSession()
                .createSQLQuery(call);
        q.setString("tipo", entity.getGrupo().getTipoGrupo().toUpperCase());
        q.setString("codigo", entity.getCodigoGrupo().toUpperCase());
        q.setString("nombre", entity.getNombreGrupoAdministrativo().toUpperCase());
        q.setString("objetivo", entity.getObjetivoGrupoAdministrativo().toUpperCase());
        return (String) q.uniqueResult();
    }

    @Override
    public String edit(GrupoAdministrativo entity) {
        String call = ResourceBundle.getBundle("/procedures")
                .getString("ActualizarGrupoAdministrativo");
        Query q = sessionFactory.getCurrentSession()
                .createSQLQuery(call);
        q.setString("codigo", entity.getCodigoGrupo());
        q.setString("nombre", entity.getNombreGrupoAdministrativo().toUpperCase());
        q.setString("objetivo", entity.getObjetivoGrupoAdministrativo().toUpperCase());
        return (String) q.uniqueResult();
    }

    @Override
    public String delete(GrupoAdministrativo entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GrupoAdministrativo find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<GrupoAdministrativo> findForEnable() {

        return (List<GrupoAdministrativo>) sessionFactory.getCurrentSession()
                .getNamedQuery("GrupoAdministrativo.findAll").list();

    }
}
