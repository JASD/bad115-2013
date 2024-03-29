/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.controladores;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.ListModelList;
import sv.fia.eisi.entidades.Actividad;
import sv.fia.eisi.entidades.CoordinacionCursoPK;
import sv.fia.eisi.entidades.Curso;
import sv.fia.eisi.entidades.EmpleadoDocente;
import sv.fia.eisi.servicios.ActividadService;
import sv.fia.eisi.servicios.CursoService;
import sv.fia.eisi.servicios.DocenteService;

/**
 *
 * @author Antonio
 */
public class AsignacionCoordinacionCurso extends SelectorComposer<Component> {
    
    @Wire
    private Combobox cursos;
    @Wire
    private Combobox docentes;
    @Wire
    private Combobox actividades;
    @WireVariable
    private CursoService cursoService;
    @WireVariable
    private ActividadService actividadService;
    @WireVariable
    private DocenteService docenteService;
    
    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        docentes.setModel(new ListModelList<EmpleadoDocente>(docenteService.obtenerDocentesActivos()));
        actividades.setModel(new ListModelList<Actividad>(actividadService
                .obtenerActividadesCoordinativas()));
        cursos.setModel(new ListModelList<Curso>(cursoService.findActives()));
    }
    
    @Listen("onClick=#guardarAsig")
    public void asignarCarga() {
        CoordinacionCursoPK pk = new CoordinacionCursoPK();
        Curso c = (Curso) cursos.getSelectedItem().getValue();
        Actividad a = (Actividad) actividades.getSelectedItem().getValue();
        EmpleadoDocente ed = (EmpleadoDocente) docentes.getSelectedItem().getValue();
        pk.setCodigoCurso(c.getCodigoCurso());
        pk.setIsssEmpleado(ed.getIsssEmpleado());
        pk.setCodigoActividad(a.getCodigoActividad());
        String message = null;
        String type = null;
        try {
            message = cursoService.asignarCarga(pk);
            type = Clients.NOTIFICATION_TYPE_INFO;
        } catch (Exception ex) {
            message = ex.getMessage();
            type = Clients.NOTIFICATION_TYPE_ERROR;
        } finally {
            Clients.showNotification(message,
                    type, this.getSelf(), "top_center", 2000, true);
        }
    }
}
