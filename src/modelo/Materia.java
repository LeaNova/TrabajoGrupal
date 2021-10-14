package modelo;

/**
 * @author Gomez Jon Darian, Guardia Lucero Santiago Agustín, Heredia Leandro
 */
public class Materia {
    private int idMateria;
    private String nombre;
    private int anio;
    private boolean activo;

    // Constructores
    public Materia(int idMateria, String nombre, int anio, boolean activo) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.anio = anio;
        this.activo = activo;
    }

    public Materia(String nombre, int anio, boolean activo) {
        this.nombre = nombre;
        this.anio = anio;
        this.activo = activo;
    }

    public Materia() {
    }

    // Getters & Setters
    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Materia= id: " + idMateria + ". Nombre: " + nombre + ". Año: " + anio + ". Activo: " + activo + ".";
    }
}
