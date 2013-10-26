package thinice.TS;

public class TablaTexto extends TablaAbstracta<String, SimboloAbstracto>{
    //---------------------------Override Methods------------------------------- 
    // <editor-fold defaultstate="collapsed" desc="Override Methods">
    @Override
    protected SimboloAbstracto getNuevoSimbolo(String texto, int indice, int linea, int columna){
        return new SimboloTexto(indice, texto, linea, columna);
    }
    //---------------------------------------
    //  </editor-fold>    
}
