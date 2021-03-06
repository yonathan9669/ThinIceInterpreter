package thinice.AST;

import java.io.PrintStream;

public class Programa extends NodoArbol {
    //---------------------------Private Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    ListaSentencia sentencias;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Programa(ListaSentencia sentencias, int linea, int columna) {
        super(linea, columna);
        this.sentencias = sentencias;
    }

    //  </editor-fold>
    //---------------------------Getters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public ListaSentencia getSentencias() {
        return sentencias;
    }
    
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println("_programa");
        sentencias.dump(out, n + 2);
    }
    
    //---------------------------------------
    @Override
    public void aceptar(Visitor visit, Object... params) {
        visit.visitar(this, params);
    }
    //---------------------------------------
    //  </editor-fold>
}
