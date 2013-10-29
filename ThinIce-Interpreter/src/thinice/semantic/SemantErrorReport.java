package thinice.semantic;

import java.io.PrintStream;
import thinice.AST.NodoArbol;

public class SemantErrorReport {
    //---------------------------Protected Attributes---------------------------
    // <editor-fold desc="Protected Attributes">
    protected int errores;
    protected PrintStream errorStream;
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Private Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    private static SemantErrorReport report=null;
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    private SemantErrorReport() {
	errores = 0;
	errorStream = System.err;
    }
    
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Public static Methods-------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Public static Methods">
    public static SemantErrorReport getInstancia(){
        if(report==null)
            report = new SemantErrorReport();
        
        return report;
    }
    
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Public Methods--------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    public PrintStream semantError(NodoArbol t) {
	errorStream.println(t.getLinea() + ":"+ t.getColumna() +": ");
	return semantError();
    }
    
    //---------------------------------------
    public PrintStream semantError(NodoArbol t, String mensaje) {
	errorStream.println("Error en línea " + t.getLinea() + ":"+ t.getColumna() +": "+mensaje);
	return semantError();
    }

    //---------------------------------------
    public PrintStream semantError() {
	errores++;
	return errorStream;
    }

    //---------------------------------------
    public boolean tieneErrores() {
	return errores != 0;
    }
    
    //---------------------------------------
    public int getErrores() {
        return errores;
    }
    
    //---------------------------------------
    //  </editor-fold>
    
}
