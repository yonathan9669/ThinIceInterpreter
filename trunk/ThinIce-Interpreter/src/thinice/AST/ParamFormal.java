package thinice.AST;

import java.io.PrintStream;
import thinice.TS.SimboloAbstracto;

public abstract class ParamFormal extends NodoArbol{
    //---------------------------Protected Attributes------------------------------
    // <editor-fold desc="Public Attributes">
    protected SimboloAbstracto tipo;
    protected SimboloAbstracto id;
    protected boolean esDireccion;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public ParamFormal(SimboloAbstracto tipo, SimboloAbstracto id, int linea, int columna) {
        super(linea, columna);
        this.tipo = tipo;
        this.id = id;
        this.esDireccion = false;
    }

    //---------------------------------------
    public ParamFormal(SimboloAbstracto tipo, SimboloAbstracto id, boolean esDireccion, int linea, int columna) {
        super(linea, columna);
        this.tipo = tipo;
        this.id = id;
        this.esDireccion = esDireccion;
    }
    
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println("_parametro_formal");
        dump_SimboloAbstracto(out, n+2, tipo);
        dump_SimboloAbstracto(out, n+2, id);
    }//  </editor-fold>
    
}
