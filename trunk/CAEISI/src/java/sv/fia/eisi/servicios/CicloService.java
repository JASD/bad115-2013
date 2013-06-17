/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.fia.eisi.entidades.AsignacionGrupo;
import sv.fia.eisi.entidades.Ciclo;
import sv.fia.eisi.entidades.reportes.CargaCicloAcad;
import sv.fia.eisi.entidades.reportes.CargaCicloAdmin;
import sv.fia.eisi.repositorios.CicloAcademicoDAO;

/**
 *
 * @author Ever
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
    public List<CargaCicloAcad> obtenerCargaAcadCiclo(){
    
        List<AsignacionGrupo> agList = cicloAcademicoDAO.obtenerCargaAcademicaCiclo();
        List<CargaCicloAcad> ccList = new ArrayList<CargaCicloAcad>();
        for(AsignacionGrupo ag: agList){
            CargaCicloAcad cc = new CargaCicloAcad();
            cc.setDocente(ag.getEmpleadoDocente().getEmpleado().getPrimerNombreEmpleado() 
                    + " " + ag.getEmpleadoDocente().getEmpleado().getPrimerApellidoEmpleado());
            cc.setCodigoCurso(ag.getGrupo().getGrupoAcademico().getCodigoCurso().getCodigoCurso());
            cc.setTipoGrupo(ag.getGrupo().getTipoGrupo());
            cc.setNumeroGrupo(String.valueOf(ag.getGrupo().getGrupoAcademico().getNumeroGrupoAcademico()));
            cc.setActividad(ag.getActividad().getNombreActividad());
            cc.setHoras(Float.valueOf(ag.getActividad().getNumeroHoras()));
            ccList.add(cc);
        }
        return ccList;
        
    }
    
    @Transactional(readOnly = true)
    public List<CargaCicloAdmin> obtenerCargaAdminCiclo(){
    
        List<AsignacionGrupo> agList = cicloAcademicoDAO.obtenerCargaAdminisCiclo();
        List<CargaCicloAdmin> ccList = new ArrayList<CargaCicloAdmin>();
        for(AsignacionGrupo ag: agList){
            CargaCicloAdmin cc = new CargaCicloAdmin();
            cc.setDocente(ag.getEmpleadoDocente().getEmpleado().getPrimerNombreEmpleado() 
                    + " " + ag.getEmpleadoDocente().getEmpleado().getPrimerApellidoEmpleado());
            cc.setTipoGrupo(ag.getGrupo().getTipoGrupo());
            cc.setNombreGrupo(ag.getGrupo().getGrupoAdministrativo().getNombreGrupoAdministrativo());
            cc.setActividad(ag.getActividad().getNombreActividad());
            cc.setHoras(Float.valueOf(ag.getActividad().getNumeroHoras()));
            ccList.add(cc);
        }
        return ccList;
        
    }

    @Transactional(readOnly = true)
    public String findUltimo() {
        return cicloAcademicoDAO.findUltimo().toString();
    }

    @Transactional(readOnly = true)
    public String findUltimoN() {
        return cicloAcademicoDAO.findUltimoN().toString();
    }

    @Transactional(readOnly = true)
    public String findUltimoFechaf() {
        return cicloAcademicoDAO.findUltimoFechaf().toString();
    }

    @Transactional(readOnly = true)
    public String findUltimoFechai() {
        return cicloAcademicoDAO.findUltimoFechai().toString();
    }
}
