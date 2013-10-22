package thinice.AST;

import java.util.ArrayList;

public abstract class NodoLista<T> extends NodoArbol {
    //---------------------------Protected Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    protected ArrayList<T> lista;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public NodoLista() {
        super(0, 0);
        lista = new ArrayList<T>();
    }
    //  </editor-fold>
    //---------------------------Getters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public ArrayList<T> getLista() {
        return lista;
    }
    
    //---------------------------------------
    public int getLongitud(){
        return lista.size();
    }
    
    //  </editor-fold>
    //---------------------------Public Methods--------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    public void agregarElemento(T element){
        lista.add(element);
    }
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public String toString(){
        return lista.toString();
    }
    //  </editor-fold>
}
