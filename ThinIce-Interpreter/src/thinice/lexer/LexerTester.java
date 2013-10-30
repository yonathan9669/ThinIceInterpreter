package thinice.lexer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java_cup.runtime.Symbol;
import thinice.parser.ThinIceTokenDef;
import thinice.util.Utilities;

public class LexerTester {

    public static void main(String[] args) {
        FileInputStream input = null;

        try {
            BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

            for (String file : args) {
                input = new FileInputStream(file);

                FileReader f = new FileReader(file);
                char[] buf = new char[1024];
                int n = f.read(buf);

                if (n > 0) {
                    System.out.println(new String(buf, 0, n));
                }

                ThinIceLexer lexer = new ThinIceLexer(input);

                Symbol symbol;
                while ((symbol = lexer.next_token()).sym != ThinIceTokenDef.EOF) {
                    Utilities.dumpToken(System.out, symbol);
                }

                System.out.println("El análisis LEXICO ha finalizado sobre el archivo " + file);

                System.out.println("Desea analizar el siguiente archivo si hay? N/*: ");
                if (scan.readLine().toUpperCase().equals("N")) {
                    break;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No se pudo abrir el archivo de entrada");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Usar: lexer simpleMoves.ti");
        } catch (IOException ex) {
            System.out.println("Ha ocurrido un error de entrada y salida en el analizador léxico");
        }
    }
}
