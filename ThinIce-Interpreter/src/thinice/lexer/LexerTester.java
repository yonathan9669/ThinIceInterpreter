package thinice.lexer;

import JFlex.sym;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java_cup.runtime.Symbol;

public class LexerTester {
    
    
    public static void main(String[] args) {
        FileInputStream input = null;

        try {
            input = new FileInputStream(args[0]);

            ThinIceLexer lexer = new ThinIceLexer(input);

            Symbol symbol;
            while ((symbol = lexer.next_token()).sym != sym.EOF) {
                System.out.println(symbol.value);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No se pudo abrir el archivo de entrada");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Usar: lexer.Lexer programa.tny");
        } catch(IOException ex){
            System.out.println("Ha ocurrido un error de entrada y salida en el analizador léxico");
        }
    }
}
