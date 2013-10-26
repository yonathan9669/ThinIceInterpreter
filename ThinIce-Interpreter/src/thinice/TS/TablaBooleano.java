package thinice.TS;

public class TablaBooleano extends TablaAbstracta<String, SimboloAbstracto>{
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Abstract Methods">
    @Override
    protected SimboloAbstracto getNuevoSimbolo(String texto, int indice, int linea, int columna){
        return new SimboloBooleano(indice, texto, linea, columna);
    }
    //---------------------------------------
    //  </editor-fold>    
}
