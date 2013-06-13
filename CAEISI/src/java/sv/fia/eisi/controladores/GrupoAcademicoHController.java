/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.controladores;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Row;
import sv.fia.eisi.entidades.GrupoAcademico;
import sv.fia.eisi.servicios.GrupoAcademicoService;

/**
 *
 * @author Antonio
 */
public class GrupoAcademicoHController extends SelectorComposer<Component> {

    @Wire
    private Grid gruposDes;
    @WireVariable
    private GrupoAcademicoService grupoAcademicoService;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        gruposDes.setModel(
                new ListModelList<GrupoAcademico>(
                grupoAcademicoService.obtenerGruposDisponibles()));

    }

    @Listen("onCheck = checkbox")
    public void cambiarEstadoCurso(Event e) {
        Checkbox check = (Checkbox) e.getTarget();
        Row row = (Row) e.getTarget().getParent();
        int posicion = row.getIndex();
        GrupoAcademico ga = (GrupoAcademico) gruposDes.getModel()
                .getElementAt(posicion);
        Boolean estado = (Boolean) check.getValue();
        if (estado == null) {
            ga.getGrupo().setEstaCerradoGrupo(Boolean.valueOf(false));
        } else {
            ga.getGrupo().setEstaCerradoGrupo(estado);
        }
        String message = null;
        String type = null;
        try {
            message = grupoAcademicoService.actualizarGrupoAcademico(ga);
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
