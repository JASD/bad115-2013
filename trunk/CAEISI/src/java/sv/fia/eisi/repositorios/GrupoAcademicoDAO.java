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
import sv.fia.eisi.entidades.GrupoAcademico;

/**
 *
 * @author Antonio
 */
@Repository
public class GrupoAcademicoDAO extends AbstractDAO<GrupoAcademico> {

    @Autowired
    private SessionFactory sessionFactory;

    public GrupoAcademicoDAO() {
        super(GrupoAcademico.class);
    }

    @Override
    public String create(GrupoAcademico entity) {
        String call = ResourceBundle.getBundle("/procedures")
                .getString("InsertarGrupoAcademico");
        Query q = sessionFactory.getCurrentSession()
                .createSQLQuery(call);
        q.setString("tipo", entity.getGrupo().getTipoGrupo().toUpperCase());
        q.setString("codigo", entity.getCodigoGrupo().toUpperCase());
        q.setString("curso", entity.getCodigoCurso().getCodigoCurso());
        q.setShort("numero", entity.getNumeroGrupoAcademico());
        q.setString("tema", entity.getTemaGrupoAcademico());
        return (String) q.uniqueResult();
    }

    @Override
    public String edit(GrupoAcademico entity) {
        String call = ResourceBundle.getBundle("/procedures")
                .getString("ActualizarEstadoGrupo");
        Query q = sessionFactory.getCurrentSession()
                .createSQLQuery(call);
        q.setString("codigo", entity.getCodigoGrupo());
        q.setBoolean("estado", entity.getGrupo().getEstaCerradoGrupo());
        return (String) q.uniqueResult();
    }

    @Override
    public String delete(GrupoAcademico entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public GrupoAcademico find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<GrupoAcademico> findForEnable(){
        
        return (List<GrupoAcademico>) sessionFactory.getCurrentSession()
                .getNamedQuery("GrupoAcademico.findHabilitar").list();
    
    }
}
