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

/**
 * @author Mario Sanchez
 */
@Controller
public class ActividadController {

    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/nuevaActividad")
    public ModelAndView newActivity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Retuning nuevaActividad view");
        return new ModelAndView("nueva_actividad.zul");
    }

    @RequestMapping(value = "/actividades")
    public ModelAndView allActivities(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Retuning actividades view");
        return new ModelAndView("actividades.zul");
    }
}