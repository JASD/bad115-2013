/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.controladores;

import java.util.List;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Grid;
import org.zkoss.zul.ListModelList;
import sv.fia.eisi.entidades.reportes.CargaCiclo;
import sv.fia.eisi.servicios.CicloService;

/**
 *
 * @author Antonio
 */
public class CargaCicloController extends SelectorComposer<Component>{
    
    
    @Wire
    private Grid caGrid;
    @WireVariable
    private CicloService cicloService;
    private List<CargaCiclo> cargaCicloList;
    
    @Override
    public void doAfterCompose(Component comp) throws Exception{
        super.doAfterCompose(comp);
        cargaCicloList = cicloService.obtenerCargaAcadCiclo();
        caGrid.setModel(new ListModelList<CargaCiclo>(cargaCicloList));
        
        
    }
    
}
