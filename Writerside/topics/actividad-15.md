# Actividad 15: Resolviendo el Sudoku importado

## Descripción

En esta actividad, aprenderás a resolver un Sudoku que ha sido importado desde un archivo objeto.
Esto es útil para verificar la validez del Sudoku y asegurarte de que se pueda completar correctamente.

## Objetivos

- Aprender a resolver un Sudoku utilizando algoritmos de resolución.
- Validar la solución del Sudoku importado.
- Practicar la manipulación de datos en estructuras de Sudoku.

## Instrucciones

1. **Función para resolver el Sudoku**:
    - Implementa una función `solveSudoku(sudoku: SudokuBoard) -> bool` que tome un Sudoku importado y lo resuelva
      utilizando un algoritmo de backtracking.
    - La función debe modificar el Sudoku en su lugar y devolver `True` si se encuentra una solución, o `False` si no es
      posible resolverlo.
2. **Validar la solución del Sudoku**:
    - Asegúrate de que el Sudoku resuelto cumpla con las reglas del Sudoku (cada número del 1 al 9 debe aparecer una
      sola vez en cada fila, columna y subcuadro 3x3).
    - Implementa una función `isValidSudoku(sudoku: SudokuBoard) -> bool` que verifique si el Sudoku es válido.
3. **Prueba las funciones**:
    - Usa la función `importSudokuFromFile` para cargar un Sudoku desde un archivo objeto.
    - Utiliza la función `solveSudoku` para resolver el Sudoku importado.
    - Verifica la validez del Sudoku resuelto utilizando `isValidSudoku`.
    - Imprime el Sudoku resuelto en la consola para verificar que la solución sea correcta.

## Metodología

Para completar esta actividad, sigue estos pasos:

1. **Implementa la función de resolución**:
    - Crea la función `solveSudoku` siguiendo las instrucciones proporcionadas.
2. **Implementa la función de validación**:
    - Crea la función `isValidSudoku` siguiendo las instrucciones proporcionadas.
3. **Prueba las funciones**:
    - Sigue las instrucciones para probar ambas funciones y verificar que el Sudoku importado pueda ser resuelto y
      validado correctamente.
4. **Documenta tu código**:
    - Asegúrate de agregar comentarios y documentación a tu código para explicar cómo funcionan las funciones y
      cualquier detalle importante.
5. **Entrega tu trabajo**:
    - Prepara tu proyecto para su entrega, asegurándote de que todo el código esté limpio y bien organizado.

## Entrega

En un solo documento `PDF`, incluye lo siguiente:

1. Portada con lo siguiente:
    - Nombre del curso
    - Nombre de la actividad
    - Nombre de los integrantes del equipo
2. Código fuente bien documentado.
3. Capturas de pantalla de las pruebas realizadas, mostrando los Sudokus generados, las celdas ocultas y el contenido
   del archivo de texto exportado.
4. Breve explicación de cómo implementaste cada función y cualquier desafío que enfrentaste durante el proceso.

## Criterios de evaluación

| Criterio                          | Descripción                                                                                                        | Puntuación |
|-----------------------------------|--------------------------------------------------------------------------------------------------------------------|------------|
| Implementación de `solveSudoku`   | La función resuelve correctamente el Sudoku importado utilizando backtracking.                                     | 50%        |
| Implementación de `isValidSudoku` | La función valida correctamente la solución del Sudoku resuelto.                                                   | 30%        |
| Pruebas y documentación           | El código está bien documentado y las pruebas demuestran la funcionalidad correcta de las funciones implementadas. | 20%        |
| **Total**                         |                                                                                                                    | **100%**   |