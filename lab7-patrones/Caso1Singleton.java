/**
 * Caso1: Gestión de configuración global
 * Ventajas de Usar el Patrón Singleton
 * Control de Acceso Global: Garantiza que haya una única instancia de la clase, proporcionando un punto de acceso global a esa instancia
 * Consistencia: Asegura que todos los componentes del sistema utilicen la misma configuración, evitando conflictos de acceso y problemas de sincronización. 
 * Facilidad de Uso: Simplifica el acceso a la configuración desde cualquier parte del sistema sin necesidad de pasar instancias de configuración explícitamente.
 */
public class Configuracion {
    private static Configuracion instancia;
    private Properties config;

    private Configuracion() {
        config = new Properties();
    }

    public static synchronized Configuracion getInstancia() {
        if (instancia == null) {
            instancia = new Configuracion();
        }
        return instancia;
    }

    public String obtenerConfiguracion(String clave) {
        return config.getProperty(clave);
    }

    public void establecerConfiguracion(String clave, String valor) {
        config.setProperty(clave, valor);
    }
}

// Uso del Singleton
public class Caso1Singleton {
    public static void main(String[] args) {
        Configuracion config1 = Configuracion.getInstancia();
        Configuracion config2 = Configuracion.getInstancia();

        config1.establecerConfiguracion("base_datos", "mysql");
        System.out.println(config2.obtenerConfiguracion("base_datos"));
    }
}