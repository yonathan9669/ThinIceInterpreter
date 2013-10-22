package thinice.AST;

import java.io.PrintStream;

public class Declaracion extends Sentencia{
    //---------------------------Protected Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    protected TipoVariable tipo;
    protected Variable id;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Declaracion(TipoVariable tipo, Variable id, int linea, int columna) {
        super(linea, columna);
        this.tipo = tipo;
        this.id = id;
    }
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println("_asignacion");
        tipo.dump(out, n + 2);
        id.dump(out, n + 2);
    }
    //  </editor-fold>
    
}
