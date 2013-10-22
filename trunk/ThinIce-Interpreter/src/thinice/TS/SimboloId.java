package thinice.TS;

public class SimboloId extends SimboloAbstracto{
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public SimboloId(int indice, String texto, int linea, int columna) {
        super(indice, texto, linea, columna);
    }
    
    //---------------------------------------
    public SimboloId(String texto, int linea, int columna) {
        super(texto, linea, columna);
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
