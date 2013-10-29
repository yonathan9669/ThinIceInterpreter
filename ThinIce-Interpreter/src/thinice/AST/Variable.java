package thinice.AST;

import java.io.PrintStream;
import thinice.TS.AbstractSymbol;
import thinice.util.Utilities;

public class Variable extends Expresion{
    //---------------------------Protected Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    protected AbstractSymbol nombre;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Variable(AbstractSymbol nombre, int linea, int columna) {
        super(linea, columna);
        this.nombre = nombre;
    }
    //  </editor-fold>
    //---------------------------Public Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Public Methods">

    public AbstractSymbol getNombre() {
        return nombre;
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println(" " + AbstractSymbol.nombreTipo[AbstractSymbol.VARIABLE]);
        if(tipo_expr!=null) out.println(Utilities.pad(n+2)+"tipo_expr: "+tipo_expr);
        dump_SimboloAbstracto(out, n + 2, nombre);
    }
    
    //---------------------------------------
    @Override
    public void aceptar(Visitor visit, Object... params) {
            visit.visitar(this, params);
    }
    
    //---------------------------------------
    @Override
    public String getTextExpression() {
        return this.nombre.getTexto();
    }
    //  </editor-fold>

    
}
