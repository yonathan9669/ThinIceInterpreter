package thinice.semantic;

import thinice.AST.FuncionDef;
import thinice.AST.Programa;
import thinice.TS.SymbolsTable;
import thinice.util.LenguageKernel;

public class ThinIceSemantic {
    //---------------------------Private Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    private Programa program;
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Protected Attributes---------------------------
    // <editor-fold desc="Protected Attributes">
    protected SymbolsTable table;
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Public Attributes------------------------------
    // <editor-fold desc="Public Attributes">
    public SemantErrorReport errors;
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public ThinIceSemantic(){
        this.errors = SemantErrorReport.getInstancia();
        this.table = new SymbolsTable();
    }

    //---------------------------------------
    public ThinIceSemantic(Programa program) {
        this.program = program;
        this.errors = SemantErrorReport.getInstancia();
        this.table = new SymbolsTable();
    }

    //  </editor-fold>
    //---------------------------Getters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public Programa getProgram() {
        return program;
    }
    
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Public Methods--------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    public int walkTheTree(){
        SemanticVisitor semantVisitor = new SemanticVisitor();
        
        this.table = semantVisitor.getTable();
        this.addKernelFuntions();
        
        this.program.aceptar(semantVisitor, "Programa");
        
        return SemantErrorReport.getInstancia().errores;
    }
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Private Methods-------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Private Methods">
    private void addKernelFuntions(){
        for (FuncionDef function : LenguageKernel.getInstancia().getFuncBasicas().values()) {
            table.agregarId(function.getNombre(), function);
        }
    }
    //---------------------------------------
    //  </editor-fold>
}