package Game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Box extends JLabel {

    public static final int height = 27, width = 27;
    
    private int posX, posY;
    private int tipoCasilla;

    public Box(int posX, int posY, int tipoCasilla, Table tablero) {
        this.posX = posX;
        this.posY = posY;
        this.tipoCasilla = tipoCasilla;
        
        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Parameters.path_box + Parameters.box_images[tipoCasilla])));
        this.setBounds(posX * width, posY * height, 25, 25);
        
        tablero.add(this);
    }

    public int getTipoCasilla() {
        return tipoCasilla;
    }

    public void updateImage(){
        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Parameters.path_box + Parameters.box_images[tipoCasilla])));
    }
    
    public void setTipoCasilla(int tipoCasilla) {
        this.tipoCasilla = tipoCasilla;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}
