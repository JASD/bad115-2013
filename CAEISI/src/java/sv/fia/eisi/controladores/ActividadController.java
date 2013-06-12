package sv.fia.eisi.controladores;

import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;
import sv.fia.eisi.repositorios.ActividadDAO;

/**
 * @author Mario Sanchez
 */
@Controller
public class ActividadController extends SelectorComposer<Component> {

    @Wire
    private Grid activityList;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        activityList=(Grid) comp;
        activityList.setModel(new ListModelList<ActividadDAO>());
    }
}