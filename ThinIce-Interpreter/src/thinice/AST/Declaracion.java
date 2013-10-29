package thinice.AST;

import java.io.PrintStream;
import thinice.TS.AbstractSymbol;

public abstract class Declaracion extends Sentencia{
    //---------------------------Protected Attributes---------------------------
    // <editor-fold desc="Private Attributes">
    protected int tipo;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Declaracion(int tipo, int linea, int columna) {
        super(linea, columna);
        this.tipo = tipo;
    }

    //  </editor-fold>
    //---------------------------Getters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public int getTipo() {
        return tipo;
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">@Override
    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println("_tipo_de_dato "+ AbstractSymbol.nombreTipo[tipo]);
    }
    
    //---------------------------------------
    @Override
    public void aceptar(Visitor visit, Object... params) {
        visit.visitar(this, params);
    }
    //  </editor-fold>
    //---------------------------Abstract Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Abstract Methods">
    public abstract Variable getId();
    //---------------------------------------
    //  </editor-fold>
}
