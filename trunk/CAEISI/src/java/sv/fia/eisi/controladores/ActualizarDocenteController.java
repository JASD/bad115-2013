package sv.fia.eisi.controladores;

import org.springframework.stereotype.Controller;
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
import sv.fia.eisi.entidades.EmpleadoDocente;
import sv.fia.eisi.servicios.DocenteService;

/**
 * @author Adolfo
 */
@Controller
public class ActualizarDocenteController extends SelectorComposer<Component> {
    
    @Wire
    private Grid docentesList;
    @WireVariable
    private DocenteService docenteService;
    
    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        docentesList.setModel(new ListModelList<EmpleadoDocente>(
                docenteService.findAll()));
    }
    
    @Listen("onCheck = checkbox")
    public void cambiarEstadoGrupo(Event e) {
        Checkbox check = (Checkbox) e.getTarget();
        Row row = (Row) e.getTarget().getParent();
        int posicion = row.getIndex();
        EmpleadoDocente ed = (EmpleadoDocente) docentesList.getModel()
                .getElementAt(posicion);
        Boolean estado = (Boolean) check.isChecked();
        ed.setEstaActivoDocente(estado);
        String message = null;
        String type = null;
        try {
            message = docenteService.cambiarEstadoDocente(ed);
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