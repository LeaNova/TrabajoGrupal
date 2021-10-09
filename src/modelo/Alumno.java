package modelo;

import java.time.LocalDate;

/**
 * @author Gomez Jon Darian, Guardia Lucero Santiago Agustín, Heredia Leandro
 */
public class Alumno {
    
    private int idAlumno;
    private int legajo;
    private String nombre;
    private String apellido;
    private LocalDate fecNac;
    private boolean activo;

    public Alumno(){
        
    }
    
    public Alumno(int legajo, String nombre, String apellido, LocalDate fecNac, boolean activo) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecNac = fecNac;
        this.activo = activo;
    }

    public Alumno(int idAlumno, int legajo, String nombre, String apellido, LocalDate fecNac, boolean activo) {
        this.idAlumno = idAlumno;
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecNac = fecNac;
        this.activo = activo;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFecNac() {
        return fecNac;
    }

    public void setFecNac(LocalDate fecNac) {
        this.fecNac = fecNac;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}
