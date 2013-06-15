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
import sv.fia.eisi.entidades.Actividad;

/**
 *
 * @author Mario Sanchez
 */
@Repository
public class ActividadDAO extends AbstractDAO<Actividad> {

    @Autowired
    private SessionFactory sessionFactory;

    public ActividadDAO() {
        super(Actividad.class);
    }

    @Override
    public String create(Actividad entity) {
        String call = ResourceBundle.getBundle("/procedures").getString("InsertarActividad");
        Query q = sessionFactory.getCurrentSession().createSQLQuery(call);
        q.setString("codigo", entity.getCodigoActividad().toUpperCase());
        q.setString("nombre", entity.getNombreActividad().toUpperCase());
        q.setShort("horas", entity.getNumeroHoras());
        q.setString("tipo", entity.getTipoActividad().toUpperCase());
        return (String) q.uniqueResult();
    }

    @Override
    public String edit(Actividad entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete(Actividad entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Actividad find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Actividad> getActivities() {
        return (List<Actividad>) sessionFactory.getCurrentSession().getNamedQuery("Actividad.findAll").list();
    }
}
