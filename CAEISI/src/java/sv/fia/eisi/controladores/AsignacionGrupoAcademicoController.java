/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.controladores;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.ListModelList;
import sv.fia.eisi.entidades.Actividad;
import sv.fia.eisi.entidades.EmpleadoDocente;
import sv.fia.eisi.entidades.GrupoAcademico;
import sv.fia.eisi.servicios.ActividadService;
import sv.fia.eisi.servicios.DocenteService;
import sv.fia.eisi.servicios.GrupoAcademicoService;

/**
 *
 * @author Antonio
 */
public class AsignacionGrupoAcademicoController extends SelectorComposer<Component>{
    
    @Wire
    private Combobox grupos;
    @Wire
    private Combobox docentes;
    @Wire
    private Combobox actividades;
    @WireVariable
    private GrupoAcademicoService grupoAcademicoService;
    @WireVariable
    private ActividadService actividadService;
    @WireVariable
    private DocenteService docenteService;
    
    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        docentes.setModel(new ListModelList<EmpleadoDocente>
                (docenteService.obtenerDocentesActivos()));
        actividades.setModel(new ListModelList<Actividad>(actividadService
                .obtenerActividadesAcademicas()));
        grupos.setModel(new ListModelList<GrupoAcademico>(
                grupoAcademicoService.obtenerGruposDisponibles()));
    }
    
    
}
