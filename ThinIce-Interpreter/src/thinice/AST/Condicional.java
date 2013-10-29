package thinice.AST;

import java.io.PrintStream;
import thinice.util.Utilities;

public class Condicional extends Sentencia{
    //---------------------------Protected Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    protected Expresion condicion;
    protected ListaSentencia entonces;
    protected ListaSentencia sino;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Condicional(Expresion condicion, ListaSentencia entonces, ListaSentencia sino, int linea, int columna) {
        super(linea, columna);
        this.condicion = condicion;
        this.entonces = entonces;
        this.sino = sino;
    }
    
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Getters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public Expresion getCondicion() {
        return condicion;
    }
    
    //---------------------------------------
    public ListaSentencia getEntonces() {
        return entonces;
    }
    
    //---------------------------------------
    public ListaSentencia getSino() {
        return sino;
    }
    
    //  </editor-fold>
    //---------------------------Public Methods--------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    public boolean existElsePart(){
        return sino != null;
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println("_condicional");
        condicion.dump(out, n+4);
        out.println(Utilities.pad(n+2) + "_entonces");
        entonces.dump(out, n+4);
        if(sino!=null){
            out.println(Utilities.pad(n+2) + "_sino");
            sino.dump(out, n+4);
        }
    }
    
    //---------------------------------------
    @Override
    public void aceptar(Visitor visit, Object... params) {
        visit.visitar(this, params);
    }
    
    //---------------------------------------
    //  </editor-fold>
    
}
