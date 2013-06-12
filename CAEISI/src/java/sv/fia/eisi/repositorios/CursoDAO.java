/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.repositorios;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sv.fia.eisi.entidades.Curso;

/**
 *
 * @author Antonio
 */
@Repository
public class CursoDAO extends AbstractDAO<Curso> {

    @Autowired
    private SessionFactory sessionFactory;

    public CursoDAO() {
        super(Curso.class);
    }

    @Override
    public String create(Curso entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String edit(Curso entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete(Curso entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curso find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Curso> findActives() {
        return (List<Curso>) sessionFactory.getCurrentSession()
                .getNamedQuery("Curso.findActives").list();
    }
}
