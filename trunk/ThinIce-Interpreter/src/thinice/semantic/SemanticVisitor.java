package thinice.semantic;

import java.util.ArrayList;
import thinice.AST.And;
import thinice.AST.Asignacion;
import thinice.AST.Booleano;
import thinice.AST.Condicional;
import thinice.AST.DeclCompleja;
import thinice.AST.Declaracion;
import thinice.AST.Division;
import thinice.AST.Entero;
import thinice.AST.Expresion;
import thinice.AST.FuncionDef;
import thinice.AST.LlamadaFuncion;
import thinice.AST.Modulo;
import thinice.AST.Multiplicacion;
import thinice.AST.NodoArbol;
import thinice.AST.Not;
import thinice.AST.Or;
import thinice.AST.ParamFormal;
import thinice.AST.PosVector;
import thinice.AST.Programa;
import thinice.AST.Relacionales;
import thinice.AST.RepitaHasta;
import thinice.AST.RepitaPara;
import thinice.AST.Resta;
import thinice.AST.Suma;
import thinice.AST.Variable;
import thinice.AST.Visitor;
import thinice.TS.AbstractSymbol;
import thinice.TS.SymbolsTable;
import thinice.util.LenguageKernel;

public class SemanticVisitor implements Visitor {
    //---------------------------Static Constants-------------------------------
    // <editor-fold desc="Static Constants">

    protected static final int reservedWords = 0;
    protected static final int declaringVariable = 1;
    protected static final int declaringVector = 2;
    protected static final int variableNotDeclared = 3;
    protected static final int vectorNotDeclared = 4;
    protected static final int invalidEpressionType = 5;
    protected static final int functionNotDefined = 6;
    protected static final int incorrectParameters = 7;
    protected static final int wrongVariableType = 8;
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Private Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    private SymbolsTable table;

    //---------------------------------------
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public SemanticVisitor() {
        this.table = new SymbolsTable();
        this.table.crearAmbito();
    }

    //---------------------------------------
    //  </editor-fold>
    //---------------------------Public Methods--------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Getters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public SymbolsTable getTable() {
        return this.table;
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Private Methods-------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Private Methods">

