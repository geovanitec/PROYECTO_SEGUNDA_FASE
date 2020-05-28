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
    private static String db = "NOMINA_SALARIO";
    private static String user = "root";
    private static String password = "compromiso";
    private static String host = "localhost";
    private static String server = "jdbc:mysql://"+ host + "/" +db;
    public void mostrarnomb (){
        
        DefaultTableModel modelo = new DefaultTableModel();
        try{
            

            Connection cn = DriverManager.getConnection(server, user, password);
            PreparedStatement pst = cn.prepareStatement("select * from DATOS_EMPLEADO");
            ResultSet rs = pst.executeQuery();
            
            modelo.addColumn("Id_Emp");
            modelo.addColumn("NombreEmplea");
            modelo.addColumn("CodigoPuesto");
            modelo.addColumn("NombrePuesto");
            modelo.addColumn("CodigoDep");
            modelo.addColumn("NombreDep");

            while(rs.next()){

                int idemp=0,idpuesto=0,iddep;
                String nombreemp = "", nombredep = "", nombrepues="";
                
                idemp = Integer.parseInt(rs.getString("Id_Empleado"));
                nombreemp = String.valueOf(rs.getString("NombreEmpleado"));

                
                Connection cn2 = DriverManager.getConnection(server, user, password);
            PreparedStatement pst2 = cn.prepareStatement("select * from PUESTO");
            ResultSet rs2 = pst2.executeQuery();
            
            while(rs2.next()){
                
                idpuesto = Integer.parseInt(rs2.getString("IdPuesto"));
                nombrepues = String.valueOf(rs2.getString("NombrePuesto"));
                
                
                Connection cn3 = DriverManager.getConnection(server, user, password);
            PreparedStatement pst3 = cn3.prepareStatement("select * from DEPARTAMENTO");
            ResultSet rs3 = pst3.executeQuery();
            
            while(rs3.next()){
                 iddep = Integer.parseInt(rs3.getString("IdDepartamento"));
                nombredep = String.valueOf(rs3.getString("NombreDepartamento"));
                
                
                Object filas[] = {idemp,nombreemp,idpuesto,nombrepues,iddep,nombredep};
                modelo.addRow(filas);
                TablaEmpleados.setModel(modelo);
                
            }
                
               
            
            }
            
            
                
                
                
                
                
                
            }

           // TablaEmpleados.setModel(modelo);

        }catch(Exception e){

        }
        
        
        /*DefaultTableModel modelo = new DefaultTableModel();
      
       
       try{

            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/prueba", "root", "compromiso");
            PreparedStatement pst = cn.prepareStatement("select * from maestros where idmaestro = ?");
            pst.setString(1, txtBuscar.getText().trim());
            
            modelo.addColumn("Nombre");
            modelo.addColumn("Sueldo");
            modelo.addColumn("bonif");
            modelo.addColumn("extra");
            modelo.addColumn("Total");
            modelo.addColumn("Concepto");
            modelo.addColumn("Aplicacion");
            modelo.addColumn("TotalDesc");
            modelo.addColumn("TotalLiq");
            
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                
               String nombremaestro="";
                double S = 0, B = 0, E = 0, T = 0, I = 0, Max = 0, Min = 0, TD = 0, TL = 0;
                    
                nombremaestro = String.valueOf(rs.getString("nombremaestro"));
                S = Double.parseDouble(rs.getString("sueldo"));
                B = Double.parseDouble(rs.getString("bonificacion"));
                E = Double.parseDouble(rs.getString("extraordinario"));
                        
             
                
            }
            
            
        }catch(Exception e){
              JOptionPane.showMessageDialog(null, "Error");
        }*/
        
    }
    
    
