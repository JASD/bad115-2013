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
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;
import sv.fia.eisi.controladores.util.JasperExporter;
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
    @WireVariable
    private CicloService cicloService;
    private List<CargaCicloAcad> cargaAcadCicloList;
    private List<CargaCicloAdmin> cargaAdminCicloList;
    private static final String JASPER_PATH_ACAD = "/WEB-INF/resources/jasper/cargaAcademicaCiclo.jasper";
    private static final String JASPER_PATH_ADMIN = "/WEB-INF/resources/jasper/cargaAdministrativaCiclo.jasper";

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        cargaAcadCicloList = cicloService.obtenerCargaAcadCiclo();
        cargaAdminCicloList = cicloService.obtenerCargaAdminCiclo();
        caGrid.setModel(new ListModelList<CargaCicloAcad>(cargaAcadCicloList));
        cadGrid.setModel(new ListModelList<CargaCicloAdmin>(cargaAdminCicloList));


    }

    @Listen("onClick = #caPDF")
    public void generarReporteAcad() throws JRException, IOException {

        Execution exec = Executions.getCurrent();
        HttpServletRequest request = (HttpServletRequest) exec.getNativeRequest();
        String realPath = request.getServletContext().getRealPath(JASPER_PATH_ACAD);
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("anioCiclo", "2013");
        params.put("numCiclo", "1");
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
        params.put("anioCiclo", "2013");
        params.put("numCiclo", "1");
        String format = JasperExporter.EXTENSION_TYPE_PDF;
        String type = JasperExporter.MEDIA_TYPE_PDF;
        File report = File.createTempFile("CargaAdministrativaCiclo", format);
        JasperExporter.export(realPath, params, new JRBeanCollectionDataSource(cargaAdminCicloList),
                format, report);
        Filedownload.save(report, type);
    }
}
