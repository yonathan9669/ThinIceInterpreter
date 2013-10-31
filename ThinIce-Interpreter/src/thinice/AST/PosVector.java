package thinice.AST;

import java.io.PrintStream;
import java.util.ArrayList;
import thinice.TS.AbstractSymbol;
import thinice.util.Utilities;

public class PosVector extends Variable {

    Expresion exp;
    int size;
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">

    public PosVector(AbstractSymbol nombre, Expresion exp, int linea, int columna) {
        super(nombre, linea, columna);
        this.exp = exp;
        this.size = 0;
    }

    //  </editor-fold>
    //---------------------------Getters----------------------------------------
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public Expresion getExp() {
        return exp;
    }

    //---------------------------------------
    public int getSize() {
        if(this.value instanceof ArrayList)
            return ((ArrayList)this.value).size();
        
        return size;
    }

    //---------------------------------------
    public int getPos() {
        return Integer.parseInt(this.exp.getValue().toString());
    }

    //---------------------------------------
    public Object getPosValue(int i) {
        return ((ArrayList) this.getValue()).get(i);
    }
    //  </editor-fold>
    //---------------------------Public Methods--------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    public void initVector(int size){
        this.size = size;
        ArrayList vec = new ArrayList<>(size);
        
        for (int i = 0; i < this.size; i++) {
            vec.add(null);
        }
        
        this.value = vec;
    }
    //---------------------------------------
    public void setPosValue(Object value, Expresion pos){
        int i = ((Integer)pos.getValue()).intValue();
        setPosValue(value, i);
    }
    
    //---------------------------------------
    public void setPosValue(Object value, int i){
        ((ArrayList)this.value).set(i, value);
    }
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">

    @Override
    public void dump(PrintStream out, int n) {
        dumpLineaColumna(out, n);
        out.println(" " + AbstractSymbol.nombreTipo[AbstractSymbol.VECTOR]);
        if (tipo_expr != null) {
            out.println(Utilities.pad(n + 2) + "tipo_expr: " + tipo_expr);
        }
        dump_SimboloAbstracto(out, n + 2, nombre);
        dumpLineaColumna(out, n + 4);
        out.println("_posicion");
        exp.dump(out, n + 4);
    }

    //---------------------------------------
    @Override
    public void aceptar(Visitor visit, Object... params) {
        visit.visitar(this, params);
    }

    //---------------------------------------
    @Override
    public String getTextExpression() {
        return super.getTextExpression() + "[" + this.exp.getTextExpression() + "]";
    }
    //  </editor-fold>
}
