package thinice.util;

import java.io.PrintStream;
import thinice.TS.SimboloAbstracto;
import java_cup.runtime.Symbol;
import thinice.parser.ThinIceTokenDef;

public class Utilidades {

    private static String padding = "                                                                                ";

    public static String tokenEnTexto(Symbol s) {
        switch (s.sym) {
            case ThinIceTokenDef.LLA_I:
                return "{";
            //case ThinIceTokenDef.EMPTY:
                //return "?";
            case ThinIceTokenDef.ENTERO:
                return "ENTERO";
            case ThinIceTokenDef.LLA_D:
                return "}";
            case ThinIceTokenDef.DIFERENTE:
                return "<>";
            case ThinIceTokenDef.RESTA:
                return "-";
            case ThinIceTokenDef.INT:
                return "INT";
            case ThinIceTokenDef.FOR:
                return "PARA";
            case ThinIceTokenDef.NOT:
                return "NOT";
            case ThinIceTokenDef.AND:
                return "AND";
            case ThinIceTokenDef.IGUAL:
                return "=";
            case ThinIceTokenDef.OR:
                return "OR";
            case ThinIceTokenDef.DIV:
                return "/";
            case ThinIceTokenDef.SUMA:
                return "+";
            case ThinIceTokenDef.IF:
                return "IF";
            case ThinIceTokenDef.ID:
                return "ID";
            case ThinIceTokenDef.EOF:
                return "FIN_ARCHIVO";
            case ThinIceTokenDef.BOOLEAN:
                return "BOOL";
            case ThinIceTokenDef.ASIG:
                return ":=";
            case ThinIceTokenDef.PAR_I:
                return "(";
            case ThinIceTokenDef.error:
                return "error";
            case ThinIceTokenDef.PROGRAM:
                return "PROGRAMA";
            case ThinIceTokenDef.COMA:
                return ",";
            case ThinIceTokenDef.PAR_D:
                return ")";
            case ThinIceTokenDef.MENOR:
                return "<";
            case ThinIceTokenDef.MOD:
                return "%";
            case ThinIceTokenDef.PUNT_C:
                return ";";
            case ThinIceTokenDef.ERROR:
                return ">";
            case ThinIceTokenDef.MAYOR:
                return ">";
            case ThinIceTokenDef.ELSE:
                return "ELSE";
            case ThinIceTokenDef.WHILE:
                return "WHILE";
            case ThinIceTokenDef.MAYOR_IGUAL:
                return ">=";
            case ThinIceTokenDef.COR_I:
                return "[";
            case ThinIceTokenDef.MULTI:
                return "*";
            case ThinIceTokenDef.BOOLEANO:
                return "BOOLEANO";
            case ThinIceTokenDef.COR_D:
                return "]";
            case ThinIceTokenDef.MENOR_IGUAL:
                return "<=";
            case ThinIceTokenDef.DO:
                return "DO";
            default:
                return ("<Token invalido: " + s.sym + ">");
        }
    }

    public static void imprimirToken(Symbol s) {
        System.err.print(tokenEnTexto(s));
        SimboloAbstracto sym = (SimboloAbstracto) s.value;;

        switch (s.sym) {
            case ThinIceTokenDef.ENTERO:
            case ThinIceTokenDef.ID:
                System.err.print(" = " + sym.getTexto());
                break;
            case ThinIceTokenDef.error:
            case ThinIceTokenDef.ERROR:
                System.err.print(" = \"");
                System.err.print(sym.getTexto());
                System.err.print("\"");
                break;
        }
        System.err.println("");
    }

    public static void dumpToken(PrintStream str, Symbol s) {
        SimboloAbstracto sym = (SimboloAbstracto) s.value;
        str.print("#" + sym.getLinea() + ":" + sym.getColumna() + ": " + tokenEnTexto(s));

        switch (s.sym) {
            case ThinIceTokenDef.BOOLEANO:
            case ThinIceTokenDef.ENTERO:
            case ThinIceTokenDef.ID:
                str.print(" = " + sym.getTexto());
                break;
            case ThinIceTokenDef.error:
            case ThinIceTokenDef.ERROR:
                str.print(" = \"");
                str.print(sym.getTexto());
                str.print("\"");
                break;
        }
        str.println("");
    }

    public static String pad(int n) {
        if (n > 80) {
            return padding;
        }
        if (n < 0) {
            return "";
        }
        return padding.substring(0, n);
    }

    public static void fatalError(String msg) {
        (new Throwable(msg)).printStackTrace();
        System.exit(1);
    }
}
