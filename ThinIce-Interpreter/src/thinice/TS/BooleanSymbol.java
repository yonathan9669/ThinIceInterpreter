package thinice.TS;

public class BooleanSymbol extends AbstractSymbol{
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public BooleanSymbol(int indice, String texto, int linea, int columna) {
        super(indice, texto, linea, columna);
    }
    
    //---------------------------------------
    public BooleanSymbol(String texto, int linea, int columna) {
        super(texto, linea, columna);
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public Object clone() {
        return new BooleanSymbol(indice, texto, linea, columna);
    }

    //---------------------------------------
    //  </editor-fold>
 
}
