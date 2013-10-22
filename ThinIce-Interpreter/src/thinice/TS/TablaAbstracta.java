package thinice.TS;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public abstract class TablaAbstracta {
    //---------------------------Private Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    private int idx;   
    private static int TAM_MAX_SYMB=1024;
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Protected Attributes---------------------------
    // <editor-fold desc="Protected Attributes">
    protected HashMap<String, SimboloAbstracto> tabla;
    //  </editor-fold>
    //---------------------------Public Attributes------------------------------
    // <editor-fold desc="Public Attributes">
    public static TablaEntero intTabla = new TablaEntero();
    public static TablaId idTabla = new TablaId();
    public static TablaTexto texTabla = new TablaTexto();
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public TablaAbstracta() {
        tabla = new HashMap<String, SimboloAbstracto>();
        idx = 0;
    }   
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Public Methods--------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    public SimboloAbstracto agregarSimbolo(String texto, int linea, int columna){
        return agregarSimbolo(texto, TAM_MAX_SYMB, linea, columna);
    }
    
    //---------------------------------------
    public SimboloAbstracto agregarSimbolo(String texto, int tam, int linea, int columna){
        SimboloAbstracto sym = null;
        
        texto = (texto.length() <= TAM_MAX_SYMB) ? texto : texto.substring(0, TAM_MAX_SYMB);
        
        if(!tabla.containsKey(texto)){
            sym = getNuevoSimbolo(texto, idx++, linea, columna);
            tabla.put(texto, sym);
        }else{
            sym = (SimboloAbstracto) tabla.get(texto).clone();
            sym.linea = linea;
            sym.columna = columna;
        }
        
        return sym;
    }
    //---------------------------------------
    
    public Collection<SimboloAbstracto> getSimbolos() {
        return tabla.values();
    }
    //---------------------------------------
    
    public SimboloAbstracto getSimbolo(String texto){
        return tabla.get(texto);
    }
    //---------------------------------------
    
    public SimboloAbstracto getSimbolo(int indice){
        for(SimboloAbstracto sym: tabla.values()){
            if(sym.equalsIndice(indice))
                return sym;
        }
        
        return null;
    }
    //  </editor-fold>
    //---------------------------Abstract Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Abstract Methods">
    protected abstract SimboloAbstracto getNuevoSimbolo(String texto, int indice, int linea, int columna);
    //---------------------------------------
    //  </editor-fold>    
}
