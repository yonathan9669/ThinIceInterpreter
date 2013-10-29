package thinice.TS;

public abstract class AbstractSymbol {
    //---------------------------Static Constants-------------------------------
    // <editor-fold desc="Static Constants">
    public static final int NOTYPE = 0;
    public static final int BOOLEANO = 1;
    public static final int ENTERO = 2;
    public static final int FUNCION = 3;
    public static final int VARIABLE = 4;
    public static final int VECTOR = 5;
    
    public static final String[] nombreTipo = { "_notype", "_booleano", "_entero",
                                                "_funcion","_variable", "_vector"};    
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Protected Attributes---------------------------
    // <editor-fold desc="Protected Attributes">
    protected int indice;
    protected String texto;
    protected int linea;
    protected int columna;
    protected int tipo;
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public AbstractSymbol(int indice, String texto, int linea, int columna) {
        this.indice = indice;
        this.texto = texto;
        this.linea = linea;
        this.columna = columna;
        this.tipo = AbstractSymbol.NOTYPE;
    }
    
    //---------------------------------------
    public AbstractSymbol(String texto, int linea, int columna) {
        this.texto = texto;
        this.linea = linea;
        this.columna = columna;
        this.tipo = AbstractSymbol.NOTYPE;
        indice = -1;
    }
    //  </editor-fold>
    //---------------------------Getters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Getters">
    public String getTexto(){
        return texto;
    }
    
    //---------------------------------------
    public int getIndice(){
        return indice;
    }

    //---------------------------------------
    public int getColumna() {
        return columna;
    }

    //---------------------------------------
    public int getLinea() {
        return linea;
    }
    
    //---------------------------------------
    public int getTipo(){
        return tipo;
    }
    
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Setters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Setters">
    public void setTipo(int tipo){
        this.tipo = tipo;
    }
    
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Public Methods--------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Public Methods">
    public boolean equalsTexto(String str){
        return texto.equals(str);
    }
    
    //---------------------------------------
    public boolean equalsIndice(int index){
        return indice==index;
    }
    
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public boolean equals(Object otro) {
	return (otro instanceof AbstractSymbol) && 
	    ((AbstractSymbol)otro).indice == this.indice;
    }

    //---------------------------------------
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.indice;
        hash = 29 * hash + (this.texto != null ? this.texto.hashCode() : 0);
        return hash;
    }
    
    //---------------------------------------
    @Override
    public String toString(){
        return texto;
    }
    
    //---------------------------------------
    @Override
    public abstract Object clone();
    //---------------------------------------
    //  </editor-fold>
    
}
