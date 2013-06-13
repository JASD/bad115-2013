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
import org.zkoss.zul.Textbox;
import sv.fia.eisi.entidades.Grupo;
import sv.fia.eisi.entidades.GrupoAdministrativo;
import sv.fia.eisi.servicios.GrupoAdministrativoService;

/**
 *
 * @author Antonio
 */
public class GrupoAdministrativoController extends SelectorComposer<Component> {
    
    @Wire
    private Textbox codigo;
    @Wire
    private Textbox objetivo;
    @Wire
    private Combobox tipo;
    @Wire
    private Textbox nombre;
    @WireVariable
    private GrupoAdministrativoService grupoAdministrativoService;
    
    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
    }
    
    @Listen("onClick=#guardarGrupoAdmin")
    public void guardarGrupoAcademico() {
        Grupo nuevo = new Grupo();
        nuevo.setTipoGrupo((String) tipo.getSelectedItem().getValue());
        GrupoAdministrativo ga = new GrupoAdministrativo();
        ga.setGrupo(nuevo);
        ga.setNombreGrupoAdministrativo(nombre.getValue());
        ga.setCodigoGrupo(codigo.getValue());
        String obj = objetivo.getValue();
        if (obj.equals("")) {
            ga.setObjetivoGrupoAdministrativo(null);
        } else {
            ga.setObjetivoGrupoAdministrativo(obj.toUpperCase());
        }
        String message = null;
        String type = null;
        try {
            message = grupoAdministrativoService.guardarGrupoAdministrativo(ga);
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
