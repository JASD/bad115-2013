/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.servicios;

import java.util.ResourceBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.fia.eisi.entidades.Ciclo;
import sv.fia.eisi.repositorios.CerrarCicloDAO;

/**
 *
 * @author Ever
 */
@Service
public class CerrarCicloService {

    @Autowired
    private CerrarCicloDAO cerrarCicloDAO;

    @Transactional
    public String cerrarCicloAcademico() throws Exception {
        String status = cerrarCicloDAO.cerrar();
        if (status.equals("OK")) {
            return ResourceBundle.getBundle("/messages")
                    .getString("CicloAcademicoCerrado");
        } else {
            throw new Exception(status);
        }
    }
    
    @Transactional(readOnly = true)
    public Ciclo obtenerCicloActual(){
    
        return cerrarCicloDAO.obtenerActual();
    }
}
