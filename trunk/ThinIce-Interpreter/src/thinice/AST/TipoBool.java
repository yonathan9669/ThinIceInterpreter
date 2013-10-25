package thinice.AST;

import java.io.PrintStream;
import thinice.TS.SimboloAbstracto;
import thinice.util.Utilidades;

public class TipoBool extends TipoVariable{
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public TipoBool(SimboloAbstracto simbolo) {
        super(simbolo);
    }
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println("_tipo-bool");
        if(tipo_var!=null) out.println(Utilidades.pad(n+2)+"tipo_var: "+tipo_var);
        dump_SimboloAbstracto(out, n + 2, tipo_var);
    }
    //  </editor-fold>
}
