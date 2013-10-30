package thinice.AST;

import thinice.TS.AbstractSymbol;

public abstract class Constante extends Expresion{
    //---------------------------Protected Attributes---------------------------
    // <editor-fold desc="Private Attributes">
    protected AbstractSymbol token;
    //  </editor-fold>
    
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Constante(int linea, int columna, AbstractSymbol token) {
        super(linea, columna);
        this.token = token;
    }

    //  </editor-fold>
    //---------------------------Getters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public AbstractSymbol getToken() {
        return token;
    }
    
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public String getTextExpression() {
        return this.token.getTexto();
    }
    
    //---------------------------------------
    //  </editor-fold>
    
}
