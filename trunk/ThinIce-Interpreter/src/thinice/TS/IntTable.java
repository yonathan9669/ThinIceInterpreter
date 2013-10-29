package thinice.TS;

public class IntTable extends AbstractTable<String, AbstractSymbol>{
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Abstract Methods">
    @Override
    protected AbstractSymbol getNewSymbol(String texto, int indice, int linea, int columna) {
        return new IntSymbol(indice, texto, linea, columna);
    }
    //---------------------------------------
    //  </editor-fold>
}