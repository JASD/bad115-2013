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
public class CargaCicloAdmin implements Serializable{
    
    private String docente;
    private String tipoGrupo;
    private String nombreGrupo;
    private String actividad;
    private Float horas;
    private String codigoGrupo;
    private String codigoActividad;
    private String isssEmpleado;

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getTipoGrupo() {
        return tipoGrupo;
    }

    public void setTipoGrupo(String tipoGrupo) {
        this.tipoGrupo = tipoGrupo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public Float getHoras() {
        return horas;
    }

    public void setHoras(Float horas) {
        this.horas = horas;
    }

    public String getCodigoGrupo() {
        return codigoGrupo;
    }

    public void setCodigoGrupo(String codigoGrupo) {
        this.codigoGrupo = codigoGrupo;
    }

    public String getCodigoActividad() {
        return codigoActividad;
    }

    public void setCodigoActividad(String codigoActividad) {
        this.codigoActividad = codigoActividad;
    }

    public String getIsssEmpleado() {
        return isssEmpleado;
    }

    public void setIsssEmpleado(String isssEmpleado) {
        this.isssEmpleado = isssEmpleado;
    }
    
}
