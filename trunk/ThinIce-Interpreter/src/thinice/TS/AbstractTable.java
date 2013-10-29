package thinice.TS;

import java.util.Collection;
import java.util.HashMap;

public abstract class AbstractTable<K, V> extends HashMap<K, V>{
    //---------------------------Private Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    private int idx;   
    private static int TAM_MAX_SYMB=1024;
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Protected Attributes---------------------------
    // <editor-fold desc="Protected Attributes">
    
    //  </editor-fold>
    //---------------------------Public Attributes------------------------------
    // <editor-fold desc="Public Attributes">
    public static IntTable intTabla = new IntTable();
    public static BooleanTable boolTabla = new BooleanTable();
    public static IdTable idTabla = new IdTable();
    public static StringTable texTabla = new StringTable();
    public static ArrayTable vecTabla = new ArrayTable();
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public AbstractTable() {
        super();
        idx = 0;
    }   
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Public Methods--------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    public AbstractSymbol addSymbol(K texto, int linea, int columna){
        return addSymbol(texto, TAM_MAX_SYMB, linea, columna);
    }
    
    //---------------------------------------
    public AbstractSymbol addSymbol(K key, int tam, int linea, int columna){
        if(key instanceof String){
            key = (K)((((String)key).length() <= TAM_MAX_SYMB) ? key : ((String)key).substring(0, TAM_MAX_SYMB));
        }
        
        AbstractSymbol value = ((AbstractSymbol) this.get(key));
        
        if(value == null){
            value = (AbstractSymbol) getNewSymbol(key, idx++, linea, columna);
            this.put(key, (V)value);
        }else{
            value = (AbstractSymbol) value.clone();
            value.linea = linea;
            value.columna = columna;
        }
        
        return value;
    }
    //---------------------------------------
    
    public Collection<V> getSimbolos() {
        return this.values();
    }
    //---------------------------------------
    
    public V getSimbolo(K texto){
        return this.get(texto);
    }
    //---------------------------------------
    
    public V getSimbolo(int indice){
        for(V sym: getSimbolos()){
            if(sym.equals(indice))
                return sym;
        }
        
        return null;
    }
    //  </editor-fold>
    //---------------------------Abstract Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Abstract Methods">
    protected abstract V getNewSymbol(K texto, int indice, int linea, int columna);
    //---------------------------------------
    //  </editor-fold>    
}
