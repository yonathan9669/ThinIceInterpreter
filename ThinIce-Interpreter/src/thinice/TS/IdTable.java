package thinice.TS;

public class IdTable extends AbstractTable<String, AbstractSymbol>{
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Abstract Methods">
    @Override
    protected AbstractSymbol getNewSymbol(String texto, int indice, int linea, int columna){
        return new IdSymbol(indice, texto, linea, columna);
    }
    //---------------------------------------
    //  </editor-fold>    
}
