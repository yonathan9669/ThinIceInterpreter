package thinice.AST;

import java.io.PrintStream;
import thinice.util.Utilidades;

public class RepitaHasta extends Sentencia{
    //---------------------------Protected Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    protected Expresion condicion;
    protected ListaSentencia sentencias;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public RepitaHasta(Expresion condicion, ListaSentencia sentencias, int linea, int columna) {
        super(linea, columna);
        this.condicion = condicion;
        this.sentencias = sentencias;
    }
    
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println("_repita-hasta");
        out.println(Utilidades.pad(n+2) + "_sentencias");
        sentencias.dump(out, n+4);
        condicion.dump(out, n+2);
    }
    //  </editor-fold>
    
}
