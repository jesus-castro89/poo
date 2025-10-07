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

### InvalidInputException.java

![a8_2.png](a8_2.png){style="block"}

## Paso 3: Compilar las clases

Configuramos el proyecto para que al construir se generé un archivo JAR.

Para hacer esto en IntelliJ IDEA, sigue estos pasos:

1. Selecciona tu proyecto y presiona `F4` para abrir las configuraciones de proyecto.
    * ![a8_3.png](a8_3.png){style="block"}
2. Ve a la sección "Artifacts".
    * ![a8_4.png](a8_4.png){style="block"}
3. Haz clic en el botón `+` y selecciona "JAR" > "From modules with dependencies".
4. Selecciona el módulo principal (el que contiene el método `main` si lo tienes) y asegúrate de que la opción "Include
   in project build" esté marcada.
5. En la sección "Output Directory", especifica dónde quieres que se guarde el archivo JAR.
    * ![a8_5.png](a8_5.png){style="block"}
6. Haz clic en "OK" para guardar la configuración.
7. Selecciona "Build" > "Build Artifacts" > "Build" para compilar y generar el archivo JAR.

## Paso 4: Verificar el archivo JAR

Para usar nuestra librería JAR en otro proyecto, simplemente agrega el archivo JAR a las dependencias del proyecto. Para
hacer esto copia el mismo en la carpeta `libs` de tu nuevo proyecto y luego haz clic derecho en el archivo JAR y
selecciona "Add as Library".

## Entregables

En un solo documento PDF, incluye lo siguiente:

* Portada con los siguientes datos:
    * Nombre del curso
    * Nombre de la actividad
    * Nombre de los integrantes del equipo
* Código fuente de todas las clases implementadas.
* Capturas de pantalla que muestren la estructura de directorios, la configuración del proyecto para generar el JAR, y
  la inclusión del JAR en otro proyecto.
* Breve reflexión (máximo 200 palabras) sobre los desafíos encontrados durante la implementación y cómo lo superarón.

> Actividades entregadas posteriores a la fecha límite serán consideradas con una calificación máxima de 70/100.
> {style="warning"}

> Integrante que no aparezca en la portada no será considerado en la evaluación de la actividad.
> {style="warning"}

## Criterios de Evaluación

| Criterio                  | Descripción                                                   | Peso     |
|---------------------------|---------------------------------------------------------------|----------|
| Portada                   | Datos de identificación de los miembros del equipo            | 5%       |
| Estructura de Directorios | Implementación correcta de la estructura de directorios       | 20%      |
| Clases Java               | Implementación correcta de las clases con sus funcionalidades | 30%      |
| Archivo JAR               | Correcta configuración y generación del archivo JAR           | 20%      |
| Documentación             | Código comentado y documentado adecuadamente                  | 15%      |
| **Total**                 |                                                               | **100%** |