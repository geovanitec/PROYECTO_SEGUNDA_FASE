/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PLANILLA_FASE2;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

/**
 *
 * @author Geovani
 */


/**
 * 
 * @class que permite insertar una imagen en nuestro DesktopPane
 */
public class ImagenFondo implements Border{

    public BufferedImage back;
    
    public ImagenFondo(){
        
        try{
            URL imagePath = new URL (getClass().getResource("../Imagenes/fondopanel.jpg").toString());
           
            back = ImageIO.read(imagePath);
        }catch(Exception e ){
            
        }
    }
    
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
       g.drawImage(back, (x + ( width - back.getWidth())/2),(y + (height - back.getHeight()) /2), null);
        
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Insets getBorderInsets(Component cmpnt) {
        return new Insets(0,0,0,0);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isBorderOpaque() {
       return false;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
