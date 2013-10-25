package thinice.AST;

import java.io.PrintStream;
import thinice.TS.SimboloAbstracto;
import thinice.util.Utilidades;

public class Booleano extends Constante{
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Booleano(SimboloAbstracto token, int linea, int columna) {
        super(linea, columna, token);
    }
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println("_booleano");
        if(tipo_expr!=null) out.println(Utilidades.pad(n+2)+"tipo_expr: "+tipo_expr);
        dump_SimboloAbstracto(out, n + 2, token);
    }
    //---------------------------------------
    //  </editor-fold>
}
