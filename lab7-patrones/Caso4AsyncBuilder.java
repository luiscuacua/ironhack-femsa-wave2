// Clase que representa una operación asincrónica
class OperacionAsincronica {

    public OperacionAsincronica(String nombre) {
        this.nombre = nombre;
    }

    public CompletableFuture<String> ejecutar() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simulación de una llamada API que tarda 2 segundos
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Resultado de " + nombre;
        });
    }
}

// Builder para gestionar múltiples operaciones asincrónicas
class OperacionesBuilder {
    private CompletableFuture<Void> todasLasOperaciones;

    public OperacionesBuilder() {
        todasLasOperaciones = CompletableFuture.completedFuture(null);
    }

    public OperacionesBuilder agregarOperacion(OperacionAsincronica operacion) {
        todasLasOperaciones = todasLasOperaciones.thenCompose(v -> operacion.ejecutar().thenAccept(System.out::println));
        return this;
    }

    public void ejecutarTodas() {
        try {
            todasLasOperaciones.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

/**
 * Caso 4: Gestión eficiente de operaciones asincrónicas
 * En este ejemplo se utilizó el patrón de diseño Builder.
 * Ventajas de Usar el Patrón Builder
 * Construcción Paso a Paso: Permite construir y configurar objetos complejos paso a paso, lo cual es útil para gestionar múltiples operaciones asincrónicas.
 * Fluidez: Facilita la adición de nuevas operaciones de manera fluida y encadenada.
 * Flexibilidad: Permite la ejecución ordenada y coordinada de múltiples tareas asincrónicas sin bloquear el flujo de trabajo de la aplicación principal.
 */
public class Caso4AsyncBuilder {
    public static void main(String[] args) {
        OperacionesBuilder builder = new OperacionesBuilder();

        builder.agregarOperacion(new OperacionAsincronica("API 1"))
               .agregarOperacion(new OperacionAsincronica("API 2"))
               .agregarOperacion(new OperacionAsincronica("API 3"));

        builder.ejecutarTodas();
    }
}