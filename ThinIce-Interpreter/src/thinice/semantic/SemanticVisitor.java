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
    protected static final int invalidExpressionType = 5;
    protected static final int functionNotDefined = 6;
    protected static final int incorrectParameters = 7;
    protected static final int wrongVariableType = 8;
    //---------------------------------------
    protected static final int declaration = 0;
    protected static final int asignation = 1;
    protected static final int getValue = 2;
    protected static final int execution = 3;
    //---------------------------------------
    protected static final int indexOutOfBounds = 0;
    protected static final int notPossitiveIndex = 1;
    protected static final int notInicialized = 2;
    //  </editor-fold>
    //---------------------------Private Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    private SymbolsTable table;
    private boolean genCode;
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

    private boolean addSemanticError(int error, Object... params) {
        boolean isError = false;
        int type = 1;

        switch (error) {
            case reservedWords:
                if (params[0] instanceof FuncionDef) {
                    FuncionDef f = (FuncionDef) params[0];
                    SemantErrorReport.getInstancia().semantError(((NodoArbol) params[1]),
                            " \"" + f.getTextFunctionDef() + "\" es una funcion definida en "
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
            case invalidExpressionType:
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

                if (declaredVariable != usedVariable) {
                    SemantErrorReport.getInstancia().semantError((Variable) params[1],
                            "Uso incorrecto del IDENTIFICADOR \""
                            + ((Variable) params[0]).getNombre().getTexto()
                            + "\" en la expresion \""
                            + ((Variable) params[1]).getTextExpression()
                            + "\". Se intenta usar como "
                            + ((usedVariable == 1) ? "Vector" : "Variable")
                            + " pero fue declarada como "
                            + ((declaredVariable == 1) ? "Vector" : "Variable"));
                    isError = true;
                }

                break;

        }

        if (genCode && isError) {
            genCode = false;
        }

        return isError;
    }
    //---------------------------------------

    private boolean addRuntimeError(int error, Object... params) {
        boolean isError = false;

        switch (error) {
            case indexOutOfBounds:
                PosVector declaredVec = (PosVector) params[0];
                PosVector usedVec = (PosVector) params[1];

                int pos = usedVec.getPos();

                if (declaredVec.getSize() >= pos || pos < 0) {
                    SemantErrorReport.getInstancia().semantError(usedVec.getExp(),
                            "El indice usado en la expresion"
                            + usedVec.getTextExpression()
                            + "esta fuera de los limites del vector declarado \""
                            + declaredVec.getNombre().getTexto()
                            + " -> TAMAÑO [" + declaredVec.getSize() + "]\" Pos -> "
                            + usedVec.getExp().getValue());
                    isError = true;
                }
                break;
            case notPossitiveIndex:
                PosVector vec = (PosVector) params[0];
                int size = vec.getPos();

                if (size < 1) {
                    SemantErrorReport.getInstancia().semantError(vec.getExp(),
                            "El valor usado en la declaracion de un vector debe ser MAYOR a 0 \""
                            + vec.getTextExpression()
                            + "\" Valor Expresion -> \""
                            + size
                            + "\"");
                    isError = true;
                }
                break;
            case notInicialized:
                Variable var = (Variable) params[0];

                if (var.getValue() == null) {
                    SemantErrorReport.getInstancia().semantError(var,
                            "La variable NUNCA fue INICIALIZADA \""
                            + var.getTextExpression()
                            + " -> " + var.getValue()
                            + "\"");
                    isError = true;
                }
                break;
        }

        if (genCode && isError) {
            genCode = false;
        }

        return isError;
    }
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold desc="Override Methods">
    //-----------------------Program Visitor CALL--------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Program Visitor CALL">

    @Override
    public void visitar(Programa element, Object... params) {
        this.genCode = (boolean) params[0];
        element.getSentencias().aceptar(this, execution);
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

        if (id == null || (!addSemanticError(reservedWords, id, element) && !addSemanticError(declareType, id, element))) {
            Variable var = element.getId();
            var.getNombre().setTipo(element.getTipo());

            table.agregarId(var.getNombre(), var);

            var.aceptar(this, declaration);
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

        element.getVariable().aceptar(this, asignation);
        element.getExpr().aceptar(this, getValue);

        if (var != null && !addSemanticError(invalidExpressionType, var, element.getExpr()) && genCode) {
            Variable v = (Variable) var;
            v.setValue(element.getExpr().getValue());
        }
    }

    //---------------------------------------
    @Override
    public void visitar(LlamadaFuncion element, Object... params) {
        Object fun = table.buscar(element.getId());

        if (!addSemanticError(functionNotDefined, fun, element)) {
            element.getParams().aceptar(this, params);

            if (!addSemanticError(incorrectParameters, fun, element)) {
                ArrayList<ParamFormal> lp = ((FuncionDef) fun).getParametros().getLista();
                for (int i = 0; i < lp.size(); i++) {
                    ParamFormal paramFormal = lp.get(i);
                    Expresion param = element.getParams().getLista().get(i);

                    if (addSemanticError(invalidExpressionType, paramFormal.getTipo().getTipo(), param)) {
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
        this.table.crearAmbito();
        element.getCondicion().aceptar(this, getValue);

        this.genCode = false;

        this.table.crearAmbito();
        element.getEntonces().aceptar(this, execution);

        if (element.existElsePart()) {
            element.getSino().aceptar(this, execution);
        }
        this.table.quitarAmbito();

        this.genCode = SemantErrorReport.getInstancia().getErrores() == 0;

        if (!addSemanticError(invalidExpressionType, new Integer(AbstractSymbol.BOOLEANO), element.getCondicion())
                && genCode) {
            if (((Boolean) element.getCondicion().getValue()).booleanValue()) {
                element.getEntonces().aceptar(this, execution);
            } else if (element.existElsePart()) {
                element.getSino().aceptar(this, execution);
            }
        }

        this.table.quitarAmbito();
    }

    //---------------------------------------
    @Override
    public void visitar(RepitaHasta element, Object... params) {
        boolean typeVerified = false;

        do {
            this.table.crearAmbito();
            element.getSentencias().aceptar(this, execution);
            this.table.quitarAmbito();
            
            element.getCondicion().aceptar(this, getValue);
            if (!typeVerified) {
                addSemanticError(invalidExpressionType, new Integer(AbstractSymbol.BOOLEANO), element.getCondicion());
            }
        } while (genCode && ((Boolean) element.getCondicion().getValue()).booleanValue());
    }

    //---------------------------------------
    @Override
    public void visitar(RepitaPara element, Object... params) {
        this.table.crearAmbito();
        element.getInicialization().aceptar(this, params);
        element.getStep().aceptar(this, params);
        element.getCondicion().aceptar(this, params);

        if (!addSemanticError(invalidExpressionType, new Integer(AbstractSymbol.BOOLEANO), element.getCondicion())) {
            //si la condicion es de tipo bool
        }
        this.table.quitarAmbito();
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

        if (!addSemanticError(invalidExpressionType, new Integer(AbstractSymbol.BOOLEANO), element.getLeftExp())
                && !addSemanticError(invalidExpressionType, new Integer(AbstractSymbol.BOOLEANO), element.getRightExp())) {
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

        if (!addSemanticError(invalidExpressionType, new Integer(AbstractSymbol.BOOLEANO), element.getLeftExp())
                && !addSemanticError(invalidExpressionType, new Integer(AbstractSymbol.BOOLEANO), element.getRightExp())) {
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

        if (!addSemanticError(invalidExpressionType, new Integer(AbstractSymbol.BOOLEANO), element.getExpr())) {
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

        if (!addSemanticError(invalidExpressionType, element.getLeftExp(), element.getRightExp())) {
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

        if (!addSemanticError(invalidExpressionType, new Integer(AbstractSymbol.ENTERO), element.getLeftExp())
                && !addSemanticError(invalidExpressionType, new Integer(AbstractSymbol.ENTERO), element.getRightExp())) {
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

        if (!addSemanticError(invalidExpressionType, new Integer(AbstractSymbol.ENTERO), element.getLeftExp())
                && !addSemanticError(invalidExpressionType, new Integer(AbstractSymbol.ENTERO), element.getRightExp())) {
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

        if (!addSemanticError(invalidExpressionType, new Integer(AbstractSymbol.ENTERO), element.getLeftExp())
                && !addSemanticError(invalidExpressionType, new Integer(AbstractSymbol.ENTERO), element.getRightExp())) {
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

        if (!addSemanticError(invalidExpressionType, new Integer(AbstractSymbol.ENTERO), element.getLeftExp())
                && !addSemanticError(invalidExpressionType, new Integer(AbstractSymbol.ENTERO), element.getRightExp())) {
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

        if (!addSemanticError(invalidExpressionType, new Integer(AbstractSymbol.ENTERO), element.getLeftExp())
                && !addSemanticError(invalidExpressionType, new Integer(AbstractSymbol.ENTERO), element.getRightExp())) {
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

        //Seccion de generacion de codigo y ejecucion
        if (genCode && (int) params[0] == getValue) {
            element.setValue(Integer.getInteger(element.getIntValue()));
        }
    }

    //---------------------------------------
    @Override
    public void visitar(Booleano element, Object... params) {
        element.setTipo_expr(LenguageKernel.symbolType[AbstractSymbol.BOOLEANO]);

        //Seccion de generacion de codigo y ejecucion
        if (genCode && (int) params[0] == getValue) {
            element.setValue(Boolean.valueOf(element.getToken().getTexto()));
        }
    }

    //---------------------------------------
    @Override
    public void visitar(Variable element, Object... params) {
        Object sym = table.buscar(element.getNombre());

        int type = (!addSemanticError(variableNotDeclared, sym, element)
                && !addSemanticError(wrongVariableType, sym, element)
                && !addSemanticError(reservedWords, sym, element))
                ? ((Variable) sym).getNombre().getTipo() : AbstractSymbol.NOTYPE;

        element.setTipo_expr(LenguageKernel.symbolType[type]);

        //Seccion de generacion de codigo y ejecucion
        if (genCode && (int) params[0] != asignation) {
            Variable var = (Variable) sym;
            if ((int) params[0] == declaration) {
                var.setValue(null);
            } else if ((int) params[0] == getValue) {
                element.setValue(var.getValue());
            }
        }
    }
    //---------------------------------------

    @Override
    public void visitar(PosVector element, Object... params) {
        Object sym = table.buscar(element.getNombre());

        int type = (!addSemanticError(vectorNotDeclared, sym, element)
                && !addSemanticError(wrongVariableType, sym, element)
                && !addSemanticError(reservedWords, sym, element))
                ? ((PosVector) sym).getNombre().getTipo() : AbstractSymbol.NOTYPE;

        element.setTipo_expr(LenguageKernel.symbolType[type]);

        element.getExp().aceptar(this, getValue);

        //Seccion de generacion de codigo y ejecucion
        if (!addSemanticError(invalidExpressionType, new Integer(AbstractSymbol.ENTERO), element.getExp()) && genCode && (int) params[0] != asignation) {
            PosVector vec = (PosVector) sym;
            int pos = element.getPos();
            if ((int) params[0] == declaration && !addRuntimeError(notPossitiveIndex, element)) {
                vec.initVector(pos);
            } else if ((int) params[0] == getValue && !addRuntimeError(indexOutOfBounds, vec, element.getExp())) {
                element.setValue(vec.getPosValue(pos));
            }
        }
    }
    //  </editor-fold>
    //  </editor-fold>
    //  </editor-fold>
}
