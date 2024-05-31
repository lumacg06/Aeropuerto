import java.util.Random;

public class TorreControl {
    private ColaLista colaAterrizaje;
    private ColaLista colaDespegue;
    private Random random;

    public TorreControl() {
        colaAterrizaje = new ColaLista();
        colaDespegue = new ColaLista();
        random = new Random();
    }

    public void inicializarColas() {
        colaAterrizaje = new ColaLista();
        colaDespegue = new ColaLista();
    }

    public void revisarAproximacion() {
        int tipo = random.nextInt(2) + 1; // 1 para aterrizaje, 2 para despegue
        String idAvion = "AV-" + random.nextInt(1000);
        if (tipo == 1) {
            colaAterrizaje.encolar(idAvion);
            System.out.println("Avión " + idAvion + " en cola de aterrizaje.");
        } else {
            colaDespegue.encolar(idAvion);
            System.out.println("Avión " + idAvion + " en cola de despegue.");
        }
    }

    public void ejecutarAccionPista() {
        if (!colaAterrizaje.estaVacia()) {
            String idAvion = colaAterrizaje.desencolar();
            System.out.println("Avión " + idAvion + " aterrizando.");
        } else if (!colaDespegue.estaVacia()) {
            String idAvion = colaDespegue.desencolar();
            System.out.println("Avión " + idAvion + " despegando.");
        } else {
            System.out.println("No hay aviones en cola.");
        }
    }

    public void calcularEspera(String id) {
        int posicion = colaAterrizaje.obtenerPosicion(id);
        if (posicion != -1) {
            System.out.println("El avión " + id + " está en la posición " + posicion + " de la cola de aterrizaje.");
            System.out.println("Tiempo de espera aproximado: " + (posicion * 10) + " minutos.");
        } else {
            posicion = colaDespegue.obtenerPosicion(id);
            if (posicion != -1) {
                System.out.println("El avión " + id + " está en la posición " + posicion + " de la cola de despegue.");
                System.out.println("Tiempo de espera aproximado: " + (colaAterrizaje.obtenerTamano() * 10 + posicion * 10) + " minutos.");
            } else {
                System.out.println("El avión " + id + " no se encuentra en las colas.");
            }
        }
    }

    public void mostrarColas() {
        System.out.println("Cola de aterrizaje:");
        colaAterrizaje.mostrarCola();
        System.out.println("Cola de despegue:");
        colaDespegue.mostrarCola();
    }
}
