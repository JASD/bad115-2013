/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.controladores;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import sv.fia.eisi.servicios.CerrarCicloService;

/**
 *
 * @author Ever
 */
public class CerrarCicloController extends SelectorComposer<Component> {

    @WireVariable
    private CerrarCicloService cerrarCicloService;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

    }

    @Listen("onClick=#cerrarCicloAcad")
    public void cerrarCiclo() {
        String message = null;
        String type = null;
        try {
            message = cerrarCicloService.cerrarCicloAcademico();
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
