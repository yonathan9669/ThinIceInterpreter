package thinice.util;

import Game.interpreterInput;
import java.util.HashMap;
import thinice.AST.FuncionDef;
import thinice.AST.ListaParamFormal;
import thinice.AST.ParamFormal;
import thinice.TS.AbstractSymbol;
import thinice.TS.IdSymbol;
import thinice.TS.AbstractTable;

public class LenguageKernel {
    //---------------------------Static Constants-------------------------------
    // <editor-fold desc="Static Constants">
    private static final AbstractSymbol nonType = AbstractTable.idTabla.addSymbol(AbstractSymbol.nombreTipo[AbstractSymbol.NOTYPE], 0, 0);
    private static final AbstractSymbol boolType = AbstractTable.idTabla.addSymbol(AbstractSymbol.nombreTipo[AbstractSymbol.BOOLEANO], 0, 0);
    private static final AbstractSymbol intType = AbstractTable.idTabla.addSymbol(AbstractSymbol.nombreTipo[AbstractSymbol.ENTERO], 0, 0);
    //---------------------------------------
    public static final AbstractSymbol moveFunc = AbstractTable.idTabla.addSymbol(interpreterInput.functions[interpreterInput.avanzar], 0, 0);
    //---------------------------------------
    public static final AbstractSymbol lookUpFunc = AbstractTable.idTabla.addSymbol(interpreterInput.functions[interpreterInput.mirarArriba], 0, 0);
    public static final AbstractSymbol lookDownFunc = AbstractTable.idTabla.addSymbol(interpreterInput.functions[interpreterInput.mirarAbajo], 0, 0);
    public static final AbstractSymbol lookLeftFunc = AbstractTable.idTabla.addSymbol(interpreterInput.functions[interpreterInput.mirarIzquierda], 0, 0);
    public static final AbstractSymbol lookRightFunc = AbstractTable.idTabla.addSymbol(interpreterInput.functions[interpreterInput.mirarDerecha], 0, 0);
    //---------------------------------------
    public static final AbstractSymbol[] symbolType = {nonType, boolType, intType};
    //  </editor-fold>
    //---------------------------Private Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    private HashMap<AbstractSymbol, FuncionDef> funciones;
    //---------------------------------------
    private static LenguageKernel nucleo = null;

    //---------------------------------------
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    private LenguageKernel() {
        funciones = new HashMap<>();
        agregarFuncBasicas();
    }

    //---------------------------------------
    //  </editor-fold>
    //---------------------------Public Methods--------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    public static LenguageKernel getInstancia() {
        if (nucleo == null) {
            nucleo = new LenguageKernel();
        }

        return nucleo;
    }

    //---------------------------------------
    public HashMap<AbstractSymbol, FuncionDef> getFuncBasicas() {
        return funciones;
    }

    //---------------------------------------
    //  </editor-fold>
    //---------------------------Private Methods-------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Private Methods">
    private void agregarFuncBasicas() {
        ListaParamFormal formal;
        FuncionDef f;
        
        nonType.setTipo(AbstractSymbol.NOTYPE);
        boolType.setTipo(AbstractSymbol.BOOLEANO);
        intType.setTipo(AbstractSymbol.ENTERO);
        
        formal = new ListaParamFormal();
        formal.agregarElemento(new ParamFormal(intType, new IdSymbol("steps", 0, 0), 0, 0));
        f = new FuncionDef(moveFunc, formal, 0, 0);
        f.getNombre().setTipo(AbstractSymbol.FUNCION);
        funciones.put(moveFunc, f);

        formal = new ListaParamFormal();
        f = new FuncionDef(lookUpFunc, formal, 0, 0);
        f.getNombre().setTipo(AbstractSymbol.FUNCION);
        funciones.put(lookUpFunc, f);

        formal = new ListaParamFormal();
        f = new FuncionDef(lookDownFunc, formal, 0, 0);
        f.getNombre().setTipo(AbstractSymbol.FUNCION);
        funciones.put(lookDownFunc, f);

        formal = new ListaParamFormal();
        f = new FuncionDef(lookLeftFunc, formal, 0, 0);
        f.getNombre().setTipo(AbstractSymbol.FUNCION);
        funciones.put(lookLeftFunc, f);

        formal = new ListaParamFormal();
        f = new FuncionDef(lookRightFunc, formal, 0, 0);
        f.getNombre().setTipo(AbstractSymbol.FUNCION);
        funciones.put(lookRightFunc, f);
    }
    //---------------------------------------
    //  </editor-fold>
}
