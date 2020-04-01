/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import Otros.Limpiar_datos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Geovani
 */
public class INGRESO_PLANILLA extends javax.swing.JFrame {
 Limpiar_datos Ldatos = new Limpiar_datos();
float FltTotalDevengado;
float FltTotalDescuento;
float FltTotalliquido;
float igss, isr;

    private String ruta_txt = "DatosPlanilla.txt";

  Definicion_Variables dvariables;
   Metodos metodos;

    int clic_tabla;
    /**
     * Creates new form INGRESO_PLANILLA
     */
    public INGRESO_PLANILLA() {
        initComponents();
        metodos = new Metodos();

        try {
            Cargar_txt();
            ListarRegistro();
        } catch (Exception ex) {
            mensaje("No existe el archivo txt");
        }

        jrbFiltrarPorCodigo.setSelected(true);
    }
    
     public void Cargar_txt() {
        File ruta = new File(ruta_txt);
        try {

            FileReader Freader = new FileReader(ruta);
            BufferedReader Breader = new BufferedReader(Freader);

            String linea = null;
            while ((linea = Breader.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(linea, ",");
                dvariables = new Definicion_Variables();
                dvariables .setIntCodigo(Integer.parseInt(st.nextToken()));
                dvariables .setStrNombre(st.nextToken());
                dvariables .setStrPuesto(st.nextToken());
                  dvariables .setFltSueldo(Float.parseFloat(st.nextToken()));
                   dvariables .setFltSalarioExtraordinario(Float.parseFloat(st.nextToken()));
                    dvariables .setFltBonificacion(Float.parseFloat(st.nextToken()));
                     dvariables .setFltComision(Float.parseFloat(st.nextToken()));
                 dvariables .setFltOtros(Float.parseFloat(st.nextToken()));
                 dvariables.setFltTotalDevengado(Float.parseFloat(st.nextToken()));
                 dvariables.setFltIgss(Float.parseFloat(st.nextToken()));
                 dvariables.setFltIsr(Float.parseFloat(st.nextToken()));
                  dvariables .setFltAnticipos(Float.parseFloat(st.nextToken()));
                  dvariables .setFltDescuentosJudiciales(Float.parseFloat(st.nextToken()));
                   dvariables .setFltOtrosDescuentos(Float.parseFloat(st.nextToken()));
                   dvariables.setFltTotalDescuentos(Float.parseFloat(st.nextToken()));
               dvariables.setFltTotalLiquido(Float.parseFloat(st.nextToken()));
                metodos.AgregarRegistro(dvariables);
            }
            Breader.close();
        } catch (Exception ex) {
            mensaje("Error al cargar archivo: " + ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }
    
    
    /*
    *
    *
    */

    public void Grabar_txt() {
        FileWriter Fwriter;
        PrintWriter Pwriter;
        try {
            Fwriter = new FileWriter(ruta_txt);
            Pwriter = new PrintWriter(Fwriter);

            for (int i = 0; i < metodos.CantidadRegistro(); i++) {
                dvariables = metodos.ObtenerRegistro(i);
                Pwriter.println(String.valueOf(dvariables.getIntCodigo() + ", " + dvariables.getStrNombre() + ", " +dvariables.getStrPuesto() + ", " + dvariables.getFltSueldo()
                + ", " +dvariables.getFltSalarioExtraordinario() +  ", " + dvariables.getFltBonificacion() + ", " + dvariables.getFltComision() + ", "+ dvariables.getFltOtros()
                + ", " + dvariables.getFltTotalDevengado() + ", " +  dvariables.getFltIgss() + ", " + dvariables.getFltIsr() + ", " +dvariables.getFltAnticipos()+ ", " 
                        + dvariables.getFltDescuentosJudiciales() + ", " + dvariables.getFltOtrosDescuentos() + ", " + dvariables.getFltTotalDescuentos() + ", " 
                        + dvariables.getFltTotalLiquido()));
            }
            Pwriter.close();

        } catch (Exception ex) {
            mensaje("Error al grabar archivo: " + ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }
    
    
    
    
    /*
    *
    *
    */
    
     public void IngresarRegistro(File ruta) {
        try {
             if (LeerintCodigo() == -666) {
                mensaje("Ingresar codigo entero");
            } else if (LeerstrNombre() == null) {
                mensaje("Ingresar Nombre");
            } else if (LeerstrPuesto() == null) {
                mensaje("Ingresar Puesto");
            } else if (LeerfltSueldo() == -666) {
                mensaje("Ingresar Salario Ordinario");
                 } else if (LeerfltSalarioExtraordinario() == -666) {
                mensaje("Ingresar SalarioExtraordinario");
             } else if (LeerfltBonificacion() == -666) {
                mensaje("Ingresar Bonificacion");   
                 } else if (LeerfltComision() == -666) {
                mensaje("Ingresar Comision");  
               } else if (LeerfltOtros() == -666) {
                mensaje("Ingresar Otros"); 
                 }else if (LeerfltAnticipos() == -666) {
                mensaje("Ingresar Anticipos"); 
                 } else if (LeerfltDescuentosJudiciales() == -666) {
                mensaje("Ingresar Descuentos Judiciales"); 
                 } else if (LeerfltOtrosDescuentos() == -666) {
                mensaje("Ingresar Otros Descuentos"); 
                } else {
                     
            
                     
                     
                     
                     
                     
                dvariables = new Definicion_Variables(LeerintCodigo(), LeerstrNombre(),LeerstrPuesto(),LeerfltSueldo(),LeerfltSalarioExtraordinario(),LeerfltBonificacion(),LeerfltComision(),LeerfltOtros()
                 , LeerfltTotalDev()  , LeerfltIgss(), LeerfltIsr(), LeerfltAnticipos(),LeerfltDescuentosJudiciales(),LeerfltOtrosDescuentos(), LeerfltTotaldes(), LeerfltTotalliq());
                if (metodos.BuscaCodigo(dvariables.getIntCodigo()) != -1) {
                    mensaje("Este codigo ya existe");
                } else {
                    metodos.AgregarRegistro(dvariables);
                }

                Grabar_txt();
                ListarRegistro();
                Ldatos.Limpiar_texto(panel);
            }
        } catch (Exception ex) {
            mensaje(ex.getMessage());
        }
    }
    
     public void ModificarRegistro(File ruta) {
        try {
            if (LeerintCodigo() == -666) {
                mensaje("Ingresar codigo entero");
            } else if (LeerstrNombre() == null) {
                mensaje("Ingresar Nombre");
            } else if (LeerstrPuesto() == null) {
                mensaje("Ingresar Puesto");
            } else if (LeerfltSueldo() == -666) {
                mensaje("Ingresar Salario Ordinario");
                 } else if (LeerfltSalarioExtraordinario() == -666) {
                mensaje("Ingresar SalarioExtraordinario");
             } else if (LeerfltBonificacion() == -666) {
                mensaje("Ingresar Bonificacion");   
                 } else if (LeerfltComision() == -666) {
                mensaje("Ingresar Comision");  
               } else if (LeerfltOtros() == -666) {
                mensaje("Ingresar Totdev"); 
                 } else if (LeerfltTotalDev() == -666) {
                mensaje("Ingresar Igss"); 
                 }else if (LeerfltIgss() == -666) {
                mensaje("Ingresar isr"); 
                 }else if (LeerfltIsr() == -666) {
                mensaje("Ingresar otros"); 
                 }else if (LeerfltAnticipos() == -666) {
                mensaje("Ingresar Anticipos"); 
                 } else if (LeerfltDescuentosJudiciales() == -666) {
                mensaje("Ingresar Descuentos Judiciales"); 
                 } else if (LeerfltOtrosDescuentos() == -666) {
                mensaje("Ingresar Otros Descuentos"); 
                } else if (LeerfltTotaldes() == -666) {
                mensaje("Ingresar total descuentos");
                } else if (LeerfltTotalliq() == -666) {
                mensaje("Ingresar total liquido");
                
                
            } else {
                     
                     
                int intCodigo = metodos.BuscaCodigo(LeerintCodigo());
                dvariables = new Definicion_Variables(LeerintCodigo(),LeerstrNombre(),LeerstrPuesto(),LeerfltSueldo(),LeerfltSalarioExtraordinario(),LeerfltBonificacion(),LeerfltComision(),LeerfltOtros()
                , LeerfltTotalDev()  , LeerfltIgss(), LeerfltIsr(),LeerfltAnticipos(),LeerfltDescuentosJudiciales(),LeerfltOtrosDescuentos(), LeerfltTotaldes(), LeerfltTotalliq());

                if (intCodigo == -1) {
                    metodos.AgregarRegistro(dvariables);
                } else {
                    metodos.ModificarRegistro(intCodigo,dvariables);
                }

                Grabar_txt();
                ListarRegistro();
                Ldatos.Limpiar_texto(panel);
            }
        } catch (Exception ex) {
            mensaje(ex.getMessage());
        }
    }
    
     
     
      public void EliminarRegistro() {
        try {
            if (LeerintCodigo() == -666) {
                mensaje("Ingrese codigo entero");
            } else {
                int intCodigo = metodos.BuscaCodigo(LeerintCodigo());
                if (intCodigo == -1) {
                    mensaje("codigo no existe");
                } else {
                    int s = JOptionPane.showConfirmDialog(null, "ESTA SEGURO DE DAR DE BAJA AL EMPLEADO", "Si/No", 0);
                    if (s == 0) {
                        metodos.EliminarRegistro(intCodigo);

                        Grabar_txt();
                        ListarRegistro();
                        Ldatos.Limpiar_texto(panel);
                    }
                }

            }
        } catch (Exception ex) {
            mensaje(ex.getMessage());
        }
    }
     
     public void ListarRegistro() {
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
            
        }
        tabla.setModel(dt);
        tabla.setRowHeight(60);
        
       
        
    }
     
     
     
      public int LeerintCodigo() {
        try {
            int intCodigo = Integer.parseInt(txtCodigo.getText().trim());
            return intCodigo;
        } catch (Exception ex) {
            return -666;
        }
    }

    public String LeerstrNombre() {
        try {
            String  LeerstrNombre = txtNombre.getText().trim().replace(" ", "_");
            
            return  LeerstrNombre;
        } catch (Exception ex) {
            return null;
        }
    }
    
    public String LeerstrPuesto() {
        try {
            String strPuesto = txtPuesto.getText().trim().replace(" ", "_");
            return strPuesto;
        } catch (Exception ex) {
            return null;
        }
    }

    public float LeerfltSueldo() {
        try {
            float fltSueldo = Float.parseFloat(txtSueldo.getText().trim());
            return fltSueldo;
        } catch (Exception ex) {
            return -666;
        }
    }

    
    public float LeerfltSalarioExtraordinario() {
        try {
            float fltSalarioExtraordinario = Float.parseFloat(txtSalarioExtraordinario.getText().trim());
            return fltSalarioExtraordinario;
        } catch (Exception ex) {
            return -666;
        }
    }
    
    public float LeerfltBonificacion() {
        try {
            float fltBonificacion = Float.parseFloat(txtBonificacion.getText().trim());
            return fltBonificacion;
        } catch (Exception ex) {
            return -666;
        }
    }
    
    public float LeerfltComision() {
        try {
            float fltComision = Float.parseFloat(txtComision.getText().trim());
            return fltComision;
        } catch (Exception ex) {
            return -666;
        }
    }
    
     public float LeerfltOtros() {
        try {
            float fltOtros = Float.parseFloat(txtOtros.getText().trim());
            return fltOtros;
        } catch (Exception ex) {
            return -666;
        }
    }
     
     
public float LeerfltTotalDev() {
        try {
            
            float Fltse=0, Fltsu=0, Fltbf=0, Fltcs=0, Fltos=0;
            
            Fltsu = Float.parseFloat(txtSueldo.getText().trim());
            Fltse = Float.parseFloat(txtSalarioExtraordinario.getText().trim());
            Fltbf = Float.parseFloat(txtBonificacion.getText().trim());
            Fltcs = Float.parseFloat(txtComision.getText().trim());
            Fltos = Float.parseFloat(txtOtros.getText().trim());
            
            FltTotalDevengado = Fltsu + Fltse + Fltbf + Fltcs + Fltos;
            
            return FltTotalDevengado;
        } catch (Exception ex) {
            return -666;
        }
    }



    public float LeerfltIgss() {
        try {
           
            float Fltse=0, Fltsu=0, Fltbf=0, Fltcs=0, Fltos=0;
            
            Fltsu = Float.parseFloat(txtSueldo.getText().trim());
            Fltse = Float.parseFloat(txtSalarioExtraordinario.getText().trim());
            Fltbf = Float.parseFloat(txtBonificacion.getText().trim());
            Fltcs = Float.parseFloat(txtComision.getText().trim());
            Fltos = Float.parseFloat(txtOtros.getText().trim());
            
            FltTotalDevengado = Fltsu + Fltse + Fltbf + Fltcs + Fltos;
            
            
            float Fltigss=0;
            
            if(FltTotalDevengado  == 6000) {
                
                Fltigss = FltTotalDevengado * 0.0483f;
                
            }else{
                
                if(FltTotalDevengado  > 6000) {
                
                Fltigss = FltTotalDevengado * 0.0483f;
                
                }
                    
                    
            }
            
            
            
            
            return Fltigss;
            
        } catch (Exception ex) {
            return -666;
        }
    }
    
    public float LeerfltIsr() {
        try {
           float Fltse=0, Fltsu=0, Fltbf=0, Fltcs=0, Fltos=0;
            
            Fltsu = Float.parseFloat(txtSueldo.getText().trim());
            Fltse = Float.parseFloat(txtSalarioExtraordinario.getText().trim());
            Fltbf = Float.parseFloat(txtBonificacion.getText().trim());
            Fltcs = Float.parseFloat(txtComision.getText().trim());
            Fltos = Float.parseFloat(txtOtros.getText().trim());
            
            FltTotalDevengado = Fltsu + Fltse + Fltbf + Fltcs + Fltos;
            
            
            float Fltisr=0;
            
            if(FltTotalDevengado  < 6000 | FltTotalDevengado  <= 7500) {
                
                Fltisr = 0;
                
            }else{
                if(FltTotalDevengado  > 7500 && FltTotalDevengado  < 9000 ){
                    
                    Fltisr = FltTotalDevengado * 0.05f;
                    
                }else{
                    
                    if(FltTotalDevengado  > 7500  && FltTotalDevengado  < 9000){
                        
                        Fltisr = FltTotalDevengado * 0.06f;
                        
                    }else{
                        if(FltTotalDevengado  > 9000){
                        
                        Fltisr = FltTotalDevengado * 0.08f;
                        
                    }
                        
                        
                    }
                    
                }
                
            }
            
            return Fltisr;
        } catch (Exception ex) {
            return -666;
        }
    }

    
     
      public float LeerfltAnticipos() {
        try {
            float fltAnticipos = Float.parseFloat(txtAnticipos.getText().trim());
            return fltAnticipos;
        } catch (Exception ex) {
            return -666;
        }
    }
       public float LeerfltDescuentosJudiciales() {
        try {
            float fltDescuentosJudiciales= Float.parseFloat(txtDescuentosJudiciales.getText().trim());
            return fltDescuentosJudiciales;
        } catch (Exception ex) {
            return -666;
        }
    }
        public float LeerfltOtrosDescuentos (){
        try {
            float fltOtrosDescuentos = Float.parseFloat(txtOtrosDescuentos.getText().trim());
            return fltOtrosDescuentos;
        } catch (Exception ex) {
            return -666;
        }
    }
        
        
        public float LeerfltTotaldes (){
        try {
            
            float Fltse=0, Fltsu=0, Fltbf=0, Fltcs=0, Fltos=0;
            
            Fltsu = Float.parseFloat(txtSueldo.getText().trim());
            Fltse = Float.parseFloat(txtSalarioExtraordinario.getText().trim());
            Fltbf = Float.parseFloat(txtBonificacion.getText().trim());
            Fltcs = Float.parseFloat(txtComision.getText().trim());
            Fltos = Float.parseFloat(txtOtros.getText().trim());
            
            FltTotalDevengado = Fltsu + Fltse + Fltbf + Fltcs + Fltos;
            
            
            float Fltigss=0;
            
            if(FltTotalDevengado  == 6000) {
                
                Fltigss = FltTotalDevengado * 0.0483f;
                
            }else{
                
                if(FltTotalDevengado  > 6000) {
                
                Fltigss = FltTotalDevengado * 0.0483f;
                
                }
                    
                    
            }
            
            
            
            
            float Fltisr=0;
            
            if(FltTotalDevengado  < 6000 | FltTotalDevengado  <= 7500) {
                
                Fltisr = 0;
                
            }else{
                if(FltTotalDevengado  > 7500 && FltTotalDevengado  < 9000 ){
                    
                    Fltisr = FltTotalDevengado * 0.05f;
                    
                }else{
                    
                    if(FltTotalDevengado  > 7500  && FltTotalDevengado  < 9000){
                        
                        Fltisr = FltTotalDevengado * 0.06f;
                        
                    }else{
                        if(FltTotalDevengado  > 9000){
                        
                        Fltisr = FltTotalDevengado * 0.08f;
                        
                    }
                        
                        
                    }
                    
                }
                
            }
            
            
            float Fltas, Fltds, Fltods;
            
             Fltas = Float.parseFloat(txtAnticipos.getText().trim());
             Fltds = Float.parseFloat(txtDescuentosJudiciales.getText().trim());
             Fltods = Float.parseFloat(txtOtrosDescuentos.getText().trim());
            
             FltTotalDescuento = Fltigss + Fltisr + Fltas + Fltds + Fltods;

             
             
            return FltTotalDescuento;
            
            
        } catch (Exception ex) {
            return -666;
        }
    }
        
        public float LeerfltTotalliq (){
        try {
            
            
            
            
            
            float Fltse=0, Fltsu=0, Fltbf=0, Fltcs=0, Fltos=0;
            
            Fltsu = Float.parseFloat(txtSueldo.getText().trim());
            Fltse = Float.parseFloat(txtSalarioExtraordinario.getText().trim());
            Fltbf = Float.parseFloat(txtBonificacion.getText().trim());
            Fltcs = Float.parseFloat(txtComision.getText().trim());
            Fltos = Float.parseFloat(txtOtros.getText().trim());
            
            FltTotalDevengado = Fltsu + Fltse + Fltbf + Fltcs + Fltos;
            
            
            float Fltigss=0;
            
            if(FltTotalDevengado  == 6000) {
                
                Fltigss = FltTotalDevengado * 0.0483f;
                
            }else{
                
                if(FltTotalDevengado  > 6000) {
                
                Fltigss = FltTotalDevengado * 0.0483f;
                
                }
                    
                    
            }
            
            
            
            
            float Fltisr=0;
            
            if(FltTotalDevengado  < 6000 | FltTotalDevengado  <= 7500) {
                
                Fltisr = 0;
                
            }else{
                if(FltTotalDevengado  > 7500 && FltTotalDevengado  < 9000 ){
                    
                    Fltisr = FltTotalDevengado * 0.05f;
                    
                }else{
                    
                    if(FltTotalDevengado  > 7500  && FltTotalDevengado  < 9000){
                        
                        Fltisr = FltTotalDevengado * 0.06f;
                        
                    }else{
                        if(FltTotalDevengado  > 9000){
                        
                        Fltisr = FltTotalDevengado * 0.08f;
                        
                    }
                        
                        
                    }
                    
                }
                
            }
            
            
            float Fltas, Fltds, Fltods;
            
             Fltas = Float.parseFloat(txtAnticipos.getText().trim());
             Fltds = Float.parseFloat(txtDescuentosJudiciales.getText().trim());
             Fltods = Float.parseFloat(txtOtrosDescuentos.getText().trim());
            
             FltTotalDescuento = Fltigss + Fltisr + Fltas + Fltds + Fltods;
            
            
           float FltTotalLiquido = FltTotalDevengado - FltTotalDescuento;
            
            return FltTotalLiquido;
            
        } catch (Exception ex) {
            return -666;
        }
    }
        
     
     public void mensaje(String texto) {
        JOptionPane.showMessageDialog(null, texto);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jrbFiltrarPorCodigo = new javax.swing.JRadioButton();
        jrbFiltrarPorNombre = new javax.swing.JRadioButton();
        txtBuscar = new javax.swing.JTextField();
        bntBuscar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBuscar = new javax.swing.JTable();
        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtSueldo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPuesto = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRuta = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtSalarioExtraordinario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtComision = new javax.swing.JTextField();
        txtBonificacion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtOtros = new javax.swing.JTextField();
        txtAnticipos = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDescuentosJudiciales = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtOtrosDescuentos = new javax.swing.JTextField();
        jTabbedPane2 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jrbFiltrarPorCodigo.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jrbFiltrarPorCodigo.setText("Filtrar por Codigo");
        jrbFiltrarPorCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbFiltrarPorCodigoActionPerformed(evt);
            }
        });

        jrbFiltrarPorNombre.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jrbFiltrarPorNombre.setText("Filtrar por Nombre");
        jrbFiltrarPorNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbFiltrarPorNombreActionPerformed(evt);
            }
        });

        txtBuscar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        bntBuscar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        bntBuscar.setText("Buscar");
        bntBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntBuscarActionPerformed(evt);
            }
        });

        tblBuscar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "PUESSTO", "SALARIO ORDINARIO", "SALARIO EXTRAORDINARIO", "BONIFICACION", "COMISION", "OTROS", "TOTAL DEVENGADO", "IGSS", "ISR", "ANTICIPOS", "DESC. JUDICIALES", "OTROS DESC.", "TOTAL DESCUENTOS", "TOTAL LIQUIDO"
            }
        ));
        tblBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBuscarMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblBuscar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addComponent(jrbFiltrarPorCodigo)
                                        .addGap(86, 86, 86)
                                        .addComponent(jrbFiltrarPorNombre))
                                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(272, 272, 272)
                                .addComponent(bntBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 605, Short.MAX_VALUE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbFiltrarPorCodigo)
                    .addComponent(jrbFiltrarPorNombre))
                .addGap(30, 30, 30)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bntBuscar)
                .addGap(143, 143, 143)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(323, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("BUSCAR", jPanel1);

        panel.setBackground(new java.awt.Color(204, 255, 204));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE", "PUESSTO", "SALARIO ORDINARIO", "SALARIO EXTRAORDINARIO", "BONIFICACION", "COMISION", "OTROS", "TOTAL DEVENGADO", "IGSS", "ISR", "ANTICIPOS", "DESC. JUDICIALES", "OTROS DESC.", "TOTAL DESCUENTOS", "TOTAL LIQUIDO"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        btnGuardar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        txtSueldo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setText("Salario Ordinario");

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel3.setText("PUESTO");

        txtPuesto.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        txtNombre.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtCodigo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel1.setText("Codigo:");

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        txtRuta.setEditable(false);
        txtRuta.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N

        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setText("SALARIO EXTRAORDINARIO");

        txtSalarioExtraordinario.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel6.setText("BONIFICACION");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setText("COMISIONES");

        txtComision.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        txtBonificacion.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setText("ANTICIPOS");

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setText("OTROS");

        txtOtros.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        txtAnticipos.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtAnticipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnticiposActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setText("DESCUENTOS JUDICIALES");

        txtDescuentosJudiciales.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtDescuentosJudiciales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescuentosJudicialesActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel11.setText("OTROS DESCUENTOS");

        txtOtrosDescuentos.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        txtOtrosDescuentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOtrosDescuentosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(192, 192, 192)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(txtCodigo)
                            .addComponent(txtPuesto)
                            .addComponent(txtSueldo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(199, 199, 199))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnModificar)
                                .addGap(30, 30, 30)
                                .addComponent(btnEliminar)
                                .addGap(184, 184, 184))))
                    .addComponent(jScrollPane1)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(122, 122, 122)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtBonificacion, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                                    .addComponent(txtSalarioExtraordinario)
                                    .addComponent(txtComision)
                                    .addComponent(txtOtros)
                                    .addComponent(txtAnticipos)
                                    .addComponent(txtDescuentosJudiciales)
                                    .addComponent(txtOtrosDescuentos)))
                            .addComponent(jLabel8))
                        .addGap(480, 480, 480)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRuta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnEliminar)
                    .addComponent(btnModificar)
                    .addComponent(btnGuardar)
                    .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSalarioExtraordinario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBonificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtComision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOtros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnticipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(17, 17, 17)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescuentosJudiciales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOtrosDescuentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("REGISTRO EMPLEADOS", panel);
        jTabbedPane1.addTab("REGISTROS", jTabbedPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrbFiltrarPorCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbFiltrarPorCodigoActionPerformed
        txtBuscar.setText("");
    }//GEN-LAST:event_jrbFiltrarPorCodigoActionPerformed

    private void jrbFiltrarPorNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbFiltrarPorNombreActionPerformed
        txtBuscar.setText("");
    }//GEN-LAST:event_jrbFiltrarPorNombreActionPerformed

    private void bntBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntBuscarActionPerformed
        Buscar BusquedaDato = new Buscar();
        if(jrbFiltrarPorCodigo.isSelected()) {
            int intCodigo = Integer.parseInt(txtBuscar.getText().trim());
            BusquedaDato.BuscarPorCodigo(tblBuscar, dvariables, metodos, intCodigo);
        }
        else if (jrbFiltrarPorNombre.isSelected()){
            String srtNombre = txtNombre.getText().trim();
            BusquedaDato.BuscarPorNombre(tblBuscar, dvariables, metodos, srtNombre);
        }
    }//GEN-LAST:event_bntBuscarActionPerformed

    private void tblBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBuscarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblBuscarMouseClicked

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

        clic_tabla = tabla.rowAtPoint(evt.getPoint());

        int codigo = (int) tabla.getValueAt(clic_tabla, 0);
        String nombre = "" + tabla.getValueAt(clic_tabla, 1);
        String Puesto = "" + tabla.getValueAt(clic_tabla, 2);
        Float Sueldo = (float) tabla.getValueAt(clic_tabla, 3);
        Float SalarioExtraordinario = (float) tabla.getValueAt(clic_tabla, 4);
        Float Bonificacion = (float) tabla.getValueAt(clic_tabla, 5);
        Float Comision = (float) tabla.getValueAt(clic_tabla, 6);
        Float Otros = (float) tabla.getValueAt(clic_tabla, 7);
        Float TotalDevengado = (float) tabla.getValueAt(clic_tabla, 8);
        Float Igss = (float) tabla.getValueAt(clic_tabla, 9);
        Float Isr = (float) tabla.getValueAt(clic_tabla, 10);
        Float Anticipos = (float) tabla.getValueAt(clic_tabla, 11);
        Float DescuentosJudiciales = (float) tabla.getValueAt(clic_tabla, 12);
        Float OtrosDescuentos = (float) tabla.getValueAt(clic_tabla, 13);
        Float TotalDescuentos = (float) tabla.getValueAt(clic_tabla, 14);
        Float Totalliquido = (float) tabla.getValueAt(clic_tabla, 15);

        //  Object descripcion = "" + tabla.getValueAt(clic_tabla, 3);

        txtCodigo.setText(String.valueOf(codigo));
        txtNombre.setText(nombre);
        txtPuesto.setText(Puesto);
        txtSueldo.setText(String.valueOf(Sueldo));
        txtSalarioExtraordinario.setText(String.valueOf(SalarioExtraordinario));
        txtBonificacion.setText(String.valueOf(Bonificacion));
        txtComision.setText(String.valueOf(Comision));
        txtOtros.setText(String.valueOf(Otros));
        
        txtAnticipos.setText(String.valueOf(Anticipos));
        txtDescuentosJudiciales.setText(String.valueOf(DescuentosJudiciales));
        txtOtrosDescuentos.setText(String.valueOf(OtrosDescuentos));

        try {
            JLabel lbl = (JLabel) tabla.getValueAt(clic_tabla, 14);
            //lblFoto.setIcon(lbl.getIcon());
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        File ruta = new File(txtRuta.getText());
        this.IngresarRegistro(ruta);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        File ruta = new File(txtRuta.getText());
        this.ModificarRegistro(ruta);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        this.EliminarRegistro();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Limpiar_datos lp = new Limpiar_datos();
        lp.Limpiar_texto(panel);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtAnticiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnticiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnticiposActionPerformed

    private void txtDescuentosJudicialesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescuentosJudicialesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescuentosJudicialesActionPerformed

    private void txtOtrosDescuentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOtrosDescuentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOtrosDescuentosActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(INGRESO_PLANILLA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(INGRESO_PLANILLA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(INGRESO_PLANILLA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(INGRESO_PLANILLA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new INGRESO_PLANILLA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JRadioButton jrbFiltrarPorCodigo;
    private javax.swing.JRadioButton jrbFiltrarPorNombre;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tblBuscar;
    private javax.swing.JTextField txtAnticipos;
    private javax.swing.JTextField txtBonificacion;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtComision;
    private javax.swing.JTextField txtDescuentosJudiciales;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtOtros;
    private javax.swing.JTextField txtOtrosDescuentos;
    private javax.swing.JTextField txtPuesto;
    private javax.swing.JTextField txtRuta;
    private javax.swing.JTextField txtSalarioExtraordinario;
    private javax.swing.JTextField txtSueldo;
    // End of variables declaration//GEN-END:variables
}
