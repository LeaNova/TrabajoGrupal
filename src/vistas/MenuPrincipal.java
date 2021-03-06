package vistas;

/**
 * @author Gomez Jon Darian, Guardia Lucero Santiago Agustín, Heredia Leandro
 */
public class MenuPrincipal extends javax.swing.JFrame {
    
    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmAgregarMateria = new javax.swing.JMenuItem();
        jmModificarMateria = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jmAgregarInscripcion = new javax.swing.JMenuItem();
        jmListaInscripciones = new javax.swing.JMenuItem();
        jmInscripcionesAlumno = new javax.swing.JMenuItem();
        jmInscriptosMaterias = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 831, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 705, Short.MAX_VALUE)
        );

        jMenu1.setText("Alumnos");

        jMenuItem1.setText("Agregar Alumno");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Modificar Alumno");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Materias");

        jmAgregarMateria.setText("Agregar Materia");
        jmAgregarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAgregarMateriaActionPerformed(evt);
            }
        });
        jMenu2.add(jmAgregarMateria);

        jmModificarMateria.setText("Modificar Materia");
        jmModificarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmModificarMateriaActionPerformed(evt);
            }
        });
        jMenu2.add(jmModificarMateria);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Inscripciones");

        jmAgregarInscripcion.setText("Agregar Inscripcion");
        jmAgregarInscripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmAgregarInscripcionActionPerformed(evt);
            }
        });
        jMenu3.add(jmAgregarInscripcion);

        jmListaInscripciones.setText("Lista de Inscripciones");
        jmListaInscripciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmListaInscripcionesActionPerformed(evt);
            }
        });
        jMenu3.add(jmListaInscripciones);

        jmInscripcionesAlumno.setText("Inscripciones del Alumno");
        jmInscripcionesAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmInscripcionesAlumnoActionPerformed(evt);
            }
        });
        jMenu3.add(jmInscripcionesAlumno);

        jmInscriptosMaterias.setText("Inscriptos en Materias");
        jmInscriptosMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmInscriptosMateriasActionPerformed(evt);
            }
        });
        jMenu3.add(jmInscriptosMaterias);

        jMenuItem5.setText("Agregar Nota");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Salir");

        jMenuItem7.setText("Salir");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmAgregarInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAgregarInscripcionActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaAgregarInscripcion vai = new VistaAgregarInscripcion();
        vai.setVisible(true);
        escritorio.add(vai);
    }//GEN-LAST:event_jmAgregarInscripcionActionPerformed

    private void jmInscripcionesAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmInscripcionesAlumnoActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaMostrarMateriasDeAlumno vmma = new VistaMostrarMateriasDeAlumno();
        vmma.setVisible(true);
        escritorio.add(vmma);
    }//GEN-LAST:event_jmInscripcionesAlumnoActionPerformed

    private void jmInscriptosMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmInscriptosMateriasActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaMostrarAlumnosPorMateria vmam = new VistaMostrarAlumnosPorMateria();
        vmam.setVisible(true);
        escritorio.add(vmam);
    }//GEN-LAST:event_jmInscriptosMateriasActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaAgregarNota van = new VistaAgregarNota();
        van.setVisible(true);
        escritorio.add(van);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jmListaInscripcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmListaInscripcionesActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaListaInscripciones vli = new VistaListaInscripciones();
        vli.setVisible(true);
        escritorio.add(vli);
    }//GEN-LAST:event_jmListaInscripcionesActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jmAgregarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmAgregarMateriaActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaAgregarMateria vim = new VistaAgregarMateria();
        vim.setVisible(true);
        escritorio.add(vim);
        
        
    }//GEN-LAST:event_jmAgregarMateriaActionPerformed

    private void jmModificarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmModificarMateriaActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaModificarMateria vimm = new VistaModificarMateria();
        vimm.setVisible(true);
        escritorio.add(vimm);
    }//GEN-LAST:event_jmModificarMateriaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaAgregarAlumno vaa = new VistaAgregarAlumno();
        vaa.setVisible(true);
        escritorio.add(vaa);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaModificarAlumno vma = new VistaModificarAlumno();
        vma.setVisible(true);
        escritorio.add(vma);
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jmAgregarInscripcion;
    private javax.swing.JMenuItem jmAgregarMateria;
    private javax.swing.JMenuItem jmInscripcionesAlumno;
    private javax.swing.JMenuItem jmInscriptosMaterias;
    private javax.swing.JMenuItem jmListaInscripciones;
    private javax.swing.JMenuItem jmModificarMateria;
    // End of variables declaration//GEN-END:variables
}
