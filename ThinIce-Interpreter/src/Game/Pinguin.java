package Game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pinguin extends JLabel {

    public static final int derecha = 4;
    public static final int izquierda = 5;
    public static final int arriba = 6;
    public static final int abajo = 7;

    private int posX, posY, moverX, moverY;
    int direccion;

    public Pinguin(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        //mirar arriba
        moverX = 0;
        moverY = -1;
        this.direccion = arriba;

        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Parameters.path_box + Parameters.box_images[this.direccion])));
        this.setBounds(posX * Box.width, posY * Box.height, 25, 25);
    }

    public void setDireccion(int pos) {
        this.direccion = pos;
        moverX = (direccion == derecha) ? 1 : (direccion == izquierda) ? -1 : 0;
        moverY = (direccion == abajo) ? 1 : (direccion == arriba) ? -1 : 0;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    public void updateImage(){
        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Parameters.path_box + Parameters.box_images[this.direccion])));
    }
    
    public void updateLocation(){
        this.setLocation(this.posX * Box.width, this.posY * Box.height);
    }
    
    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int getMoverX() {
        return moverX;
    }

    public int getMoverY() {
        return moverY;
    }

}
