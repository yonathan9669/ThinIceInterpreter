package Game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public class Table extends JPanel {

    public static final int NADA = 0;
    public static final int LIBRE = 1;
    public static final int USADO = 2;
    public static final int HIELO = 3;
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
                        this.mapa[letra][index] = new Box(letra, index, letter);
                        this.add(this.mapa[letra][index]);
                    }
                }
            }
        } catch (URISyntaxException | IOException ex) {
            System.out.println(ex.toString());
        }
        this.repaint();
    }

    public void mirar(int direccion) {
        pinguino.setDireccion(direccion);
        this.pinguino.updateImage();
    }

    public void avanzar(int steps) {
        if (steps > 0) {
            int dx = pinguino.getMoverX();
            int dy = pinguino.getMoverY();
            for (int i = pinguino.getPosX() + dx, j = pinguino.getPosY() + dy;
                    steps > 0 && (i >= 0 && i < 20) && (j >= 0 && j < 20);
                    i += dx, j += dy, steps--) {
                if (mapa[i][j].getTipoCasilla() == LIBRE) {
                    try {
                        pinguino.setPosX(i);
                        pinguino.setPosY(j);
                        pinguino.updateLocation();
                        mapa[i - dx][j - dy].setTipoCasilla(USADO);
                        mapa[i - dx][j - dy].updateImage();
                        repaint();
                        Thread.sleep(250);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    break;
                }
            }
        }
    }
}
