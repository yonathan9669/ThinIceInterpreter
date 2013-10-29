package thinice.AST;

import java.io.PrintStream;
import thinice.TS.AbstractSymbol;

public class ParamFormal extends NodoArbol{
    //---------------------------Protected Attributes------------------------------
    // <editor-fold desc="Public Attributes">
    protected AbstractSymbol tipo;
    protected AbstractSymbol id;
    protected boolean esDireccion;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public ParamFormal(AbstractSymbol tipo, AbstractSymbol id, int linea, int columna) {
        super(linea, columna);
        this.tipo = tipo;
        this.id = id;
        this.esDireccion = false;
    }

    //---------------------------------------
    public ParamFormal(AbstractSymbol tipo, AbstractSymbol id, boolean esDireccion, int linea, int columna) {
        super(linea, columna);
        this.tipo = tipo;
        this.id = id;
        this.esDireccion = esDireccion;
    }
    
    //  </editor-fold>
    //---------------------------Getters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public AbstractSymbol getTipo() {
        return tipo;
    }
    
    //---------------------------------------
    public AbstractSymbol getId() {
        return id;
    }
    
    //---------------------------------------
    public String getTextFormalParam(){
        return this.tipo.getTexto() + " " + this.id.getTexto();
    }
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println("_parametro_formal");
        dump_SimboloAbstracto(out, n+2, tipo);
        dump_SimboloAbstracto(out, n+2, id);
    }
    
    //---------------------------------------
    @Override
    public void aceptar(Visitor visit, Object... params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //---------------------------------------
    //  </editor-fold>
    
}
