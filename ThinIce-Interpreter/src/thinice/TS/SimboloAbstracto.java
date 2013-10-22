/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package thinice.TS;

/**
 *
 * @author Oscar
 */
public abstract class SimboloAbstracto {
    //---------------------------Static Constants-------------------------------
    // <editor-fold desc="Static Constants">
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Private Attributes-----------------------------
    // <editor-fold desc="Private Attributes">
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Public Attributes------------------------------
    // <editor-fold desc="Public Attributes">
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Protected Attributes---------------------------
    // <editor-fold desc="Protected Attributes">
    protected int indice;
    protected String texto;
    protected int linea;
    protected int columna;
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Constructors-----------------------------------
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public SimboloAbstracto(int indice, String texto, int linea, int columna) {
        this.indice = indice;
        this.texto = texto;
        this.linea = linea;
        this.columna = columna;
    }
    
    //---------------------------------------
    public SimboloAbstracto(String texto, int linea, int columna) {
        this.texto = texto;
        this.linea = linea;
        this.columna = columna;
        indice = -1;
    }
    //---------------------------------------
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
    //  </editor-fold>
    //---------------------------Setters---------------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Setters">
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
    //---------------------------Private Methods-------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Private Methods">
    //---------------------------------------
    //  </editor-fold>
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    public boolean equals(Object otro) {
	return (otro instanceof SimboloAbstracto) && 
	    ((SimboloAbstracto)otro).indice == this.indice;
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
