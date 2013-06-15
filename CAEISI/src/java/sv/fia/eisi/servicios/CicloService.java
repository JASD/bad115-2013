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
import sv.fia.eisi.entidades.Ciclo;
import sv.fia.eisi.repositorios.CicloAcademicoDAO;

/**
 *
 * @author Antonio
 */
@Service
public class CicloService {

    @Autowired
    private CicloAcademicoDAO cicloAcademicoDAO;

    @Transactional
    public String guardarCicloAcademico(Ciclo ca) throws Exception {
        String status = cicloAcademicoDAO.create(ca);
        if (status.equals("OK")) {
            return ResourceBundle.getBundle("/messages")
                    .getString("CicloAcademicoGuardado");
        } else {
            throw new Exception(status);
        }
    }
    
    @Transactional
    public String actualizarCicloAcademico(Ciclo ca) throws Exception {
        String status = cicloAcademicoDAO.edit(ca);
        if (status.equals("OK")) {
            return ResourceBundle.getBundle("/messages")
                    .getString("CicloAcademicoActualizado");
        } else {
            throw new Exception(status);
        }
    }

     @Transactional(readOnly = true)
    public  String findUltimo() {
        return cicloAcademicoDAO.findUltimo().toString();
    }
     
    @Transactional(readOnly = true)
     public  String findUltimoN() {
        return cicloAcademicoDAO.findUltimoN().toString();
    } 
     
    
}
