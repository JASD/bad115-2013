/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.controladores;

import java.util.Date;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Textbox;
import sv.fia.eisi.entidades.Ciclo;
import sv.fia.eisi.entidades.CicloPK;
import sv.fia.eisi.servicios.CicloService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ever
 */
public class CicloController extends SelectorComposer<Component> {

    @Wire
    private Textbox anyo;
    @Wire
    private Textbox numero;
    @Wire
    private Datebox fechaini;
    @Wire
    private Datebox fechafin;
    @WireVariable
    private CicloService cicloService;

    @Override
    public void doAfterCompose(Component comp) {
        try {
            super.doAfterCompose(comp);
            String fechaUltimaFin = cicloService.findUltimoFechaf().replace("[", "").replace("]", "");
            String fechaUltimaIn = cicloService.findUltimoFechai().replace("[", "").replace("]", "");
            anyo.setValue(cicloService.findUltimo().replace("[", "").replace("]", ""));
            numero.setValue(cicloService.findUltimoN().replace("[", "").replace("]", ""));

            if (!(fechaUltimaIn.equals("null"))) {
                fechaini.setValue(getDate(fechaUltimaIn));
            }

            if (!(fechaUltimaFin.equals("null"))) {
                fechafin.setValue(getDate(fechaUltimaFin));
            }
        } catch (Exception ex) {
            Logger.getLogger(CicloController.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Listen("onClick=#guardarCicloAcad")
    public void guardarGrupoAcademico() {
        Ciclo guardar = new Ciclo();
        CicloPK guardarpk = new CicloPK();
        guardar.setCicloPK(guardarpk);

        guardarpk.setAnoCiclo(Long.parseLong(anyo.getValue()));
        guardarpk.setNumeroCiclo(Short.parseShort(numero.getValue()));
        guardar.setFechaInicioCiclo(fechaini.getValue());
        guardar.setFechaFinCiclo(fechafin.getValue());


        String message = null;
        String type = null;
        try {
            message = cicloService.actualizarCicloAcademico(guardar);
            type = Clients.NOTIFICATION_TYPE_INFO;
        } catch (Exception ex) {
            message = ex.getMessage();
            type = Clients.NOTIFICATION_TYPE_ERROR;
        } finally {
            Clients.showNotification(message,
                    type, this.getSelf(), "top_center", 2000, true);
        }
    }

    public Date getDate(String date) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        try {

            return df.parse(date);

        } catch (ParseException ex) {
        }

        return null;
    }
}
