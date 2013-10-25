package thinice.AST;

import java.io.PrintStream;
import thinice.TS.SimboloAbstracto;
import thinice.util.Utilidades;

public class Entero extends Constante{
    //---------------------------Private Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    protected String signo;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Entero(SimboloAbstracto token, int linea, int columna, String signo) {
        super(linea, columna, token);
        this.signo = signo;
    }
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.print("_entero_");
        out.println(signo);
        if(tipo_expr!=null) out.println(Utilidades.pad(n+2)+"tipo_expr: "+tipo_expr);
        dump_SimboloAbstracto(out, n + 2, token);
    }
    //---------------------------------------
    //  </editor-fold>
}
