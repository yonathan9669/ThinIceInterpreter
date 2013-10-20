package thinice.AST;

import java.io.PrintStream;

public abstract class Nodo {
    //---------------------------Static Constants-------------------------------
    // <editor-fold desc="Static Constants">
    public static final String padding = "                                                                                                    ";
    //  </editor-fold>
    //---------------------------Private Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    private int linea;
    private int columna;
    private Nodo padre;
    
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Public Attributes------------------------------
    // <editor-fold desc="Public Attributes">
    public int profundidad;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Nodo() {
        this.linea = 1;
        this.columna = 1;
        this.padre = null;
        this.profundidad = 0;
    }
    
    //---------------------------------------
    public Nodo(int linea, int columna, int profundidad) {
        this.linea = linea;
        this.columna = columna;
        this.padre = null;
        this.profundidad = profundidad;
    }
    
    //---------------------------------------
    public Nodo(int linea, int columna, Nodo padre) {
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
    public Nodo getPadre() {
        return padre;
    }

    //---------------------------------------
    //  </editor-fold>
    //---------------------------Setters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Setters">
    public void setPadre(Nodo padre) {
        this.padre = padre;
        this.profundidad = padre.profundidad + 1;
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Public Methods--------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Private Methods-------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Private Methods">
    private String getPadding() {
        return (profundidad > 0) ? padding.substring(0, profundidad * 5) : "";
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    public String toString() {
        return getPadding() + "[" + linea + "·" + columna + "] ";
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Abstract Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Abstract Methods">
    public abstract void dump(PrintStream out, int n);
    //---------------------------------------
    //  </editor-fold>
}
