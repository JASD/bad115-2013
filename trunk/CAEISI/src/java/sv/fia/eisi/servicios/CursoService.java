/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.servicios;

import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.fia.eisi.entidades.CoordinacionCursoPK;
import sv.fia.eisi.entidades.Curso;
import sv.fia.eisi.entidades.Departamento;
import sv.fia.eisi.entidades.GrupoAcademico;
import sv.fia.eisi.repositorios.CursoDAO;
import sv.fia.eisi.repositorios.DepartamentoDAO;
import sv.fia.eisi.repositorios.GrupoAcademicoDAO;

/**
 *
 * @author Antonio
 */
@Service
public class CursoService {

    @Autowired
    private CursoDAO cursoDAO;
    @Autowired
    private GrupoAcademicoDAO gaDAO;
    @Autowired
    private DepartamentoDAO departamentoDAO;

    @Transactional(readOnly = true)
    public List<Curso> findActives() {
        return cursoDAO.findActives();
    }
    
    @Transactional
    public void guardarGrupo(GrupoAcademico ga){
   
        gaDAO.create(ga);
    
    }
    
     @Transactional
    public String asignarCarga(CoordinacionCursoPK cc) throws Exception {
        String status = cursoDAO.asignar(cc);
        if (status.equals("OK")) {
            return ResourceBundle.getBundle("/messages")
                    .getString("CoordinacionGuardada");
        } else {
            throw new Exception(status);
        }
    }

    @Transactional(readOnly = true)
    public List <Departamento> getDepartamentos() {
        return departamentoDAO.findAll(); 
    }
    
    @Transactional
    public String guardarCurso(Curso curso) throws Exception {
        String status = cursoDAO.create(curso);
        if (status.equals("OK")) {
            return ResourceBundle.getBundle("/messages")
                    .getString("CursoGuardado");
        } else {
            throw new Exception(status);
        } //To change body of generated methods, choose Tools | Templates.
    }
}
