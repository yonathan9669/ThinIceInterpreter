package thinice.AST;

import java.io.PrintStream;
import thinice.TS.SimboloAbstracto;

public class LlamadaFuncion extends Sentencia{
    //---------------------------Protected Attributes-----------------------------
    // <editor-fold desc="Protected Attributes">
    protected SimboloAbstracto id;
    protected ListaParametros params;
    //  </editor-fold>
    //---------------------------Private Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    private boolean tieneParam;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public LlamadaFuncion(SimboloAbstracto id, ListaParametros params, int linea, int columna) {
        super(linea, columna);
        this.id = id;
        this.params = params;
        tieneParam = true;
    }
    
    //---------------------------------------
    public LlamadaFuncion(SimboloAbstracto id, int linea, int columna) {
        super(linea, columna);
        this.id = id;
        this.params = null;
        tieneParam = false;
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println("_llamadaFuncion");
        dump_SimboloAbstracto(out, n + 2, id);
        if(tieneParam)
            params.dump(out, n + 2);
    }
    //  </editor-fold>
    
}
