package thinice.TS;

import java.util.Stack;
import java.util.HashMap;
import thinice.util.Utilidades;

public class TablaSimbolos {
    //---------------------------Private Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    private Stack<HashMap<SimboloAbstracto, Object>> tbl;
    
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public TablaSimbolos() {
        tbl = new Stack<HashMap<SimboloAbstracto, Object>>();
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Public Methods--------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    public void crearAmbito() {
        tbl.push(new HashMap<SimboloAbstracto, Object>());
    }

    //---------------------------------------
    public void quitarAmbito() {
        if (tbl.empty()) {
            Utilidades.fatalError("salirAmbito: no se puede remover el Ã¡mbito de la tabla.");
        }
        tbl.pop();
    }
    
    //---------------------------------------
    public void agregarId(SimboloAbstracto id, Object info) {
        if (tbl.empty()) {
            Utilidades.fatalError("agregarId: no se puede agregar id sin un Ã¡mbito.");
        }
        tbl.peek().put(id, info);
    }
    
    //---------------------------------------
    public Object buscar(SimboloAbstracto sym) {
        if (tbl.empty()) {
            Utilidades.fatalError("buscar: no existen Ã¡mbitos en la tabla.");
        }

        for (int i = tbl.size() - 1; i >= 0; i--) {
            Object info = tbl.elementAt(i).get(sym);
            if (info != null) return info;
        }
        return null;
    }
    
    //---------------------------------------
    public Object buscarAmbitoActual(SimboloAbstracto sym) {
        if (tbl.empty()) {
            Utilidades.fatalError("explorar: no existen Ã¡mbitos en la tabla.");
        }
        return tbl.peek().get(sym);
    }
    
    //---------------------------------------
    public void combinar(TablaSimbolos table) {
		HashMap<SimboloAbstracto, Object> env = table.tbl.peek();
		env.putAll(tbl.peek());
	}

    //---------------------------------------
	public TablaSimbolos copy() {
		TablaSimbolos table = new TablaSimbolos();
		for (int i = 0; i < tbl.size(); i++) {
			table.crearAmbito();
			table.tbl.peek().putAll(tbl.elementAt(i));
		}

		return table;
	}
    //  </editor-fold>
}
