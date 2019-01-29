/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas;

import bo.EstudianteBo;
import clases.Estudiante;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anyelacristinadaza
 */
public class MantEstudiante extends javax.swing.JFrame {

    private EstudianteBo estudianteBo;
    private DefaultTableModel modeloEstudiante;

    public MantEstudiante() {
        initComponents();
        this.setLocationRelativeTo(null);
        estudianteBo = new EstudianteBo();
        llenarTabla();
    }

    public void llenarTabla() {
        this.modeloEstudiante = new DefaultTableModel() {
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };

        this.modeloEstudiante.setColumnCount(0);//Vamos a trabajar en la columna 0
        this.modeloEstudiante.addColumn("Cedula");
        this.modeloEstudiante.addColumn("Nombre");
        this.modeloEstudiante.addColumn("Carrera");
        this.modeloEstudiante.addColumn("Carnet");

        List<Estudiante> listaEstudiantes = estudianteBo.consultaTodos();

        modeloEstudiante.setNumRows(listaEstudiantes.size());

        for (int i = 0; i < listaEstudiantes.size(); i++) {
            Estudiante estudiante = listaEstudiantes.get(i);
            modeloEstudiante.setValueAt(estudiante.getCedula(), i, 0);
            modeloEstudiante.setValueAt(estudiante.getNombre(), i, 1);
            modeloEstudiante.setValueAt(estudiante.getCarrera(), i, 2);
            modeloEstudiante.setValueAt(estudiante.getCarnet(), i, 3);
        }
        tablaEstudiante.setModel(modeloEstudiante);

    }

    public boolean validarDatos() {
        boolean bandera = true;

        if (txtCedula.getText().trim().equals("")) {
            bandera = false;
            JOptionPane.showMessageDialog(null, "Digite la cedula, por favor");
        } else {
            try {
                int numero = Integer.parseInt(txtCedula.getText());
            } catch (NumberFormatException e) {
                bandera = false;
                JOptionPane.showMessageDialog(null, "Digite solamente numeros en la cedula, por favor");
            }
        }

        if (txtNombre.getText().trim().equals("")) {
            bandera = false;
            JOptionPane.showMessageDialog(null, "Digite el nombre, por favor");
        }

        if (txtCarrera.getText().trim().equals("")) {
            bandera = false;
            JOptionPane.showMessageDialog(null, "Digite la carrera, por favor");
        }

        if (txtCarnet.getText().trim().equals("")) {
            bandera = false;
            JOptionPane.showMessageDialog(null, "Digite el carnet, por favor");
        } else {
            try {
                int numero = Integer.parseInt(txtCarnet.getText());
            } catch (NumberFormatException e) {
                bandera = false;
            }
        }
        return bandera;
    }

    public void limpiar() {
        txtCarnet.setText("");
        txtCarrera.setText("");
        txtCedula.setText("");
        txtNombre.setText("");
        llenarTabla();
        txtCedula.setEnabled(true);
    }

    public EstudianteBo getEstudianteBo() {
        return estudianteBo;
    }

    public void setEstudianteBo(EstudianteBo estudianteBo) {
        this.estudianteBo = estudianteBo;
    }

    public DefaultTableModel getModeloEstudiante() {
        return modeloEstudiante;
    }

