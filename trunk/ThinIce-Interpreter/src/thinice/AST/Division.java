package thinice.AST;

import java.io.PrintStream;
import thinice.util.Utilities;

public class Division extends ExpresionBinaria{
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Division(Expresion expr1, Expresion expr2, int linea, int columna) {
        super(expr1, expr2, linea, columna);
    }
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println("_division");
        if(tipo_expr!=null) out.println(Utilities.pad(n+2)+"tipo_expr: "+tipo_expr);
        expr1.dump(out, n+2);
        expr2.dump(out, n+2);
    }
    
    //---------------------------------------
    @Override
    public void aceptar(Visitor visit, Object... params) {
        visit.visitar(this, params);
    }
    
    //---------------------------------------
    @Override
    public String getTextExpression() {
        return this.expr1.getTextExpression() + " / " + this.expr2.getTextExpression();
    }
    //  </editor-fold>
}
