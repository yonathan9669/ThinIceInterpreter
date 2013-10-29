package thinice.TS;

import java.util.Stack;
import java.util.HashMap;
import thinice.util.Utilities;

public class SymbolsTable {
    //---------------------------Private Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    private Stack<HashMap<AbstractSymbol, Object>> tbl;
    
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public SymbolsTable() {
        tbl = new Stack<>();
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Public Methods--------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    public void crearAmbito() {
        tbl.push(new HashMap<AbstractSymbol, Object>());
    }

    //---------------------------------------
    public void quitarAmbito() {
        if (tbl.empty()) {
            Utilities.fatalError("salirAmbito: no se puede remover el Ambito de la tabla.");
        }
        tbl.pop();
    }
    
    //---------------------------------------
    public void agregarId(AbstractSymbol id, Object info) {
        if (tbl.empty()) {
            Utilities.fatalError("agregarId: no se puede agregar id sin un Ambito.");
        }
        tbl.peek().put(id, info);
    }
    
    //---------------------------------------
    public Object buscar(AbstractSymbol sym) {
        if (tbl.empty()) {
            Utilities.fatalError("buscar: no existen Ambitos en la tabla.");
        }

        for (int i = tbl.size() - 1; i >= 0; i--) {
            Object info = tbl.elementAt(i).get(sym);
            if (info != null) return info;
        }
        return null;
    }
    
    //---------------------------------------
    public Object buscarAmbitoActual(AbstractSymbol sym) {
        if (tbl.empty()) {
            Utilities.fatalError("explorar: no existen Ambitos en la tabla.");
        }
        return tbl.peek().get(sym);
    }
    
    //---------------------------------------
    public void combinar(SymbolsTable table) {
		HashMap<AbstractSymbol, Object> env = table.tbl.peek();
		env.putAll(tbl.peek());
	}

    //---------------------------------------
	public SymbolsTable copy() {
		SymbolsTable table = new SymbolsTable();
		for (int i = 0; i < tbl.size(); i++) {
			table.crearAmbito();
			table.tbl.peek().putAll(tbl.elementAt(i));
		}

		return table;
	}
    //  </editor-fold>
}
