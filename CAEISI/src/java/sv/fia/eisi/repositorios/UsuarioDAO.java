/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.repositorios;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sv.fia.eisi.entidades.Usuario;

/**
 *
 * @author antonio
 */
@Repository
public class UsuarioDAO extends AbstractDAO<Usuario> {

    @Autowired
    private SessionFactory sessionFactory;

    public UsuarioDAO() {
        super(Usuario.class);
    }

    @Override
    public void create(Usuario entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Usuario entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Usuario entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario find(Object id) {
        return (Usuario) sessionFactory.getCurrentSession().get(Usuario.class, (String) id);

    }
}
