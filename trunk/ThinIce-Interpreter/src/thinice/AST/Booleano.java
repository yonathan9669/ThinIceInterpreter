package thinice.AST;

import java.io.PrintStream;
import thinice.TS.AbstractSymbol;
import thinice.util.Utilities;

public class Booleano extends Constante{
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Booleano(AbstractSymbol token, int linea, int columna) {
        super(linea, columna, token);
    }
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.print("_constante");
        out.println(" " + AbstractSymbol.nombreTipo[AbstractSymbol.BOOLEANO]);
        if(tipo_expr!=null) out.println(Utilities.pad(n+2)+"tipo_expr: "+tipo_expr);
        dump_SimboloAbstracto(out, n + 2, token);
    }
    
    //---------------------------------------
    @Override
    public void aceptar(Visitor visit, Object... params) {
        visit.visitar(this, params);
    }
    
    //---------------------------------------
    //  </editor-fold>
}
