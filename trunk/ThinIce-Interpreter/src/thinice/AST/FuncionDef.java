package thinice.AST;

import java.io.PrintStream;
import thinice.TS.SimboloAbstracto;

public class FuncionDef extends NodoArbol{
    //---------------------------Protected Attributes------------------------------
    // <editor-fold desc="Public Attributes">
    protected SimboloAbstracto nombre;
    protected ListaParamFormal parametros;
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public FuncionDef(SimboloAbstracto nombre, ListaParamFormal parametros, int linea, int columna) {
        super(linea, columna);
        this.nombre = nombre;
        this.parametros = parametros;
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Getters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public SimboloAbstracto getNombre() {
        return nombre;
    }
    
    //---------------------------------------
    public ListaParamFormal getParametros() {
        return parametros;
    }
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println("_funcion");
        dump_SimboloAbstracto(out, n+2, nombre);
        parametros.dump(out, n+2);
    }
    //---------------------------------------
    //  </editor-fold>
}
