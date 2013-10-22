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
    public TipoVariable(int linea, int columna, SimboloAbstracto tipo_var) {
        super(linea, columna);
        this.tipo_var = tipo_var;
    }
    //  </editor-fold>
}
