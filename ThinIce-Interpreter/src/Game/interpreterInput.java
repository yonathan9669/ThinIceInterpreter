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
    private Queue queueOutput;
    //---------------------------------------
    private static interpreterInput input = null;
    private static interpreterInput errors = null;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public interpreterInput(){
        queueOutput = new ArrayDeque();
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Getters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public String poll(){
        return (String) this.queueOutput.poll();   
    }
    public boolean IsEmpty(){
        return this.queueOutput.isEmpty();
    }
    
    
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Setters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Setters">
    public void push(String input){
        queueOutput.add(input);
       
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
    public static interpreterInput getErrors(){
        if(errors == null)
            errors = new interpreterInput();
        return errors;
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Public static Methods--------------------------
    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    public void clearQueue(){
        input.queueOutput.clear();
    }
    public int size(){
        return input.size();
        
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Private Methods-------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Private Methods">
    //---------------------------------------
    //  </editor-fold>
}
