package thinice.AST;

import java.io.PrintStream;

public class ListaParamFormal extends NodoLista<ParamFormal>{
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public ListaParamFormal() {
        super();
    }    
    //  </editor-fold>
    //---------------------------Public Methods--------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    public String getTextParameters(){
        if(this.lista.isEmpty())
            return "";
        
        String params = "";
        
        for (ParamFormal param : lista) {
            params += param.getTextFormalParam() + ", ";
        }
        
        return params.substring(0, params.lastIndexOf(","));
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    public void dump(PrintStream out, int n) {
        for(ParamFormal pf : lista){
            pf.dump(out, n);
        }
    }
    
    //---------------------------------------
    @Override
    public void aceptar(Visitor visit, Object... params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //---------------------------------------
    //  </editor-fold>
    
}
