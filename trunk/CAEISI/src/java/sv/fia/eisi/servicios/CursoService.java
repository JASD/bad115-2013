/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.servicios;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sv.fia.eisi.entidades.Curso;
import sv.fia.eisi.entidades.GrupoAcademico;
import sv.fia.eisi.repositorios.CursoDAO;
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

    @Transactional(readOnly = true)
    public List<Curso> findActives() {
        return cursoDAO.findActives();
    }
    
    @Transactional
    public void guardarGrupo(GrupoAcademico ga){
   
        gaDAO.create(ga);
    
    }
}
