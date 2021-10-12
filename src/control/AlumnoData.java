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
            System.out.println("Error en la conexion");
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
            System.out.println("Error al agregar al alumno" + ex);
        }
    }
    
    public void actualizarAlumno(Alumno alumno){
        String sql = "UPDATE alumno SET legajo = ?, nombre = ?, apellido = ?, fecha_nac = ?, activo = ? WHERE id_alumno = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            
            ps.setInt(1, alumno.getLegajo());
            ps.setString(2, alumno.getNombre());
            ps.setString(3, alumno.getApellido());
            ps.setDate(4, Date.valueOf(alumno.getFecNac()));
            ps.setBoolean(5, alumno.isActivo());
            ps.setInt(6, alumno.getIdAlumno());
            
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al actualizar al alumno" + ex);
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
                a.setIdAlumno(rs.getInt("id_alumno"));
                a.setLegajo(rs.getInt("legajo"));
                a.setNombre(rs.getString("nombre"));
                a.setApellido(rs.getString("apellido"));
                a.setFecNac(rs.getDate("fecha_nac").toLocalDate());
                a.setActivo(rs.getBoolean("activo"));
            }
            
        ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar al alumno" + ex);
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
            System.out.println("Error al obtener a los alumnos" + ex);
        }
        
        return alumnos;
    }
}
