package thinice.AST;

import java.io.PrintStream;
import thinice.TS.AbstractSymbol;
import thinice.util.Utilities;

public class SentError extends Sentencia{

    AbstractSymbol error;
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public SentError(AbstractSymbol error,int linea, int columna) {
        super(linea, columna);
        this.error = error;
    }
    //  </editor-fold>
    
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public void dump(PrintStream out, int n) {
        Utilities.fatalError(null);
    }
    
    //---------------------------------------
    @Override
    public void aceptar(Visitor visit, Object... params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //---------------------------------------
    //  </editor-fold>
}
