/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.repositorios;

import org.springframework.stereotype.Repository;
import sv.fia.eisi.entidades.Actividad;

/**
 *
 * @author admin
 */
@Repository
public class ActividadDAO extends AbstractDAO<Actividad> {

    public ActividadDAO() {
        super(Actividad.class);
    }

    @Override
    public void create(Actividad entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Actividad entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Actividad entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Actividad find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
