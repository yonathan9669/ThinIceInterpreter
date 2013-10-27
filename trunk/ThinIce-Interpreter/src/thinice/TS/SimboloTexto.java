package thinice.TS;

public class SimboloTexto extends SimboloAbstracto{
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public SimboloTexto(int indice, String texto, int linea, int columna) {
        super(indice, texto, linea, columna);
    }
    
    //---------------------------------------
    public SimboloTexto(String texto, int linea, int columna) {
        super(texto, linea, columna);
    }
    //---------------------------------------
    
    public SimboloTexto(int indice, String texto, int linea, int columna, int tipo) {
        super(indice, texto, linea, columna, tipo);
    }
    
    //---------------------------------------
    public SimboloTexto(String texto, int linea, int columna, int tipo) {
        super(texto, linea, columna, tipo);
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public Object clone() {
        return new SimboloTexto(indice, texto, linea, columna);
    }

    //---------------------------------------
    //  </editor-fold>
 
}
