
 package sv.fia.eisi.controladores;

import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;
import sv.fia.eisi.entidades.Empleado;
import sv.fia.eisi.servicios.ActualizarDocenteService;

/**
 * @author Adolfo
 */
@Controller
public class ActualizarDocenteController extends SelectorComposer<Component> {

    @Wire
    private Grid activityList;
    @WireVariable
    private ActualizarDocenteService actualizardocenteService;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        activityList = (Grid) comp;
        activityList.setModel(new ListModelList<Empleado>(actualizardocenteService.obtenerActualizarDocente()));
    }
}