package thinice.AST;

import java.io.PrintStream;
import thinice.TS.SimboloAbstracto;
import thinice.util.Utilidades;

public class PosVector extends Variable{
    Expresion exp;
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public PosVector(SimboloAbstracto nombre, Expresion exp, int linea, int columna) {
        super(nombre, linea, columna);
        this.exp = exp;
    }
    //  </editor-fold>    
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println("_vector");
        if(tipo_expr!=null) out.println(Utilidades.pad(n+2)+"tipo_expr: "+tipo_expr);
        dump_SimboloAbstracto(out, n + 2, nombre);
        dumpLineaColumna(out, n + 4);
        out.println("_posicion");
        exp.dump(out, n + 4);
    }
    //---------------------------------------
    //  </editor-fold>
}
