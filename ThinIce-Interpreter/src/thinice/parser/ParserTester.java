package thinice.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import thinice.lexer.ThinIceLexer;

public class ParserTester {
    
    public static void main(String[] args) {
        FileInputStream input=null;
        
        try {
            input = new FileInputStream(new File(args[0]));
            
            ThinIceLexer lexer = new ThinIceLexer(input);
            //lexer.setNombreArchivo(args[0]);
            ThinIceParser parser = new ThinIceParser(lexer);
            
            /*
            Programa result = (Programa) (parser.parse().value);
           
            if (parser.omerrs > 0) {
		System.err.println("El análisis ha terminado con "+ parser.omerrs +" errores");
		System.exit(1);
	    }
            
            result.dump(System.out, 0);
            */
            System.out.println("El análisis ha finalizado correctamente");
        /*}catch (URISyntaxException ex) {
            System.out.println("Ha ocurrido un error de formato en la ruta del archivo");
        */}catch (FileNotFoundException ex) {
            System.out.println("No se pudo abrir el archivo de entrada");
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Usar: parser.Parser programa.tny");
        }catch (Exception ex) {
            ex.printStackTrace(System.err);
	    System.err.println("Error inesperado en el analizador sintáctico");
        }
    }
}
