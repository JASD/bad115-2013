/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.repositorios;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sv.fia.eisi.entidades.Departamento;

/**
 *
 * @author Antonio
 */
@Repository
public class DepartamentoDAO extends AbstractDAO<Departamento> {

    @Autowired
    private SessionFactory sessionFactory;

    public DepartamentoDAO() {
        super(Departamento.class);
    }

    @Override
    public String create(Departamento entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String edit(Departamento entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete(Departamento entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Departamento find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Departamento> findAll() {
        return sessionFactory.getCurrentSession().getNamedQuery("Departamento.findAll").list();
    }
}
