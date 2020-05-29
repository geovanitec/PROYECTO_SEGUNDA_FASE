/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACCESO_ADMINISTRADOR;

import PLANILLA_FASE2.Seleccion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Geovani
 */
public class AplicacionExcepciones extends javax.swing.JInternalFrame {

    
/**
 * @param void funcion que permite ingresarle informacion o datos a una tabla de contenido
 */
    public void mostrarnomb() {

        DefaultTableModel modelo = new DefaultTableModel();
        try {

            Connection cn = DriverManager.getConnection(Seleccion.BD, Seleccion.Usuario, Seleccion.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from DATOS_EMPLEADO");
            ResultSet rs = pst.executeQuery();

            modelo.addColumn("Id_Empleado");
            modelo.addColumn("NombreEmpleado");
            modelo.addColumn("CodigoPuesto");
            modelo.addColumn("NombrePuesto");
            modelo.addColumn("CodigoDepartamento");
            modelo.addColumn("NombreDepartamento");

            while (rs.next()) {

                int idemp = 0, idpuesto = 0, iddep;
                String nombreemp = "", nombredep = "", nombrepues = "";

                idemp = Integer.parseInt(rs.getString("Id_Empleado"));
                nombreemp = String.valueOf(rs.getString("NombreEmpleado"));

                Connection cn2 = DriverManager.getConnection(Seleccion.BD, Seleccion.Usuario, Seleccion.Contraseña);
                PreparedStatement pst2 = cn.prepareStatement("select * from PUESTO");
                ResultSet rs2 = pst2.executeQuery();

                while (rs2.next()) {

                    idpuesto = Integer.parseInt(rs2.getString("IdPuesto"));
                    nombrepues = String.valueOf(rs2.getString("NombrePuesto"));

                    Connection cn3 = DriverManager.getConnection(Seleccion.BD, Seleccion.Usuario, Seleccion.Contraseña);
                    PreparedStatement pst3 = cn3.prepareStatement("select * from DEPARTAMENTO");
                    ResultSet rs3 = pst3.executeQuery();

                    while (rs3.next()) {
                        iddep = Integer.parseInt(rs3.getString("IdDepartamento"));
                        nombredep = String.valueOf(rs3.getString("NombreDepartamento"));

                        Object filas[] = {idemp, nombreemp, idpuesto, nombrepues, iddep, nombredep};
                        modelo.addRow(filas);
                        TablaEmpleados.setModel(modelo);

                    }

                }

            }

            // TablaEmpleados.setModel(modelo);
        } catch (Exception e) {

        }

      
    }

    String[] NombresColumnas = {"IdExcepcion", "NombreConcepto", "CodigoEmpleado"};

    public void MostrarDB(String Tabla) {

        String[] columnas = new String[3];
        String query;
        try {

            Connection cn = DriverManager.getConnection(Seleccion.BD, Seleccion.Usuario, Seleccion.Contraseña);

            query = "SELECT * FROM " + Tabla;

            PreparedStatement consulta = cn.prepareStatement(query);
            ResultSet resultado = consulta.executeQuery();
            DefaultTableModel md = new DefaultTableModel(null, NombresColumnas);

            while (resultado.next()) {
                for (int i = 0; i < 3; i++) {
                    columnas[i] = resultado.getString(NombresColumnas[i]);
                }
                md.addRow(columnas);

            }
            table.setModel(md);

        } catch (Exception err) {
            err.printStackTrace();
        }

    }

    String[] Nombres = {"Id_Empleado", "CodigoPuesto", "CodigoDepartamento", "NombreEmpleado"};

    public void Mostrar(String Tabla) {
        String[] columnas = new String[4];
        String query, query2, query3;
        try {

            Connection cn = DriverManager.getConnection(Seleccion.BD, Seleccion.Usuario, Seleccion.Contraseña);

            query = "SELECT * FROM " + Tabla;
            /*query2 = "SELECT NombrePuesto FROM PUESTO where IdPuesto = ?";
             query3 = "SELECT NombreDepartamento FROM DEPARTAMENTO where IdDepartamento = ?";*/

            PreparedStatement consulta = cn.prepareStatement(query);
            ResultSet resultado = consulta.executeQuery();
            DefaultTableModel md = new DefaultTableModel(null, Nombres);
            // PreparedStatement cPuesto = cn.prepareStatement(query2);
            // PreparedStatement cDepto = cn.prepareStatement(query3);

            while (resultado.next()) {
                for (int i = 0; i < 4; i++) {
                    columnas[i] = resultado.getString(Nombres[i]);
                }
                md.addRow(columnas);
                  //ResultSet rPuesto = cPuesto.executeQuery();
                // ResultSet rDepto = cDepto.executeQuery();

               // while (rPuesto.next()) {
                //    columnas[1] = rPuesto.getString("NombrePuesto");
                // while (rDepto.next()) {
                //    columnas[2] = rDepto.getString("NombreDepartamento");
                //  }
            }
            //TablaEmpleados.setModel(md);
            mostrarnomb();

        } catch (Exception err) {
            err.printStackTrace();
        }

    }

    /**
     * Creates new form AplicacionExcepciones
     */
    public AplicacionExcepciones() {
        initComponents();
        MantenimientoConceptos object = new MantenimientoConceptos();
        txtNombreEx.setText(object.NombreConcepto);
        //table.setVisible(false);
        //lblTabla.setVisible(false);
        mostrarnomb();

        MostrarDB("EXCEPCIONES");
        Mostrar("DATOS_EMPLEADO");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        lblTabla = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombreEx = new javax.swing.JTextField();
        cboxCodigoEmpleado = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaEmpleados = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbxFormaIngreso = new javax.swing.JComboBox();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        lb = new javax.swing.JLabel();
        lblfondo = new javax.swing.JLabel();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setAutoscrolls(true);
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 390, 160));

