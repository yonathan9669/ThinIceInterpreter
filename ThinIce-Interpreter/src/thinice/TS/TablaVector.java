package thinice.TS;

public class TablaVector extends TablaAbstracta<SimboloAbstracto, SimboloVector> {
    //---------------------------Public Methods---------------------------------
    // <editor-fold defaultstate="collapsed" desc="Public Methods">

    @Override
    public SimboloAbstracto agregarSimbolo(SimboloAbstracto key, int linea, int columna) {
        SimboloVector vec = this.get(key);

        if (vec == null) {
            vec = new SimboloVector(key, linea, columna);
            this.put(key, vec);
        } else {
            vec = ((SimboloVector) vec.clone());
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
    protected SimboloVector getNuevoSimbolo(SimboloAbstracto sim, int indice, int linea, int columna) {
        return new SimboloVector(sim, linea, columna);
    }
    //---------------------------------------
    //  </editor-fold>   
}
