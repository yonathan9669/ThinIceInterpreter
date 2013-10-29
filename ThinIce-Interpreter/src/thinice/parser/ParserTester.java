package thinice.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import thinice.AST.Programa;
import thinice.lexer.ThinIceLexer;

public class ParserTester {

    public static void main(String[] args) {
        FileInputStream input = null;

        try {
            BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

            for (String file : args) {
                input = new FileInputStream(new File(file));

                FileReader f = new FileReader(file);
                char[] buf = new char[1024];
                int n = f.read(buf);

                if (n > 0) {
                    System.out.println(new String(buf, 0, n));
                }

                ThinIceLexer lexer = new ThinIceLexer(input);
                lexer.setNombreArchivo(file);
                ThinIceParser parser = new ThinIceParser(lexer);

                Programa result = (Programa) (parser.parse().value);

                if (parser.omerrs > 0) {
                    System.err.println("El análisis ha terminado con " + parser.omerrs + " errores");

                    System.out.println("Desea analizar el siguiente archivo si hay? N/*: ");
                    if (!scan.readLine().toUpperCase().equals("N")) {
                        continue;
                    }
                    System.exit(1);
                }

                result.dump(System.out, 0);

                System.out.println("El análisis SINTACTICO ha finalizado correctamente para el archivo " + file);
                System.out.println("Desea analizar el siguiente archivo si hay? N/*: ");
                if (scan.readLine().toUpperCase().equals("N")) {
                    break;
                }
            }
            /*}catch (URISyntaxException ex) {
             System.out.println("Ha ocurrido un error de formato en la ruta del archivo");
             */
        } catch (FileNotFoundException ex) {
            System.out.println("No se pudo abrir el archivo de entrada");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Usar: parser.Parser programa.tny");
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
            System.err.println("Error inesperado en el analizador sintáctico");
        }
    }
}
