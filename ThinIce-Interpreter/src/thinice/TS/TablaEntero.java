package thinice.TS;

public class TablaEntero extends TablaAbstracta{
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Abstract Methods">
    @Override
    protected SimboloAbstracto getNuevoSimbolo(String texto, int indice, int linea, int columna){
        return new SimboloEntero(indice, texto, linea, columna);
    }
    //---------------------------------------
    //  </editor-fold>    
}
