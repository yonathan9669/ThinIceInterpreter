package thinice.AST;

import java.io.PrintStream;

public class ListaSentencia extends NodoLista<Sentencia>{
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public ListaSentencia() {
        super();
    }
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public void dump(PrintStream out, int n) {
        for(Sentencia s: lista){
            s.dump(out, n);
        }
    }
    
    //---------------------------------------
    @Override
    public void aceptar(Visitor visit, Object... params) {
        for (Sentencia sentencia : this.getLista()) {
            sentencia.aceptar(visit, params);
        }
    }
    
    //---------------------------------------
    //  </editor-fold>
}
