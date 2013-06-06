/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sv.fia.eisi.servicios.UsuarioService;

/**
 *
 * @author antonio
 */
@Controller
public class SessionController {

    @Autowired
    private UsuarioService usuarioService;
    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value = "/home")
    public ModelAndView home(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Usuario admin = usuarioService.encontrar();



        logger.info("Returning home view");

        return new ModelAndView("home");
    }
}
