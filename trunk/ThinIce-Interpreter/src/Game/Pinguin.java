package Game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pinguin extends JLabel {

    public static final int arriba = interpreterInput.mirarArriba;
    public static final int abajo = interpreterInput.mirarAbajo;
    public static final int izquierda = interpreterInput.mirarIzquierda;
    public static final int derecha = interpreterInput.mirarDerecha;

    private int x, y, dx, dy;
    int direccion;

    public Pinguin(int posX, int posY) {
        this.x = posX;
        this.y = posY;
        
        this.setDireccion(arriba);
        this.updateImage();
        
        this.setBounds(posX * Box.width, posY * Box.height, 25, 25);
    }

    public void setDireccion(int pos) {
        this.direccion = pos;
        dx = (direccion == derecha) ? 1 : (direccion == izquierda) ? -1 : 0;
        dy = (direccion == abajo) ? 1 : (direccion == arriba) ? -1 : 0;
    }

    public void setPosX(int posX) {
        this.x = posX;
    }

    public void setPosY(int posY) {
        this.y = posY;
    }
    
    public void updateImage(){
        this.setIcon(new ImageIcon(getClass().getClassLoader().getResource(Parameters.path_box + Parameters.pac_images[this.direccion])));
    }
    
    public void updateLocation(){
        this.setLocation(this.x * Box.width, this.y * Box.height);
    }
    
    public int getPosX() {
        return x;
    }

    public int getPosY() {
        return y;
    }

    public int getMoverX() {
        return dx;
    }

    public int getMoverY() {
        return dy;
    }

}
