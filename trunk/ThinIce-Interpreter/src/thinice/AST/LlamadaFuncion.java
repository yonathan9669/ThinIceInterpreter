package thinice.AST;

import java.io.PrintStream;
import thinice.TS.AbstractSymbol;

public class LlamadaFuncion extends Sentencia{
    //---------------------------Protected Attributes-----------------------------
    // <editor-fold desc="Protected Attributes">
    protected AbstractSymbol id;
    protected ListaParametros params;
    //  </editor-fold>
    //---------------------------Private Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    private boolean tieneParam;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public LlamadaFuncion(AbstractSymbol id, ListaParametros params, int linea, int columna) {
        super(linea, columna);
        this.id = id;
        this.params = params;
        tieneParam = true;
    }
    
    //---------------------------------------
    public LlamadaFuncion(AbstractSymbol id, int linea, int columna) {
        super(linea, columna);
        this.id = id;
        this.params = null;
        tieneParam = false;
    }

    //---------------------------------------
    //  </editor-fold>
    //---------------------------Getters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public AbstractSymbol getId() {
        return id;
    }
    
    //---------------------------------------
    public ListaParametros getParams() {
        return params;
    }
    
    //---------------------------------------
    public String getTextFunction(){
        return this.id.getTexto() + "("+this.params.getTextParameters()+")";
    }
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.print("_llamada");
        out.println(" " + AbstractSymbol.nombreTipo[AbstractSymbol.FUNCION]);
        dump_SimboloAbstracto(out, n + 2, id);
        if(tieneParam)
            params.dump(out, n + 2);
    }
    
    //---------------------------------------
    @Override
    public void aceptar(Visitor visit, Object... params) {
        visit.visitar(this, params);
    }
    
    //---------------------------------------
    //  </editor-fold>
    
}
