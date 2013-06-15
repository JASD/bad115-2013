/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.repositorios;

import java.util.ResourceBundle;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sv.fia.eisi.entidades.Ciclo;
//import sv.fia.eisi.entidades.GrupoAcademico;

/**
 *
 * @author Ever
 */
@Repository
public class CerrarCicloDAO extends AbstractDAO<Ciclo> {

    @Autowired
    private SessionFactory sessionFactory;

    public CerrarCicloDAO() {
        super(Ciclo.class);
    }

    @Override
    public String create(Ciclo entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String edit(Ciclo entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String cerrar() {
        String call = ResourceBundle.getBundle("/procedures")
                .getString("CerrarCicloAcademico");
        Query q = sessionFactory.getCurrentSession()
                .createSQLQuery(call);

        return (String) q.uniqueResult();
    }

    @Override
    public String delete(Ciclo entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ciclo find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
