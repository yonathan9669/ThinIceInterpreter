package thinice.AST;

import java.io.PrintStream;

public class ListaParametros extends NodoLista<Expresion>{
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public ListaParametros() {
        super();
    }    
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    public void dump(PrintStream out, int n) {
        for(Expresion expr : lista){
            expr.dump(out, n);
        }
    }
    //  </editor-fold>
    
}
