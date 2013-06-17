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
import sv.fia.eisi.entidades.CoordinacionCurso;
import sv.fia.eisi.entidades.EmpleadoDocente;
import sv.fia.eisi.entidades.reportes.CargaCicloAcad;
import sv.fia.eisi.entidades.reportes.CargaCicloAdmin;
import sv.fia.eisi.entidades.reportes.CargaDocente;
import sv.fia.eisi.entidades.reportes.CoordinacionesCiclo;
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
    public List<CargaCicloAcad> obtenerCargaAcadCiclo(Ciclo c) {

        List<AsignacionGrupo> agList = cicloAcademicoDAO.obtenerCargaAcademicaCiclo(c);
        List<CargaCicloAcad> ccList = new ArrayList<CargaCicloAcad>();
        for (AsignacionGrupo ag : agList) {
            CargaCicloAcad cc = new CargaCicloAcad();
            cc.setDocente(ag.getEmpleadoDocente().getEmpleado().getPrimerNombreEmpleado()
                    + " " + ag.getEmpleadoDocente().getEmpleado().getPrimerApellidoEmpleado());
            cc.setCodigoCurso(ag.getGrupo().getGrupoAcademico().getCodigoCurso().getCodigoCurso());
            cc.setTipoGrupo(ag.getGrupo().getTipoGrupo());
            cc.setNumeroGrupo(String.valueOf(ag.getGrupo().getGrupoAcademico().getNumeroGrupoAcademico()));
            cc.setActividad(ag.getActividad().getNombreActividad());
            cc.setHoras(Float.valueOf(ag.getActividad().getNumeroHoras()));
            cc.setCodigoGrupo(ag.getGrupo().getCodigoGrupo());
            cc.setCodigoActividad(ag.getActividad().getCodigoActividad());
            cc.setIsssEmpleado(ag.getEmpleadoDocente().getIsssEmpleado());
            ccList.add(cc);
        }
        return ccList;

    }

    @Transactional(readOnly = true)
    public List<CargaCicloAdmin> obtenerCargaAdminCiclo(Ciclo c) {

        List<AsignacionGrupo> agList = cicloAcademicoDAO.obtenerCargaAdminisCiclo(c);
        List<CargaCicloAdmin> ccList = new ArrayList<CargaCicloAdmin>();
        for (AsignacionGrupo ag : agList) {
            CargaCicloAdmin cc = new CargaCicloAdmin();
            cc.setDocente(ag.getEmpleadoDocente().getEmpleado().getPrimerNombreEmpleado()
                    + " " + ag.getEmpleadoDocente().getEmpleado().getPrimerApellidoEmpleado());
            cc.setTipoGrupo(ag.getGrupo().getTipoGrupo());
            cc.setNombreGrupo(ag.getGrupo().getGrupoAdministrativo().getNombreGrupoAdministrativo());
            cc.setActividad(ag.getActividad().getNombreActividad());
            cc.setHoras(Float.valueOf(ag.getActividad().getNumeroHoras()));
            cc.setCodigoGrupo(ag.getGrupo().getCodigoGrupo());
            cc.setCodigoActividad(ag.getActividad().getCodigoActividad());
            cc.setIsssEmpleado(ag.getEmpleadoDocente().getIsssEmpleado());
            ccList.add(cc);
        }
        return ccList;

    }

    @Transactional(readOnly = true)
    public List<CargaDocente> obtenerCargaDocente(EmpleadoDocente e, Ciclo c) {

        List<AsignacionGrupo> agAcadList = cicloAcademicoDAO.obtenerCargaAcadDocente(e, c);
        List<AsignacionGrupo> agAdminList = cicloAcademicoDAO.obtenerCargaAdminDocente(e, c);
        List<CargaDocente> cdList = new ArrayList<CargaDocente>();

        for (AsignacionGrupo ag : agAcadList) {
            CargaDocente cd = new CargaDocente();
            cd.setCodigoGrupo(ag.getGrupo().getCodigoGrupo());
            cd.setGrupo(ag.getGrupo().getGrupoAcademico().getCodigoCurso().getCodigoCurso());
            cd.setTipoGrupo(ag.getGrupo().getTipoGrupo());
            cd.setActividad(ag.getActividad().getNombreActividad());
            cd.setHoras(Float.valueOf(ag.getActividad().getNumeroHoras()));
            cdList.add(cd);
        }

        for (AsignacionGrupo ag : agAdminList) {
            CargaDocente cd = new CargaDocente();
            cd.setCodigoGrupo(ag.getGrupo().getCodigoGrupo());
            cd.setGrupo(ag.getGrupo().getGrupoAdministrativo().getNombreGrupoAdministrativo());
            cd.setTipoGrupo(ag.getGrupo().getTipoGrupo());
            cd.setActividad(ag.getActividad().getNombreActividad());
            cd.setHoras(Float.valueOf(ag.getActividad().getNumeroHoras()));
            cdList.add(cd);
        }
        return cdList;
    }

    @Transactional
    public String eliminarCargaAcad(CargaCicloAcad cca) throws Exception {

        String status = cicloAcademicoDAO.eliminarAsignacionAcadCiclo(cca);
        if (status.equals("OK")) {
            return ResourceBundle.getBundle("/messages")
                    .getString("AsignacionEliminada");
        } else {
            throw new Exception(status);
        }
    }

    @Transactional
    public String eliminarCargaAdmin(CargaCicloAdmin cca) throws Exception {

        String status = cicloAcademicoDAO.eliminarAsignacionAdminCiclo(cca);
        if (status.equals("OK")) {
            return ResourceBundle.getBundle("/messages")
                    .getString("AsignacionEliminada");
        } else {
            throw new Exception(status);
        }
    }

    @Transactional(readOnly = true)
    public List<CoordinacionesCiclo> obtenerCoordinacionesCiclo(Ciclo c) {
        List<CoordinacionCurso> cCurso = cicloAcademicoDAO
                .obtenerCoordinacionesCiclo(c);
        List<CoordinacionesCiclo> ccList = new ArrayList<CoordinacionesCiclo>();
        for (CoordinacionCurso cc : cCurso) {
            CoordinacionesCiclo coorCiclo = new CoordinacionesCiclo();
            coorCiclo.setCodigo(cc.getCurso().getCodigoCurso());
            coorCiclo.setCurso(cc.getCurso().getNombreCurso());
            coorCiclo.setDocente(cc.getEmpleadoDocente().getEmpleado()
                    .getPrimerNombreEmpleado() + " " + cc.getEmpleadoDocente()
                    .getEmpleado().getPrimerApellidoEmpleado());
            coorCiclo.setActividad(cc.getActividad().getNombreActividad());
            ccList.add(coorCiclo);
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

    @Transactional(readOnly = true)
    public Ciclo obtenerCicloActual() {
        return cicloAcademicoDAO.obtenerCicloActual();
    }
}
