package pantallas;

import bo.LibroBo;
import bo.ProfeoBo;
import bo.ReservaProfesorBo;
import clases.Libro;
import clases.Profesor;
import clases.ReservaProfesor;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author anyelacristinadaza
 */
public class ReservaProfesorP extends javax.swing.JFrame {

    private ReservaProfesorBo reservaProfesorBo;
    private DefaultTableModel tablaModelo;
    private ProfeoBo profesorBo;
    private LibroBo libroBo;

    public ReservaProfesorP() {
        initComponents();
        reservaProfesorBo = new ReservaProfesorBo();
        tablaModelo = new DefaultTableModel();
        profesorBo = new ProfeoBo();
        libroBo = new LibroBo();
        cargaProfesores();
        cargarLibros();
        llenarTabla();
    }

    private boolean validarDatos() {
        boolean bandera = true;
        if (cbProfesores.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un profesor");
            bandera = false;
        }

        if (cbLibros.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un libro");
            bandera = false;
        }
        return bandera;
    }

    private void cargaProfesores() {
        List<Profesor> listaProfesor = profesorBo.consultaTodos();
        cbProfesores.addItem("Seleccione");

        for (int i = 0; i < listaProfesor.size(); i++) {
            Profesor profesor = listaProfesor.get(i);
            cbProfesores.addItem(profesor.getCedula() + " - " + profesor.getNombre());
        }
    }

    private void cargarLibros() {
        List<Libro> listaLibros = libroBo.consultaTodos();
        cbLibros.addItem("Seleccione");

        for (int i = 0; i < listaLibros.size(); i++) {
            Libro libro = listaLibros.get(i);
            cbLibros.addItem(libro.getCodigo() + " - " + libro.getNombre());
        }
    }

    private void llenarTabla() {
        
        this.tablaModelo = new DefaultTableModel() {
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };                
        
        tablaModelo.setColumnCount(0);
        tablaModelo.addColumn("Cedula");
        tablaModelo.addColumn("Codigo");
        tablaModelo.addColumn("Días");
        tablaModelo.addColumn("Fecha");

        List<ReservaProfesor> listaReservaProfesor = reservaProfesorBo.consultaTodos();

        tablaModelo.setNumRows(listaReservaProfesor.size());

        for (int i = 0; i < listaReservaProfesor.size(); i++) {
            ReservaProfesor reservaProfesor = listaReservaProfesor.get(i);
            Profesor profesor = profesorBo.consultaCedula(reservaProfesor.getCedulaProfesor());
            Libro libro = libroBo.consultaCodigo(reservaProfesor.getCodigoLibro());

            tablaModelo.setValueAt(profesor.getNombre(), i, 0);
            tablaModelo.setValueAt(libro.getNombre(), i, 1);
            tablaModelo.setValueAt(reservaProfesor.getDiasReserva(), i, 2);
            tablaModelo.setValueAt(reservaProfesor.getFechaReserva(), i, 3);
        }
        tablaReservacionProfesor.setModel(tablaModelo);

    }

    public void limpiar() {
        cbLibros.setSelectedIndex(0);
        cbProfesores.setSelectedIndex(0);
        spinnDias.setValue(1);
    }

    public ReservaProfesorBo getReservaProfesorBo() {
        return reservaProfesorBo;
    }

    public void setReservaProfesorBo(ReservaProfesorBo reservaProfesorBo) {
        this.reservaProfesorBo = reservaProfesorBo;
    }

    public DefaultTableModel getTablaModelo() {
        return tablaModelo;
    }

    public void setTablaModelo(DefaultTableModel tablaModelo) {
        this.tablaModelo = tablaModelo;
    }

    public ProfeoBo getProfesorBo() {
        return profesorBo;
    }

    public void setProfesorBo(ProfeoBo profesorBo) {
        this.profesorBo = profesorBo;
    }

    public LibroBo getLibroBo() {
        return libroBo;
    }

    public void setLibroBo(LibroBo libroBo) {
        this.libroBo = libroBo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReservacionProfesor = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbProfesores = new javax.swing.JComboBox<>();
        cbLibros = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        spinnDias = new javax.swing.JSpinner();
        btnReservacion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaReservacionProfesor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaReservacionProfesor);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Reserva de Profesores");

        jLabel2.setText("Profesor");

        jLabel3.setText("Libro");

        jLabel4.setText("Días de préstamo");

        spinnDias.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));

        btnReservacion.setText("Crear Reservación");
        btnReservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReservacion)
                .addGap(164, 164, 164))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spinnDias, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbLibros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(spinnDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(btnReservacion)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservacionActionPerformed
        if (validarDatos()) {
            ReservaProfesor reservaProfesor = new ReservaProfesor();

            String profeSeleccionado = String.valueOf(cbProfesores.getSelectedItem());
            String libroSeleccionado = String.valueOf(cbLibros.getSelectedItem());

            String[] cadenaStringProfe = profeSeleccionado.split("-");
            String[] cadenaStringLibro = libroSeleccionado.split("-");

            reservaProfesor.setCedulaProfesor(Integer.parseInt(cadenaStringProfe[0].trim()));
            reservaProfesor.setCodigoLibro(Integer.parseInt(cadenaStringLibro[0].trim()));
            reservaProfesor.setDiasReserva((Integer) spinnDias.getValue());
            reservaProfesor.setFechaReserva(new Date());

            int respuesta = reservaProfesorBo.insertarReservarProfesor(reservaProfesor);

            switch (respuesta) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Reserva agregada correctamente");
                    break;
                case 1:
                    JOptionPane.showMessageDialog(null, "No se pudo conectar a la BD");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Ya existe una reserva con esos datos");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado");
                    break;
            }
        }
        llenarTabla();

    }//GEN-LAST:event_btnReservacionActionPerformed

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
            java.util.logging.Logger.getLogger(ReservaProfesorP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservaProfesorP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservaProfesorP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservaProfesorP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReservaProfesorP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReservacion;
    private javax.swing.JComboBox<String> cbLibros;
    private javax.swing.JComboBox<String> cbProfesores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinnDias;
    private javax.swing.JTable tablaReservacionProfesor;
    // End of variables declaration//GEN-END:variables
}
