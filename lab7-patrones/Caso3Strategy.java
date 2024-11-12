// Interfaz Strategy para notificación
interface EstrategiaNotificacion {
    void notificar(String estado);
}

// Implementaciones concretas de la estrategia de notificación
class NotificacionConsola implements EstrategiaNotificacion {
    @Override
    public void notificar(String estado) {
        System.out.println("Notificación en consola: " + estado);
    }
}

class NotificacionArchivo implements EstrategiaNotificacion {
    @Override
    public void notificar(String estado) {
        // Aquí se podría implementar la lógica para escribir en un archivo
        System.out.println("Notificación en archivo: " + estado);
    }
}

// Clase Sujeto (Subject)
class Sujeto {
    private List<EstrategiaNotificacion> estrategias = new ArrayList<>();
    private String estado;

    public void agregarEstrategia(EstrategiaNotificacion estrategia) {
        estrategias.add(estrategia);
    }

    public void eliminarEstrategia(EstrategiaNotificacion estrategia) {
        estrategias.remove(estrategia);
    }

    public void notificarEstrategias() {
        for (EstrategiaNotificacion estrategia : estrategias) {
            estrategia.notificar(estado);
        }
    }

    public void setEstado(String estado) {
        this.estado = estado;
        notificarEstrategias();
    }
}


/**
 * Caso 3: Notificación de cambio de estado en todos los componentes del sistema
 * En este ejemplo se utilizó el patrón de diseño Strategy.
 * por que este patron?
 * Desacoplamiento: Permite que las estrategias de notificación sean intercambiables y gestionadas de manera independiente del sujeto.
 * Flexibilidad: Facilita la adición de nuevas estrategias de notificación sin modificar el código existente del sujeto.
 * Reutilización: Las estrategias pueden ser reutilizadas en diferentes contextos y sujetos, promoviendo la reutilización del código.
 */
public class Caso3Strategy {
    public static void main(String[] args) {
        Sujeto sujeto = new Sujeto();

        EstrategiaNotificacion consola = new NotificacionConsola();
        EstrategiaNotificacion archivo = new NotificacionArchivo();

        sujeto.agregarEstrategia(consola);
        sujeto.agregarEstrategia(archivo);

        sujeto.setEstado("Nuevo Estado 1");
        sujeto.setEstado("Nuevo Estado 2");
    }
}