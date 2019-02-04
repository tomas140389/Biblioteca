/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pantallas;

import bo.LibroBo;
import clases.Libro;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author anyelacristinadaza
 */
public class MantLibro extends javax.swing.JFrame {

    private DefaultTableModel tablaModelo;
    private LibroBo libroBo;

    public MantLibro() {
        initComponents();
        libroBo = new LibroBo();
        tablaModelo = new DefaultTableModel();
        this.setLocationRelativeTo(null);
        llenarTabla();
    }

    public void llenarTabla() {
        this.tablaModelo = new DefaultTableModel() {
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };

        this.tablaModelo.setColumnCount(0);//Vamos a trabajar en la columna 0
        this.tablaModelo.addColumn("Codigo");
        this.tablaModelo.addColumn("Nombre");
        this.tablaModelo.addColumn("Autor");
        this.tablaModelo.addColumn("Año");
        this.tablaModelo.addColumn("Precio");

        List<Libro> listaLibros = new ArrayList();

        listaLibros = libroBo.consultaTodos();

        tablaModelo.setNumRows(listaLibros.size());

        for (int i = 0; i < listaLibros.size(); i++) {
            Libro libro = listaLibros.get(i);
            tablaModelo.setValueAt(libro.getCodigo(), i, 0);
            tablaModelo.setValueAt(libro.getNombre(), i, 1);
            tablaModelo.setValueAt(libro.getAutor(), i, 2);
            tablaModelo.setValueAt(libro.getAno(), i, 3);
            tablaModelo.setValueAt(libro.getPrecio(), i, 4);
        }
        tablaLibro.setModel(tablaModelo);

        this.tablaLibro.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int c = 0; c < this.tablaLibro.getColumnCount(); c++) {
            empacarColumna(this.tablaLibro, c, 2);
        }

    }

    public boolean validarDatos() {
        boolean bandera = true;

        if (txtCodigo.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite el codigo del libro por favor");
            bandera = false;
        } else {
            try {
                int numero = Integer.parseInt(txtCodigo.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite solamente numeros por favor");
                bandera = false;
            }
        }

        if (txtNombre.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite el nombre del libro por favor");
            bandera = false;
        }

        if (txtAno.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite el año del libro por favor");
            bandera = false;
        } else {
            try {
                int numero = Integer.parseInt(txtAno.getText());

                if (numero < 1000 || numero > 9999) {
                    JOptionPane.showMessageDialog(null, "Digite un año valido");
                    bandera = false;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite solamente numeros por favor");
                bandera = false;
            }
        }

        if (txtPrecio.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite el precio del libro por favor");
            bandera = false;
        } else {
            try {
                double numero = Double.parseDouble(txtPrecio.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite solamente numeros por favor");
                bandera = false;
            }
        }

        if (txtAutor.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite el autor del libro por favor");
            bandera = false;
        }
        return bandera;
    }

    public void empacarColumna(JTable table, int vColIndex, int margin) {
        DefaultTableColumnModel colModel = (DefaultTableColumnModel) table.getColumnModel();
        TableColumn col = colModel.getColumn(vColIndex);
        int width = 0;
        TableCellRenderer renderer = col.getHeaderRenderer();
        if (renderer == null) {
            renderer = table.getTableHeader().getDefaultRenderer();
        }
        Component comp = renderer.getTableCellRendererComponent(table, col.getHeaderValue(), false, false, 0, 0);
        width = comp.getPreferredSize().width;
        for (int r = 0; r < table.getRowCount(); r++) {
            renderer = table.getCellRenderer(r, vColIndex);
            comp = renderer.getTableCellRendererComponent(
                    table, table.getValueAt(r, vColIndex), false, false, r, vColIndex);
            width = Math.max(width, comp.getPreferredSize().width);
        }
        width += 2 * margin;
        col.setPreferredWidth(width);
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
        txtAno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnConsultaCodigo = new javax.swing.JButton();
        btnConsultaNombre = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibro = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Año");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel2.setText("Codigo");

        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Mantenimiento de Libros");

        jLabel5.setText("Autor");

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

        btnConsultaCodigo.setText("Consulta por codigo");
        btnConsultaCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaCodigoActionPerformed(evt);
            }
        });

        btnConsultaNombre.setText("Consulta por nombre");
        btnConsultaNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaNombreActionPerformed(evt);
            }
        });

        tablaLibro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaLibroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaLibro);

        jLabel6.setText("Precio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3)
                        .addGap(23, 23, 23)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(18, 54, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnConsultaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnAgregar)
                                    .addGap(17, 17, 17)
                                    .addComponent(btnEliminar)))
                            .addGap(75, 75, 75)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnConsultaNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(0, 46, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(566, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 217, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnAgregar)
                        .addComponent(btnEliminar)
                        .addComponent(btnModificar)
                        .addComponent(btnLimpiar))
                    .addGap(21, 21, 21)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnConsultaCodigo)
                        .addComponent(btnConsultaNombre))
                    .addGap(31, 31, 31)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 28, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if (validarDatos()) {
            Libro libro = new Libro();
            libro.setCodigo(Integer.parseInt(txtCodigo.getText()));
            libro.setNombre(txtNombre.getText());
            libro.setAutor(txtAutor.getText());
            libro.setAno(Integer.parseInt(txtAno.getText()));
            libro.setPrecio(Double.parseDouble(txtPrecio.getText()));

            int resultado = libroBo.insertar(libro);

            switch (resultado) {
                case 0:
                    JOptionPane.showMessageDialog(null, "EL registro se guardo correctamente");
                    break;

                case 1:
                    JOptionPane.showMessageDialog(null, "No se conecto a la BD");
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null, "Registro ya existente");
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Ocurrio un error");
                    break;
            }

        }
        limpiar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        if (txtCodigo.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite el codigo del libro por favor");
        } else {
            try {
                Libro libro = new Libro();

                libro.setCodigo(Integer.parseInt(txtCodigo.getText()));

                int resultado = libroBo.eliminar(libro);

                switch (resultado) {
                    case 0:
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro");
                        break;

                    case 1:
                        JOptionPane.showMessageDialog(null, "Se elimino el registro correctamente");
                        break;

                    case 2:
                        JOptionPane.showMessageDialog(null, "No se conecto a la BD");
                        break;

                    case 3:
                        JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado");
                        break;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite solamente numeros por favor");
            }
        }
        limpiar();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if (validarDatos()) {

            Libro libro = new Libro();
            libro.setCodigo(Integer.parseInt(txtCodigo.getText()));
            libro.setNombre(txtNombre.getText());
            libro.setAutor(txtAutor.getText());
            libro.setAno(Integer.parseInt(txtAno.getText()));
            libro.setPrecio(Double.parseDouble(txtPrecio.getText()));

            int resultado = libroBo.modificar(libro);

            switch (resultado) {
                case 0:
                    JOptionPane.showMessageDialog(null, "EL registro se modifico correctamente");
                    break;

                case 1:
                    JOptionPane.showMessageDialog(null, "No se modifico el registro");
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

    private void tablaLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaLibroMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int fila = tablaLibro.getSelectedRow();
            txtCodigo.setText(tablaLibro.getValueAt(fila, 0).toString());
            txtNombre.setText(tablaLibro.getValueAt(fila, 1).toString());
            txtAutor.setText(tablaLibro.getValueAt(fila, 2).toString());
            txtAno.setText(tablaLibro.getValueAt(fila, 3).toString());
            txtPrecio.setText(tablaLibro.getValueAt(fila, 4).toString());
            txtCodigo.setEnabled(false);
        }
    }//GEN-LAST:event_tablaLibroMouseClicked

    private void btnConsultaCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaCodigoActionPerformed
        // TODO add your handling code here:
        if (txtCodigo.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite el codigo por favor");
        } else {
            try {
                //Limpio la tabla
                this.tablaModelo.setRowCount(0);

                int codigo = Integer.parseInt(txtCodigo.getText());

                Libro libro = new Libro();

                libro = libroBo.consultaCodigo(codigo);

                if (libro.getCodigo() == codigo) {
                    tablaModelo.setRowCount(1);
                } else {
                    tablaModelo.setRowCount(0);
                }

                tablaModelo.setValueAt(libro.getCodigo(), 0, 0);
                tablaModelo.setValueAt(libro.getNombre(), 0, 1);
                tablaModelo.setValueAt(libro.getAutor(), 0, 2);
                tablaModelo.setValueAt(libro.getAno(), 0, 3);
                tablaModelo.setValueAt(libro.getPrecio(), 0, 4);

                tablaLibro.setModel(tablaModelo);

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite solamente numeros por favor");
            }
        }

    }//GEN-LAST:event_btnConsultaCodigoActionPerformed

    private void btnConsultaNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaNombreActionPerformed
        // TODO add your handling code here:
        if (txtNombre.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite el nombre del libro por favor");
        } else {

            List<Libro> listaNombreLibros = new ArrayList();

            listaNombreLibros = libroBo.consultaNombre(txtNombre.getText());

            tablaModelo.setNumRows(listaNombreLibros.size());

            for (int i = 0; i < listaNombreLibros.size(); i++) {
                Libro libro = listaNombreLibros.get(i);
                tablaModelo.setValueAt(libro.getCodigo(), i, 0);
                tablaModelo.setValueAt(libro.getNombre(), i, 1);
                tablaModelo.setValueAt(libro.getAutor(), i, 2);
                tablaModelo.setValueAt(libro.getAno(), i, 3);
                tablaModelo.setValueAt(libro.getPrecio(), i, 4);
            }
            tablaLibro.setModel(tablaModelo);
        }
    }//GEN-LAST:event_btnConsultaNombreActionPerformed

    public void limpiar() {
        txtAno.setText("");
        txtAutor.setText("");
        txtCodigo.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtCodigo.setEnabled(true);
        llenarTabla();
    }

    public DefaultTableModel getTablaModelo() {
        return tablaModelo;
    }

    public void setTablaModelo(DefaultTableModel tablaModelo) {
        this.tablaModelo = tablaModelo;
    }

    public LibroBo getLibroBo() {
        return libroBo;
    }

    public void setLibroBo(LibroBo libroBo) {
        this.libroBo = libroBo;
    }

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
            java.util.logging.Logger.getLogger(MantLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantLibro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnConsultaCodigo;
    private javax.swing.JButton btnConsultaNombre;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaLibro;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
