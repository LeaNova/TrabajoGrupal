package control;

import java.sql.*;
import java.util.*;

import modelo.*;

/**
 * @author Gomez Jon Darian, Guardia Lucero Santiago Agustín, Heredia Leandro
 */
public class InscripcionData {
    private Connection con;
    private Conexion conexion;
    
    public InscripcionData(Conexion conexion) {
        
        try {
            con = conexion.getConexion();
            this.conexion = conexion;
        } catch (SQLException ex) {
            System.out.println("Error en conexion!");
        }
        
    }
    
    public void agregarInscripcion(Inscripcion inscripcion) {
        
        String sql = "INSERT INTO inscripcion (id_alumno, id_materia) VALUES (?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, inscripcion.getAlumno().getIdAlumno());
            ps.setInt(2, inscripcion.getMateria().getIdMateria());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                inscripcion.setId_inscripcion(rs.getInt(1));
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar");
        }
    }
    
    public void agregarNota(Inscripcion inscripcion, double nota) {
        String sql = "UPDATE inscripcion SET nota = ? WHERE id_alumno = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setDouble(1, nota);
            
            ps.setInt(2, inscripcion.getAlumno().getIdAlumno());
            
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error en actualizar!");
        }
    }
    
    public List<Inscripcion> inscripcionesMaterias(int id) {
        List<Inscripcion> listaMaterias = new ArrayList<>();
        
        Inscripcion inscripcion;
        Alumno alumno;
        Materia materia;
        
        String sql = "SELECT * FROM inscripcion, alumno, materia WHERE inscripcion.id_alumno = alumno.id_alumno AND inscripcion.id_materia = materia.id_materia AND materia.id_materia = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                inscripcion = new Inscripcion();
                
                alumno = buscarAlumno(rs.getInt("id_alumno"));
                inscripcion.setAlumno(alumno);
                
                materia = buscarMateria(rs.getInt("id_materia"));
                inscripcion.setMateria(materia);
                
                inscripcion.setNota(rs.getDouble("nota"));
                
                listaMaterias.add(inscripcion);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error en buscar " + ex);
        }
        
        return listaMaterias;
    }
    
    public List<Inscripcion> inscripcionesAlumno(int id) {
        List<Inscripcion> listaAlumnos = new ArrayList<>();
        
        Inscripcion inscripcion;
        Alumno alumno;
        Materia materia;
        
        String sql = "SELECT * FROM inscripcion, alumno, materia WHERE inscripcion.id_alumno = alumno.id_alumno AND inscripcion.id_materia = materia.id_materia AND alumno.id_alumno = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                inscripcion = new Inscripcion();
                
                alumno = buscarAlumno(rs.getInt("id_alumno"));
                inscripcion.setAlumno(alumno);
                
                materia = buscarMateria(rs.getInt("id_materia"));
                inscripcion.setMateria(materia);
                
                inscripcion.setNota(rs.getDouble("nota"));
                
                listaAlumnos.add(inscripcion);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error en buscar " + ex);
        }
        
        return listaAlumnos;
    }
    
    public Alumno buscarAlumno(int id) {
        AlumnoData ad = new AlumnoData(conexion);
        
        return ad.buscarAlumno(id);
    }
    
    public Materia buscarMateria(int id) {
        MateriaData mt = new MateriaData(conexion);
        
        return mt.buscarMateria(id);
    }
}
