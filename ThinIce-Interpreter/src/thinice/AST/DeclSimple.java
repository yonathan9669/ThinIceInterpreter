package thinice.AST;

import java.io.PrintStream;

public class DeclSimple extends Declaracion{
    //---------------------------Protected Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    protected Variable id;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public DeclSimple(int tipo, Variable id, int linea, int columna) {
        super(tipo, linea, columna);
        this.id = id;
    }

    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println("_declaracion_simple");
        super.dump(out, n+2);
        id.dump(out, n+2);
    }
    
    //---------------------------------------
    @Override
     public Variable getId() {
        return id;
    }
    
    //---------------------------------------
    //  </editor-fold>
    
}
