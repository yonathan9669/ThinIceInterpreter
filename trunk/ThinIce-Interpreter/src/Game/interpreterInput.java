package Game;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

public class interpreterInput {

    //---------------------------Static Constants-------------------------------
    // <editor-fold desc="Static Constants">
    public static final int mirarArriba = 0;
    public static final int mirarAbajo = 1;
    public static final int mirarIzquierda = 2;
    public static final int mirarDerecha = 3;
    public static final int avanzar = 4;
    //---------------------------------------
    public static final String[] functions = {"mirarArriba", "mirarAbajo", "mirarIzquierda", "mirarDerecha", "avanzar"};
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
    public static int getDirection(String direction){
        for (int i = 0; i < functions.length; i++) {
            if(functions[i].equals(direction))
                return i;
        }
        return -1;
    }
    //  </editor-fold>
    //---------------------------Public static Methods--------------------------
    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    public void clearQueue(){
        input.queueOutput.clear();
    }
    
    //---------------------------------------
    public int size(){
        return input.size();
        
    }
    
    //---------------------------------------
    public Object[] getItems(){
        return input.queueOutput.toArray();
    }
    //  </editor-fold>
    //---------------------------Private Methods-------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Private Methods">
    //---------------------------------------
    //  </editor-fold>
}
