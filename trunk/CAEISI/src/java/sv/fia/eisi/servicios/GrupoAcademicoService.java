/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.servicios;

import java.util.ResourceBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.fia.eisi.entidades.GrupoAcademico;
import sv.fia.eisi.repositorios.GrupoAcademicoDAO;

/**
 *
 * @author Antonio
 */
@Service
public class GrupoAcademicoService {

    @Autowired
    private GrupoAcademicoDAO grupoAcademicoDAO;

    @Transactional
    public String guardarGrupoAcademico(GrupoAcademico ga) throws Exception {
        String status = grupoAcademicoDAO.create(ga);
        if (status.equals("OK")) {
            return ResourceBundle.getBundle("/messages")
                    .getString("GrupoAcademicoGuardado");
        } else {
            throw new Exception(status);
        }
    }
}