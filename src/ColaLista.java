public class ColaLista {
    private NodoListaSimple frente;
    private NodoListaSimple finalCola;
    private int tamano;

    public ColaLista() {
        this.frente = null;
        this.finalCola = null;
        this.tamano = 0;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void encolar(String id) {
        NodoListaSimple nuevoNodo = new NodoListaSimple(id, null, null);
        if (estaVacia()) {
            frente = nuevoNodo;
            finalCola = nuevoNodo;
        } else {
            finalCola.siguiente = nuevoNodo;
            finalCola = nuevoNodo;
        }
        tamano++;
    }

    public String desencolar() {
        if (estaVacia()) {
            return null;
        }
        String id = frente.placa;
        frente = frente.siguiente;
        if (frente == null) {
            finalCola = null;
        }
        tamano--;
        return id;
    }

    public void mostrarCola() {
        NodoListaSimple actual = frente;
        while (actual != null) {
            System.out.println("Avión ID: " + actual.placa);
            actual = actual.siguiente;
        }
    }

    public int obtenerPosicion(String id) {
        NodoListaSimple actual = frente;
        int posicion = 0;
        while (actual != null) {
            if (actual.placa.equals(id)) {
                return posicion;
            }
            actual = actual.siguiente;
            posicion++;
        }
        return -1; // No encontrado
    }

    public int obtenerTamano() {
        return tamano;
    }
}

