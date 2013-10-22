package thinice.AST;

import java.io.PrintStream;

public class ListaParamFormal extends NodoLista<ParamFormal>{
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public ListaParamFormal() {
        super();
    }    
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    public void dump(PrintStream out, int n) {
        for(ParamFormal pf : lista){
            pf.dump(out, n);
        }
    }
    //  </editor-fold>
    
}
