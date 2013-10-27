package thinice.TS;

public class SimboloBooleano extends SimboloAbstracto{
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public SimboloBooleano(int indice, String texto, int linea, int columna) {
        super(indice, texto, linea, columna, SimboloAbstracto.BOOLEANO);
    }
    
    //---------------------------------------
    public SimboloBooleano(String texto, int linea, int columna) {
        super(texto, linea, columna, SimboloAbstracto.BOOLEANO);
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public Object clone() {
        return new SimboloBooleano(indice, texto, linea, columna);
    }

    //---------------------------------------
    //  </editor-fold>
 
}
