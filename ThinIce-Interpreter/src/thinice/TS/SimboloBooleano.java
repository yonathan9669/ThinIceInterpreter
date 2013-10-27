package thinice.TS;

public class SimboloBooleano extends SimboloAbstracto{
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public SimboloBooleano(int indice, String texto, int linea, int columna, int tipo) {
        super(indice, texto, linea, columna, tipo);
    }
    
    //---------------------------------------
    public SimboloBooleano(String texto, int linea, int columna, int tipo) {
        super(texto, linea, columna, tipo);
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public Object clone() {
        return new SimboloBooleano(indice, texto, linea, columna, 0);
    }

    //---------------------------------------
    //  </editor-fold>
 
}
