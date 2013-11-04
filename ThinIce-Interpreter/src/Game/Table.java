package Game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JPanel;

public class Table extends JPanel {

    public static final int HIELO = 0;
    public static final int USADO = 1;
    public static final int LIBRE = 2;
    public static final int NADA = 3;
    public static final int PINGUINO = 4;

    private Box[][] mapa;
    private Pinguin pinguino;

    public Table() {
        this.setLayout(null);
        this.setBounds(670, 20, 550, 540);
        this.setDoubleBuffered(true);
    }

    public void leer(int level) throws FileNotFoundException, IOException, URISyntaxException {
        this.mapa = new Box[20][20];
        try {
            File tab = new File(getClass().getClassLoader().getResource(Parameters.path_level + Parameters.levels[level]).toURI());
            String line;
            if (!tab.isFile()) {
                System.out.println("no es archivo");
            } else {
                BufferedReader lea = new BufferedReader(new FileReader(tab));
                for (int index = 0; index < 20; index++) {
                    line = "";
                    line = lea.readLine();
                    for (int letra = 0; letra < 20; letra++) {
                        int letter = line.charAt(letra) - 48;
                        if (letter == PINGUINO) {
                            pinguino = new Pinguin(letra, index);
                            this.add(pinguino);
                            letter = LIBRE;
                        }
                        this.mapa[letra][index] = new Box(letra, index, letter, this);
                    }
                }
            }
        } catch (URISyntaxException | IOException ex) {
            System.out.println(ex.toString());
        }
        this.repaint();
    }

    public void mirarArriba() {
        pinguino.setDireccion(Pinguin.arriba);
        this.pinguino.updateImage();
        //pinguino.setMoverX(0);
        //pinguino.setMoverY(-1);
    }

    public void mirarAbajo() {
        pinguino.setDireccion(Pinguin.abajo);
        this.pinguino.updateImage();
        //pinguino.setMoverX(0);
        //pinguino.setMoverY(1);
    }

    public void mirarIzquierda() {
        pinguino.setDireccion(Pinguin.izquierda);
        this.pinguino.updateImage();
        //pinguino.setMoverX(-1);
        //pinguino.setMoverY(0);
    }

    public void mirarDerecha() {
        pinguino.setDireccion(Pinguin.derecha);
        this.pinguino.updateImage();
        //pinguino.setMoverX(1);
        //pinguino.setMoverY(0);
    }

    public void avanzar(int pasos) {

        if (pasos > 0) {
            int dx = this.pinguino.getMoverX();
            int dy = this.pinguino.getMoverY();
            for (int i = this.pinguino.getPosX(), j = this.pinguino.getPosY();
                    pasos > 0 && (i >= 0 && i < 20) && (j >= 0 && j < 20);
                    i += dx, j += dy, pasos--) {
                if(this.mapa[i][j].getTipoCasilla() == LIBRE){
                    this.pinguino.setPosX(i);
                    this.pinguino.setPosY(j);
                    this.mapa[i - dx][j - dy].setTipoCasilla(USADO);
                    this.mapa[i - dx][j - dy].updateImage();
                }
                else{
                    break;
                }
            }
            this.pinguino.updateLocation();
            this.repaint();
            this.getParent().repaint();
            /*
             int posX = pinguino.getPosX();
             int posY = pinguino.getPosY();
             int moverX = pinguino.getMoverX();
             int moverY = pinguino.getMoverY();

            
             int esperadaX = 0;
             int esperadaY = 0;

             int posibleX = posX;
             int posibleY = posY;

             if (moverX == 1) {
             if (posX + pasos < mapa[0].length)
             esperadaX = posX + pasos;
             for (posibleX = posX; posibleX < mapa[0].length - 1; posibleX++) {
             if (mapa[posibleX + 1][posibleY].getTipoCasilla() != LIBRE) {
             break;
             }
             }
             } else if (moverX == -1) {
             if (posX - pasos >= 0)
             esperadaX = posX - pasos;
             for (posibleX = posX; posibleX > 0; posibleX--) {
             if (mapa[posibleX - 1][posibleY].getTipoCasilla() != LIBRE) {
             break;
             }
             }
             } else if (moverY == 1) {
             if (posY + pasos < mapa.length)
             esperadaY = posY + pasos;
             for (posibleY = posY; posibleY < mapa.length - 1; posibleY++) {
             if (mapa[posibleX][posibleY + 1].getTipoCasilla() != LIBRE) {
             break;
             }
             }
             } else if (moverY == -1) {
             if (posY - pasos >= 0)
             esperadaY = posY - pasos;
             for (posibleY = posY; posibleY > 0; posibleY--) {
             if (mapa[posibleX][posibleY - 1].getTipoCasilla() != LIBRE) {
             break;
             }
             }
             }

             if (esperadaX >= posibleX && esperadaX >= 0) {
             pinguino.setPosX(posibleX);
             } else if (posibleX > 0) {
             pinguino.setPosX(esperadaX);
             }

             if (esperadaY >= posibleY && esperadaY >= 0) {
             pinguino.setPosY(posibleY);
             } else if (posibleY > 0) {
             pinguino.setPosY(esperadaY);
             }
             */
            this.repaint();
        }
    }

}
