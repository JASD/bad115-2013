package sv.fia.eisi.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.Composer;
import org.zkoss.zul.Grid;

/**
 * @author Mario Sanchez
 */
@Controller
public class ActividadController implements Composer<Component>{

    protected final Log logger = LogFactory.getLog(getClass());

    private Grid activityList;
    
    @RequestMapping(value = "/nuevaActividad")
    public ModelAndView newActivity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Retuning nuevaActividad view");
        return new ModelAndView("actividad/nueva_actividad");
    }

    @RequestMapping(value = "/actividades")
    public ModelAndView allActivities(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Retuning actividades view");
        
        return new ModelAndView("actividad/actividad");
    }

    @Override
    public void doAfterCompose(Component t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}