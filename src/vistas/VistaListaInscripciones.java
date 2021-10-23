package vistas;

import control.*;
import modelo.*;

import java.util.logging.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;

/**
 * @author Gomez Jon Darian, Guardia Lucero Santiago Agustín, Heredia Leandro
 */
public class VistaListaInscripciones extends javax.swing.JInternalFrame {
    
    private InscripcionData id;
    private MateriaData md;
    private AlumnoData ad;
    private ArrayList<Inscripcion> listaInscripcion;
    private ArrayList<Materia> listaMaterias;
    private ArrayList<Alumno> listaAlumnos;
    
    private Conexion conexion;
    
    private DefaultTableModel modelo;
    
    /**
     * Creates new form VistaListaInscripciones
     */
    public VistaListaInscripciones() {
        try {
            initComponents();
            
            conexion = new Conexion("jdbc:mysql://localhost/universidad", "root", "");
            id = new InscripcionData(conexion);
            md = new MateriaData(conexion);
            ad = new AlumnoData(conexion);
            listaInscripcion = (ArrayList)id.obtenerInscripciones();
            listaMaterias = (ArrayList)md.obtenerMaterias();
            listaAlumnos = (ArrayList)ad.obtenerAlumnos();
            
            modelo = new DefaultTableModel();
            armarCabezera();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VistaMostrarMateriasDeAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabInscripciones = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Inscripciones");

        jtabInscripciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtabInscripciones);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel1)
                .addContainerGap(158, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        borrarFila();
        llenarTabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void armarCabezera() {
        ArrayList<Object> titulos = new ArrayList<>();
        
        titulos.add("ID");
        titulos.add("Alumno");
        titulos.add("Materia");
        
        for (Object titulo: titulos) {
            modelo.addColumn(titulo);
        }
        
        jtabInscripciones.setModel(modelo);
    }
    
    private void borrarFila() {
        int filas = modelo.getRowCount() - 1;
        
        for (int cont = filas; cont >= 0; cont--) {
            modelo.removeRow(cont);
        }
    }
    
    private void llenarTabla() {
        for (Inscripcion insc: listaInscripcion) {
            modelo.addRow(new Object[]{insc.getId_inscripcion(), insc.getAlumno().getNombre() + ", "+ insc.getAlumno().getApellido(), insc.getMateria().getNombre()});
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtabInscripciones;
    // End of variables declaration//GEN-END:variables
}
