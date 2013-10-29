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
    //---------------------------Getters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public Expresion getLeftExp(){
        return this.expr1;
    }
    //---------------------------------------
    public Expresion getRightExp(){
        return this.expr2;
    }
    //  </editor-fold>
    //---------------------------Abstract Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Abstract Methods">
    //---------------------------------------
    //  </editor-fold>
}
