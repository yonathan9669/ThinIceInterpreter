package thinice.AST;

import java.io.PrintStream;
import thinice.TS.SimboloAbstracto;
import thinice.util.Utilidades;

public class Vector extends Expresion{
    //---------------------------Protected Attributes---------------------------
    // <editor-fold desc="Private Attributes">
    protected Variable var;
    protected Expresion pos;
    //  </editor-fold>
    
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Vector(Variable var, Expresion expr, int linea, int columna) {
        super(linea, columna);
        this.var = var;
        this.pos = expr;
    }
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println("_vector");
        if(tipo_expr!=null) out.println(Utilidades.pad(n+2)+"tipo_expr: "+tipo_expr);
        var.dump(out, n+2);
        pos.dump(out, n+2);
    }
    //---------------------------------------
    //  </editor-fold>
}
