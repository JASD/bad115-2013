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
import sv.fia.eisi.entidades.AsignacionGrupoPK;
import sv.fia.eisi.entidades.EmpleadoDocente;
import sv.fia.eisi.entidades.GrupoAdministrativo;
import sv.fia.eisi.servicios.ActividadService;
import sv.fia.eisi.servicios.DocenteService;
import sv.fia.eisi.servicios.GrupoAdministrativoService;

/**
 *
 * @author Antonio
 */
public class AsignacionGrupoAdminController extends SelectorComposer<Component> {

    @Wire
    private Combobox gruposAdmin;
    @Wire
    private Combobox docentesAdmin;
    @Wire
    private Combobox actividadesAdmin;
    @WireVariable
    private GrupoAdministrativoService grupoAdministrativoService;
    @WireVariable
    private ActividadService actividadService;
    @WireVariable
    private DocenteService docenteService;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        docentesAdmin.setModel(new ListModelList<EmpleadoDocente>(docenteService.obtenerDocentesActivos()));
        actividadesAdmin.setModel(new ListModelList<Actividad>(actividadService
                .obtenerActividadesAdministrativas()));
        gruposAdmin.setModel(new ListModelList<GrupoAdministrativo>(
                grupoAdministrativoService.obtenerGruposActivos()));
    }
    
    @Listen("onClick=#guardarAsigAdmin")
    public void asignarCarga() {
        AsignacionGrupoPK pk = new AsignacionGrupoPK();
        GrupoAdministrativo ga = (GrupoAdministrativo) gruposAdmin.getSelectedItem().getValue();
        Actividad a = (Actividad) actividadesAdmin.getSelectedItem().getValue();
        EmpleadoDocente ed = (EmpleadoDocente) docentesAdmin.getSelectedItem().getValue();
        pk.setCodigoGrupo(ga.getCodigoGrupo());
        pk.setIsssEmpleado(ed.getIsssEmpleado());
        pk.setCodigoActividad(a.getCodigoActividad());
        String message = null;
        String type = null;
        try {
            message = grupoAdministrativoService.asignarCarga(pk);
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
