/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.controladores;

import java.util.List;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;
import sv.fia.eisi.entidades.Ciclo;
import sv.fia.eisi.entidades.EmpleadoDocente;
import sv.fia.eisi.entidades.reportes.CargaDocente;
import sv.fia.eisi.servicios.CicloService;
import sv.fia.eisi.servicios.DocenteService;

/**
 *
 * @author Antonio
 */
public class CargaDocenteController extends SelectorComposer<Component> {

    @Wire
    private Grid caGrid;
    @Wire
    private Button caPDF;
    @Wire
    private Combobox docentes;
    @WireVariable
    private CicloService cicloService;
    @WireVariable
    private DocenteService docenteService;
    private Ciclo c;
    private List<CargaDocente> cdList;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        c = cicloService.obtenerCicloActual();
        docentes.setModel(new ListModelList<EmpleadoDocente>(
                docenteService.obtenerDocentesActivos()));
    }

    @Listen("onSelect = #docentes")
    public void mostrarCarga() {
        EmpleadoDocente e = docentes.getSelectedItem().getValue();
        cdList = cicloService.obtenerCargaDocente(e, c);
        caGrid.setModel(new ListModelList<CargaDocente>(cdList));
        caPDF.setDisabled(false);

    }
}
