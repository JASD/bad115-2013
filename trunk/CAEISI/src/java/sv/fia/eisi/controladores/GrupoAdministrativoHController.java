/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.controladores;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Row;
import org.zkoss.zul.Textbox;
import sv.fia.eisi.entidades.GrupoAdministrativo;
import sv.fia.eisi.servicios.GrupoAdministrativoService;

/**
 *
 * @author Antonio
 */
public class GrupoAdministrativoHController extends SelectorComposer<Component> {

    @Wire
    private Grid gruposDes;
    @WireVariable
    private GrupoAdministrativoService grupoAdministrativoService;
    private final int TEXTBOX_NOMBRE = 2;
    private final int TEXTBOX_OBJETIVO = 3;
    private final int BUTTON_GUARDAR = 5;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        gruposDes.setModel(
                new ListModelList<GrupoAdministrativo>(
                grupoAdministrativoService.obtenerGruposDisponibles()));

    }

    @Listen("onChanging = textbox")
    public void habilitarGuardar(InputEvent e) {
        //Obtenemos la fila
        Row row = (Row) e.getTarget().getParent();
        Button b = (Button) row.getChildren().get(BUTTON_GUARDAR);
        //Habilitamos el boton
        b.setDisabled(false);
        //Mostrar advertencia de guardado
        Clients.showNotification("Guardar Cambios",
                Clients.NOTIFICATION_TYPE_WARNING, b, "top_center", 2000, true);
    }

    @Listen("onCheck = checkbox")
    public void cambiarEstadoGrupo(Event e) {
        Checkbox check = (Checkbox) e.getTarget();
        Row row = (Row) e.getTarget().getParent();
        int posicion = row.getIndex();
        GrupoAdministrativo ga = (GrupoAdministrativo) gruposDes.getModel()
                .getElementAt(posicion);
        Boolean estado = (Boolean) check.isChecked();
        ga.getGrupo().setEstaCerradoGrupo(estado);
        String message = null;
        String type = null;
        try {
            message = grupoAdministrativoService
                    .actualizarEstadoGrupoAdministrativo(ga);
            type = Clients.NOTIFICATION_TYPE_INFO;
        } catch (Exception ex) {
            message = ex.getMessage();
            type = Clients.NOTIFICATION_TYPE_ERROR;
        } finally {
            Clients.showNotification(message,
                    type, this.getSelf(), "top_center", 2000, true);
        }
    }

    @Listen("onClick = button")
    public void guardarCambios(Event e) {

        //Obtenemos la fila afectada
        Row row = (Row) e.getTarget().getParent();
        int posicion = row.getIndex();
        //Obtenemos el grupo
        GrupoAdministrativo ga = (GrupoAdministrativo) gruposDes.getModel()
                .getElementAt(posicion);
        //Deshabilitar boton de nuevo
        Button b = (Button) row.getChildren().get(BUTTON_GUARDAR);
        b.setDisabled(true);

        //Obtenemos los valores que vamos a oucupar para actualizar
        Textbox nombre = (Textbox) row.getChildren().get(TEXTBOX_NOMBRE);
        Textbox objetivo = (Textbox) row.getChildren().get(TEXTBOX_OBJETIVO);
        //Los ingresamos al grupo
        ga.setNombreGrupoAdministrativo(nombre.getValue());
        String t = objetivo.getValue();
        if (t.equals("")) {
            ga.setObjetivoGrupoAdministrativo(null);
        } else {
            ga.setObjetivoGrupoAdministrativo(t.toUpperCase());
        }

        String message = null;
        String type = null;
        try {
            message = grupoAdministrativoService.actualizarGrupoAdministrativo(ga);
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
