package thinice.TS;

public class BooleanTable extends AbstractTable<String, AbstractSymbol>{
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Abstract Methods">
    @Override
    protected AbstractSymbol getNewSymbol(String texto, int indice, int linea, int columna){
        return new BooleanSymbol(indice, texto, linea, columna);
    }
    //---------------------------------------
    //  </editor-fold>    
}
