/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thinice.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java_cup.internal_error;

/**
 *
 * @author Administrador
 */
public class GenerateFlexCup {
    private File lexFile, cupFile;

    public GenerateFlexCup(String lexFile, String cupFile) throws URISyntaxException {
        this.lexFile = new File(lexFile);
        this.cupFile = new File(cupFile);
    }
    
    public void generar() throws internal_error, IOException, Exception{
        String cup_opts[] = new String[]{"-destdir", cupFile.getParent(), "-parser", 
                                         "parser", "-expect", "10000", "-dump", 
                                         "-nopositions", "-interface", "-symbols",
                                         "sym", "-package", "parser",
                                         cupFile.getPath()};
        JFlex.Main.generate(lexFile);
        System.out.print("Ejecutando java_cup");
        for(String f:cup_opts)
            System.out.print(" "+f);
        System.out.println("");
        java_cup.Main.main(cup_opts);
    }
    
    public static void main(String args[]){
        args = new String[2];
        
        String path = "src/thinice/especificaciones/";
        args[0] = path + "lexico.flex";
        args[1] = path + "sintactico.cup";
        
        if(args.length<2)
            System.err.println("Usar GeneraFlexCup.Main ruta_archivo_lex ruta_archivo_cup");
        else
            try {
                new GenerateFlexCup(args[0], args[1]).generar();
                System.out.println("Todas las tareas han finalizado de manera correcta...");
            } catch (URISyntaxException ex) {
                System.err.println("Se ha producido al procesar el archivo " + args[0]);
            } catch (internal_error ex) {
                System.err.println("Ha ocurrido un error interno al procesar el archivo " + args[1]);
            } catch (IOException ex) {
                System.err.println("Se ha producido un error de entrada/salida al procesar el archivo " + args[1]);
            } catch (Exception ex) {
                System.err.println("Se ha producido un error inesperado al procesar el archivo "+ args[1]);
            }
    }
}
