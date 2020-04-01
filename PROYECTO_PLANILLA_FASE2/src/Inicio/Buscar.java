/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Geovani
 */
public class Buscar {
    
    public void BuscarPorCodigo(JTable tblBuscar, Definicion_Variables dvariables, Metodos metodos, int intCodigo) {
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        dt.addColumn("Codigo");
        dt.addColumn("Nombre");
        dt.addColumn("Puesto");
        dt.addColumn("Sueldo Ordinario");
        dt.addColumn("Sueldo Extraordinario");
        dt.addColumn("Bonificacion");
        dt.addColumn("Comision");
        dt.addColumn("Otros");
        dt.addColumn("Total Devengado");
        dt.addColumn("IGSS");
        dt.addColumn("ISR");
        dt.addColumn("Anticipos");
        dt.addColumn("Descuentos Judiciales");
        dt.addColumn("Otros Descuentos");
        dt.addColumn("Total Descuentos");
        dt.addColumn("Total Liquido");
        
             
        
                

        //tabla.setDefaultRenderer(Object.class, new imgTabla());

        Object fila[] = new Object[dt.getColumnCount()];
        for (int i = 0; i < metodos.CantidadRegistro(); i++) {
            dvariables = metodos.ObtenerRegistro(i);
             if(dvariables.getIntCodigo() == (intCodigo)){
            fila[0] = dvariables.getIntCodigo();
            fila[1] = dvariables.getStrNombre();
            fila[2] = dvariables.getStrPuesto();
            fila[3] = dvariables.getFltSueldo();
            fila[4] = dvariables.getFltSalarioExtraordinario();
            fila[5] = dvariables.getFltBonificacion();
            fila[6] = dvariables.getFltComision();
            fila[7] = dvariables.getFltOtros();
            fila[8] = dvariables.getFltTotalDevengado();
            fila[9] = dvariables.getFltIgss();
            fila[10] = dvariables.getFltIsr();
            fila[11] = dvariables.getFltAnticipos();
            fila[12] = dvariables.getFltDescuentosJudiciales();
            fila[13] = dvariables.getFltOtrosDescuentos();
            fila[14] = dvariables.getFltTotalDescuentos();
            fila[15] = dvariables.getFltTotalLiquido();
            dt.addRow(fila);
        }else{
            //(producto.getCodigo()  codigo){
                JOptionPane.showMessageDialog(null, "NO EXISTE NINGUN EMPLEADO CON DICHO CODIGO");
                }
        }
        tblBuscar.setModel(dt);
        tblBuscar.setRowHeight(60);
        
        
    }
    
    
    public void BuscarPorNombre(JTable tblBuscar, Definicion_Variables dvariables, Metodos metodos, String strNombre) {
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        dt.addColumn("Codigo");
        dt.addColumn("Nombre");
        dt.addColumn("Puesto");
        dt.addColumn("Sueldo Ordinario");
        dt.addColumn("Sueldo Extraordinario");
        dt.addColumn("Bonificacion");
        dt.addColumn("Comision");
        dt.addColumn("Otros");
        dt.addColumn("Total Devengado");
        dt.addColumn("IGSS");
        dt.addColumn("ISR");
        dt.addColumn("Anticipos");
        dt.addColumn("Descuentos Judiciales");
        dt.addColumn("Otros Descuentos");
        dt.addColumn("Total Descuentos");
        dt.addColumn("Total Liquido");
        
             
        
                

        //tabla.setDefaultRenderer(Object.class, new imgTabla());

        Object fila[] = new Object[dt.getColumnCount()];
        for (int i = 0; i < metodos.CantidadRegistro(); i++) {
            dvariables = metodos.ObtenerRegistro(i);
             if(dvariables.getStrNombre() == (strNombre)){
            fila[0] = dvariables.getIntCodigo();
            fila[1] = dvariables.getStrNombre();
            fila[2] = dvariables.getStrPuesto();
            fila[3] = dvariables.getFltSueldo();
            fila[4] = dvariables.getFltSalarioExtraordinario();
            fila[5] = dvariables.getFltBonificacion();
            fila[6] = dvariables.getFltComision();
            fila[7] = dvariables.getFltOtros();
            fila[8] = dvariables.getFltTotalDevengado();
            fila[9] = dvariables.getFltIgss();
            fila[10] = dvariables.getFltIsr();
            fila[11] = dvariables.getFltAnticipos();
            fila[12] = dvariables.getFltDescuentosJudiciales();
            fila[13] = dvariables.getFltOtrosDescuentos();
            fila[14] = dvariables.getFltTotalDescuentos();
            fila[15] = dvariables.getFltTotalLiquido();
            dt.addRow(fila);
        }else{
            //(producto.getCodigo()  codigo){
                JOptionPane.showMessageDialog(null, "NO EXISTE NINGUN EMPLEADO CON DICHO NOMBRE");
                }
        }
        tblBuscar.setModel(dt);
        tblBuscar.setRowHeight(60);
    }
    
}
