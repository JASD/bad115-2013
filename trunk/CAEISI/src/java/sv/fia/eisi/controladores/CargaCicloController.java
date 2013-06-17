/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.controladores;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Row;
import org.zkoss.zul.Tabpanel;
import sv.fia.eisi.controladores.util.JasperExporter;
import sv.fia.eisi.entidades.Ciclo;
import sv.fia.eisi.entidades.reportes.CargaCicloAcad;
import sv.fia.eisi.entidades.reportes.CargaCicloAdmin;
import sv.fia.eisi.servicios.CicloService;

/**
 *
 * @author Antonio
 */
public class CargaCicloController extends SelectorComposer<Component> {

    @Wire
    private Grid caGrid;
    @Wire
    private Grid cadGrid;
    @Wire
    private Tabpanel tabAcad;
    @Wire
    private Tabpanel tabAdmin;
    @Wire
    private Button caPDF;
    @Wire
    private Button cadPDF;
    @WireVariable
    private CicloService cicloService;
    private Ciclo c;
    private List<CargaCicloAcad> cargaAcadCicloList;
    private List<CargaCicloAdmin> cargaAdminCicloList;
    private static final String JASPER_PATH_ACAD = "/WEB-INF/resources/jasper/cargaAcademicaCiclo.jasper";
    private static final String JASPER_PATH_ADMIN = "/WEB-INF/resources/jasper/cargaAdministrativaCiclo.jasper";

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        c = cicloService.obtenerCicloActual();
        cargaAcadCicloList = cicloService.obtenerCargaAcadCiclo(c);
        cargaAdminCicloList = cicloService.obtenerCargaAdminCiclo(c);
        if (cargaAcadCicloList.isEmpty()) {
            caPDF.setDisabled(true);
        }
        if (cargaAdminCicloList.isEmpty()) {
            cadPDF.setDisabled(true);
        }
        caGrid.setModel(new ListModelList<CargaCicloAcad>(cargaAcadCicloList));
        cadGrid.setModel(new ListModelList<CargaCicloAdmin>(cargaAdminCicloList));


    }

    @Listen("onClick = #caPDF")
    public void generarReporteAcad() throws JRException, IOException {

        Execution exec = Executions.getCurrent();
        HttpServletRequest request = (HttpServletRequest) exec.getNativeRequest();
        String realPath = request.getServletContext().getRealPath(JASPER_PATH_ACAD);
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("anioCiclo", String.valueOf(c.getCicloPK().getAnoCiclo()));
        params.put("numCiclo", String.valueOf(c.getCicloPK().getNumeroCiclo()));
        String format = JasperExporter.EXTENSION_TYPE_PDF;
        String type = JasperExporter.MEDIA_TYPE_PDF;
        File report = File.createTempFile("CargaAcademicaCiclo", format);
        JasperExporter.export(realPath, params, new JRBeanCollectionDataSource(cargaAcadCicloList),
                format, report);
        Filedownload.save(report, type);
    }

    @Listen("onClick = #cadPDF")
    public void generarReporteAdmin() throws JRException, IOException {

        Execution exec = Executions.getCurrent();
        HttpServletRequest request = (HttpServletRequest) exec.getNativeRequest();
        String realPath = request.getServletContext().getRealPath(JASPER_PATH_ADMIN);
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("anioCiclo", String.valueOf(c.getCicloPK().getAnoCiclo()));
        params.put("numCiclo", String.valueOf(c.getCicloPK().getNumeroCiclo()));
        String format = JasperExporter.EXTENSION_TYPE_PDF;
        String type = JasperExporter.MEDIA_TYPE_PDF;
        File report = File.createTempFile("CargaAdministrativaCiclo", format);
        JasperExporter.export(realPath, params, new JRBeanCollectionDataSource(cargaAdminCicloList),
                format, report);
        Filedownload.save(report, type);
    }

    @Listen("onClick = button")
    public void eliminarAsignacion(Event e) {
        if (!e.getTarget().getParent().equals(tabAdmin) && !e.getTarget().getParent().equals(tabAcad)) {
            Row row = (Row) e.getTarget().getParent();
            Grid g = (Grid) row.getGrid();
            int posicion = row.getIndex();
            String message = null;
            String type = null;
            if (g.equals(caGrid)) {
                CargaCicloAcad cca = (CargaCicloAcad) caGrid.getModel().getElementAt(posicion);
                try {
                    message = cicloService.eliminarCargaAcad(cca);
                    type = Clients.NOTIFICATION_TYPE_INFO;
                    cargaAcadCicloList = cicloService.obtenerCargaAcadCiclo(c);
                    caGrid.setModel(new ListModelList<CargaCicloAcad>(cargaAcadCicloList));
                    if (cargaAcadCicloList.isEmpty()) {
                        caPDF.setDisabled(true);
                    }
                } catch (Exception ex) {
                    message = ex.getMessage();
                    type = Clients.NOTIFICATION_TYPE_ERROR;
                } finally {
                    Clients.showNotification(message,
                            type, this.getSelf(), "top_center", 2000, true);
                }
            } else {
                CargaCicloAdmin cca = (CargaCicloAdmin) cadGrid.getModel().getElementAt(posicion);
                try {
                    message = cicloService.eliminarCargaAdmin(cca);
                    type = Clients.NOTIFICATION_TYPE_INFO;
                    cargaAdminCicloList = cicloService.obtenerCargaAdminCiclo(c);
                    cadGrid.setModel(new ListModelList<CargaCicloAdmin>(cargaAdminCicloList));
                    if (cargaAdminCicloList.isEmpty()) {
                        cadPDF.setDisabled(true);
                    }
                } catch (Exception ex) {
                    message = ex.getMessage();
                    type = Clients.NOTIFICATION_TYPE_ERROR;
                } finally {
                    Clients.showNotification(message,
                            type, this.getSelf(), "top_center", 2000, true);
                }
            }
        }
    }
}
