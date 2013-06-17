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
import org.zkoss.zul.Button;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;
import sv.fia.eisi.controladores.util.JasperExporter;
import sv.fia.eisi.entidades.Ciclo;
import sv.fia.eisi.entidades.reportes.CoordinacionesCiclo;
import sv.fia.eisi.servicios.CicloService;

/**
 *
 * @author Antonio
 */
public class CoordinacionCicloController extends SelectorComposer<Component> {

    @Wire
    private Grid cGrid;
    @Wire
    private Button cPDF;
    @WireVariable
    private CicloService cicloService;
    private List<CoordinacionesCiclo> ccList;
    private Ciclo c;
    private static final String JASPER_PATH = "/WEB-INF/resources/jasper/coordCursos.jasper";

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        c = cicloService.obtenerCicloActual();
        ccList = cicloService.obtenerCoordinacionesCiclo(c);
        if (ccList.isEmpty()) {
            cPDF.setDisabled(true);
        }
        cGrid.setModel(new ListModelList<CoordinacionesCiclo>(ccList));
    }

    @Listen("onClick = #cPDF")
    public void generarReporteCoord() throws JRException, IOException {
        Execution exec = Executions.getCurrent();
        HttpServletRequest request = (HttpServletRequest) exec.getNativeRequest();
        String realPath = request.getServletContext().getRealPath(JASPER_PATH);
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("anioCiclo", String.valueOf(c.getCicloPK().getAnoCiclo()));
        params.put("numCiclo", String.valueOf(c.getCicloPK().getNumeroCiclo()));
        String format = JasperExporter.EXTENSION_TYPE_PDF;
        String type = JasperExporter.MEDIA_TYPE_PDF;
        File report = File.createTempFile("CoordinacionesCiclo", format);
        JasperExporter.export(realPath, params, new JRBeanCollectionDataSource(ccList),
                format, report);
        Filedownload.save(report, type);
    }
   
    @Listen("onClick = button")
    public void eliminarCoord(Event e) {
        
    }
}
