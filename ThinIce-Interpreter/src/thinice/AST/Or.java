package thinice.AST;

import java.io.PrintStream;
import thinice.util.Utilidades;

public class Or extends ExpresionBinaria{
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Or(Expresion expr1, Expresion expr2, int linea, int columna) {
        super(expr1, expr2, linea, columna);
    }
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println("_o(||)");
        if(tipo_expr!=null) out.println(Utilidades.pad(n+2)+"tipo_expr: "+tipo_expr);
        expr1.dump(out, n+2);
        expr2.dump(out, n+2);
    }
    //---------------------------------------
    //  </editor-fold>
}
