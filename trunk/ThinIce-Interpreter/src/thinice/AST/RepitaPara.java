package thinice.AST;

import java.io.PrintStream;
import thinice.util.Utilidades;

public class RepitaPara extends Sentencia{
    //---------------------------Protected Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    protected Asignacion asign1;
    protected Asignacion asign2;
    protected Expresion condicion;
    protected ListaSentencia sentencias;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public RepitaPara(Asignacion asign1, Asignacion asign2, Expresion condicion, 
            ListaSentencia sentencias, int linea, int columna) {
        super(linea, columna);
        this.asign1 = asign1;
        this.asign2 = asign2;
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
        out.println("_repita-para");
        asign1.dump(out, n+2);
        asign2.dump(out, n+2);
        condicion.dump(out, n+2);
        out.println(Utilidades.pad(n+2) + "_sentencias");
        sentencias.dump(out, n+4);
    }
    //  </editor-fold>
    
}
