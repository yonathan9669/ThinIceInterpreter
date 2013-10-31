package thinice.AST;

import java.io.PrintStream;
import thinice.util.Utilities;

public class Relacionales extends ExpresionBinaria {
    //---------------------------Static Constants-------------------------------
    // <editor-fold desc="Static Constants">

    public static final int MENOR = 0;
    public static final int MENOR_IGUAL = 1;
    public static final int MAYOR = 2;
    public static final int MAYOR_IGUAL = 3;
    public static final int IGUAL = 4;
    public static final int DIFERENTE = 5;
    public static final String[] typeName = {"_menor_que", "_menor_igual_que", "_mayor_que", "_mayor_igual_que", "_igual_que", "_diferente_que"};
    private static final String[] typeToken = {"<", "<=", ">", ">=", "=", "<>"};
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Private Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    private int type;
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">

    public Relacionales(Expresion expr1, Expresion expr2, int TIPO, int linea, int columna) {
        super(expr1, expr2, linea, columna);
        this.type = TIPO;
    }
    //  </editor-fold>
    //---------------------------Getters-----------------------------
    // <editor-fold desc="Getters">
    public int getType(){
        return type;
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Public Methods--------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    public boolean getExpressionResult(boolean isBool){
        switch(type){
            case IGUAL:
                if(isBool)
                    return ((Boolean)this.expr1.getValue()).booleanValue() == ((Boolean)this.expr2.getValue()).booleanValue();
                else
                    return ((Integer)this.expr1.getValue()).intValue() == ((Integer)this.expr2.getValue()).intValue();
            case DIFERENTE:
                if(isBool)
                    return ((Boolean)this.expr1.getValue()).booleanValue() != ((Boolean)this.expr2.getValue()).booleanValue();
                else
                    return ((Integer)this.expr1.getValue()).intValue() != ((Integer)this.expr2.getValue()).intValue();
            case MENOR:
                return ((Integer)this.expr1.getValue()).intValue() < ((Integer)this.expr2.getValue()).intValue();
            case MENOR_IGUAL:
                return ((Integer)this.expr1.getValue()).intValue() <= ((Integer)this.expr2.getValue()).intValue();
            case MAYOR:
                return ((Integer)this.expr1.getValue()).intValue() > ((Integer)this.expr2.getValue()).intValue();
            case MAYOR_IGUAL:
                return ((Integer)this.expr1.getValue()).intValue() >= ((Integer)this.expr2.getValue()).intValue();
        }
        return false;
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println(typeName[type]);
        if (tipo_expr != null) {
            out.println(Utilities.pad(n + 2) + "tipo_expr: " + tipo_expr);
        }
        expr1.dump(out, n + 2);
        expr2.dump(out, n + 2);
    }

    //---------------------------------------
    @Override
    public void aceptar(Visitor visit, Object... params) {
        visit.visitar(this, params);
    }

    //---------------------------------------
    @Override
    public String getTextExpression() {
        return this.expr1.getTextExpression() + " " + typeToken[type] + " " + this.expr2.getTextExpression();
    }
    //  </editor-fold>
}
