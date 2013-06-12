package sv.fia.eisi.controladores;

import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Grid;

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
//        activityList.setModel(new ListModelList<Actividad>(ActividadDAO.find()));
    }
}