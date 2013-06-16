/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.controladores;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Label;
import sv.fia.eisi.entidades.Ciclo;
import sv.fia.eisi.servicios.CerrarCicloService;

/**
 *
 * @author Antonio
 */
public class HomeController extends SelectorComposer<Component> {

    @WireVariable
    private CerrarCicloService cerrarCicloService;
    @Wire
    private Label anio;
    @Wire
    private Label ciclo;
    @Wire
    private Label fechain;
    @Wire
    private Label fechafin;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        Ciclo c = cerrarCicloService.obtenerCicloActual();
        if (c != null) {
            if (c.getFechaFinCiclo() != null) {
                fechafin.setValue(c.getFechaFinCiclo().toString());
            } else {
                fechafin.setValue("Sin Configurar");
            }
            if (c.getFechaInicioCiclo() != null) {
                fechain.setValue(c.getFechaInicioCiclo().toString());
            } else {
                fechain.setValue("Sin Configurar");
            }
            anio.setValue(String.valueOf(c.getCicloPK().getAnoCiclo()));
            ciclo.setValue(String.valueOf(c.getCicloPK().getNumeroCiclo()));
        }
    }
}
