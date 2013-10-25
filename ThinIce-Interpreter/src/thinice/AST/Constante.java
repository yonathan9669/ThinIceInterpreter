package thinice.AST;

import java.io.PrintStream;
import thinice.TS.SimboloAbstracto;

public class Constante extends Expresion{
    //---------------------------Protected Attributes---------------------------
    // <editor-fold desc="Private Attributes">
    protected SimboloAbstracto token;
    //  </editor-fold>
    
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Constante(int linea, int columna, SimboloAbstracto token) {
        super(linea, columna);
        this.token = token;
    }
    //  </editor-fold>

    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public void dump(PrintStream out, int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //  </editor-fold>
    
}
