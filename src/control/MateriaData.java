package control;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelo.*;

/**
 * @author Gomez Jon Darian, Guardia Lucero Santiago Agustín, Heredia Leandro
 */
public class MateriaData {
    
    private Connection con;

    public MateriaData(Conexion conexion) {
        try {
            this.con = conexion.getConexion();
        } catch (SQLException ex) {
            System.out.println("Error en la conexion.");
        }
    }
    
    public void agregarMateria(Materia materia){
        String sql = "INSERT INTO materia (anio,nombre,activo) VALUE (?,?,?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, materia.getAnio());
            ps.setString(2,materia.getNombre());
            ps.setBoolean(3, materia.isActivo());

            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys(); 
            
            if (rs.next()){
                materia.setIdMateria(rs.getInt(1));
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al agregar la materia. " + ex);
        }
    }
    
    public void actualizarMateria(Materia materia){
        String sql = "UPDATE materia SET anio = ?, nombre = ? WHERE id_materia = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, materia.getAnio());
            ps.setString(2, materia.getNombre());
            ps.setInt(3, materia.getIdMateria());
            ps.executeUpdate();
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al actualizar la materia. " + ex);
        }
        
    }
    
    public List<Materia> obtenerMaterias(){
        List<Materia> materias= new ArrayList<>();
        String sql="SELECT * FROM materia";
    
        try {
            PreparedStatement ps= con.prepareStatement(sql);
                       
            ResultSet rs =ps.executeQuery();
            
            while (rs.next()){
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt(1));
                materia.setAnio(rs.getInt(2));
                materia.setNombre(rs.getString(3));
                materia.setActivo(rs.getBoolean(4));
                materias.add(materia);
            }          
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener las materias. " + ex);
        }
        
        return materias;
    }
    
    public List<Materia> obtenerMateriasActivas(){
        List<Materia> materiasActivas = new ArrayList<>();;
        String sql="SELECT * FROM materia WHERE activo = true";
    
        try {
            PreparedStatement ps= con.prepareStatement(sql);
                       
            ResultSet rs =ps.executeQuery();
            
            while (rs.next()){
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt(1));
                materia.setAnio(rs.getInt(2));
                materia.setNombre(rs.getString(3));
                materia.setActivo(rs.getBoolean(4));
                
                materiasActivas.add(materia);
            }          
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener las materias activas. " + ex);
        }
        
        return materiasActivas;
    }
    
    public List<Materia> obtenerMateriasInactivas(){
        List<Materia> materiasInactivas = new ArrayList<>();
        String sql="SELECT * FROM materia WHERE activo = false";
    
        try {
            PreparedStatement ps= con.prepareStatement(sql);
                       
            ResultSet rs =ps.executeQuery();
            
            while (rs.next()){
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt(1));
                materia.setAnio(rs.getInt(2));
                materia.setNombre(rs.getString(3));
                materia.setActivo(rs.getBoolean(4));
                materiasInactivas.add(materia);
            }          
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al obtener las materias inactivas. " + ex);
        }
        
        return materiasInactivas;
    }
    
    public Materia buscarMateria(int id){
    Materia materia = new Materia();
    String sql="SELECT * FROM materia WHERE id_materia=?";
    
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs =ps.executeQuery();
            if (rs.next()){
                materia.setIdMateria(rs.getInt(1));
                materia.setAnio(rs.getInt(2));
                materia.setNombre(rs.getString(3));
                materia.setActivo(rs.getBoolean(4));
            }
            
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al buscar la materia. " + ex);
        }
        
        return materia;
    }
   
    public void desactivarMateria(int idMateria){
        String sql = "UPDATE materia SET activo = false WHERE id_materia = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, idMateria);
            
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al desactivar la materia. " + ex);
        }
    }
    
    public void activarMateria(int idMateria){
        String sql = "UPDATE materia SET activo = true WHERE id_materia = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, idMateria);
            
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al activar la materia. " + ex);
        }
    }
    
    public void borrarMateria(int idMateria){
        String sql = "DELETE FROM materia WHERE id_materia = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, idMateria);
            
            ps.executeUpdate();
            ps.close();
            
        } catch (SQLException ex) {
            System.out.println("Error al borrar la materia. " + ex);
        }
    }
}
