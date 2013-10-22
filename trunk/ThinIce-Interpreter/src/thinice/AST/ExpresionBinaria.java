package thinice.AST;

public abstract class ExpresionBinaria extends Expresion{
    //---------------------------Protected Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    protected Expresion expr1;
    protected Expresion expr2;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public ExpresionBinaria(Expresion expr1, Expresion expr2, int linea, int columna) {
        super(linea, columna);
        this.expr1 = expr1;
        this.expr2 = expr2;
    }
    //  </editor-fold>
}
