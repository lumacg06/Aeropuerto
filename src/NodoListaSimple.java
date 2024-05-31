 public class NodoListaSimple {
    String placa;
    String fechaIngreso;
    String horaIngreso;
    NodoListaSimple siguiente;

    public NodoListaSimple(String placa, String fechaIngreso, String horaIngreso) {
        this.placa = placa;
        this.fechaIngreso = fechaIngreso;
        this.horaIngreso = horaIngreso;
        this.siguiente = null;
    }
}
