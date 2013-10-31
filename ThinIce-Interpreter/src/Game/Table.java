/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JPanel;

/**
 *
 * @author Moises
 */
public class Table extends JPanel {
    private Box [][]mapa; 
    private int [][] ma_logic;
    
    public Table(){
        this.setLayout(null);
        this.setBounds(670, 20, 550, 540);    
    }
    public void leer(int level) throws FileNotFoundException, IOException, URISyntaxException
    {
        
        ma_logic= new int[20][20];        
        try {
            File tab = new File(getClass().getClassLoader().getResource(Parameters.path_level+ Parameters.levels[level]).toURI());
            String line;
        if( !tab.isFile() )
            System.out.println("no es archivo");
        else
        {
            BufferedReader lea = new BufferedReader( new FileReader(tab) );
            for( int index = 0 ; index < 20 ; index++ )
            {
                line = "";
                line = lea.readLine();
                for( int letra = 0 ; letra < 20 ; letra++ )
                {          
                    ma_logic[letra][index] = line.charAt(letra)-48;
                      
                }
            }
           
        }
        } catch (URISyntaxException | IOException ex) {
            System.out.println(ex.toString());
        }
        
    }
    public void pintar(int nivel){
        this.mapa = new Box[20][20];
    for( int y = 0 ; y < 20 ; y++ )
        { 
            for(  int x = 0 ; x < 20 ; x++ )
            {
                if( ma_logic[x][y]==0)
                    this.mapa[x][y] = new Box(x*27, y*27, 0, this);
                if( ma_logic[x][y]==1)
                    this.mapa[x][y] = new Box(x*27, y*27, 1, this);
                if( ma_logic[x][y]==2)
                    this.mapa[x][y] = new Box(x*27, y*27, 2, this);
                if( ma_logic[x][y]==3)
                    this.mapa[x][y] = new Box(x*27, y*27, 3, this);
                
            }
        }
            this.repaint();
            this.repaint();
    }
    
}
