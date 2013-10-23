package thinice.AST;

import java.io.PrintStream;

public class DeclCompleja extends Declaracion{
    //---------------------------Protected Attributes---------------------------
    // <editor-fold desc="Private Attributes">
    protected Asignacion asign;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public DeclCompleja(TipoVariable tipo, Asignacion asign, int linea, int columna) {
        super(linea, columna);
        this.tipo = tipo;
        this.asign = asign;
    }
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println("_declaracion_compleja");
        tipo.dump(out, n+2);
        asign.dump(out, n+2);
    }
    //  </editor-fold>
    
}
