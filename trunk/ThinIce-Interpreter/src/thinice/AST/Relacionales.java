package thinice.AST;

import java.io.PrintStream;
import thinice.util.Utilidades;

public class Relacionales extends ExpresionBinaria{
    //---------------------------Static Constants-------------------------------
    // <editor-fold desc="Static Constants">
    public static final int MENOR = 0;
    public static final int MENOR_IGUAL = 1;
    public static final int MAYOR = 2;
    public static final int MAYOR_IGUAL = 3;
    public static final int IGUAL = 4;
    public static final int DIFERENTE = 5;
    
    public static final String[] typeName = {"_menor_que","_menor_igual_que","_mayor_que","_mayor_igual_que","_igual_que","_diferente_que"};
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Private Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    private int type;
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Relacionales(Expresion expr1, Expresion expr2, int linea, int columna, int TIPO) {
        super(expr1, expr2, linea, columna);
        this.type = TIPO;
    }
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println(typeName[type]);
        if(tipo_expr!=null) out.println(Utilidades.pad(n+2)+"tipo_expr: "+tipo_expr);
        expr1.dump(out, n+2);
        expr2.dump(out, n+2);
    }
    //---------------------------------------
    //  </editor-fold>
}
