package thinice.AST;

import thinice.TS.SimboloAbstracto;

public abstract class Expresion extends NodoArbol{
    //---------------------------Package Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    SimboloAbstracto tipo_expr;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Expresion(int linea, int columna) {
        super(linea, columna);
        tipo_expr = null;
    }
    
    //---------------------------------------
    public Expresion(int linea, int columna, SimboloAbstracto tipo_expr) {
        super(linea, columna);
        this.tipo_expr = tipo_expr;
    }
    //  </editor-fold>
}
