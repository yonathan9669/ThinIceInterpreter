/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Moises
 */
public class Box extends JLabel{
    
    
    
    
    private int posX,posY;
    private int tipoCasilla;
    private Rectangle rectangulo;
    private Table tablero;
    public Box(int posX, int posY, int tipoCasilla, Table tablero){
        this.posX = posX;
        this.posY = posY;
        this.tipoCasilla = tipoCasilla;
        this.tablero = tablero;
        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Parameters.path_box+Parameters.box_images[tipoCasilla])));
        this.setBounds(posX, posY,25, 25);
        this.rectangulo=this.getBounds();
        this.tablero.add(this);
    
    }
    
}
