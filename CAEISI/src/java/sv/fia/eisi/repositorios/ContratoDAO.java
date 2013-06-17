/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.repositorios;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sv.fia.eisi.entidades.Contrato;

/**
 *
 * @author Antonio
 */
@Repository
public class ContratoDAO extends AbstractDAO<Contrato> {

    @Autowired
    private SessionFactory sessionFactory;

    public ContratoDAO() {
        super(Contrato.class);
    }

    @Override
    public String create(Contrato entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String edit(Contrato entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete(Contrato entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Contrato find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Contrato> findAll(){
        return sessionFactory.getCurrentSession().getNamedQuery("Contrato.findAll").list();
    }
}
