package thinice.AST;

import java.io.PrintStream;
import thinice.TS.SimboloAbstracto;

public class SentError extends Sentencia{

    SimboloAbstracto error;
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public SentError(SimboloAbstracto error,int linea, int columna) {
        super(linea, columna);
        this.error = error;
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
