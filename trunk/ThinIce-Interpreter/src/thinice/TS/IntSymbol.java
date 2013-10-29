package thinice.TS;

public class IntSymbol extends AbstractSymbol{
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public IntSymbol(int indice, String texto, int linea, int columna) {
        super(indice, texto, linea, columna);
    }
    
    //---------------------------------------
    public IntSymbol(String texto, int linea, int columna) {
        super(texto, linea, columna);
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public Object clone() {
        return new IntSymbol(indice, texto, linea, columna);
    }

    //---------------------------------------
    //  </editor-fold>
 
}
