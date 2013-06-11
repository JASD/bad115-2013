/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author antonio
 */
@Controller
public class FrontController {

    @RequestMapping(value = "/home")
    public ModelAndView home(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/administracion/modificar-ciclo")
    public ModelAndView modificarFechasCiclo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/administracion/modificar_ciclo");
    }

    @RequestMapping(value = "/administracion/cerrar-ciclo")
    public ModelAndView cerrarCiclo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/administracion/cerrar_ciclo");
    }

    @RequestMapping(value = "/carga-academica/asignar-grupo")
    public ModelAndView asignarGrupos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/carga_academica/asignar_grupos");
    }

    @RequestMapping(value = "/carga-academica/asignar-coordinacion")
    public ModelAndView asignarCoordinacion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/carga_academica/asignar_coordinacion");
    }

    @RequestMapping(value = "/carga-academica/asignar-horarios")
    public ModelAndView asignarHorarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/carga_academica/asignar_horarios");
    }

    @RequestMapping(value = "/mantenimiento/actividad")
    public ModelAndView verActividades(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/mantenimiento/actividades/actividad");
    }

    @RequestMapping(value = "/mantenimiento/actividad/nueva")
    public ModelAndView agregarActividad(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/mantenimiento/actividades/nueva_actividad");
    }

    @RequestMapping(value = "/docentes/actualizar")
    public ModelAndView actualizarDocente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/docentes/actualizar");
    }

    @RequestMapping(value = "/docentes/nuevo")
    public ModelAndView agregarDocente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/docentes/nuevo");
    }

    @RequestMapping(value = "/grupo-acad/nuevo")
    public ModelAndView crearGrupoAcademico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/grupos_academicos/crear");
    }

    @RequestMapping(value = "/grupo-acad/deshabilitar")
    public ModelAndView deshabilitarGrupoAcademico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/grupos_academicos/deshabilitar");
    }

    @RequestMapping(value = "/grupo-acad/habilitar")
    public ModelAndView habilitarGrupoAcademico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/grupos_academicos/habilitar");
    }
}
