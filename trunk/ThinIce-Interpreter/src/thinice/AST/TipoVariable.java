package thinice.AST;

import thinice.TS.SimboloAbstracto;

public abstract class TipoVariable extends NodoArbol{
    //---------------------------Package Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    SimboloAbstracto tipo_var;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public TipoVariable(int linea, int columna) {
        super(linea, columna);
        tipo_var = null;
    }
    
    //---------------------------------------
    public TipoVariable(SimboloAbstracto tipo_var) {
        super(tipo_var.getLinea(), tipo_var.getColumna());
        this.tipo_var = tipo_var;
    }
    //  </editor-fold>
    //---------------------------Public Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Public Methods">

    public SimboloAbstracto getTipoVar() {
        return tipo_var;
    }
    //---------------------------------------
    //  </editor-fold>
}
