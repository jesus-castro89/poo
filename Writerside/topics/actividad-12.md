# Actividad 12: Generador de Sudokus en Java

## Objetivo

Desarrollar un programa en Java que genere tableros de Sudoku válidos de manera aleatoria.
De al menos tres dificultades: fácil, medio y difícil, para ellos usaremos un HashMap para almacenar las posiciones y
valores del Sudoku.
El programa debe permitir al usuario seleccionar la dificultad y mostrar el tablero generado en la consola.

## Requisitos

1. **Generación del tablero**:
    - Crear una función que genere un tablero de Sudoku válido.
    - Asegurarse de que el tablero cumpla con las reglas del Sudoku (cada número del 1 al 9 debe aparecer una sola vez
      en cada fila, columna y subcuadro 3x3).
2. **Dificultad**:
    - Implementar diferentes niveles de dificultad (fácil, medio, difícil) que determinen cuántos números se ocultan en
      el tablero generado.
3. **Uso de HashMap**:
    - Utilizar un `HashMap` para almacenar las posiciones (clave) y los valores (valor) del tablero de Sudoku.
4. **Interfaz de usuario**:
    - Permitir al usuario seleccionar la dificultad del Sudoku.
    - Mostrar el tablero generado en la consola de manera clara y legible.

## Algoritmo sugerido

Se usa **backtracking** puro para llenar un tablero vacío con una solución válida.

Idea:

* Rellenas casillas de izquierda a derecha y de arriba abajo.
* En cada celda, intentas un número del 1 al 9 (en orden aleatorio).
* Si el número cumple las reglas del Sudoku (sin repetir en fila, columna, ni cuadrante 3×3), lo colocas y pasas a la
  siguiente celda.
* Si no puedes colocar ningún número, haces backtrack (retrocedes) y cambias el valor anterior.

✅ Al final obtienes un tablero completo y válido.

> Nota: Backtracking es un enfoque de fuerza bruta, pero es eficiente para este problema específico.
> {style="note"}

> Puedes usar un enfoque similar para eliminar números y crear diferentes niveles de dificultad. Sin embargo asegurarnos
> de que el Sudoku resultante tenga una única solución puede ser más complejo y requerir un análisis adicional.
> {style="warning"}

Por consiguiente en nuestro código implementaremos este algoritmo para generar el Sudoku, sin embargo, lo haremos
mediante el uso de dos clases iniciales:

* `Cell`: Representa una celda individual del Sudoku.
* `SudokuBoard`: Maneja la generación y visualización del tablero de Sudoku.

## 🧩 Concepto básico: Dificultad según cantidad de pistas

Un Sudoku tiene 81 celdas (9×9). Al eliminar números, dejamos solo “pistas” que el jugador puede usar para deducir el
resto.

| Nivel   | Cantidad de celdas vacías | Pistas visibles aproximadas | Definición                                                                                                     |
|---------|---------------------------|-----------------------------|----------------------------------------------------------------------------------------------------------------|
| Fácil   | 36 – 45                   | 36 – 45 vacías              | El jugador puede resolverlo casi sin hipótesis; la mayoría de los números se deducen por eliminación directa.  |
| Medio   | 30 – 35                   | 46 – 51 vacías              | Se requieren más pasos lógicos; algunos números deben deducirse por intersección o patrón.                     |
| Difícil | 22 – 29                   | 52 – 59 vacías              | Se necesita razonamiento avanzado (por ejemplo, cadenas o pares ocultos). Ideal para jugadores experimentados. |

📏 En términos de código, nosotros usaremos los siguientes valores:

| Nivel   | Celdas vacías | Celdas visibles |
|---------|---------------|-----------------|
| Fácil   | 36            | 45              |
| Medio   | 46            | 35              |
| Difícil | 54            | 27              |

> Estos valores son aproximados y pueden variar ligeramente según la implementación, pero proporcionan una buena base
> para definir la dificultad.
> {style="info"}