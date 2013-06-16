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
    }

    @Listen("onClick=#guardarEmpleado")
    public void guardarEmpleado() {
        // ESTAS SON LAS TABLAS CON LAS QUE REALCIONA DOCENTE
        Contrato c = new Contrato();
        Empleado e = new Empleado();
        EmpleadoDocente ed = new EmpleadoDocente();
        Usuario u = new Usuario();
        Departamento d = new Departamento();

        e.setIsssEmpleado(isss.getValue());
        e.setPrimerNombreEmpleado(primer.getValue());
        e.setSegundoNombreEmpleado(segundo.getValue());
        e.setPrimerApellidoEmpleado(primerapellido.getValue());
        e.setSegundoApellidoEmpleado(segundoapellido.getValue());
        e.setGradoAcademicoEmpleado(grado.getValue());
        // codigo de contrato es de la tabla contrato
        c.setCodigoContrato(tipo.getSelectedItem().getValue().toString());
        e.setCodigoContrato(c);
        e.setCorreoEmpleado(correo.getValue());

        // isss  de la tabla de empleado
        ed.setIsssEmpleado(e.getIsssEmpleado());
        // nombre de usuario es de la tbla usuario
        u.setNombreUsuario(usuar.getValue().toString());
        ed.setNombreUsuario(u);
        // codigo departamento es de la tabla deprtamento
        d.setCodigoDepartamento(depto.getSelectedItem().getValue().toString());
        ed.setCodigoDepartamento(d);
        ed.setCategoriaDocente(categoria.getSelectedItem().getValue().toString());
        ed.setCargoDocente((String) cargo.getValue());
        
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
