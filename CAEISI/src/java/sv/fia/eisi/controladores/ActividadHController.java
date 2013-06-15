/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.controladores;

import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Spinner;
import org.zkoss.zul.Textbox;
import sv.fia.eisi.entidades.Actividad;
import sv.fia.eisi.servicios.ActividadService;

/**
 *
 * @author admin
 */
@Controller
public class ActividadHController extends SelectorComposer<Component> {

    @Wire
    private Textbox codActivity;
    @Wire
    private Textbox nomActivity;
    @Wire
    private Spinner horasActivity;
    @Wire
    private Textbox tipoActivity;
    @WireVariable
    private ActividadService actividadService;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
    }

    @Listen("onClick=#guardarActividad")
    public void guardarActividad() {
        Actividad actividad = new Actividad();
        actividad.setCodigoActividad(codActivity.getValue());
        actividad.setNombreActividad(nomActivity.getValue());
        actividad.setNumeroHoras(horasActivity.getValue().shortValue());
        actividad.setTipoActividad(tipoActivity.getValue());
        String message = null;
        String type = null;
        try {
            message = actividadService.guardarActividad(actividad);
            type = Clients.NOTIFICATION_TYPE_INFO;
        } catch (Exception e) {
            message = e.getMessage();
            type = Clients.NOTIFICATION_TYPE_ERROR;
        } finally {
            Clients.showNotification(message, type, this.getSelf(), "top_center", 2000, true);
        }
    }
}
