package Game;

import java.util.ArrayDeque;
import java.util.Queue;

public class interpreterInput {

    //---------------------------Static Constants-------------------------------
    // <editor-fold desc="Static Constants">
    public static final int avanzar = 0;
    public static final int mirarArriba = 1;
    public static final int mirarAbajo = 2;
    public static final int mirarIzquierda = 3;
    public static final int mirarDerecha = 4;
    //---------------------------------------
    public static final String[] functions = {"avanzar", "mirarArriba", "mirarAbajo", "mirarIzquierda", "mirarDerecha"};
    //  </editor-fold>
    //---------------------------Private Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    private Queue a;
    //---------------------------------------
    private static interpreterInput input = null;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public interpreterInput(){
        a = new ArrayDeque();
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Getters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Getters">
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Setters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Setters">
    public void push(String input){
        a.add(input);
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Static Methods--------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Static Methods">
    public static interpreterInput getInstance(){
        if(input == null)
            input = new interpreterInput();
        return input;
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Public static Methods--------------------------
    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    public void clearQueue(){
        input.a.clear();
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Private Methods-------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Private Methods">
    //---------------------------------------
    //  </editor-fold>
}
