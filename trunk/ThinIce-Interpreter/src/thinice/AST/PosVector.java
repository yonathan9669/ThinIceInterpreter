package thinice.AST;

import java.io.PrintStream;
import thinice.TS.AbstractSymbol;
import thinice.util.Utilities;

public class PosVector extends Variable{
    Expresion exp;
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public PosVector(AbstractSymbol nombre, Expresion exp, int linea, int columna) {
        super(nombre, linea, columna);
        this.exp = exp;
    }

    //  </editor-fold>
    //---------------------------Getters----------------------------------------
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public Expresion getExp() {
        return exp;
    }
    
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println(" " + AbstractSymbol.nombreTipo[AbstractSymbol.VECTOR]);
        if(tipo_expr!=null) out.println(Utilities.pad(n+2)+"tipo_expr: "+tipo_expr);
        dump_SimboloAbstracto(out, n + 2, nombre);
        dumpLineaColumna(out, n + 4);
        out.println("_posicion");
        exp.dump(out, n + 4);
    }
    
    //---------------------------------------
    @Override
    public void aceptar(Visitor visit, Object... params) {
        visit.visitar(this, params);
    }
    
    //---------------------------------------
    @Override
    public String getTextExpression() {
        return super.getTextExpression() + "[" + this.exp.getTextExpression() + "]";
    }
    //  </editor-fold>
}
