package thinice.AST;

import java.io.PrintStream;
import thinice.TS.SimboloAbstracto;
import thinice.util.Utilidades;

public class Variable extends Expresion{
    //---------------------------Protected Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    protected SimboloAbstracto nombre;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Variable(SimboloAbstracto nombre, int linea, int columna) {
        super(linea, columna);
        this.nombre = nombre;
    }
    //  </editor-fold>
    //---------------------------Public Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Public Methods">

    public SimboloAbstracto getNombre() {
        return nombre;
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println("_variable");
        if(tipo_expr!=null) out.println(Utilidades.pad(n+2)+"tipo_expr: "+tipo_expr);
        dump_SimboloAbstracto(out, n + 2, nombre);
    }
    //---------------------------------------
    //  </editor-fold>
}
