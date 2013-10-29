package thinice.AST;

import java.io.PrintStream;
import thinice.TS.AbstractSymbol;
import thinice.util.Utilities;

public abstract class NodoArbol {
    //---------------------------Protected Attributes---------------------------
    // <editor-fold desc="Private Attributes">
    protected int linea;
    protected int columna;
    protected NodoArbol padre;
    
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Public Attributes------------------------------
    // <editor-fold desc="Public Attributes">
    public int profundidad;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public NodoArbol() {
        this.linea = 1;
        this.columna = 1;
        this.padre = null;
        this.profundidad = 0;
    }

    //---------------------------------------
    public NodoArbol(int linea, int columna) {
        this.linea = linea;
        this.columna = columna;
        this.padre = null;
    }
    
    //---------------------------------------
    public NodoArbol(int linea, int columna, int profundidad) {
        this.linea = linea;
        this.columna = columna;
        this.padre = null;
        this.profundidad = profundidad;
    }
    
    //---------------------------------------
    public NodoArbol(int linea, int columna, NodoArbol padre) {
        this.linea = linea;
        this.columna = columna;
        this.padre = padre;
        this.profundidad = padre.profundidad + 1;
    }
    
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Getters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public int getColumna() {
        return columna;
    }
    
    //---------------------------------------
    public int getLinea() {
        return linea;
    }

    //---------------------------------------
    public NodoArbol getPadre() {
        return padre;
    }

    //---------------------------------------
    //  </editor-fold>
    //---------------------------Setters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Setters">
    public void setPadre(NodoArbol padre) {
        this.padre = padre;
        this.profundidad = padre.profundidad + 1;
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Protected Methods------------------------------ 
    // <editor-fold defaultstate="collapsed" desc="Protected Methods">
    protected void dump_SimboloAbstracto(PrintStream out, int n, AbstractSymbol sym) {
        out.print(Utilities.pad(n));
        out.println(sym.getTexto());
    }
    
    protected void dumpLineaColumna(PrintStream out, int n) {
        out.print(Utilities.pad(n) + "#" + linea + ":"+columna+": ");
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Abstract Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Abstract Methods">
    public abstract void dump(PrintStream out, int n);
    public abstract void aceptar(Visitor visit, Object... params);
    //---------------------------------------
    //  </editor-fold>
}
