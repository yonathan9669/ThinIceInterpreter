package thinice.TS;

public class SimboloEntero extends SimboloAbstracto{
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public SimboloEntero(int indice, String texto, int linea, int columna) {
        super(indice, texto, linea, columna, SimboloAbstracto.ENTERO);
    }
    
    //---------------------------------------
    public SimboloEntero(String texto, int linea, int columna) {
        super(texto, linea, columna, SimboloAbstracto.ENTERO);
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public Object clone() {
        return new SimboloEntero(indice, texto, linea, columna);
    }

    //---------------------------------------
    //  </editor-fold>
 
}
