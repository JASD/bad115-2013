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
import sv.fia.eisi.entidades.EmpleadoDocente;

/**
 *
 * @author Antonio
 */
@Repository
public class DocenteDAO extends AbstractDAO<EmpleadoDocente> {

    @Autowired
    private SessionFactory sessionFactory;

    public DocenteDAO() {
        super(EmpleadoDocente.class);
    }

    @Override
    public String create(EmpleadoDocente entity) {
        String call = ResourceBundle.getBundle("/procedures")
                .getString("InsertarDocente");
        Query q = sessionFactory.getCurrentSession()
                .createSQLQuery(call);
        q.setString("isss", entity.getEmpleado().getIsssEmpleado());
        q.setString("contrato", entity.getEmpleado().getCodigoContrato().getCodigoContrato());
        q.setString("primern", entity.getEmpleado().getPrimerNombreEmpleado());
        q.setString("segundon", entity.getEmpleado().getSegundoNombreEmpleado());
        q.setString("primera", entity.getEmpleado().getPrimerApellidoEmpleado());
        q.setString("segundoa", entity.getEmpleado().getSegundoApellidoEmpleado());
        q.setString("grado", entity.getEmpleado().getGradoAcademicoEmpleado());
        q.setString("correo", entity.getEmpleado().getCorreoEmpleado());
        q.setString("codigod", entity.getCodigoDepartamento().getCodigoDepartamento());
        q.setString("categoria", entity.getCategoriaDocente());
        q.setString("cargo", entity.getCargoDocente());
        return (String) q.uniqueResult();
    }

    @Override
    public String edit(EmpleadoDocente entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String delete(EmpleadoDocente entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EmpleadoDocente find(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<EmpleadoDocente> obtenerDisponibles(){
        return sessionFactory.getCurrentSession().getNamedQuery("EmpleadoDocente.findActives").list();
    }
}
