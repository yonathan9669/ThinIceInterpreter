package thinice.AST;

import java.io.PrintStream;
import thinice.util.Utilities;

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
    //---------------------------Getters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public Expresion getCondicion() {
        return condicion;
    }
    
    //---------------------------------------
    public ListaSentencia getSentencias() {
        return sentencias;
    }
    
    //  </editor-fold>
    //---------------------------Public Methods--------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println("_repita-hasta");
        condicion.dump(out, n+2);
        out.println(Utilities.pad(n+2) + "_sentencias");
        sentencias.dump(out, n+4);
    }
    
    //---------------------------------------
    @Override
    public void aceptar(Visitor visit, Object... params) {
        visit.visitar(this, params);
    }
    
    //---------------------------------------
    //  </editor-fold>
    
}
