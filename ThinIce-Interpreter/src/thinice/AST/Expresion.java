package thinice.AST;

import thinice.TS.AbstractSymbol;

public abstract class Expresion extends NodoArbol{
    //---------------------------Package Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    AbstractSymbol tipo_expr;

    //  </editor-fold>
    //---------------------------Setters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Setters">
    public void setTipo_expr(AbstractSymbol tipo_expr) {
        this.tipo_expr = tipo_expr;
    }
    
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Getters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public AbstractSymbol getTipo_expr() {
        return tipo_expr;
    }
    
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Expresion(int linea, int columna) {
        super(linea, columna);
        tipo_expr = null;
    }
    
    //---------------------------------------
    public Expresion(int linea, int columna, AbstractSymbol tipo_expr) {
        super(linea, columna);
        this.tipo_expr = tipo_expr;
    }
    //  </editor-fold>
    //---------------------------Abstract Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Abstract Methods">
    public abstract String getTextExpression();
    //---------------------------------------
    //  </editor-fold>
}
