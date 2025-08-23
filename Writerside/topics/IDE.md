# IDE

Para nuestra asignatura de programación, vamos a utilizar un IDE (Integrated Development Environment) llamado
**[IntelliJ IDEA Community Edition](https://www.jetbrains.com/es-es/idea/download/?section=windows)**. Este IDE
proporciona una serie de herramientas y funcionalidades que facilitan la programación y el desarrollo de software en
Java.

## ¿Qué es un IDE?

Un IDE es un entorno de desarrollo integrado que proporciona herramientas para facilitar la programación y el desarrollo
de software. Estas herramientas incluyen un editor de código, un compilador, un depurador, un constructor de interfaces
gráficas y otras utilidades que permiten a los programadores escribir, compilar, depurar y ejecutar sus programas de
manera más eficiente.

## Características de IntelliJ IDEA

IntelliJ IDEA es uno de los IDE más populares para el desarrollo de software en Java y otras tecnologías. Algunas de las
características más destacadas de IntelliJ IDEA son:

- **Editor de código inteligente**: Ofrece sugerencias de código, resaltado de sintaxis, refactorización y otras
  funcionalidades que facilitan la escritura de código.
- **Depurador integrado**: Permite depurar programas paso a paso, inspeccionar variables y detectar errores en tiempo de
  ejecución.
- **Constructor de interfaces gráficas**: Proporciona herramientas para diseñar interfaces gráficas de forma visual y
  arrastrar y soltar componentes.
- **Integración con sistemas de control de versiones**: Permite gestionar proyectos con Git, SVN y otros sistemas de
  control de versiones.
- **Soporte para frameworks y tecnologías**: Ofrece soporte para frameworks como Spring, Hibernate, JavaFX y tecnologías
  como HTML, CSS, JavaScript, entre otras.

## Descarga e instalación

Para descargar IntelliJ IDEA, puedes acceder al siguiente
enlace: [Descargar IntelliJ IDEA](https://www.jetbrains.com/es-es/idea/download/?section=windows). Una vez descargado el
instalador, sigue las instrucciones de instalación para configurar el IDE en tu sistema.

> **Nota**: Asegúrate de descargar la versión **Community Edition**, que es gratuita y suficiente para la mayoría de los
> proyectos en Java.
> {style="warning"}

## Configuración inicial

Una vez instalado IntelliJ IDEA, es recomendable realizar una configuración inicial para adaptar el entorno de
desarrollo a tus preferencias. Algunas de las configuraciones que puedes realizar son:

- **Tema y esquema de color**: Puedes seleccionar un tema oscuro o claro y personalizar los colores del editor de
  código.
- **Atajos de teclado**: Puedes configurar atajos de teclado personalizados para acceder a las funciones del IDE de
  forma más rápida.
- **Plugins y extensiones**: Puedes instalar plugins y extensiones para ampliar las funcionalidades del IDE y adaptarlo
  a tus necesidades.

## Plugins recomendados

IntelliJ IDEA cuenta con una amplia variedad de plugins que puedes instalar para ampliar las funcionalidades del IDE.
Algunos de los plugins recomendados para el desarrollo en Java son:

- **Rainbow Brackets**: Resalta los corchetes y paréntesis con colores para facilitar la identificación de bloques de
  código.
- **Ident Rainbow**: Resalta los identificadores con colores para facilitar la lectura y comprensión del código.
- **Inspection Lens**: Muestra información adicional sobre el código, como errores, advertencias y sugerencias, al
  pasar el cursor sobre él.
- **PlantUML integration**: Permite crear diagramas UML directamente desde el código fuente utilizando la notación
  PlantUML.

### ¿Cómo instalar un plugin?

Para instalar un plugin en IntelliJ IDEA, sigue los siguientes pasos:

1. Abre IntelliJ IDEA y ve al icono de configuración en la esquina superior
   derecha.
   ![plugins_file.png](plugins_file.png){style="inline"}
2. Selecciona la opción **Settings** en el menú desplegable.
   ![plugins_settings.png](plugins_settings.png){style="inline"}
3. En la ventana de configuración, selecciona la opción **Plugins** en el menú lateral.
   ![plugins.png](plugins.png){style="inline"}
4. En la pestaña **Marketplace**, busca el plugin que deseas instalar y haz clic en el botón **Install**.
5. Una vez instalado el plugin, reinicia IntelliJ IDEA para aplicar los cambios.

## Creación de un proyecto

Para comenzar a programar en IntelliJ IDEA, debes crear un nuevo proyecto. Para ello, sigue los siguientes pasos:

1. Abre IntelliJ IDEA y selecciona la opción **Create New Project** en la pantalla de inicio.
2. Selecciona la opción **Java** en la lista de tipos de proyectos y haz clic en **Next**.
3. Configura el SDK de Java que deseas utilizar y haz clic en **Next**.
4. Define el nombre y la ubicación del proyecto, así como otras configuraciones adicionales, y haz clic en **Finish**.
5. Una vez creado el proyecto, podrás comenzar a escribir y ejecutar tu código en IntelliJ IDEA.
6. ¡Listo! Ya estás preparado para programar en Java con IntelliJ IDEA.

## Comprimiendo el Proyecto

Para comprimir el proyecto desde IntelliJ IDEA, se puede utilizar la opción de exportar el proyecto como un archivo ZIP.
Esto es útil cuando se necesita compartir el proyecto con otros desarrolladores o para realizar una copia de seguridad
del proyecto.

A continuación se muestra cómo comprimir un proyecto en IntelliJ IDEA:

1. Abre el proyecto que deseas comprimir en IntelliJ IDEA
2. Agrega el Plugin `Zipper` a IntelliJ IDEA si no lo tienes instalado.
3. Haz clic en menu superior `Tools` -> `Pack the Whole Project`. O bien, presiona `Ctrl + Mayus + P`.
4. Ingresa el nombre para tu archivo ZIP.
5. El mismo aparecerá dentro de la carpeta de tu proyecto.
6. Listo, tu proyecto ha sido comprimido.

Es importante tener en cuenta que al comprimir el proyecto, se incluirán todos los archivos y carpetas del proyecto en
el archivo ZIP. Por lo tanto, asegúrate de que el proyecto esté organizado correctamente antes de comprimirlo.

De igual manera puedes agregar directorios a tu proyecto para capturas de pantalla, archivos de texto, etc. y estos
también serán incluidos en el archivo ZIP.

> **Nota**: Para crear directorios en el proyecto, puedes hacer clic derecho en el proyecto y seleccionar `New` ->
`Directory`.

Recuerda que para saber en donde se guardó el archivo ZIP, puedes hacer clic derecho sobre el archivo en IntelliJ IDEA
y seleccionar la opción `Show in Explorer` o `Show in Finder` para abrir la carpeta donde se encuentra el archivo.

Espero que esta guía te haya sido de ayuda para comprimir tu proyecto en IntelliJ IDEA. Si tienes alguna duda o
sugerencia, no dudes en dejar un comentario.