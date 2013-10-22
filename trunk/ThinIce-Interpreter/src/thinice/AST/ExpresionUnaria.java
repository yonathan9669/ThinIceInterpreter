package thinice.AST;

public abstract class ExpresionUnaria extends Expresion{
    //---------------------------Protected Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    protected Expresion expr;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public ExpresionUnaria(Expresion expr, int linea, int columna) {
        super(linea, columna);
        this.expr = expr;
    }
    //  </editor-fold>
}
