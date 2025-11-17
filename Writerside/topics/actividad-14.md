# Actividad 14: Exportando el Sudoku a un archivo objeto

## Descripción

En esta actividad, aprenderás a exportar e importar un Sudoku utilizando la serialización de objetos.
Esto es útil para guardar el estado del Sudoku y cargarlo posteriormente.

## Objetivos

- Aprender a serializar y deserializar objetos en el contexto de un Sudoku.
- Exportar el Sudoku a un archivo objeto.
- Importar el Sudoku desde un archivo objeto.
- Practicar la manipulación de archivos y datos en estructuras de Sudoku.

## Instrucciones

1. **Función para exportar el Sudoku a un archivo objeto**:
    - Implementa una función `exportSudokuToFile(SudokuBoard sudoku, String filename)` que tome un Sudoku
      completo y un nombre de archivo, y guarde el Sudoku en un archivo utilizando serialización de objetos.
    - Utiliza las bibliotecas estándar de tu lenguaje de programación para manejar la serialización y escritura de
      archivos.
    - Asegúrate de manejar posibles excepciones relacionadas con la escritura de archivos.
2. **Función para importar el Sudoku desde un archivo objeto**:
    - Implementa una función `importSudokuFromFile(String filename) -> SudokuBoard` que lea un archivo objeto y
      deserialice el contenido para reconstruir el Sudoku.
    - Asegúrate de manejar posibles excepciones relacionadas con la lectura de archivos y la deserialización.
3. **Prueba las funciones**:
    - Crea un Sudoku completo utilizando la función `generateSudoku`.
    - Usa la función `exportSudokuToFile` para guardar el Sudoku en un archivo.
    - Luego, utiliza la función `importSudokuFromFile` para cargar el Sudoku desde el archivo.
    - Verifica que el Sudoku cargado sea idéntico al Sudoku original imprimiéndolos en la consola.

> Recuerda que para que ambas funciones funcionen correctamente, la clase `SudokuBoard` debe ser serializable, al igual
> que la clase `SudokuCell`.
> {style="warning"}

## Metodología

Para completar esta actividad, sigue estos pasos:

1. **Asegurate que las clases sean serializables**:
    - Verifica que las clases `SudokuBoard` y `SudokuCell` implementen la interfaz de serialización adecuada en tu
      lenguaje de programación.
2. **Implementa la función de exportación**:
    - Crea la función `exportSudokuToFile` siguiendo las instrucciones proporcionadas.
3. **Implementa la función de importación**:
    - Crea la función `importSudokuFromFile` siguiendo las instrucciones proporcionadas.
4. **Prueba las funciones**:
    - Sigue las instrucciones para probar ambas funciones y verificar que el Sudoku exportado e importado sean
      idénticos.
5. **Documenta tu código**:
    - Asegúrate de agregar comentarios y documentación a tu código para explicar cómo funcionan las funciones y
      cualquier detalle importante.
6. **Entrega tu trabajo**:
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

| Criterio                      | Descripción                                                                                           | Puntuación |
|-------------------------------|-------------------------------------------------------------------------------------------------------|------------|
| Implementación de exportación | La función `exportSudokuToFile` está correctamente implementada y maneja excepciones adecuadamente.   | 30%        |
| Implementación de importación | La función `importSudokuFromFile` está correctamente implementada y maneja excepciones adecuadamente. | 30%        |
| Pruebas y verificación        | Se realizaron pruebas adecuadas y se verificó que el Sudoku importado es idéntico al original.        | 20%        |
| Documentación del código      | El código está bien documentado y explicado.                                                          | 20%        |
| **Total**                     |                                                                                                       | **100%**   |