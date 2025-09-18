# Open/Closed Principle (OCP)

## ¿Qué es el Open/Closed Principle?

El Principio de Abierto/Cerrado (OCP) establece que las entidades de software (clases, módulos, funciones, etc.) deben
estar abiertas para su extensión, pero cerradas para su modificación. Esto significa que se debe poder agregar nueva
funcionalidad sin modificar el código existente, lo que reduce el riesgo de introducir errores.

Este principio es el segundo de los cinco principios SOLID (que son guías fundamentales para escribir código mantenible
y escalable en programación orientada a objetos).

### Metáfora para entenderlo:

Imagina que tienes un coche. Si quieres añadir una nueva característica, como un sistema de navegación, no quieres tener
que desmontar el coche y modificar su estructura interna. En cambio, quieres poder añadir el sistema de navegación como
un componente adicional que se integra con el coche sin alterar su funcionamiento básico.

¡Eso busca OCP en el código!

## Entendiendo el OCP

El OCP sugiere que las clases y módulos deben estar diseñados de manera que puedan ser extendidos sin necesidad de
modificar su código fuente. Esto se puede lograr utilizando técnicas como la herencia, la composición y el uso de
interfaces o clases abstractas.

Cuando una clase está diseñada siguiendo el OCP, se puede agregar nueva funcionalidad creando nuevas clases que
heredan de la clase base o implementan una interfaz, en lugar de modificar la clase existente. Esto ayuda a mantener el
código estable y reduce el riesgo de introducir errores al realizar cambios.

## Ejemplo de OCP

Supongamos que estamos desarrollando un sistema de notificaciones que puede enviar mensajes a través de diferentes
canales, como correo electrónico y SMS. Inicialmente, podríamos tener una clase `Notification` que maneja ambos tipos de
notificaciones:

```java
public class Notification {
    public void sendEmail(String message) {
        // Código para enviar un correo electrónico
    }

    public void sendSMS(String message) {
        // Código para enviar un SMS
    }
}
```

Si más adelante queremos agregar un nuevo canal de notificación, como notificaciones push, tendríamos que modificar la
clase `Notification`, lo que viola el OCP. Por lo tanto, este diseño no es ideal.

Para seguir el OCP, podemos refactorizar el código utilizando una interfaz `Notifier` y clases concretas para cada tipo
de notificación:

```java
// Interfaz Notifier
public interface Notifier {
    void send(String message);
}
```

```java
// Clase para enviar correos electrónicos
public class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        // Código para enviar un correo electrónico
    }
}
```

```java
// Clase para enviar SMS
public class SMSNotifier implements Notifier {
    @Override
    public void send(String message) {
        // Código para enviar un SMS
    }
}
```

```java
// Clase para enviar notificaciones push
public class PushNotifier implements Notifier {
    @Override
    public void send(String message) {
        // Código para enviar una notificación push
    }
}
```

```java
// Clase Notification que utiliza la interfaz Notifier

import java.util.List;

public class Notification {
    private List<Notifier> notifiers;

    public Notification(List<Notifier> notifiers) {
        this.notifiers = notifiers;
    }

    public void sendNotifications(String message) {
        for (Notifier notifier : notifiers) {
            notifier.send(message);
        }
    }
}
```

En este diseño, la clase `Notification` está abierta para la extensión (podemos agregar nuevos tipos de notificaciones
creando nuevas clases que implementen la interfaz `Notifier`), pero está cerrada para la modificación (no necesitamos
cambiar la clase `Notification` para agregar nuevos canales de notificación). Esto cumple con el Principio de
Abierto/Cerrado.

