package thinice.TS;

public class StringSymbol extends AbstractSymbol{
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public StringSymbol(int indice, String texto, int linea, int columna) {
        super(indice, texto, linea, columna);
    }
    
    //---------------------------------------
    public StringSymbol(String texto, int linea, int columna) {
        super(texto, linea, columna);
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public Object clone() {
        return new StringSymbol(indice, texto, linea, columna);
    }

    //---------------------------------------
    //  </editor-fold>
 
}
