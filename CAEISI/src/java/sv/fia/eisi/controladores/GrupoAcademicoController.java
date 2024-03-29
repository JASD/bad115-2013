/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.controladores;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Spinner;
import org.zkoss.zul.Textbox;
import sv.fia.eisi.entidades.Curso;
import sv.fia.eisi.entidades.Grupo;
import sv.fia.eisi.entidades.GrupoAcademico;
import sv.fia.eisi.servicios.CursoService;
import sv.fia.eisi.servicios.GrupoAcademicoService;

/**
 *
 * @author Antonio
 */
public class GrupoAcademicoController extends SelectorComposer<Component> {

    @Wire
    private Combobox cursos;
    @Wire
    private Textbox codigo;
    @Wire
    private Textbox tema;
    @Wire
    private Spinner numero;
    @Wire
    private Combobox tipo;
    @WireVariable
    private CursoService cursoService;
    @WireVariable
    private GrupoAcademicoService grupoAcademicoService;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        cursos.setModel(new ListModelList<Curso>(cursoService.findActives()));
    }

    @Listen("onClick=#guardarGrupoAcad")
    public void guardarGrupoAcademico() {
        Grupo nuevo = new Grupo();
        nuevo.setTipoGrupo((String) tipo.getSelectedItem().getValue());
        GrupoAcademico ga = new GrupoAcademico();
        ga.setGrupo(nuevo);
        ga.setCodigoGrupo(codigo.getValue());
        ga.setCodigoCurso((Curso) cursos.getSelectedItem().getValue());
        ga.setNumeroGrupoAcademico(numero.getValue().shortValue());
        String t = tema.getValue();
        if (t.equals("")) {
            ga.setTemaGrupoAcademico(null);
        } else {
            ga.setTemaGrupoAcademico(tema.getValue().toUpperCase());
        }
        String message = null;
        String type = null;
        try {
            message = grupoAcademicoService.guardarGrupoAcademico(ga);
            type = Clients.NOTIFICATION_TYPE_INFO;
        } catch (Exception ex) {
            message = ex.getMessage();
            type = Clients.NOTIFICATION_TYPE_ERROR;
        } finally {
            Clients.showNotification(message,
                    type, this.getSelf(), "top_center", 2000, true);
        }
    }
}
