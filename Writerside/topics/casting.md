# ¿Qué es el casting en programación?

El casting en programación es el proceso de convertir una variable de un tipo de dato a otro. Esto es especialmente útil
cuando se trabaja con diferentes tipos de datos y se necesita realizar operaciones que requieren un tipo específico.

## Tipos de casting

Existen dos tipos principales de casting, siendo estos el casting implícito y el casting explícito. Cada uno tiene sus
propias características y usos.

Ahora veamos en que consiste cada uno y como aplicarlos en Java.

### Casting implícito

El casting implícito ocurre cuando el compilador convierte automáticamente un tipo de dato a otro sin necesidad de
intervención del programador. Esto generalmente sucede cuando se convierte un tipo de dato más pequeño a uno más grande,
ya que no hay pérdida de información.

Ahora veamos un ejemplo en Java:

![casting_1](casting_1.png){style="block"}

Como se puede observar en el ejemplo anterior, el valor de `numeroEntero` se convierte automáticamente a `double` cuando
se asigna a la variable `numeroDecimal`. No es necesario realizar ninguna conversión explícita, ya que el compilador lo
hace por nosotros.

### Casting explícito

El casting explícito, por otro lado, requiere que el programador indique de manera explícita que desea convertir un tipo
de dato a otro. Esto se hace utilizando paréntesis para especificar el tipo de dato al que se desea convertir.

Aquí hay un ejemplo de casting explícito en Java:

![casting_2.png](casting_2.png){style="block"}

En este ejemplo, el valor de `numeroDecimal` se convierte explícitamente a `int` utilizando `(int)`. Esto resulta en la
pérdida de la parte decimal, ya que `int` no puede almacenar valores decimales.

## Autoboxing y Autounboxing

En Java, el autoboxing y autounboxing son características que permiten la conversión automática entre tipos primitivos
y sus correspondientes clases envolventes (**wrapper classes**). Esto facilita el trabajo con colecciones y otros
contextos
donde se requieren objetos en lugar de tipos primitivos.

### Autoboxing

El autoboxing es el proceso mediante el cual Java convierte automáticamente un tipo primitivo en su clase envolvente
correspondiente. Por ejemplo, cuando se asigna un valor `int` a una variable de tipo `Integer`, Java realiza el
autoboxing.

### Autounboxing

El autounboxing es el proceso inverso, donde Java convierte automáticamente una clase envolvente en su tipo primitivo
correspondiente. Por ejemplo, cuando se asigna un valor `Integer` a una variable de tipo `int`, Java realiza el
autounboxing.

### Ejemplo de autoboxing y autounboxing

Aquí hay un ejemplo que ilustra tanto el autoboxing como el autounboxing en Java:

![casting_3.png](casting_3.png)

Este tipo de conversiones automáticas hacen que el código sea más limpio y fácil de leer, ya que no es necesario
realizar conversión manual entre tipos primitivos y sus clases envolventes. Sin embargo, es importante tener en cuenta
que el autoboxing y autounboxing pueden tener un impacto en el rendimiento si se usan en exceso, ya que implican la
creación de objetos adicionales. Así mismo, debemos recordar que este tipo de conversiones solo aplican a los tipos
primitivos y sus clases envolventes, y no a otros tipos de datos como `String` o **Arrays de objetos**.

## En conclusión

El casting es una herramienta esencial en la programación que permite la conversión entre diferentes tipos de datos.
Comprender cuándo y cómo utilizar el casting implícito y explícito, así como el autoboxing y autounboxing en Java, es
fundamental para escribir código eficiente y efectivo. A medida que avances en tu carrera como programador, te
encontrarás con situaciones donde el casting será necesario, y saber cómo manejarlo adecuadamente te ayudará a evitar
errores y mejorar la calidad de tu código.