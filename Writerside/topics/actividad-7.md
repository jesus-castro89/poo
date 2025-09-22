# Actividad 7: Gestor de Pagos Universitarios

## Descripción

Imagina que una universidad necesita un sistema para gestionar pagos de sus estudiantes. Cada alumno puede pagar su
inscripción, colegiatura mensual, o incluso cursos extras.

El sistema debe manejar tanto información por estudiante como información global de la universidad. Además, utilizaremos
la sobrecarga de métodos para calcular el total de pagos realizados según el tipo de operación.

## Requisitos

1. Clase `StudentPayment`
    - **Atributos de instancia**:
        - `studentName` (String)
        - `balance` (double) → dinero acumulado que el estudiante ha pagado.
    - **Atributo de clase (estático)**:
        - `static double totalUniversityBalance` → suma de todos los pagos recibidos en la universidad.
2. Métodos de instancia
    - `addPayment(double amount)` → agrega un pago al estudiante y lo suma al balance global de la universidad.
    - `displayStudentInfo()` → muestra el nombre y el balance acumulado del estudiante.
3. Métodos sobrecargados `makePayment(...)`
    - `makePayment(double amount)` → pago simple.
    - `makePayment(double amount, String concept)` → pago con concepto (ejemplo: *“Inscripción”*).
    - `makePayment(double amount, boolean scholarship)` → si el estudiante tiene beca, se aplica un 50% de descuento al
      pago.
    - (Todos los métodos deben actualizar el balance del estudiante y el `totalUniversityBalance`).*
4. Métodos de clase (estáticos)
    - `getTotalUniversityBalance()` → devuelve el total recaudado por la universidad.
    - `generalInfo()` → imprime un mensaje general sobre el sistema de pagos.
5. Clase principal `PaymentApp`
    - Llama al método `generalInfo()`.
    - Crea al menos **2 estudiantes**.
    - Registra distintos tipos de pagos utilizando la **sobrecarga de métodos**.
    - Muestra la información individual de cada estudiante.
    - Muestra la información global de la universidad con `getTotalUniversityBalance()`.

## Entregables

En un solo documento PDF, incluye lo siguiente:

* Portada con los siguientes datos:
    * Nombre del curso
    * Nombre de la actividad
    * Nombre de los integrantes del equipo
* Código fuente de todas las clases implementadas.
* Capturas de pantalla que muestren la ejecución del programa, incluyendo el uso de todas las funcionalidades del menú.
* Breve reflexión (máximo 200 palabras) sobre los desafíos encontrados durante la implementación y cómo lo superarón.

> Actividades entregadas posteriores a la fecha límite serán consideradas con una calificación máxima de 70/100.
> {style="warning"}

> Integrante que no aparezca en la portada no será considerado en la evaluación de la actividad.
> {style="warning"}

## Criterios de Evaluación

| Criterio             | Descripción                                                    | Peso     |
|----------------------|----------------------------------------------------------------|----------|
| Portada              | Datos de identificación de los miembros del equipo             | 5%       |
| Clase StudentPayment | Implementación correcta de la clase con atributos y métodos    | 40%      |
| Clase PaymentApp     | Implementación correcta de la clase principal                  | 20%      |
| Resultados           | Correcta invocación y muestra de resultados usando JOptionPane | 20%      |
| Documentación        | Código comentado y documentado adecuadamente                   | 15%      |
| **Total**            |                                                                | **100%** |

> Recuerda que el uso de la clase `JOptionPane` es obligatorio para la interacción con el usuario. De lo contrario se
> considerará que no se ha cumplido con los requisitos de la actividad. Así mismo deberás manejar excepciones y validar
> entradas, de lo contrario se considerará que no se ha cumplido con los requisitos de la actividad.
> {style="warning"}        