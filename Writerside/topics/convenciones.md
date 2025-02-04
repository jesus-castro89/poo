# Convención de nombres

Las convenciones de nombres son reglas que se utilizan para nombrar variables, métodos, clases y otros elementos de un
programa. Estas reglas permiten que el código sea más legible y fácil de entender para los programadores, ya que siguen
un patrón consistente en todo el proyecto.

## Reglas generales

A continuación, se presentan algunas reglas generales que se deben seguir al nombrar elementos en un programa:

- **Claridad**: Los nombres deben ser descriptivos y reflejar el propósito o la función del elemento que representan.
  Evita nombres genéricos o abreviaturas que puedan ser confusas para otros programadores.
- **Consistencia**: Mantén un estilo de nomenclatura consistente en todo el proyecto. Si decides utilizar mayúsculas,
  minúsculas, guiones bajos o camelCase, asegúrate de aplicar la misma convención en todos los nombres.
- **Brevedad**: Los nombres deben ser lo suficientemente cortos como para ser fáciles de leer y escribir, pero lo
  suficientemente descriptivos como para entender su significado.
- **Evitar palabras reservadas**: No utilices palabras reservadas del lenguaje de programación como nombres de
  variables,
  métodos o clases, ya que pueden causar conflictos en el código.
- **Evitar caracteres especiales**: Evita el uso de caracteres especiales, como espacios, signos de puntuación o
  símbolos,
  en los nombres de los elementos. Utiliza letras, números y guiones bajos si es necesario.
- **Evitar nombres ambiguos**: Evita nombres ambiguos que puedan tener múltiples interpretaciones o significados.
  Utiliza
  nombres que sean claros y específicos para el contexto en el que se utilizan.
- **Evitar nombres demasiado largos**: Aunque es importante que los nombres sean descriptivos, evita que sean
  excesivamente
  largos, ya que pueden dificultar la lectura y comprensión del código.
- **Evitar nombres similares**: Evita utilizar nombres que sean similares entre sí, ya que pueden causar confusiones o
  errores al programar.

## Convenciones específicas

Además de las reglas generales, existen convenciones específicas para nombrar elementos en diferentes lenguajes de
programación. A continuación, se presentan algunas convenciones comunes para nombrar elementos en Java:

- **Clases**: Los nombres de las clases deben comenzar con una letra mayúscula y utilizar camelCase, además de ser
  sustantivos en singular. Por ejemplo, `MiClase`, `Persona`, `CuentaBancaria`.
- **Métodos**: Los nombres de los métodos deben comenzar con una letra minúscula y utilizar camelCase, además de ser
  verbos o acciones. Por ejemplo, `calcularSalario`, `obtenerEdad`, `mostrarMensaje`.
- **Variables**: Los nombres de las variables deben comenzar con una letra minúscula y utilizar camelCase, así como
  representar sustantivos. Por ejemplo, `nombre`, `edad`, `saldo`.
- **Constantes**: Los nombres de las constantes deben estar en mayúsculas y separados por guiones bajos. Por ejemplo,
  `PI`, `TASA_INTERES`, `LIMITE_EDAD`.
- **Paquetes**: Los nombres de los paquetes deben ser en minúsculas y utilizar nombres de dominio inverso. Por ejemplo,
  `com.empresa.proyecto`, `org.biblioteca.libro`.

## Ejemplo

A continuación, se muestra un ejemplo de un programa en Java que sigue las convenciones de nombres descritas
anteriormente:

```java

package com.empresa.proyecto;

public class MiClase {

    public static final double PI = 3.14159;

    private String nombreCompleto;

    public MiClase(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void saludar() {
        System.out.println("Hola, mi nombre es " + nombreCompleto);
    }

    public static void main(String[] args) {
        MiClase miObjeto = new MiClase("Juan Pérez");
        miObjeto.saludar();
    }
}

```