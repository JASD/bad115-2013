/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.repositorios;

import java.math.BigInteger;
import java.util.List;
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
public class CicloAcademicoDAO extends AbstractDAO<Ciclo> {

    @Autowired
    private SessionFactory sessionFactory;

    public CicloAcademicoDAO() {
        super(Ciclo.class);
    }

    @Override
    public String create(Ciclo entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String edit(Ciclo entity) {
        String call = ResourceBundle.getBundle("/procedures")
                .getString("ModificarCicloAcademico");
        Query q = sessionFactory.getCurrentSession()
                .createSQLQuery(call);
        q.setLong("anyo", entity.getCicloPK().getAnoCiclo());
        q.setShort("numero", entity.getCicloPK().getNumeroCiclo());
        q.setDate("fechaini", entity.getFechaInicioCiclo());
        q.setDate("fechafin", entity.getFechaFinCiclo());
        
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
    
    public List<Ciclo> findForEnable(){
        
        return (List<Ciclo>) sessionFactory.getCurrentSession()
                .getNamedQuery("Ciclo.findall").list();
    
    }
    
    public List<Ciclo> findUltimo() {
        return (List<Ciclo>) sessionFactory.getCurrentSession()
                .getNamedQuery("Ciclo.ultimo").list();
    }
    
    public List<Ciclo> findUltimoN() {
        return (List<Ciclo>) sessionFactory.getCurrentSession()
                .getNamedQuery("CicloNumero.ultimo").list();
    }
}