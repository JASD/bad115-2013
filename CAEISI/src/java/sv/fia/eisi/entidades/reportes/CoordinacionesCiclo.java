/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.fia.eisi.entidades.reportes;

import java.io.Serializable;

/**
 *
 * @author Antonio
 */
public class CoordinacionesCiclo implements Serializable{
    
    private String codigo;
    private String curso;
    private String docente;
    private String actividad;
    private String codigoCurso;
    private String isssDocente;
    private String codigoActividad;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getIsssDocente() {
        return isssDocente;
    }

    public void setIsssDocente(String isssDocente) {
        this.isssDocente = isssDocente;
    }

    public String getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(String codigoActividad) {
        this.codigoActividad = codigoActividad;
    }
}
