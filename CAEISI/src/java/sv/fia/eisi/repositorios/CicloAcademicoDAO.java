/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.repositorios;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sv.fia.eisi.entidades.AsignacionGrupo;
import sv.fia.eisi.entidades.Ciclo;
import sv.fia.eisi.entidades.EmpleadoDocente;
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

    public List<Ciclo> findForEnable() {

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

    public List<Ciclo> findUltimoFechaf() {
        return (List<Ciclo>) sessionFactory.getCurrentSession()
                .getNamedQuery("CicloFechaf.ultimo").list();
    }

    public List<Ciclo> findUltimoFechai() {
        return (List<Ciclo>) sessionFactory.getCurrentSession()
                .getNamedQuery("CicloFechai.ultimo").list();
    }
    
    public List<AsignacionGrupo> obtenerCargaAcademicaCiclo(Ciclo c) {
        Query q = sessionFactory.getCurrentSession().
                getNamedQuery("AsignacionGrupo.findByCicloAcademico");
        q.setParameter("ciclo", c);
        return q.list();
    }
    
    public List<AsignacionGrupo> obtenerCargaAdminisCiclo(Ciclo c) {
        Query q = sessionFactory.getCurrentSession().
                getNamedQuery("AsignacionGrupo.findByCicloAdminis");
        q.setParameter("ciclo", c);
        return q.list();

    }
    
    public Ciclo obtenerCicloActual(){
        return (Ciclo) sessionFactory.getCurrentSession()
                .getNamedQuery("Ciclo.actual").uniqueResult();
    }
    
    public List<AsignacionGrupo>obtenerCargaAcadDocente(EmpleadoDocente e, Ciclo c){
        Query q = sessionFactory.getCurrentSession().
                getNamedQuery("AsignacionGrupo.findByCicloDocenteAcad");
        q.setParameter("ciclo", c);
        q.setParameter("docente", e);
        return q.list();
    }
    
    public List<AsignacionGrupo>obtenerCargaAdminDocente(EmpleadoDocente e, Ciclo c){
        Query q = sessionFactory.getCurrentSession().
                getNamedQuery("AsignacionGrupo.findByCicloDocenteAdmin");
        q.setParameter("ciclo", c);
        q.setParameter("docente", e);
        return q.list();
    }
}
