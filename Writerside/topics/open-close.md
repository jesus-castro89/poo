# Open-Closed Principle (OCP)

El Principio de Abierto/Cerrado (Open/Closed Principle, OCP) es uno de los principios fundamentales del diseño de
software orientado a objetos. Fue formulado por Bertrand Meyer en 1988 y establece que las entidades de software (
clases, módulos, funciones, etc.) deben estar abiertas para su extensión, pero cerradas para su modificación.

Esto significa que se debe poder agregar nueva funcionalidad a una entidad sin modificar su código fuente existente. Al
seguir este principio, se reduce el riesgo de introducir errores en el código existente y se facilita la
mantenibilidad del software.

## Beneficios del Principio de Abierto/Cerrado

1. **Mantenibilidad**: Al evitar la modificación del código existente, se reduce el riesgo de introducir errores y se
   facilita la corrección de errores y la implementación de nuevas funcionalidades.
2. **Extensibilidad**: El software diseñado siguiendo el OCP es más fácil de extender, ya que se pueden agregar nuevas
   funcionalidades sin afectar el comportamiento del código existente.
3. **Reutilización**: Al diseñar entidades que pueden ser extendidas, se fomenta la reutilización del código en
   diferentes contextos y proyectos.
4. **Flexibilidad**: El software se vuelve más flexible y adaptable a los cambios en los requisitos del negocio y la
   tecnología.

## Cómo aplicar el Principio de Abierto/Cerrado

Para aplicar el Principio de Abierto/Cerrado en el diseño de software, se pueden seguir las siguientes estrategias:

1. **Uso de interfaces y clases abstractas**: Definir interfaces o clases abstractas que representen las
   funcionalidades comunes, y luego crear implementaciones concretas que extiendan estas interfaces o clases
   abstractas. De esta manera, se pueden agregar nuevas implementaciones sin modificar el código existente.
2. **Patrones de diseño**: Utilizar patrones de diseño como el patrón Estrategia, el patrón Decorador o el patrón
   Fábrica para permitir la extensión del comportamiento de las clases sin modificar su código fuente.
3. **Composición sobre herencia**: En lugar de utilizar la herencia para extender el comportamiento de una clase, se
   puede utilizar la composición para combinar objetos y agregar nuevas funcionalidades.
4. **Inyección de dependencias**: Utilizar la inyección de dependencias para permitir la sustitución de implementaciones
   sin modificar el código que depende de ellas.
5. **Modularidad**: Diseñar el software en módulos independientes que puedan ser extendidos o reemplazados sin afectar
   a otros módulos.

## Ejemplo del Principio de Abierto/Cerrado

A continuación, se presenta un ejemplo práctico de cómo aplicar el Principio de Abierto/Cerrado en el desarrollo de
software. Imaginemos que estamos desarrollando un sistema de notificaciones que puede enviar mensajes a través de
diferentes canales, como correo electrónico y SMS.

```java
// Interfaz que define el comportamiento de un canal de notificación
public interface CanalNotificacion {
    void enviarMensaje(String mensaje);
}
```

```java
// Implementación concreta para enviar notificaciones por correo electrónico
public class NotificacionEmail implements CanalNotificacion {
    @Override
    public void enviarMensaje(String mensaje) {
        // Lógica para enviar un correo electrónico
        System.out.println("Enviando correo electrónico: " + mensaje);
    }
}
```

```java
// Implementación concreta para enviar notificaciones por SMS
public class NotificacionSMS implements CanalNotificacion {
    @Override
    public void enviarMensaje(String mensaje) {
        // Lógica para enviar un SMS
        System.out.println("Enviando SMS: " + mensaje);
    }
}
```

```java
// Clase que utiliza el canal de notificación para enviar mensajes
public class ServicioNotificacion {
    private CanalNotificacion canalNotificacion;

    public ServicioNotificacion(CanalNotificacion canalNotificacion) {
        this.canalNotificacion = canalNotificacion;
    }

    public void notificar(String mensaje) {
        canalNotificacion.enviarMensaje(mensaje);
    }
}
```

```java
// Ejemplo de uso del Principio de Abierto/Cerrado
public class Main {
    public static void main(String[] args) {
        // Enviar notificación por correo electrónico
        CanalNotificacion email = new NotificacionEmail();
        ServicioNotificacion servicioEmail = new ServicioNotificacion(email);
        servicioEmail.notificar("¡Hola! Esta es una notificación por correo electrónico.");
        // Enviar notificación por SMS
        CanalNotificacion sms = new NotificacionSMS();
        ServicioNotificacion servicioSMS = new ServicioNotificacion(sms);
        servicioSMS.notificar("¡Hola! Esta es una notificación por SMS.");
    }
}
```

En este ejemplo, la interfaz `CanalNotificacion` define el comportamiento común para los canales de notificación. Las
clases `NotificacionEmail` y `NotificacionSMS` son implementaciones concretas que extienden la funcionalidad sin
modificar el código existente. La clase `ServicioNotificacion` utiliza la interfaz para enviar mensajes, lo que permite
agregar nuevos canales de notificación en el futuro sin modificar su código.

Al seguir el Principio de Abierto/Cerrado, hemos creado un sistema de notificaciones que es fácil de mantener,
extender y reutilizar.