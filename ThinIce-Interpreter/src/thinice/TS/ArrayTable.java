package thinice.TS;

public class ArrayTable extends AbstractTable<AbstractSymbol, ArraySymbol> {
    //---------------------------Public Methods---------------------------------
    // <editor-fold defaultstate="collapsed" desc="Public Methods">

    @Override
    public AbstractSymbol addSymbol(AbstractSymbol key, int linea, int columna) {
        ArraySymbol vec = this.get(key);

        if (vec == null) {
            vec = new ArraySymbol(key, linea, columna);
            this.put(key, vec);
        } else {
            vec = ((ArraySymbol) vec.clone());
            vec.linea = linea;
            vec.columna = columna;
        }
        
        return vec;
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    protected ArraySymbol getNewSymbol(AbstractSymbol sim, int indice, int linea, int columna) {
        return new ArraySymbol(sim, linea, columna);
    }
    //---------------------------------------
    //  </editor-fold>   
}
