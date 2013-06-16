package sv.fia.eisi.controladores;

import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Row;
import org.zkoss.zul.Spinner;
import org.zkoss.zul.Textbox;
import sv.fia.eisi.entidades.Actividad;
import sv.fia.eisi.servicios.ActividadService;

/**
 * @author Mario Sanchez
 */
@Controller
public class ActividadController extends SelectorComposer<Component> {

    @Wire
    private Grid activityList;
    @WireVariable
    private ActividadService actividadService;
    private final int TEXTBOX_NOMBRE = 1;
    private final int SPINNER_HORAS = 2;
    private final int BUTTON_GUARDAR = 4;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        activityList = (Grid) comp;
        activityList.setModel(new ListModelList<Actividad>(actividadService.obtenerActividades()));
    }

    @Listen("onChanging = spinner")
    public void enabledGuardar(InputEvent ie) {
        Row row = (Row) ie.getTarget().getParent();
        Button b = (Button) row.getChildren().get(BUTTON_GUARDAR);
        b.setDisabled(false);
        Clients.showNotification("Guardar Cambios", Clients.NOTIFICATION_TYPE_WARNING, b, "top_center", 2000, true);
    }
    
    @Listen("onChanging = textbox")
    public void habilitarGuardar(InputEvent ie) {
        Row row = (Row) ie.getTarget().getParent();
        Button b = (Button) row.getChildren().get(BUTTON_GUARDAR);
        b.setDisabled(false);
        Clients.showNotification("Guardar Cambios", Clients.NOTIFICATION_TYPE_WARNING, b, "top_center", 2000, true);
    }

    @Listen("onClick = #actualizarActivity")
    public void guardarCambios(Event e) {
        Row row = (Row) e.getTarget().getParent();
        int position = row.getIndex();
        Actividad a = (Actividad) activityList.getModel().getElementAt(position);
        Button b = (Button) row.getChildren().get(BUTTON_GUARDAR);
        b.setDisabled(true);
        Textbox nombre = (Textbox) row.getChildren().get(TEXTBOX_NOMBRE);
        Spinner horas = (Spinner) row.getChildren().get(SPINNER_HORAS);
        a.setNombreActividad(nombre.getValue());
        a.setNumeroHoras(horas.getValue().shortValue());
        String message = null;
        String type = null;
        try {
            message = actividadService.actualizarActividad(a);
            type = Clients.NOTIFICATION_TYPE_INFO;
        } catch (Exception ex) {
            message = ex.getMessage();
            type = Clients.NOTIFICATION_TYPE_ERROR;
        } finally {
            Clients.showNotification(message, type, this.getSelf(), "top_center", 2000, true);
        }
    }
}