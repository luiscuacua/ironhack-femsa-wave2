// Interfaz para los elementos de la interfaz de usuario
interface ElementoUI {
    void render();
}

// Implementaciones concretas de los elementos de la interfaz de usuario
class Boton implements ElementoUI {
    @Override
    public void render() {
        System.out.println("Renderizando un botón");
    }
}

class Texto implements ElementoUI {
    @Override
    public void render() {
        System.out.println("Renderizando un campo de texto");
    }
}

class Checkbox implements ElementoUI {
    @Override
    public void render() {
        System.out.println("Renderizando un checkbox");
    }
}

/*
 * En este ejemplo se utilizó el patrón de diseño Factory.
 * Ventajas de Usar el Patrón Factory
 * Desacoplamiento: Separa la creación de objetos de su uso, lo que facilita el mantenimiento y la extensión del código.
 *  Flexibilidad: Permite crear instancias de diferentes clases de manera dinámica en tiempo de ejecución, según las necesidades del usuario.
 *  Centralización: Centraliza la lógica de creación de objetos en un solo lugar, lo que facilita la gestión y modificación de la lógica de creación.
 */

// Factory para crear elementos de la interfaz de usuario
class Caso2UIFactory {
    public static ElementoUI crearElemento(String tipo) {
        switch (tipo) {
            case "boton":
                return new Boton();
            case "texto":
                return new Texto();
            case "checkbox":
                return new Checkbox();
            default:
                throw new IllegalArgumentException("Tipo de elemento desconocido: " + tipo);
        }
    }
}

// Uso del Factory para crear elementos dinámicamente
public class Main {
    public static void main(String[] args) {
        ElementoUI boton = UIFactory.crearElemento("boton");
        ElementoUI texto = UIFactory.crearElemento("texto");
        ElementoUI checkbox = UIFactory.crearElemento("checkbox");

        boton.render();
        texto.render();
        checkbox.render();
    }
}
