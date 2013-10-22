package thinice.AST;

import java.io.PrintStream;

public class Vector extends NodoLista<Variable>{
    //---------------------------Protected Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    protected Expresion pos;
    //  </editor-fold>
    
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Vector() {
        super();
    }
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public void dump(PrintStream out, int n) {
        for(Variable v: lista){
            v.dump(out, n);
        }
    }
    //---------------------------------------
    //  </editor-fold>
}
