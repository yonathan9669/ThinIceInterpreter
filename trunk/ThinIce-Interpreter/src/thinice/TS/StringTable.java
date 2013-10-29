package thinice.TS;

public class StringTable extends AbstractTable<String, AbstractSymbol>{
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    protected AbstractSymbol getNewSymbol(String texto, int indice, int linea, int columna){
        return new StringSymbol(indice, texto, linea, columna);
    }
    //---------------------------------------
    //  </editor-fold>    
}
