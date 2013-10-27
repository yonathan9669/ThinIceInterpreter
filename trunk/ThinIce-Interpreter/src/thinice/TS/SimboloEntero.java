package thinice.TS;

public class SimboloEntero extends SimboloAbstracto{
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public SimboloEntero(int indice, String texto, int linea, int columna, int tipo) {
        super(indice, texto, linea, columna, tipo);
    }
    
    //---------------------------------------
    public SimboloEntero(String texto, int linea, int columna, int tipo) {
        super(texto, linea, columna, tipo);
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public Object clone() {
        return new SimboloEntero(indice, texto, linea, columna, 1);
    }

    //---------------------------------------
    //  </editor-fold>
 
}
