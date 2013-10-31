package thinice.AST;

import java.io.PrintStream;

public class ListaParametros extends NodoLista<Expresion>{
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public ListaParametros() {
        super();
    }    
    //  </editor-fold>
    //---------------------------Public Methods--------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    public String getTextParameters(){
        if(this.lista.isEmpty())
            return "";
        
        String params = "";
        
        for (Expresion expresion : lista) {
            params += expresion.tipo_expr.getTexto() + ", ";
        }
        
        return params.substring(0, params.lastIndexOf(","));
    }
    
    //---------------------------------------
    public String getOutParameters(){
        if(this.lista.isEmpty())
            return "";
        
        String params = "";
        
        for (Expresion expresion : lista) {
            params += expresion.getValue().toString() + ", ";
        }
        
        return params.substring(0, params.lastIndexOf(","));
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
    
    //---------------------------------------
    @Override
    public void aceptar(Visitor visit, Object... params) {
        for (Expresion expresion : this.lista) {
            expresion.aceptar(visit, params);
        }
    }
    
    //---------------------------------------
    //  </editor-fold>
    
}
