package thinice.AST;

import java.io.PrintStream;

public abstract class Declaracion extends Sentencia{
    //---------------------------Protected Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    protected TipoVariable tipo;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Declaracion(int linea, int columna) {
        super(linea, columna);
    }
    //  </editor-fold>
}
