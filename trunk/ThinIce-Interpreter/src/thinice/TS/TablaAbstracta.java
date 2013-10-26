package thinice.TS;

import java.util.Collection;
import java.util.HashMap;

public abstract class TablaAbstracta<K, V> extends HashMap<K, V>{
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
    public static TablaEntero intTabla = new TablaEntero();
    public static TablaBooleano boolTabla = new TablaBooleano();
    public static TablaId idTabla = new TablaId();
    public static TablaTexto texTabla = new TablaTexto();
    public static TablaVector vecTabla = new TablaVector();
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public TablaAbstracta() {
        super();
        idx = 0;
    }   
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Public Methods--------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    public SimboloAbstracto agregarSimbolo(K texto, int linea, int columna){
        return agregarSimbolo(texto, TAM_MAX_SYMB, linea, columna);
    }
    
    //---------------------------------------
    public SimboloAbstracto agregarSimbolo(K key, int tam, int linea, int columna){
        if(key instanceof String){
            key = (K)((((String)key).length() <= TAM_MAX_SYMB) ? key : ((String)key).substring(0, TAM_MAX_SYMB));
        }
        
        SimboloAbstracto value = (SimboloAbstracto) this.get(key);
        
        if(value == null){
            value = (SimboloAbstracto) getNuevoSimbolo(key, idx++, linea, columna);
            this.put(key, (V)value);
        }else{
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
    protected abstract V getNuevoSimbolo(K texto, int indice, int linea, int columna);
    //---------------------------------------
    //  </editor-fold>    
}
