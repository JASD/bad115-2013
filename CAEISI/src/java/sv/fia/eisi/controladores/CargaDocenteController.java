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
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Filedownload;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;
import sv.fia.eisi.controladores.util.JasperExporter;
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
    private EmpleadoDocente e;
    private List<CargaDocente> cdList;
    private static final String JASPER_PATH = "/WEB-INF/resources/jasper/cargaDocenteCiclo.jasper";

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        c = cicloService.obtenerCicloActual();
        docentes.setModel(new ListModelList<EmpleadoDocente>(
                docenteService.obtenerDocentesActivos()));
    }

    @Listen("onSelect = #docentes")
    public void mostrarCarga() {
        e = docentes.getSelectedItem().getValue();
        cdList = cicloService.obtenerCargaDocente(e, c);
        caGrid.setModel(new ListModelList<CargaDocente>(cdList));
        caPDF.setDisabled(false);

    }

    @Listen("onClick = #caPDF")
    public void generarReporteAcad() throws JRException, IOException {

        Execution exec = Executions.getCurrent();
        HttpServletRequest request = (HttpServletRequest) exec.getNativeRequest();
        String realPath = request.getServletContext().getRealPath(JASPER_PATH);
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("anioCiclo", String.valueOf(c.getCicloPK().getAnoCiclo()));
        params.put("numCiclo", String.valueOf(c.getCicloPK().getNumeroCiclo()));
        params.put("docente", e.getEmpleado().getPrimerNombreEmpleado() 
                + " " + e.getEmpleado().getPrimerApellidoEmpleado());
        params.put("categoria", e.getCategoriaDocente());
        params.put("tiempo", e.getEmpleado().getCodigoContrato().getTiempoContrato());
        String format = JasperExporter.EXTENSION_TYPE_PDF;
        String type = JasperExporter.MEDIA_TYPE_PDF;
        File report = File.createTempFile("CargaDocenteCiclo", format);
        JasperExporter.export(realPath, params, new JRBeanCollectionDataSource(cdList),
                format, report);
        Filedownload.save(report, type);
    }
}
