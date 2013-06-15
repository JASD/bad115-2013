/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.servicios;

import java.util.List;
import java.util.ResourceBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.fia.eisi.entidades.Actividad;
import sv.fia.eisi.repositorios.ActividadDAO;

/**
 *
 * @author Mario Sanchez
 */
@Service
public class ActividadService {

    @Autowired
    private ActividadDAO actividadDAO;

    @Transactional(readOnly = true)
    public List<Actividad> obtenerActividades() {
        return actividadDAO.getActivities();
    }

    @Transactional
    public String guardarActividad(Actividad actividad) throws Exception {
        String status = actividadDAO.create(actividad);
        if (status.equals("OK")) {
            return ResourceBundle.getBundle("/messages").getString("ActividadGuardada");
        } else {
            throw new Exception(status);
        }
    }
}
