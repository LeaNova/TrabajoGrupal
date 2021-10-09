package control;

import java.sql.*;

import modelo.*;

/**
 * @author Gomez Jon Darian, Guardia Lucero Santiago Agustín, Heredia Leandro
 */
public class InscripcionData {
        private Connection con;
    
    public InscripcionData(Conexion conexion) {
        
        try {
            con = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error en conexion!");
        }
        
    }
    
    public void agregarInscripcion(Inscripcion inscripcion, Alumno alumno, Materia materia) {
        
        String sql = "INSERT INTO inscripcion (id_alumno, id_materia) VALUES (?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getIdAlumno());
            ps.setInt(2, materia.getIdMateria());
            
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
    
    public void agregarNota(Alumno alumno, double nota) {
        String sql = "UPDATE inscripcion SET nota = ? WHERE id_alumno = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setDouble(1, nota);
            
            ps.setInt(2, alumno.getIdAlumno());
            
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error en actualizar!");
        }
    }
}
