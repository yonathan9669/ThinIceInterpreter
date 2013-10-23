package thinice.AST;

import java.io.PrintStream;
import thinice.util.Utilidades;

public class Not extends Expresion{
    //---------------------------Private Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    private Expresion expr;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Not(Expresion expr, int linea, int columna) {
        super(linea, columna);
        this.expr = expr;
    }
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println("_negacion");
        if(tipo_expr!=null) out.println(Utilidades.pad(n+2)+"tipo_expr: "+tipo_expr);
        expr.dump(out, n+2);
    }
    //---------------------------------------
    //  </editor-fold>
}
