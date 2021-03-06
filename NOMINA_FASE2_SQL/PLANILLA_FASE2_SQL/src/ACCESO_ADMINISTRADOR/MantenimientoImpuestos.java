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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Angel Chacon
 */
public class MantenimientoImpuestos extends javax.swing.JFrame {
    //Variable global
    public static String valor = "";
    

    /**
     * @see  void MostrarDB funcion que nos permite insertar una tabla de contenidos segun seas sus elementos
     */
String[] Nombres = {"IdImpuesto" ,"NombpreConcepto","Porcentaje","maximo","minimo"};
     public void MostrarDB(String Tabla) {
        String[] columnas = new String[5];
        String query;
        try {

            Connection cn = DriverManager.getConnection(Seleccion.BD, Seleccion.Usuario, Seleccion.Contraseña);

            query = "SELECT * FROM " + Tabla;

            PreparedStatement consulta = cn.prepareStatement(query);
            ResultSet resultado = consulta.executeQuery();
            DefaultTableModel md = new DefaultTableModel(null, Nombres);

            while (resultado.next()) {
                for (int i = 0; i < 5; i++) {
                    columnas[i] = resultado.getString(Nombres[i]);
                }
                md.addRow(columnas);

            }
            table.setModel(md);

        } catch (Exception err) {
            err.printStackTrace();
        }
    
     }
    /**
     * Creates new form MantenimientoImpuestos
     */
    public MantenimientoImpuestos() {
        
        initComponents();
        MostrarDB("IMPUESTO");
        MantenimientoConceptos object = new MantenimientoConceptos();
        txtNombre.setText(object.NombreConcepto);
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
        btnBuscar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        btn_Modificar = new javax.swing.JButton();
        btn_Guardar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtValMax = new javax.swing.JTextField();
        txtValMin = new javax.swing.JTextField();
        txtPorcentaje = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 82, 30));

        btn_Eliminar.setText("ELIMNAR");
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 86, 31));

        btn_Modificar.setText("MODIFICAR");
        btn_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, 31));

        btn_Guardar.setText("GUARDAR");
        btn_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 91, 31));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 120, 30));
        jPanel1.add(txtValMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 120, 30));
        jPanel1.add(txtValMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, 130, 30));
        jPanel1.add(txtPorcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 90, 30));
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 100, 30));

        txtId.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 110, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Valor Min.");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 70, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nombre");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 50, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Valor Max.");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 70, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Porcentaje");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 70, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ingrese id impuesto");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 145, 130, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Id");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 20, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("INGRESO IMPUESTOS:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(table);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 660, 250));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo3.jpg"))); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 570));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    /**
     * 
     * @param evt funcion que permite ingresar un impouesto al sistema
     */
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        try{
            Connection cn = DriverManager.getConnection(Seleccion.BD, Seleccion.Usuario, Seleccion.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select * from IMPUESTO where IdImpuesto = ?");
            pst.setString(1, txtBuscar.getText().trim());

            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                txtId.setText(rs.getString("IdImpuesto"));
                txtNombre.setText(rs.getString("NombpreConcepto"));
                txtPorcentaje.setText(rs.getString("Porcentaje"));
                txtValMax.setText(rs.getString("maximo"));
                txtValMin.setText(rs.getString("minimo"));

            } else {
                JOptionPane.showMessageDialog(null, "Impuesto no registrado.");
                txtBuscar.setText("");
            }

        }catch (Exception e){

        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    
    /**
     * 
     * @param evt funcion que permite eliminar un impuesto que ya fue creado
     */
    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
        // TODO add your handling code here:

        try {
            Connection cn = DriverManager.getConnection(Seleccion.BD, Seleccion.Usuario, Seleccion.Contraseña);
            PreparedStatement pst = cn.prepareStatement("delete from IMPUESTO where IdImpuesto = ?");

            pst.setString(1, txtBuscar.getText().trim());
            pst.executeUpdate();

            txtId.setText("");
            txtNombre.setText("");
            txtPorcentaje.setText("");
            txtValMax.setText("");
            txtValMin.setText("");
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            MostrarDB("IMPUESTO");
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_EliminarActionPerformed

    
    /**
     * 
     * @param evt funcion que permite modigicar los impuestos 
     */
    private void btn_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModificarActionPerformed
        // TODO add your handling code here:

        try {
            String IdPuesto = txtBuscar.getText().trim();

            Connection cn = DriverManager.getConnection(Seleccion.BD, Seleccion.Usuario, Seleccion.Contraseña);
            PreparedStatement pst = cn.prepareStatement("update IMPUESTO set IdImpuesto = ?,NombpreConcepto = ?,Porcentaje = ?,maximo = ?,minimo = ? where IdImpuesto = " + IdPuesto);

            pst.setString(1, txtId.getText().trim());
            pst.setString(2, txtNombre.getText().trim());
            pst.setString(3, txtPorcentaje.getText().trim());
            pst.setString(4, txtValMax.getText().trim());
            pst.setString(5, txtValMin.getText().trim());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Registro Modificado");
            MostrarDB("IMPUESTO");
            txtId.setText("");
            txtNombre.setText("");
            txtPorcentaje.setText("");
            txtValMax.setText("");
            txtValMin.setText("");

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_ModificarActionPerformed

    
    /**
     * 
     * @param evt Funcion que permite guardar un impuesto en nuestra planilla
     */
    
    private void btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GuardarActionPerformed
        // TODO add your handling code here:

        valor = txtPorcentaje.getText();
        
        if ( txtId.getText().isEmpty() || txtNombre.getText().isEmpty() || txtPorcentaje.getText().isEmpty() || txtValMax.getText().isEmpty() || txtValMin.getText().isEmpty()){

            JOptionPane.showMessageDialog(null, " NO SE PUEDE DEJAR CAMPO VACIO");

        }
        else {

            try{
                Connection cn = DriverManager.getConnection(Seleccion.BD, Seleccion.Usuario, Seleccion.Contraseña);
                PreparedStatement pst2 = cn.prepareStatement("insert into IMPUESTO values(?,?,?,?,?)");

                pst2.setString(1, txtId.getText().trim());
                pst2.setString(2, txtNombre.getText().trim());
                pst2.setString(3, txtPorcentaje.getText().trim());
                pst2.setString(4, txtValMax.getText().trim());
                pst2.setString(5, txtValMin.getText().trim());
                pst2.executeUpdate();

                JOptionPane.showMessageDialog(null, "Registro exitoso");
                MostrarDB("IMPUESTO");
                txtId.setText("");
                txtNombre.setText("");
                txtPorcentaje.setText("");
                txtValMax.setText("");
                txtValMin.setText("");

                this.dispose();
                
            }catch (Exception e){

            }

        }
        
        
    }//GEN-LAST:event_btn_GuardarActionPerformed

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
            java.util.logging.Logger.getLogger(MantenimientoImpuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenimientoImpuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenimientoImpuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenimientoImpuestos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenimientoImpuestos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Guardar;
    private javax.swing.JButton btn_Modificar;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPorcentaje;
    private javax.swing.JTextField txtValMax;
    private javax.swing.JTextField txtValMin;
    // End of variables declaration//GEN-END:variables
}
