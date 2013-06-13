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
import sv.fia.eisi.entidades.GrupoAdministrativo;
import sv.fia.eisi.repositorios.GrupoAdministrativoDAO;

/**
 *
 * @author Antonio
 */
@Service
public class GrupoAdministrativoService {

    @Autowired
    private GrupoAdministrativoDAO grupoAdministrativoDAO;

    @Transactional
    public String guardarGrupoAdministrativo(GrupoAdministrativo ga) throws Exception {
        String status = grupoAdministrativoDAO.create(ga);
        if (status.equals("OK")) {
            return ResourceBundle.getBundle("/messages")
                    .getString("GrupoAdministrativoGuardado");
        } else {
            throw new Exception(status);
        }
    }

    @Transactional
    public String actualizarGrupoAcademico(GrupoAdministrativo ga) throws Exception {
        String status = grupoAdministrativoDAO.edit(ga);
        if (status.equals("OK")) {
            return ResourceBundle.getBundle("/messages")
                    .getString("GrupoAdministrativoActualizado");
        } else {
            throw new Exception(status);
        }
    }

    @Transactional(readOnly = true)
    public List<GrupoAdministrativo> obtenerGruposDisponibles() {
        return grupoAdministrativoDAO.findForEnable();
    }
}
