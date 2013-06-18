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
    public ModelAndView asignarGruposAcademicos(HttpServletRequest request, HttpServletResponse response)
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

    @RequestMapping(value = "/docente/actualizar")
    public ModelAndView actualizarDocente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/docentes/actualizar");
    }

    @RequestMapping(value = "/docente/nuevos")
    public ModelAndView agregarDocente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/docentes/nuevo");
    }

    @RequestMapping(value = "/grp-acad/crear")
    public ModelAndView crearGrupoAcad(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/grupos_academicos/crear");
    }

    @RequestMapping(value = "/grp-acad/habilitar")
    public ModelAndView habilitarGrupoAcad(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/grupos_academicos/habilitar");
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

    @RequestMapping(value = "/mantenimiento/conocimiento")
    public ModelAndView verConocimientos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/mantenimiento/conocimientos/conocimientos");
    }

    @RequestMapping(value = "/mantenimiento/conocimiento/nuevo")
    public ModelAndView agregarConocimientos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/mantenimiento/conocimientos/nuevo");
    }

    @RequestMapping(value = "/cursos/curso")
    public ModelAndView verCursos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/curso/cursos");
    }

    @RequestMapping(value = "/cursos/nueva")
    public ModelAndView agregarCurso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/curso/nuevo");
    }

    @RequestMapping(value = "/mantenimiento/grp-admin/nuevo")
    public ModelAndView crearGrupoAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/mantenimiento/grupos_administrativos/crear");
    }

    @RequestMapping(value = "/mantenimiento/grp-admin/habilitar")
    public ModelAndView habilitarGrupoAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/mantenimiento/grupos_administrativos/habilitar");
    }
    
    @RequestMapping(value = "/mantenimiento/horarios")
    public ModelAndView verHorarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/mantenimiento/horarios/horarios");
    }

    @RequestMapping(value = "/mantenimiento/locales")
    public ModelAndView verLocales(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/mantenimiento/locales/locales");
    }

    @RequestMapping(value = "/reportes/carga-ciclo")
    public ModelAndView verCargaCiclo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/reportes/carga_por_ciclo");
    }
    
    @RequestMapping(value = "/reportes/coord-ciclo")
    public ModelAndView verCoordCiclo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/reportes/coord_ciclo");
    }

    @RequestMapping(value = "/reportes/carga-docente")
    public ModelAndView verCargaDocente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/reportes/carga_por_docente");
    }

    @RequestMapping(value = "/seguridad/bitacora")
    public ModelAndView verBitacoraEventos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/seguridad/bitacora_eventos/bitacora");
    }

    @RequestMapping(value = "/seguridad/usuarios")
    public ModelAndView verUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/seguridad/usuarios/usuarios");
    }

    @RequestMapping(value = "/seguridad/usuarios/nuevo")
    public ModelAndView crearUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return new ModelAndView("/seguridad/usuarios/nuevo");
    }
    
}
