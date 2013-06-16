/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.fia.eisi.entidades.EmpleadoDocente;
import sv.fia.eisi.repositorios.DocenteDAO;

/**
 *
 * @author Antonio
 */
@Service
public class DocenteService {

    @Autowired
    private DocenteDAO docenteDAO;

    @Transactional(readOnly = true)
    public List<EmpleadoDocente> obtenerDocentesActivos() {
        return docenteDAO.obtenerDisponibles();
    }
}
