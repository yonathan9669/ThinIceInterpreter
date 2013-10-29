package thinice.AST;

import java.io.PrintStream;
import thinice.TS.AbstractSymbol;
import thinice.util.Utilities;

public class Entero extends Constante{
    //---------------------------Static Constants-------------------------------
    // <editor-fold desc="Static Constants">
    public static final int POSITIVO = 0;
    public static final int NEGATIVO = 1;
    
    public static final String[] signo = {"positivo", "negativo"};    
    //  </editor-fold>
    //---------------------------Private Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    protected boolean isPositive;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Entero(AbstractSymbol token, int linea, int columna, boolean isPositive) {
        super(linea, columna, token);
        this.isPositive = isPositive;
    }
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.print("_constante");
        out.print(" " + AbstractSymbol.nombreTipo[AbstractSymbol.ENTERO]);
        out.println(" " + signo[(isPositive) ? POSITIVO:NEGATIVO]);
        if(tipo_expr!=null) out.println(Utilities.pad(n+2)+"tipo_expr: "+tipo_expr);
        dump_SimboloAbstracto(out, n + 2, token);
    }
    
    //---------------------------------------
    @Override
    public void aceptar(Visitor visit, Object... params) {
        visit.visitar(this, params);
    }
    //  </editor-fold>

    
}
