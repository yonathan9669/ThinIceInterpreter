package thinice.AST;

import thinice.TS.SimboloAbstracto;

public class PosVector extends Variable{
    Expresion exp;
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public PosVector(SimboloAbstracto nombre, Expresion exp, int linea, int columna) {
        super(nombre, linea, columna);
        this.exp = exp;
    }
    //  </editor-fold>
    
}
