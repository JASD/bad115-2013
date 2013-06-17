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
import sv.fia.eisi.entidades.Contrato;
import sv.fia.eisi.entidades.Departamento;
import sv.fia.eisi.entidades.EmpleadoDocente;
import sv.fia.eisi.repositorios.ContratoDAO;
import sv.fia.eisi.repositorios.DepartamentoDAO;
import sv.fia.eisi.repositorios.DocenteDAO;

/**
 *
 * @author Antonio
 */
@Service
public class DocenteService {

    @Autowired
    private DocenteDAO docenteDAO;
    @Autowired
    private ContratoDAO contratoDAO;
    @Autowired
    private DepartamentoDAO departamentoDAO;

    @Transactional(readOnly = true)
    public List<EmpleadoDocente> obtenerDocentesActivos() {
        return docenteDAO.obtenerDisponibles();
    }
    
    @Transactional(readOnly = true)
    public List<Departamento> getDepartamentos(){
        return departamentoDAO.findAll();
    }
    
    @Transactional(readOnly = true)
    public List<Contrato> getTiposContratos(){
        return contratoDAO.findAll();
    }
    
    @Transactional
    public String guardarDocente(EmpleadoDocente e) throws Exception {
        String status = docenteDAO.create(e);
        if (status.equals("OK")) {
            return ResourceBundle.getBundle("/messages")
                    .getString("GrupoAdministrativoGuardado");
        } else {
            throw new Exception(status);
        }
    }
    
    
}