    private boolean addError(int error, Object... params) {
        boolean isError = false;
        int type = 1;

        switch (error) {
            case reservedWords:
                if (params[0] instanceof LlamadaFuncion) {
                    LlamadaFuncion f = (LlamadaFuncion) params[0];
                    SemantErrorReport.getInstancia().semantError(((NodoArbol) params[1]),
                            " \"" + f.getId().getTexto() + "\" es una funcion definida en "
                            + "el sistema y no se pueden declarar variables con palabras "
                            + "RESERVADAS");
                    isError = true;
                }
                break;
            case declaringVector:
                type++;
            case declaringVariable:
                type--;
                if (params[0] instanceof Variable) {
                    Variable vId = (Variable) params[0];
                    SemantErrorReport.getInstancia().semantError(((Declaracion) params[1]).getId(),
                            ((type == 0) ? "La variable" : "El vector") + " \""
                            + vId.getNombre().getTexto()
                            + "\" ya se declaro en la linea:columna #["
                            + vId.getNombre().getLinea() + ":"
                            + vId.getColumna() + "]"
                            + " de tipo "
                            + AbstractSymbol.nombreTipo[vId.getNombre().getTipo()]);
                    isError = true;
                }
                break;
            case vectorNotDeclared:
                type++;
            case variableNotDeclared:
                type--;
                if (params[0] == null) {
                    Variable vId = ((Variable) params[1]);
                    SemantErrorReport.getInstancia().semantError(vId,
                            ((type == 0) ? "La variable" : "El vector")
                            + " \"" + vId.getNombre().getTexto()
                            + "\" NUNCA se DECLARO");
                    isError = true;
                }
                break;
            case invalidEpressionType:
                int requiredType = (params[0] instanceof Integer)
                        ? ((Integer) params[0]).intValue()
                        : ((Expresion) params[0]).getTipo_expr().getTipo();
                int expressionType = (params[1] instanceof Integer)
                        ? ((Integer) params[1]).intValue()
                        : ((Expresion) params[1]).getTipo_expr().getTipo();

                if (requiredType != expressionType) {
                    SemantErrorReport.getInstancia().semantError(((NodoArbol) params[1]),
                            "Error en el tipo de expresion, se requiere un \""
                            + AbstractSymbol.nombreTipo[requiredType]
                            + "\" y la expresion"
                            + ((params[1] instanceof Expresion) ? " \"" + ((Expresion) params[1]).getTextExpression() + "\" " : " ")
                            + "es de tipo \""
                            + AbstractSymbol.nombreTipo[expressionType]
                            + "\"");
                    isError = true;
                }
                break;
            case functionNotDefined:
                if (params[0] == null || !(params[0] instanceof FuncionDef)) {
                    LlamadaFuncion f = (LlamadaFuncion) params[1];
                    SemantErrorReport.getInstancia().semantError(f,
                            "El identificador \""
                            + f.getId().getTexto()
                            + "\" no es una funcion valida o definida en el sistema");
                    isError = true;
                }
                break;
            case incorrectParameters:
                FuncionDef fd = (FuncionDef) params[0];
                LlamadaFuncion fc = (LlamadaFuncion) params[1];
                if (fd.getParametros().getLista().size() != fc.getParams().getLista().size()) {
                    SemantErrorReport.getInstancia().semantError(fc,
                            "La SINTAXIS de la funcion es \""
                            + fd.getTextFunctionDef()
                            + "\" y no coincide con "
                            + fc.getTextFunction());
                    isError = true;
                }
                break;
            case wrongVariableType:
                int declaredVariable = (params[0] instanceof PosVector) ? 1 : -1;
                int usedVariable = (params[1] instanceof PosVector) ? 1 : -1;
                
                if(declaredVariable != usedVariable){
                    SemantErrorReport.getInstancia().semantError((Variable)params[1],
                            "Uso incorrecto del IDENTIFICADOR \""
                            + ((Variable)params[0]).getNombre().getTexto()
                            + "\" en la expresion \""
                            + ((Variable)params[1]).getTextExpression()
                            + "\". Se intenta usar como "
                            + ((usedVariable == 1) ? "Vector":"Variable")
                            + " pero fue declarada como "
                            + ((declaredVariable == 1) ? "Vector":"Variable"));
                    isError = true;
                }
                
                break;
                    
        }
        return isError;
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold desc="Override Methods">
    //-----------------------Program Visitor CALL--------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Program Visitor CALL">

    @Override
    public void visitar(Programa element, Object... params) {
        element.getSentencias().aceptar(this, params);
    }

    //---------------------------------------
    //  </editor-fold>
    //---------------------------Sentences Visitor Methods----------------------
    // <editor-fold defaultstate="collapsed" desc="Sentences Visitor Methods">
    //-----------------------Declaration Visitor CALL----------------------- 
    // <editor-fold defaultstate="collapsed" desc="Declaration Visitor CALL">
    @Override
    public void visitar(Declaracion element, Object... params) {
        Object id = table.buscar(element.getId().getNombre());
        int declareType = (element.getId() instanceof PosVector) ? declaringVector : declaringVariable;

        if (id == null || (!addError(reservedWords, id, element) && !addError(declareType, id, element))) {
            Variable var = element.getId();
            var.getNombre().setTipo(element.getTipo());

            table.agregarId(element.getId().getNombre(), var);

            var.aceptar(this, params);
        }

        if (element instanceof DeclCompleja) {
            ((DeclCompleja) element).getAsign().aceptar(this, params);
        }
    }
    //---------------------------------------
    //  </editor-fold>
    //-----------------------Simple Sentences Visitor CALL------------------ 
    // <editor-fold defaultstate="collapsed" desc="Simple Sentences Visitor CALL">

    @Override
    public void visitar(Asignacion element, Object... params) {
        Object var = table.buscar(element.getVariable().getNombre());

        element.getVariable().aceptar(this, params);
        element.getExpr().aceptar(this, params);

        if (var != null && !addError(invalidEpressionType, var, element.getExpr())) {
            //la variable esta declarada y los tipos concuerdan para la asignacion
        }
    }

    //---------------------------------------
    @Override
    public void visitar(LlamadaFuncion element, Object... params) {
        Object fun = table.buscar(element.getId());

        if (!addError(functionNotDefined, fun, element)) {
            element.getParams().aceptar(this, params);

            if (!addError(incorrectParameters, fun, element)) {
                ArrayList<ParamFormal> lp = ((FuncionDef) fun).getParametros().getLista();
                for (int i = 0; i < lp.size(); i++) {
                    ParamFormal paramFormal = lp.get(i);
                    Expresion param = element.getParams().getLista().get(i);

                    if (addError(invalidEpressionType, paramFormal.getTipo().getTipo(), param)) {
                        //si alguno de los parametros no es de tipo valido
                        break;
                    }
                }
            }
        }
    }

    //---------------------------------------
    //  </editor-fold>
    //-----------------------Block Sentences Visitor CALL------------------- 
    // <editor-fold defaultstate="collapsed" desc="Block Sentences Visitor CALL">
    @Override
    public void visitar(Condicional element, Object... params) {
        element.getCondicion().aceptar(this, params);
        element.getEntonces().aceptar(this, params);

        if (element.existElsePart()) {
            element.getSino().aceptar(this, params);
        }

        if (!addError(invalidEpressionType, new Integer(AbstractSymbol.BOOLEANO), element.getCondicion())) {
            //si la condicion es de tipo bool
        }
    }

    //---------------------------------------
    @Override
    public void visitar(RepitaHasta element, Object... params) {
        element.getSentencias().aceptar(this, params);
        element.getCondicion().aceptar(this, params);

        if (!addError(invalidEpressionType, new Integer(AbstractSymbol.BOOLEANO), element.getCondicion())) {
            //si la condicion es de tipo bool
        }
    }

    //---------------------------------------
    @Override
    public void visitar(RepitaPara element, Object... params) {
        element.getInicialization().aceptar(this, params);
        element.getStep().aceptar(this, params);
        element.getCondicion().aceptar(this, params);

        if (!addError(invalidEpressionType, new Integer(AbstractSymbol.BOOLEANO), element.getCondicion())) {
            //si la condicion es de tipo bool
        }
    }

    //---------------------------------------
    //  </editor-fold>
    //  </editor-fold>
    //---------------------------Expressions Visitor Methods--------------------
    // <editor-fold defaultstate="collapsed" desc="Expressions Visitor Methods">
    //-----------------------Binary Expressions Visitor CALL----------------
    // <editor-fold defaultstate="collapsed" desc="Binary Expressions Visitor CALL">
    //---------------------------Logical Binary Expressions---------------------
    // <editor-fold defaultstate="collapsed" desc="Logical Binary Expressions">
    @Override
    public void visitar(And element, Object... params) {
        element.getLeftExp().aceptar(this, params);
        element.getRightExp().aceptar(this, params);

        AbstractSymbol type = LenguageKernel.symbolType[AbstractSymbol.BOOLEANO];

        if (!addError(invalidEpressionType, new Integer(AbstractSymbol.BOOLEANO), element.getLeftExp())
                && !addError(invalidEpressionType, new Integer(AbstractSymbol.BOOLEANO), element.getRightExp())) {
            //si ambas expresiones son de tipo boolean
            //type = LenguageKernel.symbolType[AbstractSymbol.ENTERO];
        }

        element.setTipo_expr(type);
    }

    //---------------------------------------
    @Override
    public void visitar(Or element, Object... params) {
        element.getLeftExp().aceptar(this, params);
        element.getRightExp().aceptar(this, params);

        AbstractSymbol type = LenguageKernel.symbolType[AbstractSymbol.BOOLEANO];

        if (!addError(invalidEpressionType, new Integer(AbstractSymbol.BOOLEANO), element.getLeftExp())
                && !addError(invalidEpressionType, new Integer(AbstractSymbol.BOOLEANO), element.getRightExp())) {
            //si ambas expresiones son de tipo boolean
            //type = LenguageKernel.symbolType[AbstractSymbol.ENTERO];
        }

        element.setTipo_expr(type);
    }

    //---------------------------------------
    @Override
    public void visitar(Not element, Object... params) {
        element.getExpr().aceptar(this, params);

        AbstractSymbol type = LenguageKernel.symbolType[AbstractSymbol.BOOLEANO];

        if (!addError(invalidEpressionType, new Integer(AbstractSymbol.BOOLEANO), element.getExpr())) {
            //si la expresion es booleana
            //type = LenguageKernel.symbolType[AbstractSymbol.ENTERO];
        }

        element.setTipo_expr(type);
    }
    //  </editor-fold>
    //---------------------------Relational Binary Expressions------------------
    // <editor-fold defaultstate="collapsed" desc="Relational Binary Expressions">

    @Override
    public void visitar(Relacionales element, Object... params) {
        element.getLeftExp().aceptar(this, params);
        element.getRightExp().aceptar(this, params);

        AbstractSymbol type = LenguageKernel.symbolType[AbstractSymbol.BOOLEANO];

        if (!addError(invalidEpressionType, element.getLeftExp(), element.getRightExp())) {
            //si ambas expresiones son del mismo tipo
            //type = LenguageKernel.symbolType[AbstractSymbol.ENTERO];
        }

        element.setTipo_expr(type);
    }
    //  </editor-fold>
    //---------------------------Algebraic Binary Expressions-------------------
    // <editor-fold defaultstate="collapsed" desc="Algebraic Binary Expressions">

    @Override
    public void visitar(Suma element, Object... params) {
        element.getLeftExp().aceptar(this, params);
        element.getRightExp().aceptar(this, params);

        AbstractSymbol type = LenguageKernel.symbolType[AbstractSymbol.ENTERO];

        if (!addError(invalidEpressionType, new Integer(AbstractSymbol.ENTERO), element.getLeftExp())
                && !addError(invalidEpressionType, new Integer(AbstractSymbol.ENTERO), element.getRightExp())) {
            //si ambas expresiones son de tipo entero
            //type = LenguageKernel.symbolType[AbstractSymbol.ENTERO];
        }

        element.setTipo_expr(type);
    }

    //---------------------------------------
    @Override
    public void visitar(Resta element, Object... params) {
        element.getLeftExp().aceptar(this, params);
        element.getRightExp().aceptar(this, params);

        AbstractSymbol type = LenguageKernel.symbolType[AbstractSymbol.ENTERO];

        if (!addError(invalidEpressionType, new Integer(AbstractSymbol.ENTERO), element.getLeftExp())
                && !addError(invalidEpressionType, new Integer(AbstractSymbol.ENTERO), element.getRightExp())) {
            //si ambas expresiones son de tipo entero
            //type = LenguageKernel.symbolType[AbstractSymbol.ENTERO];
        }

        element.setTipo_expr(type);
    }

    //---------------------------------------
    @Override
    public void visitar(Multiplicacion element, Object... params) {
        element.getLeftExp().aceptar(this, params);
        element.getRightExp().aceptar(this, params);

        AbstractSymbol type = LenguageKernel.symbolType[AbstractSymbol.ENTERO];

        if (!addError(invalidEpressionType, new Integer(AbstractSymbol.ENTERO), element.getLeftExp())
                && !addError(invalidEpressionType, new Integer(AbstractSymbol.ENTERO), element.getRightExp())) {
            //si ambas expresiones son de tipo entero
            //type = LenguageKernel.symbolType[AbstractSymbol.ENTERO];
        }

        element.setTipo_expr(type);
    }

    //---------------------------------------
    @Override
    public void visitar(Division element, Object... params) {
        element.getLeftExp().aceptar(this, params);
        element.getRightExp().aceptar(this, params);

        AbstractSymbol type = LenguageKernel.symbolType[AbstractSymbol.ENTERO];

        if (!addError(invalidEpressionType, new Integer(AbstractSymbol.ENTERO), element.getLeftExp())
                && !addError(invalidEpressionType, new Integer(AbstractSymbol.ENTERO), element.getRightExp())) {
            //si ambas expresiones son de tipo entero
            //type = LenguageKernel.symbolType[AbstractSymbol.ENTERO];
        }

        element.setTipo_expr(type);
    }

    //---------------------------------------
    @Override
    public void visitar(Modulo element, Object... params) {
        element.getLeftExp().aceptar(this, params);
        element.getRightExp().aceptar(this, params);

        AbstractSymbol type = LenguageKernel.symbolType[AbstractSymbol.ENTERO];

        if (!addError(invalidEpressionType, new Integer(AbstractSymbol.ENTERO), element.getLeftExp())
                && !addError(invalidEpressionType, new Integer(AbstractSymbol.ENTERO), element.getRightExp())) {
            //si ambas expresiones son de tipo entero
            //type = LenguageKernel.symbolType[AbstractSymbol.ENTERO];
        }

        element.setTipo_expr(type);
    }

    //---------------------------------------
    //  </editor-fold>
    //  </editor-fold>
    //-----------------------Simple Expressions Visitor CALL----------------
    // <editor-fold defaultstate="collapsed" desc="Simple Expressions Visitor CALL">
    @Override
    public void visitar(Entero element, Object... params) {
        element.setTipo_expr(LenguageKernel.symbolType[AbstractSymbol.ENTERO]);
    }

    //---------------------------------------
    @Override
    public void visitar(Booleano element, Object... params) {
        element.setTipo_expr(LenguageKernel.symbolType[AbstractSymbol.BOOLEANO]);
    }

    //---------------------------------------
    @Override
    public void visitar(Variable element, Object... params) {
        Object sym = table.buscar(element.getNombre());

        int type = (!addError(variableNotDeclared, sym, element) &&
                    !addError(wrongVariableType, sym, element) && 
                    !addError(reservedWords, sym, element))
                ? ((Variable) sym).getNombre().getTipo() : AbstractSymbol.NOTYPE;

        element.setTipo_expr(LenguageKernel.symbolType[type]);
    }

    //---------------------------------------
    @Override
    public void visitar(PosVector element, Object... params) {
        Object sym = table.buscar(element.getNombre());

        int type = (!addError(vectorNotDeclared, sym, element) &&
                    !addError(wrongVariableType, sym, element) && 
                    !addError(reservedWords, sym, element))
                ? ((PosVector) sym).getNombre().getTipo() : AbstractSymbol.NOTYPE;

        element.setTipo_expr(LenguageKernel.symbolType[type]);

        element.getExp().aceptar(this, params);

        if (!addError(invalidEpressionType, new Integer(AbstractSymbol.ENTERO), element.getExp())) {
            //si la expresion es correcta
        }
    }
    //  </editor-fold>
    //  </editor-fold>
    //  </editor-fold>
}
