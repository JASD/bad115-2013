/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.*/
 
package sv.fia.eisi.controladores;

import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Textbox;
import sv.fia.eisi.entidades.Empleado;
import sv.fia.eisi.entidades.EmpleadoDocente;
import sv.fia.eisi.entidades.Contrato;
import sv.fia.eisi.entidades.Departamento;
import sv.fia.eisi.entidades.Usuario;
import sv.fia.eisi.servicios.ContratoService;
import sv.fia.eisi.servicios.DepartamentoService;
import sv.fia.eisi.servicios.EmpleadoDocenteService;
import sv.fia.eisi.servicios.EmpleadoService;


 /*
 * @author Adolfo*/
 
@Controller
public class EmpleadoController extends SelectorComposer<Component> {

    @Wire
    private Textbox isss;
    @Wire
    private Textbox primer;
    @Wire
    private Textbox segundo;
    @Wire
    private Textbox primerapellido;
    @Wire
    private Textbox segundoapellido;
    @Wire
    private Textbox grado;
    @Wire
    private Combobox categoria;
    @Wire
    private Combobox tipo;
    @Wire
    private Textbox correo;
    @Wire
    private Combobox depto;
    @Wire
    private Textbox cargo;
    @Wire
    private Textbox usuar;
    @Wire
    private Textbox contra;
    
    @WireVariable
    private ContratoService contratoService;
    
    @WireVariable
    private DepartamentoService departamentoService;

    @WireVariable
    private EmpleadoDocenteService empleadodocenteService;

    @WireVariable
    private EmpleadoService empleadoService;

 @Override
public void doAfterCompose(Component comp) throws Exception {
super.doAfterCompose(comp);

tipo.setModel(new ListModelList<Contrato>(contratoService.findActives()));
depto.setModel(new ListModelList<Departamento>(departamentoService.findActives()));
categoria.setModel(new ListModelList<EmpleadoDocente>(empleadodocenteService.findActives()));
}

    
    @Listen("onClick=#guardarEmpleado")
    public void guardarEmpleado() {
        
        Empleado e = new Empleado();
        
        
        e.setIsssEmpleado(isss.getValue());
        e.setPrimerNombreEmpleado(primer.getValue());
        e.setSegundoNombreEmpleado(segundo.getValue());
        e.setPrimerApellidoEmpleado(primerapellido.getValue());
        e.setSegundoApellidoEmpleado(segundoapellido.getValue());
        e.setGradoAcademicoEmpleado(grado.getValue());
        e.setCodigoContrato((Contrato) tipo.getSelectedItem().getValue());
        e.setCorreoEmpleado(correo.getValue());
        
        
        EmpleadoDocente ed = new EmpleadoDocente();
        ed.setCategoriaDocente((String) categoria.getSelectedItem().getValue());
        ed.setCodigoDepartamento((Departamento) depto.getSelectedItem().getValue());
        ed.setNombreUsuario((String) usuar.getValue());
        ed.setCargoDocente((String) cargo.getValue());

        Usuario u = new Usuario();
        u.setContrasenaUsuario((String) contra.getValue());
       
        String message = null;
        String type = null;
        try {
            message = empleadoService.guardarEmpleado(e);
            type = Clients.NOTIFICATION_TYPE_INFO;
        } catch (Exception ex) {
            message = ex.getMessage();
            type = Clients.NOTIFICATION_TYPE_ERROR;
        } finally {
            Clients.showNotification(message, type, this.getSelf(), "top_center", 2000, true);
        }
         

     
         
    }
}
