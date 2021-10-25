package trabajogrupal;

import modelo.*;
import control.*;

import java.time.LocalDate;

/**
 * @author Gomez Jon Darian, Guardia Lucero Santiago Agustín, Heredia Leandro
 */
public class TrabajoGrupal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            // TODO code application logic here
            Conexion conexion= new Conexion();
            AlumnoData ad = new AlumnoData(conexion);
            MateriaData md = new MateriaData(conexion);
            InscripcionData id = new InscripcionData(conexion);
            
            Alumno a1 = new Alumno(1590, "Leandro", "Tamaro", LocalDate.of(1990, 2, 20), true);
            Alumno a2 = new Alumno(1785, "Jon", "Camargo", LocalDate.of(1996, 10, 5), true);
            Alumno a3 = new Alumno(1346, "Santiago", "Guzman", LocalDate.of(1997, 8, 10), true);
            Alumno a4 = new Alumno(1313, "Alumno", "Alumno", LocalDate.of(1999, 12, 31), true);
            
            Materia m1 = new Materia("Biologia", 1, true);
            Materia m2 = new Materia("Ed. Fisica", 1, true);
            Materia m3 = new Materia("Quimica", 2, true);
            Materia m4 = new Materia("Materia", 2, true);
            
            ad.agregarAlumno(a1);
            ad.agregarAlumno(a2);
            ad.agregarAlumno(a3);
            ad.agregarAlumno(a4);
            
            System.out.println(ad.obtenerAlumnos());
            
            ad.desactivarAlumno(a4.getIdAlumno());
            
            System.out.println(ad.obtenerAlumnosActivos());
            System.out.println(ad.obtenerAlumnosInactivos());
            
            md.agregarMateria(m1);
            md.agregarMateria(m2);
            md.agregarMateria(m3);
            md.agregarMateria(m4);
            
            System.out.println(md.obtenerMaterias());
            
            md.desactivarMateria(4);
            
            System.out.println(md.obtenerMateriasActivas());
            System.out.println(md.obtenerMateriasInactivas());
            
            Inscripcion i1 = new Inscripcion(a1, m1, 5);
            Inscripcion i2 = new Inscripcion(a1, m2, 7.5);
            Inscripcion i3 = new Inscripcion(a2, m2, 8);
            Inscripcion i4 = new Inscripcion(a2, m3, 10);
            Inscripcion i5 = new Inscripcion(a3, m1, 6);
            Inscripcion i6 = new Inscripcion(a3, m2, 7);
            Inscripcion i7 = new Inscripcion(a3, m3, 3.5);
            
            id.agregarInscripcion(i1);
            id.agregarInscripcion(i2);
            id.agregarInscripcion(i3);
            id.agregarInscripcion(i4);
            id.agregarInscripcion(i5);
            id.agregarInscripcion(i6);
            id.agregarInscripcion(i7);
            
            System.out.println(id.inscripcionesMaterias(m3.getIdMateria()));
            System.out.println(id.inscripcionesAlumno(a3.getIdAlumno()));
            
        } catch (ClassNotFoundException ex) {
            System.out.println("En el main"+ ex);
        }
        
    }
    
}
