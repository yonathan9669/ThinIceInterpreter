package thinice.AST;

import java.io.PrintStream;

public class DeclCompleja extends Declaracion{
    //---------------------------Protected Attributes---------------------------
    // <editor-fold desc="Private Attributes">
    protected Asignacion asign;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public DeclCompleja(int tipo, Asignacion asign, int linea, int columna) {
        super(tipo, linea, columna);
        this.asign = asign;
    }

    //  </editor-fold>
    //---------------------------Getters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public Asignacion getAsign() {
        return asign;
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println("_declaracion_compleja");
        super.dump(out, n+2);
        asign.dump(out, n+2);
    }
    
    //---------------------------------------
    @Override
    public Variable getId() {
        return asign.getVariable();
    }
    //  </editor-fold>
}
