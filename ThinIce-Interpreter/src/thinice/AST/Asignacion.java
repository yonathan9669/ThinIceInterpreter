package thinice.AST;

import java.io.PrintStream;

public class Asignacion extends Sentencia{
    //---------------------------Protected Attributes---------------------------
    // <editor-fold desc="Private Attributes">
    protected Variable id;
    protected Expresion expr;
    //  </editor-fold>
    //---------------------------Getters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public Variable getVariable(){
        return id;
    }
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Asignacion(Variable id, Expresion expr, int linea, int columna) {
        super(linea, columna);
        this.id = id;
        this.expr = expr;
    }
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println("_asignacion");
        id.dump(out, n+2);
        expr.dump(out, n+2);
    }
    //  </editor-fold>
    
}