        lblTabla.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblTabla.setForeground(new java.awt.Color(255, 255, 255));
        lblTabla.setText("TABLAS DE EXCEPCIONES");
        jPanel1.add(lblTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 320, 240, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOMBRE EXCEPCION");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 180, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("FORMA DE INGRESO:");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 190, 30));

        txtNombreEx.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        txtNombreEx.setText("    ");
        txtNombreEx.setBorder(null);
        jPanel1.add(txtNombreEx, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 180, 30));

        cboxCodigoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxCodigoEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(cboxCodigoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 180, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TABLA CODIGOS EMPLEADOS");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 240, 20));

        TablaEmpleados.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        TablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(TablaEmpleados);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 550, 160));

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("APLICACION DE EXCEPCIONES");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 240, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CODIGO ");
        jLabel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 190, 30));

        cbxFormaIngreso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione Opcion", "CodigoEmpleado", "CodigoPuesto" }));
        cbxFormaIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFormaIngresoActionPerformed(evt);
            }
        });
        jPanel1.add(cbxFormaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 180, 30));

        btnGuardar.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 100, 30));

        btnModificar.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 100, 30));

        btnEliminar.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 100, 30));

        btnBuscar.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 100, 30));

        txtBuscar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        txtBuscar.setText("   ");
        txtBuscar.setBorder(null);
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, 130, 30));

        lb.setText("..");
        jPanel1.add(lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 20, -1));

        lblfondo.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo3.jpg"))); // NOI18N
        jPanel1.add(lblfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 730));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void cboxCodigoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxCodigoEmpleadoActionPerformed

        try {
            Connection cn = DriverManager.getConnection(Seleccion.BD, Seleccion.Usuario, Seleccion.Contraseña);

            if (cbxFormaIngreso.getSelectedIndex() == 1) {
                PreparedStatement pst = cn.prepareStatement("select Id_Empleado from DATOS_EMPLEADO where NombreEmpleado= ?");
                pst.setString(1, cboxCodigoEmpleado.getSelectedItem().toString());

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    lb.setText(rs.getString("Id_Empleado"));

                }

            } else if (cbxFormaIngreso.getSelectedIndex() == 2) {
                PreparedStatement pst = cn.prepareStatement("select IdPuesto from PUESTO where NombrePuesto= ?");
                pst.setString(1, cboxCodigoEmpleado.getSelectedItem().toString());

                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    lb.setText(rs.getString("IdPuesto"));

                }
            }
            {

            }

        } catch (Exception e) {
            System.out.println(e);
        }

// TODO add your handling code here:
    }//GEN-LAST:event_cboxCodigoEmpleadoActionPerformed
/**
 * 
 * @param void funcion que permite crear una excepcion de la tabla conceptos
 * 
 */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (txtNombreEx.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, " NO SE PUEDE DEJAR CAMPOS VACIOS");

        } else {

            try {
                Connection cn = DriverManager.getConnection(Seleccion.BD, Seleccion.Usuario, Seleccion.Contraseña);
                PreparedStatement pst2 = cn.prepareStatement("insert into EXCEPCIONES values(?,?,?)");

                if (cbxFormaIngreso.getSelectedIndex() == 1) {
                    pst2.setString(1, "0");
                    pst2.setString(2, txtNombreEx.getText().trim());
                    pst2.setString(3, lb.getText().trim());

                    pst2.executeUpdate();
                     MostrarDB("EXCEPCIONES");
                      JOptionPane.showMessageDialog(null, "Registro exitoso");
                  

                   

                } else if (cbxFormaIngreso.getSelectedIndex() == 2) {

                    PreparedStatement pst3 = cn.prepareStatement("select * from DATOS_EMPLEADO where CodigoPuesto =?");
                    pst3.setString(1, lb.getText().trim());
                    ResultSet rs = pst3.executeQuery();
                    while(rs.next()){
                        
                        pst2.setString(1, "0");
                        pst2.setString(2, txtNombreEx.getText().trim());
                        pst2.setString(3, rs.getString("Id_Empleado"));

                        pst2.executeUpdate();
                    
                      
                    }
                      JOptionPane.showMessageDialog(null, "Registro exitoso");
                    
                }

                
                txtNombreEx.setText("");
                this.dispose();
            } catch (Exception e) {
                 System.out.println(e);
            }

        }

// TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        try {
            String codigo = txtBuscar.getText().trim();

            Connection cn = DriverManager.getConnection(Seleccion.BD, Seleccion.Usuario, Seleccion.Contraseña);
            PreparedStatement pst = cn.prepareStatement("update EXCEPCIONES set IdExcepcion = ? , NombreConcepto= ? , CodigoEmpleado=?  where IdExcepcion = " + codigo);

            pst.setString(1, "0");
            pst.setString(2, txtNombreEx.getText().trim());
            pst.setString(3, lb.getText().trim());

            pst.executeUpdate();
            MostrarDB("EXCEPCIONES");
            JOptionPane.showMessageDialog(this, "MODIFICACION EXITOSA.", "Exito", JOptionPane.INFORMATION_MESSAGE);

            //  btnEliminar.setEnabled(false);
            //btnModificar.setEnabled(false);
            

            txtNombreEx.setText("");
            lb.setText("");

            cboxCodigoEmpleado.setSelectedIndex(0);

            txtBuscar.setText("");

        } catch (Exception e) {
            System.out.println(e);
        }

// TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String buscar = txtBuscar.getText().trim();
        if (buscar.isEmpty()) {
            JOptionPane.showMessageDialog(this, "¡No se ingreso el campo de busqueda!", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            Connection cn = DriverManager.getConnection(Seleccion.BD, Seleccion.Usuario, Seleccion.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from EXCEPCIONES where IdExcepcion = ?");
            pst.setString(1, txtBuscar.getText().trim());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                
                txtNombreEx.setText(rs.getString("NombreConcepto"));
                lb.setText(rs.getString("CodigoEmpleado"));

                //btnEliminar.setEnabled(true);
                //btnModificar.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, " no registrado.");
            }

            PreparedStatement pst1 = cn.prepareStatement("select NombreEmpleado from DATOS_EMPLEADO where Id_Empleado=?");
            pst1.setString(1, lb.getText().trim());
            ResultSet rs1 = pst1.executeQuery();

            while (rs1.next()) {
                cboxCodigoEmpleado.setSelectedItem(rs1.getString("NombreEmpleado"));
            }

        } catch (Exception err) {
            err.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            Connection cn = DriverManager.getConnection(Seleccion.BD, Seleccion.Usuario, Seleccion.Contraseña);
            PreparedStatement pst = cn.prepareStatement("delete from EXCEPCIONES where IdExcepcion = ?");

            pst.setString(1, txtBuscar.getText().trim());
            pst.executeUpdate();
            MostrarDB("EXCEPCIONES");
            txtBuscar.setText("");

            JOptionPane.showMessageDialog(this, "REGISTRO ELIMINADO.", "Exito", JOptionPane.INFORMATION_MESSAGE);
            // btnEliminar.setEnabled(false);
            //btnModificar.setEnabled(false);

            

            txtNombreEx.setText("");
            lb.setText("");

            cboxCodigoEmpleado.setSelectedIndex(0);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en la eliminación de registros.", "Error", JOptionPane.ERROR_MESSAGE);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cbxFormaIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFormaIngresoActionPerformed
        // TODO add your handling code here:

        if (cbxFormaIngreso.getSelectedIndex() == 1) {
            try {
                Connection cn = DriverManager.getConnection(Seleccion.BD, Seleccion.Usuario, Seleccion.Contraseña);

                PreparedStatement pst = cn.prepareStatement("select NombreEmpleado from  DATOS_EMPLEADO");
                ResultSet rs = pst.executeQuery();
                cboxCodigoEmpleado.removeAllItems();
                cboxCodigoEmpleado.addItem("Seleccione opcion");
                while (rs.next()) {
                    cboxCodigoEmpleado.addItem(rs.getString("NombreEmpleado"));
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (cbxFormaIngreso.getSelectedIndex() == 2) {
            try {
                Connection cn = DriverManager.getConnection(Seleccion.BD, Seleccion.Usuario, Seleccion.Contraseña);

                PreparedStatement pst = cn.prepareStatement("select NombrePuesto from  PUESTO");
                ResultSet rs = pst.executeQuery();
                
                cboxCodigoEmpleado.removeAllItems();
                
                while (rs.next()) {
                    cboxCodigoEmpleado.addItem(rs.getString("NombrePuesto"));
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "NO HA ELEGIDO TIPO DE INGRESO");
        }
    }//GEN-LAST:event_cbxFormaIngresoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaEmpleados;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox cboxCodigoEmpleado;
    private javax.swing.JComboBox cbxFormaIngreso;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lblTabla;
    private javax.swing.JLabel lblfondo;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtNombreEx;
    // End of variables declaration//GEN-END:variables
}
