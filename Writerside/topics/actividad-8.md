# Actividad 8: Creando un JAR con nuestras librerías

Para esta actividad, vamos a crear un archivo JAR (Java ARchive) que contenga nuestras librerías y clases Java. Un
archivo JAR es un paquete que agrupa múltiples archivos en uno solo, facilitando su distribución y uso.

## Paso 1: Crear la estructura de directorios

Para esta actividad, crearemos la siguiente estructura de directorios:

```
mi_proyecto
├── src
│   ├── org
│   │   ├── utils
│   │   │   └── InputHandler.java
│   │   └── exceptions
│   │       └── InvalidInputException.java
├── resources
│   └── fonts
└──       └── custom_font.ttf
```

- `src`: Contendrá el código fuente de nuestras clases Java.
- `resources`: Contendrá los recursos adicionales, como fuentes.
    * Es importante que esta carpeta esta el mismo nivel de src, y que sea marcada como "Resources Root" en IntelliJ
      IDEA.
    * Para hacer esto, haz clic derecho en la carpeta `resources`, selecciona "Mark Directory as" y luego "Resources
      Root".

## Paso 2: Crear las clases Java

Crea las siguientes clases Java en la carpeta `src/org/utils` y `src/org/exceptions`:

### InputHandler.java

![a8_1.png](a8_1.png){style="block"}

Como podrás notar, esta clase utiliza la librería `java.awt.Font` para cargar una fuente personalizada desde la carpeta
de recursos. Asegúrate de que la ruta del archivo de fuente sea correcta.

En este caso lo que deberás hacer es usar una fuente de tu preferencia, y colocarla en la carpeta `resources/fonts`.

De igual manera es prioritario que ajustes el tamaño de la fuente a tu preferencia.

> NOTA: Puedes inclusive cambiar el color de la fuente, para esto deberás usar la siguiente línea de código:
> 