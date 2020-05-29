/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACCESO_USUARIOS;

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
public class ConsultaPuestos extends javax.swing.JInternalFrame {

   
            
          
    /**
     * Creates new form ConsultaPuestos
     */
    public ConsultaPuestos() {
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPuestos = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        txtMostrar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        foto = new javax.swing.JLabel();

        setBackground(new java.awt.Color(153, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("CONSULTAPUESTOS");
        setToolTipText("");
        setVisible(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblPuestos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblPuestos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 470, 240));

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 177, 33));

        txtMostrar.setText("MOSTRAR");
        txtMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMostrarActionPerformed(evt);
            }
        });
        jPanel1.add(txtMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 137, 33));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("\n Esta consulta nos permite\n acceder a nuestra base de \n datos y conocer cuales son \n los puestos que tenemos \n ingresados\n");
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 250, 150));

        foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo3.jpg"))); // NOI18N
        jPanel1.add(foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 850, 530));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 840, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * 
 * @param void funcion que permite buscar los datos de los impuestos segun sean buscados
 */
    private void txtMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMostrarActionPerformed

         DefaultTableModel modelo = new DefaultTableModel();
        
        try{
                        
      Connection cn = DriverManager.getConnection(Seleccion.BD, Seleccion.Usuario, Seleccion.Contraseña);
        PreparedStatement pst2 = cn.prepareStatement("select * from PUESTO where IdPuesto= ?");
        pst2.setString(1, txtBuscar.getText().trim());
        
        ResultSet rs2 = pst2.executeQuery();
        
        ResultSetMetaData rsMd = rs2.getMetaData();
        int cantidadcol = rsMd.getColumnCount();
        
        modelo.addColumn("IdPuesto");
        modelo.addColumn("NombrePuesto");
        
        
           if( rs2.next()){
                
                Object[] filas = new Object[cantidadcol];
                
                for(int i=0; i<cantidadcol; i++){
                    
                    filas[i] = rs2.getObject(i+1);
                    
                }
                
                modelo.addRow(filas);
          
          
            tblPuestos.setModel(modelo);
         
           }else 
           {
               JOptionPane.showMessageDialog(null, "CODIGO NO REGISTRADO");
              txtBuscar.setText("");
           }
           
        }catch(Exception e){
       
            
        }



// TODO add your handling code here:
    }//GEN-LAST:event_txtMostrarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel foto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable tblPuestos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JButton txtMostrar;
    // End of variables declaration//GEN-END:variables
}