    public void setModeloEstudiante(DefaultTableModel modeloEstudiante) {
        this.modeloEstudiante = modeloEstudiante;
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
        btnAgregar = new javax.swing.JButton();
        txtCarnet = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCarrera = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnConsultaCedula = new javax.swing.JButton();
        btnConsultaNombre = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEstudiante = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Carnet");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel2.setText("Cédula");

        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Mantenimiento de Estudiantes");

        jLabel5.setText("Carrera");

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnConsultaCedula.setText("Consulta por cedula");
        btnConsultaCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaCedulaActionPerformed(evt);
            }
        });

        btnConsultaNombre.setText("Consulta por nombre");
        btnConsultaNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaNombreActionPerformed(evt);
            }
        });

        tablaEstudiante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaEstudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEstudianteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaEstudiante);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 63, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(148, 148, 148)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(17, 17, 17)
                            .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(jLabel3)
                            .addGap(23, 23, 23)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24)
                            .addComponent(txtCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(btnAgregar)
                            .addGap(17, 17, 17)
                            .addComponent(btnEliminar)
                            .addGap(75, 75, 75)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(btnConsultaCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(130, 130, 130)
                            .addComponent(btnConsultaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 63, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 779, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(20, 20, 20)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(txtCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(txtCarnet, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(40, 40, 40)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAgregar)
                        .addComponent(btnEliminar)
                        .addComponent(btnModificar)
                        .addComponent(btnLimpiar))
                    .addGap(21, 21, 21)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnConsultaCedula)
                        .addComponent(btnConsultaNombre))
                    .addGap(31, 31, 31)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if (validarDatos()) {
            Estudiante estudiante = new Estudiante();

            estudiante.setCedula(Integer.parseInt(txtCedula.getText()));
            estudiante.setNombre(txtNombre.getText());
            estudiante.setCarrera(txtCarrera.getText());
            estudiante.setCarnet(Integer.parseInt(txtCarnet.getText()));

            int respuesta = estudianteBo.insertar(estudiante);

            switch (respuesta) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Se registro exitosamente");
                    break;

                case 1:
                    JOptionPane.showMessageDialog(null, "No se conecta a la BD");
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, "Registro ya existente");
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Error en intentar registro");
                    break;
            }
        }
        limpiar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (txtCedula.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite la cedula por favor");

        } else {
            try {
                //int numero = Integer.parseInt(txtCedula.getText());

                Estudiante estudiante = new Estudiante();

                estudiante.setCedula(Integer.parseInt(txtCedula.getText()));

                int resultado = estudianteBo.eliminar(estudiante);

                switch (resultado) {
                    case 0:
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro");
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "Se elimino el registro correctamente");
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "No se pudo conectar a la Base de Datos");
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado");
                        break;
                }
                limpiar();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite solamente numeros por favor");
            }

        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (validarDatos()) {
            Estudiante estudiante = new Estudiante();

            estudiante.setCedula(Integer.parseInt(txtCedula.getText()));
            estudiante.setNombre(txtNombre.getText());
            estudiante.setCarrera(txtCarrera.getText());
            estudiante.setCarnet(Integer.parseInt(txtCarnet.getText()));

            Integer resultado = estudianteBo.modificar(estudiante);

            switch (resultado) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Se modifico correctamente");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "No se modifico el registro correctamente");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado");
                    break;
            }

        }
        limpiar();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tablaEstudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEstudianteMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int fila = tablaEstudiante.getSelectedRow();
            txtCedula.setText(tablaEstudiante.getValueAt(fila, 0).toString());
            txtNombre.setText(tablaEstudiante.getValueAt(fila, 1).toString());
            txtCarrera.setText(tablaEstudiante.getValueAt(fila, 2).toString());
            txtCarnet.setText(tablaEstudiante.getValueAt(fila, 3).toString());
            txtCedula.setEnabled(false);
        }
    }//GEN-LAST:event_tablaEstudianteMouseClicked

    private void btnConsultaCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaCedulaActionPerformed
        // TODO add your handling code here:
        if (txtCedula.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite la cedula del estudiante por favor");
        } else {
            try {
                modeloEstudiante.setRowCount(0);
                
                Estudiante estudiante = new Estudiante();

                estudiante = estudianteBo.consultaCedula(Integer.parseInt(txtCedula.getText()));   
                                
                
                if (estudiante.getCedula() == Integer.parseInt(txtCedula.getText())) {
                    modeloEstudiante.setRowCount(1);
                } else {
                    modeloEstudiante.setRowCount(0);
                }

                modeloEstudiante.setValueAt(estudiante.getCedula(), 0, 0);
                modeloEstudiante.setValueAt(estudiante.getNombre(), 0, 1);
                modeloEstudiante.setValueAt(estudiante.getCarrera(), 0, 2);
                modeloEstudiante.setValueAt(estudiante.getCarnet(), 0, 3);

                tablaEstudiante.setModel(modeloEstudiante);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite solamente numeros por favor");
            }
        }
    }//GEN-LAST:event_btnConsultaCedulaActionPerformed

    private void btnConsultaNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaNombreActionPerformed
        // TODO add your handling code here:
        if(txtNombre.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Digite el nombre por favor");
        }else{
            List<Estudiante> listaEstudiantes = new ArrayList();
            
            listaEstudiantes = estudianteBo.consultaNombre(txtNombre.getText());
            
            modeloEstudiante.setNumRows(listaEstudiantes.size());
            
            for (int i = 0; i < listaEstudiantes.size(); i++) {
                Estudiante estudiante = listaEstudiantes.get(i);
                modeloEstudiante.setValueAt(estudiante.getCedula(), i, 0);
                modeloEstudiante.setValueAt(estudiante.getNombre(), i, 1);
                modeloEstudiante.setValueAt(estudiante.getCarrera(), i, 2);
                modeloEstudiante.setValueAt(estudiante.getCarnet(), i, 3);
            }
            tablaEstudiante.setModel(modeloEstudiante);
        } 
    }//GEN-LAST:event_btnConsultaNombreActionPerformed

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
            java.util.logging.Logger.getLogger(MantEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantEstudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantEstudiante().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnConsultaCedula;
    private javax.swing.JButton btnConsultaNombre;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEstudiante;
    private javax.swing.JTextField txtCarnet;
    private javax.swing.JTextField txtCarrera;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
