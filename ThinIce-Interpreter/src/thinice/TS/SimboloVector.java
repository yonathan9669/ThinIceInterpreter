package thinice.TS;

public class SimboloVector extends SimboloId{
    //---------------------------Private Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    private SimboloAbstracto[] elementos;
    private int size;
    //---------------------------------------
    //  </editor-fold
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public SimboloVector(SimboloAbstracto id, int linea, int columna) {
        super(id.getIndice(), id.getTexto(), linea, columna);
    }
    //  </editor-fold>>
    //---------------------------Public Methods---------------------------------
    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    public void initVec(int size){
        this.size = size;
        elementos = new SimboloAbstracto[size];
    }
    
    //---------------------------------------
    public SimboloAbstracto getValue(int pos)throws ArrayIndexOutOfBoundsException{
        if(pos < 0 || pos >= pos)
            throw new ArrayIndexOutOfBoundsException("El indice solicitado esta fuera de los limites del vector := "+ texto + "["+size+"]");
        
        return elementos[pos];
    }
    //---------------------------------------
    public void setValue(int pos, SimboloAbstracto value)throws ArrayIndexOutOfBoundsException{
        if(pos < 0 || pos >= pos)
            throw new ArrayIndexOutOfBoundsException("La posicion que intenta acceder no pertenece al vector := "+ texto + "["+size+"]");
        
        this.elementos[pos] = value;
    }
    //---------------------------------------
    
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public Object clone() {
        return new SimboloVector(new SimboloId(texto, linea, columna), linea, columna);
    }
    //---------------------------------------
    //  </editor-fold>
    
}
