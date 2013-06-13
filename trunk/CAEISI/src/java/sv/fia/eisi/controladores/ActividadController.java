package sv.fia.eisi.controladores;

import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;
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

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        activityList = (Grid) comp;
        activityList.setModel(new ListModelList<Actividad>(actividadService.obtenerActividades()));
    }
}