package control;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import modelo.*;

/**
 * @author Gomez Jon Darian, Guardia Lucero Santiago Agustín, Heredia Leandro
 */
public class AlumnoData {
    
    private Connection conexion;

    public AlumnoData(Conexion conexion) {
        try {
            this.conexion = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error en la conexion.");
        }
    }
    
    public void agregarAlumno(Alumno alumno){
        String sql = "INSERT INTO alumno (legajo,nombre,apellido,fecha_nac,activo) VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, alumno.getLegajo());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido());
            ps.setDate(4, Date.valueOf(alumno.getFecNac()));
            ps.setBoolean(5, alumno.isActivo());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if(rs.next()){
                alumno.setIdAlumno(rs.getInt(1));
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al agregar al alumno. " + ex);
        }
    }
    
    public void actualizarAlumno(Alumno alumno){
        String sql = "UPDATE alumno SET legajo = ?, nombre = ?, apellido = ?, fecha_nac = ? WHERE id_alumno = ?";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, alumno.getLegajo());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido());
            ps.setDate(4, Date.valueOf(alumno.getFecNac()));
            ps.setInt(5, alumno.getIdAlumno());
            
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al actualizar al alumno. " + ex);
        }
    }
    
    public Alumno buscarAlumno(int idAlumno){
        Alumno a = new Alumno();
        String sql = "SELECT * FROM alumno WHERE id_alumno = ?";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, idAlumno);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                a.setIdAlumno(rs.getInt(1));
                a.setLegajo(rs.getInt(2));
                a.setNombre(rs.getString(3));
                a.setApellido(rs.getString(4));
                a.setFecNac(rs.getDate(5).toLocalDate());
                a.setActivo(rs.getBoolean(6));
            }
            
        ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar al alumno. " + ex);
        }
        
        return a;
    }
    
    public List<Alumno> obtenerAlumnos(){
        List<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT * FROM alumno";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Alumno a = new Alumno();
                a.setIdAlumno(rs.getInt(1));
                a.setLegajo(rs.getInt(2));
                a.setNombre(rs.getString(3));
                a.setApellido(rs.getString(4));
                a.setFecNac(rs.getDate(5).toLocalDate());
                a.setActivo(rs.getBoolean(6));
                
                alumnos.add(a);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener a los alumnos. " + ex);
        }
        
        return alumnos;
    }
    
    public List<Alumno> obtenerAlumnosActivos(){
        List<Alumno> alumnosActivos = new ArrayList<>();
        String sql = "SELECT * FROM alumno WHERE activo = true";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Alumno a = new Alumno();
                a.setIdAlumno(rs.getInt(1));
                a.setLegajo(rs.getInt(2));
                a.setNombre(rs.getString(3));
                a.setApellido(rs.getString(4));
                a.setFecNac(rs.getDate(5).toLocalDate());
                a.setActivo(rs.getBoolean(6));
                
                alumnosActivos.add(a);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener a los alumnos activos. " + ex);
        }
        
        return alumnosActivos;
    }
    
    public List<Alumno> obtenerAlumnosInactivos(){
        List<Alumno> alumnosInactivos = new ArrayList<>();
        String sql = "SELECT * FROM alumno WHERE activo = false";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Alumno a = new Alumno();
                a.setIdAlumno(rs.getInt(1));
                a.setLegajo(rs.getInt(2));
                a.setNombre(rs.getString(3));
                a.setApellido(rs.getString(4));
                a.setFecNac(rs.getDate(5).toLocalDate());
                a.setActivo(rs.getBoolean(6));
                
                alumnosInactivos.add(a);
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener a los alumnos inactivos. " + ex);
        }
        
        return alumnosInactivos;
    }
    
    public void desactivarAlumno(int idAlumno){
        String sql = "UPDATE alumno SET activo = false WHERE id_alumno = ?";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, idAlumno);
            
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al desactivar al alumno. " + ex);
        }
    }
    
    public void activarAlumno(int idAlumno){
        String sql = "UPDATE alumno SET activo = true WHERE id_alumno = ?";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, idAlumno);
            
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al activar al alumno. " + ex);
        }
    }
    
    public void borrarAlumno(int idAlumno) {
        String sql = "DELETE FROM alumno WHERE id_alumno = ?";
        
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, idAlumno);
            
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al borrar alumno. " + ex);
        }
    }
}