String[] NombresColumnas= { "EXCEPCIONES","NombreConcepto","CodigoEmpleado"};
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
    
    String[] Nombres = {"Id_Empleado" ,"CodigoPuesto" ,"CodigoDepartamento" ,"NombreEmpleado"};
    public void Mostrar(String Tabla) {
        String[] columnas = new String[4];
        String query,query2,query3;
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
        try{
            Connection cn = DriverManager.getConnection(Seleccion.BD, Seleccion.Usuario, Seleccion.Contraseña);
            
            PreparedStatement pst = cn.prepareStatement("select NombreEmpleado from  DATOS_EMPLEADO");
            ResultSet rs = pst.executeQuery();
            
            cboxCodigoEmpleado.addItem("Seleccione una opción");
            while(rs.next()){
            cboxCodigoEmpleado.addItem(rs.getString("NombreEmpleado"));
            }
            
           
            
        } catch (Exception e){

        }
        
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
        jLabel4 = new javax.swing.JLabel();
        txtCodigoEx = new javax.swing.JTextField();
        txtNombreEx = new javax.swing.JTextField();
        cboxCodigoEmpleado = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaEmpleados = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, 380, 160));

        lblTabla.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblTabla.setForeground(new java.awt.Color(255, 255, 255));
        lblTabla.setText("TABLAS DE EXCEPCIONES");
        jPanel1.add(lblTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 280, 240, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOMBRE EXCEPCION");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 180, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CODIGO EMPLEADO");
        jLabel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 180, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CODIGO EXCEPCION");
        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 180, 30));

        txtCodigoEx.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        txtCodigoEx.setText("    ");
        txtCodigoEx.setBorder(null);
        jPanel1.add(txtCodigoEx, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 140, 30));

        txtNombreEx.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        txtNombreEx.setText("    ");
        txtNombreEx.setBorder(null);
        jPanel1.add(txtNombreEx, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 140, 30));

        cboxCodigoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxCodigoEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(cboxCodigoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 140, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("TABLA CODIGOS EMPLEADOS");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 240, 20));

        TablaEmpleados.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        TablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(TablaEmpleados);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 470, 160));

        jLabel6.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("APLICACION DE EXCEPCIONES");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 240, 50));

        btnGuardar.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 100, 30));

        btnModificar.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 100, 30));

        btnEliminar.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 100, 30));

        btnBuscar.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 100, 30));

        txtBuscar.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        txtBuscar.setText("   ");
        txtBuscar.setBorder(null);
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 220, 130, 30));

        lb.setText("..");
        jPanel1.add(lb, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, -1, -1));

        lblfondo.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lblfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo3.jpg"))); // NOI18N
        jPanel1.add(lblfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 500));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    
    private void cboxCodigoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxCodigoEmpleadoActionPerformed

          try{
            Connection cn = DriverManager.getConnection(Seleccion.BD, Seleccion.Usuario, Seleccion.Contraseña);
            PreparedStatement pst = cn.prepareStatement("select Id_Empleado from DATOS_EMPLEADO where NombreEmpleado= ?");
            pst.setString(1, cboxCodigoEmpleado.getSelectedItem().toString());

            ResultSet rs = pst.executeQuery();

            if(rs.next()){
                lb.setText(rs.getString("Id_Empleado"));

            } else {

            }

        }catch (Exception e){

        }





// TODO add your handling code here:
    }//GEN-LAST:event_cboxCodigoEmpleadoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        
        
        if ( txtCodigoEx.getText().isEmpty() || txtNombreEx.getText().isEmpty()){

            JOptionPane.showMessageDialog(null, " NO SE PUEDE DEJAR CAMPOS VACIOS");

        }
        else {
            
                
              
                try{
              Connection cn = DriverManager.getConnection(Seleccion.BD, Seleccion.Usuario, Seleccion.Contraseña);
            PreparedStatement pst2 = cn.prepareStatement("insert into EXCEPCIONES values(?,?,?)");
            
            
            pst2.setString(1, txtCodigoEx.getText().trim());
            pst2.setString(2, txtNombreEx.getText().trim());
             pst2.setString(3, lb.getText().trim());
           
            pst2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Registro exitoso");
           
            MostrarDB("EXCEPCIONES");   
           
            
            txtCodigoEx.setText("");
            txtNombreEx.setText("");
            
            
        }catch (Exception e){
            
        }
                

          

        }






// TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

     try {
            String codigo = txtBuscar.getText().trim();

            Connection cn = DriverManager.getConnection(Seleccion.BD, Seleccion.Usuario, Seleccion.Contraseña);
            PreparedStatement pst = cn.prepareStatement("update EXCEPCIONES set IdExcepcion = ? , NombreConcepto= ? , CodigoEmpleado=?  where IdExcepcion = " + codigo);

            pst.setString(1, txtCodigoEx.getText().trim());
            pst.setString(2, txtNombreEx.getText().trim());
            pst.setString(3, lb.getText().trim());
           

            pst.executeUpdate();
              MostrarDB("EXCEPCIONES");  
            JOptionPane.showMessageDialog(this, "MODIFICACION EXITOSA.", "Exito", JOptionPane.INFORMATION_MESSAGE);

          //  btnEliminar.setEnabled(false);
            //btnModificar.setEnabled(false);
            txtCodigoEx.setText("");

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
                txtCodigoEx.setText(rs.getString("IdExcepcion"));
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

             txtCodigoEx.setText("");

            txtNombreEx.setText("");
            lb.setText("");
          
            cboxCodigoEmpleado.setSelectedIndex(0);
            
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en la eliminación de registros.", "Error", JOptionPane.ERROR_MESSAGE);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaEmpleados;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox cboxCodigoEmpleado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lblTabla;
    private javax.swing.JLabel lblfondo;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigoEx;
    private javax.swing.JTextField txtNombreEx;
    // End of variables declaration//GEN-END:variables
}
