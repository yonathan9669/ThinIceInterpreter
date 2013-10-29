package thinice.AST;

import java.io.PrintStream;
import thinice.util.Utilities;

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
    //---------------------------Getters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public Expresion getExpr() {
        return expr;
    }
    
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println("_negacion");
        if(tipo_expr!=null) out.println(Utilities.pad(n+2)+"tipo_expr: "+tipo_expr);
        expr.dump(out, n+2);
    }
    
    //---------------------------------------
    @Override
    public void aceptar(Visitor visit, Object... params) {
        visit.visitar(this, params);
    }
    
    //---------------------------------------
    @Override
    public String getTextExpression() {
        return " ! " + this.expr.getTextExpression();
    }
    //  </editor-fold>
}
