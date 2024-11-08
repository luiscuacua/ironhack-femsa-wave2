# README

## 1. Etapa de construcción

Para esta etapa es conveniente usar el flujo de CI/CD, en esta parte se utilizaría la herramienta de GitHub y de acuerdo al lenguaje utilizado.

### 1.1 Confirmación de código

En este paso se realizaría el build justo después de que se realice un merge a una rama como dev, qa o prod. Con esto se validaría que el código que se está agregando no tenga errores de compilación por lo que garantizaría que este funciona de manera correcta.

- **Ventajas:**
  - Docker permite crear entornos de desarrollo consistentes, lo que asegura que el código funcione de la misma manera en todas las máquinas.
  - Facilita la integración continua al permitir que los desarrolladores trabajen en entornos idénticos a los de producción.
  - Evitar errores en el despliegue.

- **Desventajas:**
  - La configuración inicial de Docker puede ser compleja y requerir tiempo.
  - Puede haber una curva de aprendizaje para los desarrolladores que no están familiarizados con Docker.

### 1.2 Creación de imágenes de Docker

- **Ventajas:**
  - Las imágenes de Docker son portátiles y reproducibles, lo que facilita la creación de entornos consistentes.
  - Permite la integración de múltiples etapas de construcción en una sola imagen, optimizando el proceso.
  - Una vez creada la imagen, esta se puede guardar en un repositorio y poder usarla en cualquier máquina.

- **Desventajas:**
  - La creación de imágenes puede ser lenta si no se optimizan correctamente las capas de Docker.
  - Las imágenes pueden volverse grandes y consumir mucho espacio de almacenamiento.

## 2. Etapa de prueba

### 2.1 Pruebas automatizadas

- **Ventajas:**
  - En esta etapa se pueden validar pruebas de test, de integración, pruebas de carga lo cual ayuda a tener control sobre buenas prácticas.
  - Facilita la creación de entornos de prueba que replican fielmente el entorno de producción.

- **Desventajas:**
  - Complicado definir los parámetros de infra como memoria o CPU.
  - La configuración de entornos de prueba con Docker puede ser compleja.
  - Puede haber problemas de rendimiento si las pruebas requieren muchos recursos y se ejecutan en contenedores.

## 3. Etapa de implementación

### 3.1 Registro de contenedores

- **Ventajas:**
  - Se tiene control de imágenes y así poder tener versionadas las imágenes.
  - Los registros de contenedores (Docker Hub o registros privados) permiten almacenar y distribuir imágenes de Docker de manera eficiente.
  - Facilita la implementación continua al permitir que las imágenes se desplieguen automáticamente desde el registro.

- **Desventajas:**
  - Los registros públicos pueden tener limitaciones de almacenamiento y ancho de banda.
  - La gestión de registros privados puede requerir configuración y mantenimiento adicionales.

### 3.2 Orquestación e implementación

- **Ventajas:**
  - Kubernetes proporciona una potente plataforma de orquestación que facilita la gestión de contenedores a gran escala.
  - Permite la implementación continua y la escalabilidad automática de aplicaciones.
  - Ofrece características avanzadas como la recuperación automática y el balanceo de carga.

- **Desventajas:**
  - La configuración y gestión de Kubernetes puede ser compleja y requerir conocimientos especializados.
  - Puede haber una curva de aprendizaje significativa para los equipos que no están familiarizados con Kubernetes.
  - La sobrecarga de recursos puede ser alta, especialmente en entornos pequeños o de desarrollo.

La elección de herramientas dependerá de las necesidades específicas del proyecto y del equipo de desarrollo.