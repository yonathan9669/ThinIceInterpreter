package thinice.TS;

public class IdSymbol extends AbstractSymbol{
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public IdSymbol(int indice, String texto, int linea, int columna) {
        super(indice, texto, linea, columna);
    }
    
    //---------------------------------------
    public IdSymbol(String texto, int linea, int columna) {
        super(texto, linea, columna);
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public Object clone() {
        return new IdSymbol(indice, texto, linea, columna);
    }

    //---------------------------------------
    //  </editor-fold>
 
}
