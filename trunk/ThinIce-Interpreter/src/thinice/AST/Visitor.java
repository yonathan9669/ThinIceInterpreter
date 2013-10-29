package thinice.AST;

public interface Visitor {
    public void visitar(Programa element, Object... params);
    public void visitar(Declaracion element, Object... params);
    public void visitar(Asignacion element, Object... params);
    public void visitar(LlamadaFuncion element, Object... params);
    public void visitar(Condicional element, Object... params);
    public void visitar(RepitaHasta element, Object... params);
    public void visitar(RepitaPara element, Object... params);
    public void visitar(And element, Object... params);
    public void visitar(Or element, Object... params);
    public void visitar(Not element, Object... params);
    public void visitar(Relacionales element, Object... params);
    public void visitar(Suma element, Object... params);
    public void visitar(Resta element, Object... params);
    public void visitar(Multiplicacion element, Object... params);
    public void visitar(Division element, Object... params);
    public void visitar(Modulo element, Object... params);
    public void visitar(Entero element, Object... params);
    public void visitar(Booleano element, Object... params);
    public void visitar(Variable element, Object... params);
    public void visitar(PosVector element, Object... params);
}
