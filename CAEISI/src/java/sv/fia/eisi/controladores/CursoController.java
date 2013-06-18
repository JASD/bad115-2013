/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.controladores;

import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Textbox;
import sv.fia.eisi.entidades.Actividad;
import sv.fia.eisi.entidades.Curso;
import sv.fia.eisi.entidades.Departamento;
import sv.fia.eisi.servicios.CursoService;

/**
 *
 * @author ues
 */
@Controller
public class CursoController extends SelectorComposer<Component> {

    @Wire
    private Textbox Codigo;
    @Wire
    private Combobox Departamento;
    @Wire
    private Textbox Nombre;
    @Wire
    private Combobox Estado;
    @WireVariable
    private CursoService cursoService;
    
    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        Departamento.setModel(new ListModelList<Departamento>(cursoService.getDepartamentos()));
    }
    
    @Listen("onClick=#GuardarCurso")
    public void GuardarCurso() {
      Curso curso = new Curso();
      Departamento depto = new Departamento();
      curso.setCodigoCurso(Codigo.getValue());
      depto.setCodigoDepartamento(Departamento.getSelectedItem().getValue().toString());
      curso.setCodigoDepartamento(depto);
      curso.setNombreCurso(Nombre.getValue());
      curso.setEstaActivoCurso(true);
      
      String message = null;
        String type = null;
        try {
            message = cursoService.guardarCurso(curso);
            type = Clients.NOTIFICATION_TYPE_INFO;
        } catch (Exception ex) {
            message = ex.getMessage();
            type = Clients.NOTIFICATION_TYPE_ERROR;
        } finally {
            Clients.showNotification(message, type, this.getSelf(), "top_center", 2000, true);
        }
    }  
}
